package br.gov.mg.tce.business;

import java.net.URL;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.jws.WebParam;
import javax.xml.namespace.QName;

import org.apache.axis.utils.ByteArray;
import org.codehaus.plexus.util.StringUtils;

import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWS;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWSService;
import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.dao.CertidaoDAO;
import br.gov.mg.tce.dto.SolicitarCertidaoDTO;
import br.gov.mg.tce.dto.ValidarCertidaoResponse;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoBOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.ProcessoJulgadoAnaliseBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.exception.TceException;
import br.gov.mg.tcemg.util.DateUtil;
import br.gov.mg.tcemg.util.Parametro;

/**
 * BO responsavel por atender as operacoes relacionadas a entidade
 * {@link Certidao}
 */
@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "CertidaoBO", mappedName = "CertidaoBO")
public class CertidaoBO extends TCEMGBusinessDomain<Certidao> implements CertidaoBOLocal {

    @InjectDAO
    private CertidaoDAO dao;

    @EJB
    private ProcessoJulgadoAnaliseBOLocal processoJulgadoAnaliseBO;
    
    @EJB
    private EMailBOLocal eMailBO;

    @Override
    protected TCEMGDao<Certidao> getDao() {
        return dao;
    }

    @Override
    public Long salvarCertidao(Certidao certidao) throws Exception {
        return dao.salvarCertidao(certidao);
    }

    @Override
    public List<Certidao> consultarPeticoesPorFiltros(Certidao certidao) {
        return dao.consultarCertidoesPorFiltros(certidao, 0);
    }

