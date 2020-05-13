package br.gov.mg.tce.business.pca;

import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.xml.namespace.QName;

import br.gov.mg.tce.client.pca.core.IndicesDTO;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWS;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWSService;
import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWS;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWSService;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoPCAConsolidaBOLocal;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;

@Stateless(name = "CertidaoAnaliseConsolidaBO", mappedName = "CertidaoAnaliseConsolidaBO")
public class CertidaoPCAConsolidaBO extends CertidaoPCAAanlise implements CertidaoPCAConsolidaBOLocal {

    @Override
    public void gerarCertidao(Integer qtde) {


        // Recupera todas as certidoes que estao com tipo de analise consolidada, para serem processadas.
        CertidaoPCA peticaoCertidaoFiltro = new CertidaoPCA();
        peticaoCertidaoFiltro.setIndSituacao(IndSituacaoCertidaoEnum.EM_ANALISE);
        peticaoCertidaoFiltro.setSglTipoAnalise(EnumTipoAnalise.ANALISE_CONSOLIDADA.getSigla());
        List<CertidaoPCA> consultarPeticoesPorFiltros = peticaoCertidaoBO.consultarPeticoesPorFiltros(peticaoCertidaoFiltro, qtde);
        
//            CertidaoPCA obter = peticaoCertidaoBO.obter(86615L);
//            List<CertidaoPCA> consultarPeticoesPorFiltros = new ArrayList<>();
//            consultarPeticoesPorFiltros.add(obter);
        

        for (CertidaoPCA peticaoCertidao : consultarPeticoesPorFiltros) {
            try {

            	// Recupera a analise consoldiada
                IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)),
                        new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
                AnaliseDTO analiseConsolidada = integracaoWebECertidaoWS.buscarAnaliseConsolidadaPorMunicipioExercicio(peticaoCertidao.getCodMunicipio(), peticaoCertidao.getNumAnoRef().longValue());
         
                if (analiseConsolidada != null) {

                    IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)),
                            new QName("http://integracaocore.ecertidao.tcemg/", "IntegracaoCoreECertidaoWSService")).getIntegracaoCoreECertidaoWSPort();
                    IndicesDTO indices = integracaoCoreECertidaoWS.recuperaIndicePCA(analiseConsolidada.getCodAnalise(), true);
                    peticaoCertidao.setPercentInvEducacao(indices.getPercentInvEducacao());
                    peticaoCertidao.setPercentInvSaude(indices.getPercentInvSaude());
                    
                    if(peticaoCertidao.getNumAnoRef() != 2018){
                    	peticaoCertidao.setPercentInvPessoalExecutivo(indices.getPercentInvPessoalExecutivo());
                    	peticaoCertidao.setPercentInvPessoalLegislativo(indices.getPercentInvPessoalLegislativo());
                    	peticaoCertidao.setPercentInvPessoal(indices.getPercentInvPessoalExecutivo() + indices.getPercentInvPessoalLegislativo());
                    }else{
                    	peticaoCertidao.setPercentInvPessoalExecutivo(indices.getPercentInvPessoalExecutivoAtualizado());
                    	peticaoCertidao.setPercentInvPessoalLegislativo(indices.getPercentInvPessoalLegislativoAtualizado());
                    	peticaoCertidao.setPercentInvPessoal(indices.getPercentInvPessoalExecutivoAtualizado() + indices.getPercentInvPessoalLegislativoAtualizado());
                    }
                    
                    peticaoCertidao.setPercentInvFundeb(Double.valueOf(recuperaIndiceFundeb(
                            peticaoCertidao.getCodMunicipio().toString(),
                            peticaoCertidao.getNumAnoRef().toString(),
                            analiseConsolidada.getCodAnalise())));

                    peticaoCertidao.setCodAnalise(analiseConsolidada.getCodAnalise());
                    // Gera o documento PDF.
                    byte[] certidaoBytes = this.gerarCertidao(peticaoCertidao, null);
                    peticaoCertidao.setArqCertidaoPdf(certidaoBytes);
                    peticaoCertidao.setDataGeracaoCertidao(new Date());
                    peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
                } else {
                    peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
                    peticaoCertidao.setDataGeracaoCertidao(new Date());
                    peticaoCertidao.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_PCA);
                }

                
                peticaoCertidaoBO.alterar(peticaoCertidao);
            } catch (Exception e) {
            	peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
            	eMailBO.enviarEmailErro(new Email(peticaoCertidao, "Pca Analise", e));
            }finally{
            	peticaoCertidaoBO.alterar(peticaoCertidao);
            }
        }
    }

}
