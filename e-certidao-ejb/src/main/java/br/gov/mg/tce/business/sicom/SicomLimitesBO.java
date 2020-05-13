package br.gov.mg.tce.business.sicom;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.namespace.QName;

import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWS;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWSService;
import br.gov.mg.tce.client.pca.core.ValoresDevidos;
import br.gov.mg.tce.dto.sicom.relatorio.ExercicioAndamento;
import br.gov.mg.tce.dto.sicom.relatorio.PrevisaoArrecadacaoImpostos;
import br.gov.mg.tce.dto.sicom.relatorio.limites.EnvioCompletoExercicioFechado;
import br.gov.mg.tce.dto.sicom.relatorio.limites.Limites;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.enumerator.MesEnum;
import br.gov.mg.tce.facade.SicomBOLocal;
import br.gov.mg.tce.facade.sicom.SicomCompetenciaTributariaBOLocal;
import br.gov.mg.tce.facade.sicom.SicomLimitesBOLocal;
import br.gov.mg.tce.model.CertidaoLimites;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.util.StringUtil;

@Stateless(name = "SicomLimitesBO", mappedName = "SicomLimitesBO")
public class SicomLimitesBO implements SicomLimitesBOLocal {

//	@PersistenceContext(unitName = "SICOMBI_NOVO")
	private EntityManager entityManagerSICOM;
	
	@EJB
	private SicomBOLocal sicomBO;
	
	@EJB
	private SicomCompetenciaTributariaBOLocal sicomCompetenciaTributariaBO;

	
	@Override
	public void consultarDadosCertidaoLimites(CertidaoLimites certidao) throws IOException {

		ExercicioAndamento exercicioEmAndamento = sicomBO.consultarExercicioEmAndamento();
		boolean isExercicioAndamento = certidao.getNumAnoRef().toString().equals(exercicioEmAndamento.getAno().toString());
		if(isExercicioAndamento){
			certidao.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
			certidao.setDataGeracaoCertidao(new Date());
			certidao.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_EXERC_ANDAMENTO);
		}else if(!isEnvioCompletoExercicio(certidao.getCodMunicipio(), certidao.getNumAnoRef())){
			
			certidao.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
			certidao.setDataGeracaoCertidao(new Date());
			certidao.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_SICOM);
		}else{
			
			Integer numAnoRef = certidao.getNumAnoRef();
			Long codMunicipio = certidao.getCodMunicipio();
			
			Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("limites/Limites.sql"), Limites.class);
			nativeQuery.setParameter("exercicioSelecionado", numAnoRef);
			nativeQuery.setParameter("municipioSelecionado", codMunicipio);
			nativeQuery.setParameter("mesSelecionado", MesEnum.DEZ.getNumMes());
			SicomUtil.setDataSelecionada(nativeQuery);
			
			try {
				Limites limites = (Limites) nativeQuery.getSingleResult();
				certidao.setDscOpcaoSemestralidade(limites.getOpcsem());
				certidao.setPctDespesaExecutivo(limites.getPrcdspexe().multiply(new BigDecimal(100)));
				certidao.setPctDespesaLegislativo(limites.getPrcdspleg().multiply(new BigDecimal(100)));
				
				atualizarGastoPessoal2018(codMunicipio, certidao, limites);
				certidao.setPctDespesaTotal(certidao.getPctDespesaExecutivo().add(certidao.getPctDespesaLegislativo()));
				
				certidao.setSitPubRgf(limites.getSitpubrgf());
				certidao.setSitPubRreo(limites.getSitpubrreo());
				
				certidao.setPctDividaConsExecutivo(limites.getPrcdivconliq().multiply(new BigDecimal(100)));
				certidao.setVlrDividaConsLrf(limites.getVlrdivcon());
				
				
				certidao.setPctConcGarantExecutivo(limites.getPrcconcgrt().multiply(new BigDecimal(100)));
				
				certidao.setPctOperCredExecutivo(limites.getPrcopsemaro().multiply(new BigDecimal(100)));
				certidao.setPctOperCredRealExec(limites.getPrcopsemaro().multiply(new BigDecimal(100)));
				
				certidao.setPctAroExecutivo(limites.getPrcaro().multiply(new BigDecimal(100)));
				
				PrevisaoArrecadacaoImpostos naoPrevisto = sicomCompetenciaTributariaBO.consultarImpostoNaoPrevisto(numAnoRef, codMunicipio);
				PrevisaoArrecadacaoImpostos naoArrecadado = sicomCompetenciaTributariaBO.consultarImpostoNaoArrecadado(numAnoRef, codMunicipio, MesEnum.DEZ.getNumMes());
				
				//8
				if(!StringUtil.isStringVazia(naoArrecadado.getDemostrativo())){
					certidao.setDscImpCompNaoArrecadados(naoArrecadado.getDemostrativo());
				}else{
					certidao.setDscImpCompNaoArrecadados("OK");
				}
				
				if(!StringUtil.isStringVazia(naoPrevisto.getDemostrativo())){
					certidao.setDscImpCompNaoPrevisto(naoPrevisto.getDemostrativo());
				}else{
					certidao.setDscImpCompNaoPrevisto("OK");
				}
				
				certidao.setDataGeracaoCertidao(new Date());
				certidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
			} catch (Exception e) {
				certidao.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
				certidao.setDataGeracaoCertidao(new Date());
				certidao.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_SICOM);
			}
		}
		
	}

	private boolean isEnvioCompletoExercicio(Long codMunicipio, Integer numAnoRef) throws IOException {
		
		EnvioCompletoExercicioFechado envioCompletoExercicioFechado;
		
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("limites/EnvioCompletoExercicioFechado.sql"), EnvioCompletoExercicioFechado.class);
		nativeQuery.setParameter("exercicioSelecionado", numAnoRef);
		nativeQuery.setParameter("municipioSelecionado", codMunicipio);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		try {
			envioCompletoExercicioFechado = (EnvioCompletoExercicioFechado) nativeQuery.getSingleResult();
		} catch (NoResultException e) {
			envioCompletoExercicioFechado = new EnvioCompletoExercicioFechado();
		}
		
		return Boolean.valueOf(envioCompletoExercicioFechado.getVisibilidade());
	}
	
	/*Atualiza o percentual gasto com pessoal com os valores devidos pelo estado nao repassado aos municipios no exercicio de 2018*/
	private void atualizarGastoPessoal2018(Long codMunicipio, CertidaoLimites certidao, Limites limites) throws Exception  {

		IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
                PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)), new QName("http://integracaocore.ecertidao.tcemg/", "IntegracaoCoreECertidaoWSService"))
                .getIntegracaoCoreECertidaoWSPort();
		ValoresDevidos valoresDevidos = integracaoCoreECertidaoWS.buscarPorMunicipio(codMunicipio.intValue());
		//fundeb + icms + RCL
		BigDecimal receitaLiquidaAtualizada = valoresDevidos.getVlrFundeb().add(valoresDevidos.getVlrIcms()).add(limites.getVlrrclliq());
		BigDecimal cem = new BigDecimal(100);
		BigDecimal pctExecutivoAtualizado = limites.getVlrdspexe().multiply(cem).divide(receitaLiquidaAtualizada, 2, RoundingMode.HALF_UP);
		BigDecimal pctLegislativoAtualizado = limites.getVlrdspleg().multiply(cem).divide(receitaLiquidaAtualizada, 2, RoundingMode.HALF_UP);
		
		certidao.setPctDespesaExecutivo(pctExecutivoAtualizado);
		certidao.setPctDespesaLegislativo(pctLegislativoAtualizado);
	}
}
