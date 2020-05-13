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
import br.gov.mg.tce.facade.CertidaoPCADefesaValidadaBOLocal;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;

@Stateless(name = "CertidaoPCADefesaValidadaBO", mappedName = "CertidaoPCADefesaValidadaBO")
public class CertidaoPCADefesaValidadaBO extends CertidaoPCAAanlise implements CertidaoPCADefesaValidadaBOLocal {

    @Override
    public void gerarCertidao(Integer qtde) {


        // Recupera todas as certidoes que estao com tipo de analise consolidada, para serem processadas.
        CertidaoPCA peticaoCertidaoFiltro = new CertidaoPCA();
        peticaoCertidaoFiltro.setIndSituacao(IndSituacaoCertidaoEnum.EM_ANALISE);
        peticaoCertidaoFiltro.setSglTipoAnalise(EnumTipoAnalise.ANALISE_DE_DEFESA.getSigla());
        List<CertidaoPCA> consultarPeticoesPorFiltros = peticaoCertidaoBO.consultarPeticoesPorFiltros(peticaoCertidaoFiltro, qtde);

        for (CertidaoPCA peticaoCertidao : consultarPeticoesPorFiltros) {
            try {

                // Verifica se existe uma certidao com o mesmo municipio e ano de exercicio ja gerada.
                CertidaoPCA peticaoCertidaoRecente = peticaoCertidaoBO.consultarPeticaoGeradaPorTipoAnalise(peticaoCertidao.getCodMunicipio(), peticaoCertidao.getNumAnoRef(), peticaoCertidao.getSglTipoAnalise());
                if (peticaoCertidaoRecente != null) {

                    peticaoCertidao.setPercentInvEducacao(peticaoCertidaoRecente.getPercentInvEducacao());
                    peticaoCertidao.setPercentInvSaude(peticaoCertidaoRecente.getPercentInvSaude());
                    peticaoCertidao.setPercentInvPessoalExecutivo(peticaoCertidaoRecente.getPercentInvPessoalExecutivo());
                    peticaoCertidao.setPercentInvPessoalLegislativo(peticaoCertidaoRecente.getPercentInvPessoalLegislativo());
                    peticaoCertidao.setPercentInvPessoal(peticaoCertidaoRecente.getPercentInvPessoalExecutivo() + peticaoCertidaoRecente.getPercentInvPessoalLegislativo());
                    peticaoCertidao.setPercentInvFundeb(Double.valueOf(recuperaIndiceFundeb(
                            peticaoCertidao.getCodMunicipio().toString(),
                            peticaoCertidao.getNumAnoRef().toString(),
                            peticaoCertidaoRecente.getCodAnalise())));

                    peticaoCertidao.setCodAnalise(peticaoCertidaoRecente.getCodAnalise());
                    // Gera o documento PDF.
                    byte[] certidaoBytes = this.gerarCertidao(peticaoCertidao, null);
                    peticaoCertidao.setArqCertidaoPdf(certidaoBytes);
                    peticaoCertidao.setDataGeracaoCertidao(new Date());
                    peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
                } else {
                    // Recupera a analise consoldiada
                    IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)),
                            new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
                    AnaliseDTO analiseDefesaValidada = integracaoWebECertidaoWS.buscarUltimaAnaliseDefesaValidadaPorMunicipioExercicio(peticaoCertidao.getCodMunicipio(), peticaoCertidao.getNumAnoRef().longValue());
                    if (analiseDefesaValidada != null) {

                        IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)),
                                new QName("http://integracaocore.ecertidao.tcemg/", "IntegracaoCoreECertidaoWSService")).getIntegracaoCoreECertidaoWSPort();
                        IndicesDTO indices = integracaoCoreECertidaoWS.recuperaIndicePCA(analiseDefesaValidada.getCodAnalise(), false);
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
                                analiseDefesaValidada.getCodAnalise())));

                        peticaoCertidao.setCodAnalise(analiseDefesaValidada.getCodAnalise());
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

                }
                peticaoCertidaoBO.alterar(peticaoCertidao);
            } catch (Exception e) {
            	eMailBO.enviarEmailErro(new Email(peticaoCertidao, "Pca Analise Defesa Validada", e));
                peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
            }finally{
            	peticaoCertidaoBO.alterar(peticaoCertidao);
            }
        }
    }
}
