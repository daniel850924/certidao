package br.gov.mg.tce.business.pca;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.namespace.QName;

import br.gov.mg.tce.client.pca.core.IndicesDTO;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWS;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWSService;
import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.client.pca.web.IndiceInvPrePca;
import br.gov.mg.tce.client.pca.web.IndiceSubstituta;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWS;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWSService;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.dto.sicom.relatorio.PrePca;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoPrePCABOLocal;
import br.gov.mg.tce.facade.SicomBOLocal;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;

@Stateless(name = "CertidaoPrePCABO", mappedName = "CertidaoPrePCABO")
public class CertidaoPrePCABO extends CertidaoPCAAanlise implements CertidaoPrePCABOLocal {

	@EJB
	private SicomBOLocal sicomBO;
	
	@Override
	public void gerarCertidao(Integer qtde) {

		CertidaoPCA peticaoCertidaoFiltro = new CertidaoPCA();
		peticaoCertidaoFiltro.setIndSituacao(IndSituacaoCertidaoEnum.EM_ANALISE);
		peticaoCertidaoFiltro.setSglTipoAnalise(EnumTipoAnalise.ANALISE_PRE_PCA.getSigla());
		List<CertidaoPCA> consultarPeticoesPorFiltros = peticaoCertidaoBO.consultarPeticoesPorFiltros(peticaoCertidaoFiltro, qtde);

//		CertidaoPCA obter = peticaoCertidaoBO.obter(84628L);
//      List<CertidaoPCA> consultarPeticoesPorFiltros = new ArrayList<>();
//      consultarPeticoesPorFiltros.add(obter);
		
		for (CertidaoPCA peticaoCertidao : consultarPeticoesPorFiltros) {

			try {
				
				if(peticaoCertidao.getNumAnoRef() == 2019){
					
					CertidaoPCA peticaoCertidaoRecente = peticaoCertidaoBO.consultarPeticaoGeradaPorTipoAnalise(peticaoCertidao.getCodMunicipio(), peticaoCertidao.getNumAnoRef(), peticaoCertidao.getSglTipoAnalise());
			         if (peticaoCertidaoRecente != null) {

	                        peticaoCertidao.setPercentInvEducacao(peticaoCertidaoRecente.getPercentInvEducacao());
	                        peticaoCertidao.setPercentInvSaude(peticaoCertidaoRecente.getPercentInvSaude());
	                        peticaoCertidao.setPercentInvPessoalExecutivo(peticaoCertidaoRecente.getPercentInvPessoalExecutivo());
	                        peticaoCertidao.setPercentInvPessoalLegislativo(peticaoCertidaoRecente.getPercentInvPessoalLegislativo());
	                        peticaoCertidao.setPercentInvPessoal(peticaoCertidaoRecente.getPercentInvPessoal());
	                        peticaoCertidao.setPercentInvFundeb(peticaoCertidaoRecente.getPercentInvFundeb());
			         }else{

			        	 Map<Integer, PrePca> mapIndicePrePca = sicomBO.consultarIndicePrePca(peticaoCertidao.getCodMunicipio(), peticaoCertidao.getNumAnoRef());
			        	 if(mapIndicePrePca == null || mapIndicePrePca.isEmpty()){
			        		 
			        		 peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
			        		 peticaoCertidao.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_PCA);
			        		 peticaoCertidaoBO.alterar(peticaoCertidao);
			        		 continue;
			        	 }else{
			        		 
			        		 peticaoCertidao.setPercentInvSaude(mapIndicePrePca.get(PrePca.SAUDE).getVlrpctapl().doubleValue());
			        		 peticaoCertidao.setPercentInvEducacao(mapIndicePrePca.get(PrePca.ENSINO).getVlrpctapl().doubleValue());
			        		 peticaoCertidao.setPercentInvPessoal(mapIndicePrePca.get(PrePca.DESP_PESSOAL).getVlrpctapl().doubleValue());
			        		 peticaoCertidao.setPercentInvPessoalExecutivo(mapIndicePrePca.get(PrePca.DESP_EXECUTIVO).getVlrpctapl().doubleValue());
			        		 peticaoCertidao.setPercentInvPessoalLegislativo(mapIndicePrePca.get(PrePca.DESP_LEGISLATIVO).getVlrpctapl().doubleValue());
			        		 peticaoCertidao.setPercentInvFundeb(mapIndicePrePca.get(PrePca.FUNDEB).getVlrpctapl().doubleValue());
			        	 }
			         }
					
					
				}else{
					preencherIndicesAnterior2019(peticaoCertidao);
				}
				

				// Gera o documento PDF.
				byte[] certidaoBytes = this.gerarCertidao(peticaoCertidao, null);
				peticaoCertidao.setArqCertidaoPdf(certidaoBytes);
				peticaoCertidao.setDataGeracaoCertidao(new Date());
				peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);

				peticaoCertidaoBO.alterar(peticaoCertidao);
			} catch (Exception e) {
				eMailBO.enviarEmailErro(new Email(peticaoCertidao, "Pre Pca", e));
				peticaoCertidao.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
			}finally{
				peticaoCertidaoBO.alterar(peticaoCertidao);
			}
		}
	}

	private void preencherIndicesAnterior2019(CertidaoPCA peticaoCertidao) throws Exception {
		
		IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
				PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)), new QName("http://integracaoweb.ecertidao.tcemg/",
						"IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
		AnaliseDTO analiseConsolidada = integracaoWebECertidaoWS.buscarAnaliseConsolidadaPorMunicipioExercicio(peticaoCertidao.getCodMunicipio(),
				peticaoCertidao.getNumAnoRef().longValue());
		IndiceInvPrePca indiceInvPrePca = analiseConsolidada.getIndiceInvPrePca();
		IndiceSubstituta indiceSubstituta = analiseConsolidada.getIndiceSubstituta();
		
		if (indiceSubstituta != null) {
			
			peticaoCertidao.setPercentInvEducacao(indiceSubstituta.getPercentInvEducacao());
			peticaoCertidao.setPercentInvSaude(indiceSubstituta.getPercentInvSaude());
			peticaoCertidao.setPercentInvPessoalExecutivo(indiceSubstituta.getPercentInvPessoalExecutivo());
			peticaoCertidao.setPercentInvPessoalLegislativo(indiceSubstituta.getPercentInvPessoalLegislativo());
			peticaoCertidao.setPercentInvPessoal(indiceSubstituta.getPercentInvPessoal());
			peticaoCertidao.setPercentInvFundeb(indiceSubstituta.getPercentInvFundeb());
			peticaoCertidao.setCodAnalise(analiseConsolidada.getCodAnalise());
			peticaoCertidao.setSglTipoAnalise(EnumTipoAnalise.ANALISE_SUBSTITUA.getSigla());
		} else if (indiceInvPrePca != null) {
			
			if (!indiceInvPrePca.isBolNaoIndice()) {
				peticaoCertidao.setPercentInvEducacao(indiceInvPrePca.getPercentInvEducacao());
				peticaoCertidao.setPercentInvSaude(indiceInvPrePca.getPercentInvSaude());
				peticaoCertidao.setPercentInvPessoalExecutivo(indiceInvPrePca.getPercentInvPessoalExecutivo());
				peticaoCertidao.setPercentInvPessoalLegislativo(indiceInvPrePca.getPercentInvPessoalLegislativo());
				peticaoCertidao.setPercentInvPessoal(indiceInvPrePca.getPercentInvPessoalExecutivo()
						+ indiceInvPrePca.getPercentInvPessoalLegislativo());
				
				if (peticaoCertidao.getNumAnoRef() == 2018) {
					peticaoCertidao.setPercentInvFundeb(indiceInvPrePca.getPercentInvFundeb());
				} else {
					peticaoCertidao.setPercentInvFundeb(Double.valueOf(recuperaIndiceFundeb(peticaoCertidao.getCodMunicipio().toString(),
							peticaoCertidao.getNumAnoRef().toString(), analiseConsolidada.getCodAnalise())));
				}
				peticaoCertidao.setCodAnalise(analiseConsolidada.getCodAnalise());
			} else {
				
				IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance()
						.getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)), new QName("http://integracaocore.ecertidao.tcemg/",
								"IntegracaoCoreECertidaoWSService")).getIntegracaoCoreECertidaoWSPort();
				IndicesDTO indices = integracaoCoreECertidaoWS.recuperaIndicePCA(analiseConsolidada.getCodAnalise(), true);
				peticaoCertidao.setPercentInvEducacao(indices.getPercentInvEducacao());
				peticaoCertidao.setPercentInvSaude(indices.getPercentInvSaude());
				peticaoCertidao.setPercentInvPessoalExecutivo(indices.getPercentInvPessoalExecutivo());
				peticaoCertidao.setPercentInvPessoalLegislativo(indices.getPercentInvPessoalLegislativo());
				peticaoCertidao.setPercentInvPessoal(indices.getPercentInvPessoalExecutivo() + indices.getPercentInvPessoalLegislativo());
				peticaoCertidao.setPercentInvFundeb(Double.valueOf(recuperaIndiceFundeb(peticaoCertidao.getCodMunicipio().toString(), peticaoCertidao
						.getNumAnoRef().toString(), analiseConsolidada.getCodAnalise())));
				peticaoCertidao.setSglTipoAnalise(EnumTipoAnalise.ANALISE_CONSOLIDADA.getSigla());
				peticaoCertidao.setCodAnalise(analiseConsolidada.getCodAnalise());
			}
		}
	}

}