    public String solicitacaoCertidao(String cpf, String nome, String email, String nomeMunicipio, String uf, String cnpj, String nomeOrgao,
            String tipoCertidao, int certidaoSelecionada, int anoExercicio, int codigoFinalidade, String extensaoArquivo, byte[] arquivo, Long codOrgaoSGI)
            throws Exception {

        try {

            String sqlpackage = "{call PCK_PETICAO_ELETRONICA.PRD_SOLICITA_PETICAO_ELETR( ? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ? , ?)}";

            Map<Integer, Parametro> mapeamento = new HashMap<Integer, Parametro>();

            mapeamento.put(1, new Parametro(Long.valueOf(cpf), true));
            mapeamento.put(2, new Parametro(nome, true));
            mapeamento.put(3, new Parametro(email, true));
            mapeamento.put(4, new Parametro(nomeMunicipio, true));
            mapeamento.put(5, new Parametro(uf, true));

            // mapeamento.put(6, new Parametro(Long.valueOf(cnpj), true));
            // //substituido por pCOD_ORGAO_SGI
            // mapeamento.put(7, new Parametro(nomeOrgao, true)); //substituido
            // por pCOD_ORGAO_SGI
            mapeamento.put(6, new Parametro(codOrgaoSGI, true));
            mapeamento.put(7, new Parametro(tipoCertidao, true));
            mapeamento.put(8, new Parametro(certidaoSelecionada, true));
            mapeamento.put(9, new Parametro(anoExercicio, true));
            mapeamento.put(10, new Parametro(codigoFinalidade, true));
            mapeamento.put(11, new Parametro(extensaoArquivo == null ? "" : extensaoArquivo, true));
            mapeamento.put(12, new Parametro(arquivo == null ?  new ByteArray().toByteArray() : arquivo, true));
            mapeamento.put(new Integer(13), new Parametro(Types.VARCHAR, false));

            Map<Integer, Parametro> resultProcedure = super.executarProcedureSistema(sqlpackage, mapeamento);

            if (resultProcedure != null && !resultProcedure.isEmpty()) {

                Object[] array = resultProcedure.values().toArray();
                if (array[0] != null && StringUtils.isNotBlank(array[0].toString())) {
                    return ((Parametro) array[0]).getObject().toString();
                }
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return null;

    }

    @Override
    public Certidao recuperarPeticaoPorNumProtocolo(String numProtocolo) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("numProtocolo", Long.valueOf(numProtocolo));

        return dao.consultaUnicoRegistroPorNamedQuery(Certidao.BUSCAR_PETICAO_POR_NUMERO_PROTOCOLO, params);
    }

    @Override
    public byte[] recuperaArquivoCertidaoPorId(Long codCertidao) {
        byte[] byteArq = null;

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("codCertidao", codCertidao);

        Certidao certidao = (Certidao) dao.consultaUnicoAtributoPorNamedQuery(Certidao.BUSCAR_PETICAO_POR_ID, paramMap);

        if (certidao != null) {
            byteArq = certidao.getArqCertidaoPdf();
        }
        return byteArq;
    }

    /**
     * Realiza a solicitacao da peticao. Este webservice atende a funcionaliade
     * de solicitar certidao do sistema ECertidao
     *
     * @param certidao
     * @return
     * @throws TceException
     */
    @Override
    public SolicitarCertidaoDTO solicitarCertidao(Certidao certidao) throws Exception {
    	Long numProtocolo = dao.salvarCertidao(certidao);
    	SolicitarCertidaoDTO result = new SolicitarCertidaoDTO();
    	result.setNumProtocolo(numProtocolo.toString());
        return result;
    }

    public Boolean indicesDentroLimite(AnaliseDTO analiseAtual) throws Exception {

        IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
                PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)), new QName("http://integracaocore.ecertidao.tcemg/", "IntegracaoCoreECertidaoWSService"))
                .getIntegracaoCoreECertidaoWSPort();
        return integracaoCoreECertidaoWS.indicesDentroLimite(analiseAtual.getCodAnalise(), analiseAtual.getTipoAnalise().equalsIgnoreCase("ANA"));
    }

    /**
     * Recupera as peticoes por filtro.
     *
     * @param certidaoFiltro
     * @return
     */
    public List<Certidao> consultarPeticoesPorFiltrosDTO(Certidao certidao) {
    	return dao.consultarCertidoesPorFiltros(certidao, 0);
    }

    public ValidarCertidaoResponse validarCertidaoPorNumProtocolo(@WebParam(name = "numProtocolo") String numProtocolo) throws Exception {
        ValidarCertidaoResponse response = new ValidarCertidaoResponse();
        
        Certidao certidao = this.recuperarPeticaoPorNumProtocolo(numProtocolo);
        if(certidao == null){
        	response.setMsgRetorno("Número de protocolo inválido.");
        }else{
        	response.setCertidao(certidao);
        	
        	if (certidao.getIndSituacao().equals(IndSituacaoCertidaoEnum.EM_ANALISE)) {
        		response.setMsgRetorno("A geração da Certidão esta em processamento.");
        	} else {
        		if (certidao.getIndSituacao().equals(IndSituacaoCertidaoEnum.ERRO)) {
        			response.setMsgRetorno("Erro na geração da certidão.");
        		} else {
        			if (certidao.getIndSituacao().equals(IndSituacaoCertidaoEnum.INDEFERIDA)) {
        				response.setMsgRetorno(certidao.getDscIndeferidoJustificativa());
        			} else {
        				Date dataSolicitacao = certidao.getDataSolicitacao();
        				Date dataGeracao = certidao.getDataGeracaoCertidao();
        				Date dataValidade = null;
        				if (dataGeracao != null) {
        					dataValidade = DateUtil.adicionaDias(dataGeracao, 90);
        				}else{
        					dataValidade = DateUtil.adicionaDias(dataSolicitacao, 90);
        				}
        				
        				int comparaDataDescartandoHoras = DateUtil.comparaDataDescartandoHoras(dataValidade, DateUtil.getDataAtual());
        				
        				if (comparaDataDescartandoHoras < 0) {
        					response.setMsgRetorno("Número de protocolo Vencido.");
        				} else {
        					response.setDownloadFile(true);
        					response.setMsgRetorno("Número de protocolo Valido.");
        				}
        			}
        		}
        	}
        }
        
        return response;
    }
}
