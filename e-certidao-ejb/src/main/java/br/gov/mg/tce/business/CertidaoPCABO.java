package br.gov.mg.tce.business;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.xml.namespace.QName;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWS;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWSService;
import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWS;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWSService;
import br.gov.mg.tce.client.sgap.ListarProcessosTransJulgadosDTO;
import br.gov.mg.tce.client.sgap.ProcessoTransJulgadoWS;
import br.gov.mg.tce.client.sgap.ProcessosTransJulgadoWSService;
import br.gov.mg.tce.dao.CertidaoPCADAO;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoPCABOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.ProcessoJulgadoAnaliseBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.exception.TceException;
import br.gov.mg.tcemg.exception.TceFault;
import br.gov.mg.tcemg.util.Paginacao;

/**
 * BO responsavel por atender as operacoes relacionadas a entidade
 * {@link CertidaoPCA}
 */
@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "PeticaoCertidaoBO", mappedName = "PeticaoCertidaoBO")
public class CertidaoPCABO extends TCEMGBusinessDomain<CertidaoPCA> implements CertidaoPCABOLocal {

	@InjectDAO
	private CertidaoPCADAO dao;

	@EJB
	private ProcessoJulgadoAnaliseBOLocal processoJulgadoAnaliseBO;
	@EJB
	private EMailBOLocal eMailBO;

	@Override
	protected TCEMGDao<CertidaoPCA> getDao() {
		return dao;
	}

