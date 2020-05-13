package br.gov.mg.tce.business.pca;

import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.namespace.QName;

import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.client.pca.web.IndiceDelibInv;
import br.gov.mg.tce.client.pca.web.IndiceParecerPrevio;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWS;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWSService;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoSGAPBOLocal;
import br.gov.mg.tce.facade.ProcessoJulgadoAnaliseBOLocal;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;

@Stateless(name = "CertidaoSGAPBO", mappedName = "CertidaoSGAPBO")
public class CertidaoSGAPBO extends CertidaoPCAAanlise implements CertidaoSGAPBOLocal {

    @EJB
    private ProcessoJulgadoAnaliseBOLocal processoJulgadoAnaliseBO;

    @Override
    public void gerarCertidao() {

        List<CertidaoPCA> consultarPeticoesPorFiltros = peticaoCertidaoBO.consultarPeticoesParaJobAnalisesComProcessos(0);
        for (CertidaoPCA peticaoCertidao : consultarPeticoesPorFiltros) {
            try {

                // Recupera a analise validada mais atual pelo municipio e ano exercicio.
                IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)),
                        new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
                AnaliseDTO analiseAtual = integracaoWebECertidaoWS.buscarAnaliseConsolidadaPorMunicipioExercicio(peticaoCertidao.getCodMunicipio(), peticaoCertidao.getNumAnoRef().longValue());

                if (analiseAtual != null) {
                    ProcessoJulgadoAnalise processoJulgadoAnalise = processoJulgadoAnaliseBO.findByNumeroProcesso(analiseAtual.getNumProcesso());
                    //Se o processo estiver com status de ATJ ou IR, deve recuperar valores da aba do relator obrigatoriamente
                    if (EnumTipoAnalise.ANALISE_ATJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise()) || EnumTipoAnalise.ANALISE_IR.getSigla().equals(peticaoCertidao.getSglTipoAnalise())) {
                        IndiceParecerPrevio indiceParecerPrevio = analiseAtual.getIndiceParecerPrevio();
                        if (indiceParecerPrevio != null) {
                        	peticaoCertidao.setIndiceParecerPrevio(indiceParecerPrevio);
                            peticaoCertidao.setPercentInvEducacao(indiceParecerPrevio.getPercentInvEducacao());
                            peticaoCertidao.setPercentInvSaude(indiceParecerPrevio.getPercentInvSaude());
                            peticaoCertidao.setPercentInvPessoalExecutivo(indiceParecerPrevio.getPercentInvPessoalExecutivo());
                            peticaoCertidao.setPercentInvPessoalLegislativo(indiceParecerPrevio.getPercentInvPessoalLegislativo());
                            peticaoCertidao.setPercentInvPessoal(indiceParecerPrevio.getPercentInvPessoal());
                            peticaoCertidao.setIndInsignificancia(indiceParecerPrevio.isIndInsignificancia());
                            peticaoCertidao.setIndReconduzido(indiceParecerPrevio.isIndReconduzido());
                            peticaoCertidao.setPercentInvFundeb(Double.valueOf(recuperaIndiceFundeb(
                                    peticaoCertidao.getCodMunicipio().toString(),
                                    peticaoCertidao.getNumAnoRef().toString(),
                                    analiseAtual.getCodAnalise())));

                            peticaoCertidao.setCodAnalise(analiseAtual.getCodAnalise());

                            // Gera o documento PDF.
                            byte[] certidaoBytes;
                        	if (EnumTipoAnalise.ANALISE_ATJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise())) {
                        		certidaoBytes = this.gerarCertidao(peticaoCertidao, processoJulgadoAnalise);
                        	} else {
                        		certidaoBytes = this.gerarCertidao(peticaoCertidao, processoJulgadoAnalise);
                        	}
                            
                            peticaoCertidao.setArqCertidaoPdf(certidaoBytes);
                            peticaoCertidao.setDataGeracaoCertidao(new Date());
                            peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
                        }
                        //Se o processo estiver com status de TJ, deve recuperar valores da aba do deliberado obrigatoriamente
                    } else if (EnumTipoAnalise.ANALISE_TJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise())) {
                        IndiceDelibInv indiceDelibInv = analiseAtual.getIndiceDelibInv();
                        if (indiceDelibInv != null) {
                        	peticaoCertidao.setIndiceTransitoJulgado(indiceDelibInv);
                            peticaoCertidao.setPercentInvEducacao(indiceDelibInv.getPercentInvEducacao());
                            peticaoCertidao.setPercentInvSaude(indiceDelibInv.getPercentInvSaude());
                            peticaoCertidao.setPercentInvPessoalExecutivo(indiceDelibInv.getPercentInvPessoalExecutivo());
                            peticaoCertidao.setPercentInvPessoalLegislativo(indiceDelibInv.getPercentInvPessoalLegislativo());
                            peticaoCertidao.setPercentInvPessoal(indiceDelibInv.getPercentInvPessoal());
                            peticaoCertidao.setIndInsignificancia(indiceDelibInv.isIndInsignificancia());
                            peticaoCertidao.setIndReconduzido(indiceDelibInv.isIndReconduzido());
                            peticaoCertidao.setPercentInvFundeb(Double.valueOf(recuperaIndiceFundeb(
                                    peticaoCertidao.getCodMunicipio().toString(),
                                    peticaoCertidao.getNumAnoRef().toString(),
                                    analiseAtual.getCodAnalise())));

                            peticaoCertidao.setCodAnalise(analiseAtual.getCodAnalise());

                            // Gera o documento PDF.
                            byte[] certidaoBytes = this.gerarCertidao(peticaoCertidao, processoJulgadoAnalise);
                          
                            peticaoCertidao.setArqCertidaoPdf(certidaoBytes);
                            peticaoCertidao.setDataGeracaoCertidao(new Date());
                            peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
                        }
                    }
                    peticaoCertidaoBO.alterar(peticaoCertidao);
                }
            } catch (Exception e) {
            	eMailBO.enviarEmailErro(new Email(peticaoCertidao, "Parecer Previo - Transito em Julgado", e));
            }
        }

    }

}