	@Override
	public CertidaoPCA consultarPeticaoGeradaPorTipoAnalise(Long codMunicipio, Integer anoExercicio, String sglTipoAnalise) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("codMunicipio", codMunicipio);
		params.put("anoExercicio", anoExercicio);
		params.put("sglTipoAnalise", sglTipoAnalise);
		List<CertidaoPCA> result = super.consultarPorNamedQuery(CertidaoPCA.BUSCAR_POR_TIPO_ANALISE, params, new Paginacao(0, 1));
		return result != null && !result.isEmpty() ? result.get(0) : null;
	}

	@Override
	public List<CertidaoPCA> consultarPeticoesParaJobAnalisesComProcessos(int paginacao) {
		return dao.consultarPeticoesParaJobAnalisesComProcessos(paginacao);
	}

	public CertidaoPCA criarCertidaoPCA(Integer exercicio, String codMunicipio) throws TceException {

		CertidaoPCA certidaoPCA = new CertidaoPCA();
		certidaoPCA.setNumAnoRef(exercicio);
		certidaoPCA.setCodMunicipio(Long.valueOf(codMunicipio));
		try {
			IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
					PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)),
					new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
			
			ProcessoTransJulgadoWS processoTransJulgadoWS = new ProcessosTransJulgadoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
					PropertiesVariaveisEnum.URL_WEBSERVICE_PROCESSO_JULGADO)), new QName("http://processoTransJulgado.sgap.tcemg/",
					"ProcessosTransJulgadoWSService")).getProcessoTransJulgadoWSPort();

			if (certidaoPCA.getNumAnoRef() == 2015 && certidaoPCA.getCodMunicipio().equals(3106200L)) {
				certidaoPCA.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
				certidaoPCA.setDataGeracaoCertidao(new Date());
				certidaoPCA
						.setDscIndeferidoJustificativa("Certidão indeferida, uma vez que excepcionalmente, esta certidão será emitida manualmente, em razão de cumprimento da medida cautelar concedida no Processo nº 988.018, devendo ser requerida por petição dirigida à Presidência  deste Tribunal.");
			} else if (certidaoPCA.getNumAnoRef() >= 2015) {

				// Lista todas as analises do municipio no exercicio solicitado
				AnaliseDTO analiseConsolidada = integracaoWebECertidaoWS.buscarAnaliseConsolidadaPorMunicipioExercicio(certidaoPCA.getCodMunicipio(),
						certidaoPCA.getNumAnoRef().longValue());

				if (analiseConsolidada != null) {

					Long numProcesso = analiseConsolidada.getNumProcesso();
					ListarProcessosTransJulgadosDTO situacaoProcessoSGAP = processoTransJulgadoWS.
							listarProcessosTransJulgadosPorNumeroProcesso(numProcesso != null ? numProcesso.toString() : "0");

					if (situacaoProcessoSGAP != null
							&& ("ATJ".equals(situacaoProcessoSGAP.getSglSituacao()) || "IR".equals(situacaoProcessoSGAP.getSglSituacao()) || "TJ"
									.equals(situacaoProcessoSGAP.getSglSituacao()))) {
						
						ProcessoJulgadoAnalise processoJulgadoAnalise = processoJulgadoAnaliseBO.findByNumeroProcesso(numProcesso);
						if (processoJulgadoAnalise != null) {
							processoJulgadoAnalise.setSglSituacaoProcesso(situacaoProcessoSGAP.getSglSituacao());
						} else {
							processoJulgadoAnalise = new ProcessoJulgadoAnalise();
							processoJulgadoAnalise.setCodProcesso(numProcesso);
							processoJulgadoAnalise.setSglSituacaoProcesso(situacaoProcessoSGAP.getSglSituacao());
						}
						if ("ATJ".equals(situacaoProcessoSGAP.getSglSituacao())) {
							// 3 fase aguardando transitar em julgado ou PEDREX
							certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_ATJ.getSigla());
						} else if ("IR".equals(situacaoProcessoSGAP.getSglSituacao())) {
							certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_IR.getSigla());
						} else {
							// 4 fase transito em julgado
							certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_TJ.getSigla());
						}
					} else {
						// Se nao houve parecer previo buscar a ultima analise
						// de defesa validada
						AnaliseDTO analiseDefesaValidada = integracaoWebECertidaoWS.buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio(
								certidaoPCA.getCodMunicipio(), certidaoPCA.getNumAnoRef().longValue());
						if (analiseDefesaValidada != null) {

							// 2 fase defesa validada
							certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_DE_DEFESA.getSigla());
							certidaoPCA.setCodAnalise(analiseDefesaValidada.getCodAnalise());
						} else {
							// Caso nao tenha defesa validada busca a analise consolidada
							// 1 fase consolidada ou pre-pca para 2016 em diantes
							certidaoPCA.setCodAnalise(analiseConsolidada.getCodAnalise());
							certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_CONSOLIDADA.getSigla());

							if (certidaoPCA.getNumAnoRef() >= 2017) {
								if (analiseConsolidada.getCodAnalise() == null || analiseConsolidada.getIndiceSubstituta() != null) {
									certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_PRE_PCA.getSigla());
								} else {
									certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_CONSOLIDADA.getSigla());
								}
							}
						}

					}
				} else {
					
					if (certidaoPCA.getNumAnoRef() == 2019) {
						certidaoPCA.setSglTipoAnalise(EnumTipoAnalise.ANALISE_PRE_PCA.getSigla());
					}else{
						// se nao possuir analise consolidada a certida e indeferida
						certidaoPCA.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
						certidaoPCA.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_PCA);
					}
				}
			} else {
				certidaoPCA = null;
			}

		} catch (Exception e) {
			throw new TceException("Erro ao solicitar Certidao", new TceFault(), e);
		}

		return certidaoPCA;
	}

	private Boolean indicesDentroLimite(AnaliseDTO analiseAtual) throws Exception {

		IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
				PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)), new QName("http://integracaocore.ecertidao.tcemg/", "IntegracaoCoreECertidaoWSService"))
				.getIntegracaoCoreECertidaoWSPort();
		return integracaoCoreECertidaoWS.indicesDentroLimite(analiseAtual.getCodAnalise(), analiseAtual.getTipoAnalise().equalsIgnoreCase("ANA"));
	}

	@Override
	public List<CertidaoPCA> consultarPeticoesPorFiltros(CertidaoPCA filtro, Integer qtde) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("indSituacao", filtro.getIndSituacao());
		param.put("sglTipoAnalise", filtro.getSglTipoAnalise());
		
		Paginacao paginacao = null;
		if(qtde != null){
			paginacao = new Paginacao(0, qtde);
		}
		return super.consultarPorNamedQuery(CertidaoPCA.SOLICITACAO_EM_ANALISE, param, paginacao);
	}

	@Override
	public List<Certidao> consultarCertidaoPCAPorFiltros(Certidao peticaoCertidao) {

		Criteria criteria = this.getDao().createCriteria();

		if (peticaoCertidao.getNumCpfCnpf() != null) {
			criteria.add(Restrictions.eq("numCpfCnpf", peticaoCertidao.getNumCpfCnpf()));
		}

		if (peticaoCertidao.getNumAnoRef() != null) {
			criteria.add(Restrictions.eq("numAnoRef", peticaoCertidao.getNumAnoRef()));
		}

		if (peticaoCertidao.getIndFinalidade() != null) {
			criteria.add(Restrictions.eq("indFinalidade", peticaoCertidao.getIndFinalidade()));
		}

		if (peticaoCertidao.getIndTipoCertidao() != null) {
			criteria.add(Restrictions.eq("indTipoCertidao", peticaoCertidao.getIndTipoCertidao()));
		}

		if (peticaoCertidao.getNumProtocolo() != null) {
			criteria.add(Restrictions.eq("numProtocolo", peticaoCertidao.getNumProtocolo()));
		}

		if (peticaoCertidao.getCodMunicipio() != null) {
			criteria.add(Restrictions.eq("codMunicipio", peticaoCertidao.getCodMunicipio()));
		}
		
		if (peticaoCertidao.getIndSituacao() != null) {
			criteria.add(Restrictions.eq("indSituacao", peticaoCertidao.getIndSituacao()));
		}
		
		if(peticaoCertidao.getDataIncioEmissao() != null){
			 criteria.add(Restrictions.ge("dataGeracaoCertidao", peticaoCertidao.getDataIncioEmissao()));
		}
		if(peticaoCertidao.getDataFimEmissao() != null){
			 criteria.add(Restrictions.le("dataGeracaoCertidao", peticaoCertidao.getDataFimEmissao()));
		}
		
		if (peticaoCertidao.getTipoAnalise() != null) {
			criteria.add(Restrictions.eq("sglTipoAnalise", peticaoCertidao.getTipoAnalise().getSigla()));
		}
		
		criteria.addOrder(Order.asc("dataSolicitacao"));
		
		
		return (List<Certidao>) criteria.list();
	}

}
