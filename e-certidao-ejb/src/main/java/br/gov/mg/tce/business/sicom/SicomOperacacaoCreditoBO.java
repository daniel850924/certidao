package br.gov.mg.tce.business.sicom;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.xml.namespace.QName;

import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWS;
import br.gov.mg.tce.client.pca.core.IntegracaoCoreECertidaoWSService;
import br.gov.mg.tce.client.pca.core.ValoresDevidos;
import br.gov.mg.tce.dto.sicom.relatorio.OptanteSemestralidade;
import br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito.OperacaoCreditoExercFechado;
import br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito.OperacaoCreditoExercicioAndamentoTab1;
import br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito.OperacaoCreditoExercicioAndamentoTab2;
import br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito.OperacaoCreditoParecerPrevioTab1;
import br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito.OperacaoCreditoParecerPrevioTab3;
import br.gov.mg.tce.enumerator.IndSimNaoEnum;
import br.gov.mg.tce.facade.sicom.SicomOperacacaoCreditoBOLocal;
import br.gov.mg.tce.model.CertidaoOperacaoCredito;
import br.gov.mg.tce.model.OperacaoCreditoDados;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.util.DateUtil;

@Stateless(name = "SicomOperacacaoCreditoBO", mappedName = "SicomOperacacaoCreditoBO")
public class SicomOperacacaoCreditoBO implements SicomOperacacaoCreditoBOLocal {

//	@PersistenceContext(unitName = "SICOMBI_NOVO")
	private EntityManager entityManagerSICOM;
	
	@Override
	public void consultarDadosCertidaoOperacaoCredito(CertidaoOperacaoCredito certidaoOperacaoCredito) throws Exception {

		Long codMunicipioIbge = certidaoOperacaoCredito.getCodMunicipio(); 
		Integer ultimoExercicioParecerPrevio = certidaoOperacaoCredito.getNumUltExercAna();
		List<OperacaoCreditoDados> dadosOperacaoCredito = new LinkedList<OperacaoCreditoDados>();

		//parecer previo
		OperacaoCreditoDados operacaoCreditoDadosParecerPrevio = consultaDadosParecerPrevio(codMunicipioIbge, ultimoExercicioParecerPrevio, certidaoOperacaoCredito);
		dadosOperacaoCredito.add(operacaoCreditoDadosParecerPrevio);
		
		//exercicios fechados
		List<OperacaoCreditoDados> creditoDadosFechado = consultaDadosExercFechado(codMunicipioIbge, ultimoExercicioParecerPrevio);
		dadosOperacaoCredito.addAll(creditoDadosFechado);
		
		//exercicio andamento
		Integer exercicioAndamento = ultimoExercicioParecerPrevio + creditoDadosFechado.size() + 1;
		certidaoOperacaoCredito.setExercicioAndamento(exercicioAndamento);
		OperacaoCreditoDados operacaoCreditoDadoAndamento = consultaDadosExercAndamento(codMunicipioIbge, exercicioAndamento);
		dadosOperacaoCredito.add(operacaoCreditoDadoAndamento);
		
		//amarracao
		certidaoOperacaoCredito.setDadosOperacaoCredito(dadosOperacaoCredito);
		for (OperacaoCreditoDados operacaoCreditoDados : dadosOperacaoCredito) {
			operacaoCreditoDados.setOperacaoCredito(certidaoOperacaoCredito);
		}
	}
	
	private OperacaoCreditoDados consultaDadosParecerPrevio(Long codMunicipioIbge, Integer ultimoExercicioParecerPrevio, CertidaoOperacaoCredito certidaoOperacaoCredito) throws IOException {
		
		OperacaoCreditoDados operacaoCreditoDadosParecerPrevio = new OperacaoCreditoDados();
		operacaoCreditoDadosParecerPrevio.setNumExercicio(ultimoExercicioParecerPrevio);
		
		OperacaoCreditoParecerPrevioTab1 operacaoCreditoParecerPrevioTab1 = getTab1ParecerPrevio(codMunicipioIbge, ultimoExercicioParecerPrevio);
		OperacaoCreditoParecerPrevioTab3 operacaoCreditoParecerPrevioTab3 = getTab3ParecerPrevio(codMunicipioIbge, ultimoExercicioParecerPrevio);
		
		//1
		operacaoCreditoDadosParecerPrevio.setVlrRecOperacaoCredito(operacaoCreditoParecerPrevioTab1.getValor_receita());
		operacaoCreditoDadosParecerPrevio.setVlrDespesaCapitalDotIni(operacaoCreditoParecerPrevioTab1.getValor_despesa());
		
		if(ultimoExercicioParecerPrevio == 2014){
			operacaoCreditoDadosParecerPrevio.setIndContratacaoOp(
					Boolean.valueOf(certidaoOperacaoCredito.getIndContratacaoOP2014() == null ? "false" : certidaoOperacaoCredito.getIndContratacaoOP2014().getLabel()));
			operacaoCreditoDadosParecerPrevio.setIndRealizacaoOp(
					Boolean.valueOf(certidaoOperacaoCredito.getIndRealizacaoOP2014() == null ? "false" : certidaoOperacaoCredito.getIndRealizacaoOP2014().getLabel()));
		}else if(ultimoExercicioParecerPrevio == 2015){
			operacaoCreditoDadosParecerPrevio.setIndContratacaoOp(
					Boolean.valueOf(certidaoOperacaoCredito.getIndContratacaoOP2015() == null ? "false" : certidaoOperacaoCredito.getIndContratacaoOP2015().getLabel()));
			operacaoCreditoDadosParecerPrevio.setIndRealizacaoOp(
					Boolean.valueOf(certidaoOperacaoCredito.getIndRealizacaoOP2015() == null ? "false" : certidaoOperacaoCredito.getIndRealizacaoOP2015().getLabel()));
		}else{
			//2
			operacaoCreditoDadosParecerPrevio.setIndContratacaoOp("SIM".equalsIgnoreCase(operacaoCreditoParecerPrevioTab1.getContopcredito()));
			//3
			operacaoCreditoDadosParecerPrevio.setIndRealizacaoOp("SIM".equalsIgnoreCase(operacaoCreditoParecerPrevioTab1.getRealizopcredito()));
		}
		
		//4
		operacaoCreditoDadosParecerPrevio.setDtPublicacaoRREO12(DateUtil.converterStringParaDate(operacaoCreditoParecerPrevioTab3.getDatpubrreo()));
		operacaoCreditoDadosParecerPrevio.setIndPublicacaoRREO12Temp("INTEMPESTIVO".equalsIgnoreCase(operacaoCreditoParecerPrevioTab3.getSitpubrreo()) ? IndSimNaoEnum.N : IndSimNaoEnum.S);
		//5
		operacaoCreditoDadosParecerPrevio.setDtPublicacaoRGF12(DateUtil.converterStringParaDate(operacaoCreditoParecerPrevioTab3.getDatpubrgf()));
		operacaoCreditoDadosParecerPrevio.setIndPublicacaoRGF12Temp("INTEMPESTIVO".equalsIgnoreCase(operacaoCreditoParecerPrevioTab3.getSitpubrgf()) ? IndSimNaoEnum.N : IndSimNaoEnum.S);
		//6
		operacaoCreditoDadosParecerPrevio.setVlrDespesaTotPessoalExec(operacaoCreditoParecerPrevioTab3.getVlrdspexe());
		operacaoCreditoDadosParecerPrevio.setVlrDespesaTotPessoalLeg(operacaoCreditoParecerPrevioTab3.getVlrdspleg());
		operacaoCreditoDadosParecerPrevio.setPctDespesaTotPessoalExec(operacaoCreditoParecerPrevioTab3.getPrcdspexe().multiply(new BigDecimal(100)));
		operacaoCreditoDadosParecerPrevio.setPctDespesaTotPessoalLeg(operacaoCreditoParecerPrevioTab3.getPrcdspleg().multiply(new BigDecimal(100)));
		
		return operacaoCreditoDadosParecerPrevio;
	}
	
	private OperacaoCreditoParecerPrevioTab1 getTab1ParecerPrevio(Long codMunicipioIbge, Integer ultimoExercicioParecerPrevio) throws IOException {
		
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("operacaoCredito/OperacaoCreditoParecerPrevioTab1.sql"), OperacaoCreditoParecerPrevioTab1.class);
		nativeQuery.setParameter("municipioSelecionado", codMunicipioIbge);
		nativeQuery.setParameter("exercicioSelecionado", ultimoExercicioParecerPrevio);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		OperacaoCreditoParecerPrevioTab1 operacaoCreditoParecerPrevioTab1 = (OperacaoCreditoParecerPrevioTab1) nativeQuery.getSingleResult();
		
		return operacaoCreditoParecerPrevioTab1;
	}
	
	private OperacaoCreditoParecerPrevioTab3 getTab3ParecerPrevio(Long codMunicipioIbge, Integer ultimoExercicioParecerPrevio) throws IOException {
		
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("operacaoCredito/OperacaoCreditoParecerPrevioTab3.sql"), OperacaoCreditoParecerPrevioTab3.class);
		nativeQuery.setParameter("municipioSelecionado", codMunicipioIbge);
		nativeQuery.setParameter("exercicioParecerSelecionado", ultimoExercicioParecerPrevio);
		nativeQuery.setParameter("mesSelecionado", 12);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		OperacaoCreditoParecerPrevioTab3 operacaoCreditoParecerPrevioTab3 = (OperacaoCreditoParecerPrevioTab3) nativeQuery.getSingleResult();
		
		return operacaoCreditoParecerPrevioTab3;
	}
	
	private List<OperacaoCreditoDados> consultaDadosExercFechado(Long codMunicipioIbge, Integer ultimoExercicioParecerPrevio) throws Exception {

		List<OperacaoCreditoDados> creditoDadosFechado = new ArrayList<OperacaoCreditoDados>();
			
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("operacaoCredito/OperacaoCreditoExercicioFechado.sql"), OperacaoCreditoExercFechado.class);
		nativeQuery.setParameter("municipioSelecionado", codMunicipioIbge);
		nativeQuery.setParameter("exercicioParecerSelecionado", ultimoExercicioParecerPrevio);
		nativeQuery.setParameter("mesSelecionado", 12);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		List<?> listOpExercFechado = nativeQuery.getResultList();
		for (Object object : listOpExercFechado) {
			
			OperacaoCreditoExercFechado operacaoCreditoExercFechado = (OperacaoCreditoExercFechado) object;
			OperacaoCreditoDados operacaoCreditoDadosExercFechado = new OperacaoCreditoDados();
			operacaoCreditoDadosExercFechado.setNumExercicio(operacaoCreditoExercFechado.getAno().intValue());
			
			operacaoCreditoDadosExercFechado.setIndOpcao12("OPTANTE".equalsIgnoreCase(operacaoCreditoExercFechado.getOpsemestralidade()) ? IndSimNaoEnum.S : IndSimNaoEnum.N);
			
			//1 
			operacaoCreditoDadosExercFechado.setVlrRecOperacaoCredito(operacaoCreditoExercFechado.getPrevrecopcrd());
			operacaoCreditoDadosExercFechado.setVlrDespesaCapitalDotIni(operacaoCreditoExercFechado.getDspcapdotini());
			//4
			operacaoCreditoDadosExercFechado.setDtPublicacaoRREO12(DateUtil.converterStringParaDate(operacaoCreditoExercFechado.getDatpubrreo()));
			operacaoCreditoDadosExercFechado.setIndPublicacaoRREO12Temp("INTEMPESTIVO".equalsIgnoreCase(operacaoCreditoExercFechado.getSitpubrreo()) ? IndSimNaoEnum.N : IndSimNaoEnum.S);
			//5
			operacaoCreditoDadosExercFechado.setDtPublicacaoRGF12(DateUtil.converterStringParaDate(operacaoCreditoExercFechado.getDatpubrgf()));
			operacaoCreditoDadosExercFechado.setIndPublicacaoRGF12Temp("INTEMPESTIVO".equalsIgnoreCase(operacaoCreditoExercFechado.getSitpubrgf()) ? IndSimNaoEnum.N : IndSimNaoEnum.S);
			
			
			operacaoCreditoDadosExercFechado.setVlrDespesaTotPessoalExec(operacaoCreditoExercFechado.getVlrdspexe());
			operacaoCreditoDadosExercFechado.setVlrDespesaTotPessoalLeg(operacaoCreditoExercFechado.getVlrdspleg());
			
			if(operacaoCreditoExercFechado.getAno().intValue() == 2018){
				atualizarGastoPessoal2018(codMunicipioIbge,	operacaoCreditoDadosExercFechado, operacaoCreditoExercFechado);
				
			}else{
				operacaoCreditoDadosExercFechado.setPctDespesaTotPessoalExec(operacaoCreditoExercFechado.getPrcdspexe().multiply(new BigDecimal(100)));
				operacaoCreditoDadosExercFechado.setPctDespesaTotPessoalLeg(operacaoCreditoExercFechado.getPrcdspleg().multiply(new BigDecimal(100)));
			}
			
			creditoDadosFechado.add(operacaoCreditoDadosExercFechado);
		}
		
		return creditoDadosFechado;
	}
	
	/*Atualiza o percentual gasto com pessoal com os valores devidos pelo estado nao repassado aos municipios no exercicio de 2018*/
	private void atualizarGastoPessoal2018(Long codMunicipioIbge, OperacaoCreditoDados operacaoCreditoDadosExercFechado, 
			OperacaoCreditoExercFechado operacaoCreditoExercFechado) throws Exception {
		
		IntegracaoCoreECertidaoWS integracaoCoreECertidaoWS = new IntegracaoCoreECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(
                PropertiesVariaveisEnum.URL_INTEGRACAO_CORE_CERTIDAO)), new QName("http://integracaocore.ecertidao.tcemg/", "IntegracaoCoreECertidaoWSService"))
                .getIntegracaoCoreECertidaoWSPort();
		ValoresDevidos valoresDevidos = integracaoCoreECertidaoWS.buscarPorMunicipio(codMunicipioIbge.intValue());
		//fundeb + icms + RCL
		BigDecimal receitaLiquidaAtualizada = valoresDevidos.getVlrFundeb().add(valoresDevidos.getVlrIcms()).add(operacaoCreditoExercFechado.getVlrrclliq());
		BigDecimal cem = new BigDecimal(100);
		BigDecimal pctExecutivoAtualizado = operacaoCreditoExercFechado.getVlrdspexe().multiply(cem).divide(receitaLiquidaAtualizada, 2, RoundingMode.HALF_UP);
		BigDecimal pctLegislativoAtualizado = operacaoCreditoExercFechado.getVlrdspleg().multiply(cem).divide(receitaLiquidaAtualizada, 2, RoundingMode.HALF_UP);
		
		operacaoCreditoDadosExercFechado.setPctDespesaTotPessoalExec(pctExecutivoAtualizado);
		operacaoCreditoDadosExercFechado.setPctDespesaTotPessoalLeg(pctLegislativoAtualizado);
		
	}
	
	private OperacaoCreditoDados consultaDadosExercAndamento(Long codMunicipioIbge, Integer exercicioAndamento) throws IOException {
		
		OperacaoCreditoDados operacaoCreditoDadoAndamento = new OperacaoCreditoDados();
		operacaoCreditoDadoAndamento.setNumExercicio(exercicioAndamento);
		
		OperacaoCreditoExercicioAndamentoTab1 operacaoCreditoExercicioAndamentoTab1 = getTab1ExercicioAndamento(codMunicipioIbge, exercicioAndamento);
		//1
		operacaoCreditoDadoAndamento.setVlrRecOperacaoCredito(operacaoCreditoExercicioAndamentoTab1.getValor_receita());
		operacaoCreditoDadoAndamento.setVlrDespesaCapitalDotIni(operacaoCreditoExercicioAndamentoTab1.getValor_despesa());
		
		boolean isOptanteSemestralidade = isOptanteSemestralidade(codMunicipioIbge, exercicioAndamento);

		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("operacaoCredito/OperacaoCreditoExercicioAndamentoTab2.sql"), OperacaoCreditoExercicioAndamentoTab2.class);
		nativeQuery.setParameter("municipioSelecionado", codMunicipioIbge);
		nativeQuery.setParameter("exercicioCursoSelecionado", exercicioAndamento);
		nativeQuery.setParameter("mesSelecionado", 12);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		List<?> listOpExercAndamento = nativeQuery.getResultList();
		for (Object object : listOpExercAndamento) {
			OperacaoCreditoExercicioAndamentoTab2 operacaoCreditoExercAndamentoTab2 = (OperacaoCreditoExercicioAndamentoTab2) object;

			Integer mesBase = DateUtil.getMesData(DateUtil.converterStringParaDate(operacaoCreditoExercAndamentoTab2.getDt_base()));
			
			operacaoCreditoDadoAndamento.setNumMesBase(mesBase);
			if(!isOptanteSemestralidade || 
					(isOptanteSemestralidade && (mesBase.equals(6) || mesBase.equals(12))  )){
				operacaoCreditoDadoAndamento.setVlrDespesaTotPessoalExec(operacaoCreditoExercAndamentoTab2.getVlr_dsp_executivo());
				operacaoCreditoDadoAndamento.setPctDespesaTotPessoalExec(operacaoCreditoExercAndamentoTab2.getPrc_dps_exe().multiply(new BigDecimal(100)));
				operacaoCreditoDadoAndamento.setVlrDespesaTotPessoalLeg(operacaoCreditoExercAndamentoTab2.getVlr_dsp_legislativo());
				operacaoCreditoDadoAndamento.setPctDespesaTotPessoalLeg(operacaoCreditoExercAndamentoTab2.getPrc_dps_leg().multiply(new BigDecimal(100))); 
			}
			
			
			//4
			IndSimNaoEnum indPublicacaoRREO = "INTEMPESTIVO".equalsIgnoreCase(operacaoCreditoExercAndamentoTab2.getSituacaorreo()) ? IndSimNaoEnum.N : IndSimNaoEnum.S;
			Date publicacaoRREO = DateUtil.converterStringParaDate(operacaoCreditoExercAndamentoTab2.getDta_pub_rel_lrf());
			
			//5
			IndSimNaoEnum indPublicacaoRGF = "INTEMPESTIVO".equalsIgnoreCase(operacaoCreditoExercAndamentoTab2.getSituacaorgf()) ? IndSimNaoEnum.N : IndSimNaoEnum.S;
			Date publicacaoRGF = DateUtil.converterStringParaDate(operacaoCreditoExercAndamentoTab2.getDat_publicrgf());
			
			switch (mesBase) {
			case 2:
				operacaoCreditoDadoAndamento.setDtPublicacaoRREO2(publicacaoRREO);
				operacaoCreditoDadoAndamento.setIndPublicacaoRREO2Temp(indPublicacaoRREO);
				break;
			case 4:
				
				//Em razão de autorização da Presidência, bem como  desta Diretoria, solicito conforme conversamos, 
				//que conste na certidão de operação de crédito do município de Uberaba a data de publicação 
				//do RREO 2º bimestre e RGF 1º quadrimestre, que ocorreu em 29/05/2019, 
				//conforme comprovação de publicação encaminhada a esta Diretoria, por meio do protocolo nº 6023310/2019. 3170107L
				//Em razão de autorização da Presidência, bem como  desta Diretoria, solicito conforme conversamos, 
				//que conste na certidão de operação de crédito do município de Ipatinga a data de publicação 
				//do RREO 2º bimestre (art. 55 LRF) e RGF 1º quadrimestre (art. 55 da LRF), que ocorreu em 30/05/2019, 
				//conforme comprovação de publicação encaminhada a esta Diretoria, por meio do protocolo nº 6042010/2019. 3131307L
				if(codMunicipioIbge.equals(3118601L)){
					
					operacaoCreditoDadoAndamento.setDtPublicacaoRREO4(publicacaoRREO);
					operacaoCreditoDadoAndamento.setIndPublicacaoRREO4Temp(indPublicacaoRREO);
					
					operacaoCreditoDadoAndamento.setDtPublicacaoRGF4(DateUtil.newDate(22, 5, 2019));
					operacaoCreditoDadoAndamento.setIndPublicacaoRGF4Temp(IndSimNaoEnum.S);
				}else{
					
					operacaoCreditoDadoAndamento.setDtPublicacaoRREO4(publicacaoRREO);
					operacaoCreditoDadoAndamento.setIndPublicacaoRREO4Temp(indPublicacaoRREO);
					
					operacaoCreditoDadoAndamento.setDtPublicacaoRGF4(publicacaoRGF);
					operacaoCreditoDadoAndamento.setIndPublicacaoRGF4Temp(indPublicacaoRGF);
				}
				
				if(!isOptanteSemestralidade){
					operacaoCreditoDadoAndamento.setIndOpcao4(IndSimNaoEnum.S);
					operacaoCreditoDadoAndamento.setDatBase4(IndSimNaoEnum.S);
				}
				break;
			case 6:
				operacaoCreditoDadoAndamento.setDtPublicacaoRREO6(publicacaoRREO);
				operacaoCreditoDadoAndamento.setIndPublicacaoRREO6Temp(indPublicacaoRREO);
				
				operacaoCreditoDadoAndamento.setDtPublicacaoRGF6(publicacaoRGF);
				operacaoCreditoDadoAndamento.setIndPublicacaoRGF6Temp(indPublicacaoRGF);
				
				if(isOptanteSemestralidade){
					operacaoCreditoDadoAndamento.setIndOpcao6(IndSimNaoEnum.S);
					operacaoCreditoDadoAndamento.setDatBase6(IndSimNaoEnum.S);
				}
				break;
			case 8:
				operacaoCreditoDadoAndamento.setDtPublicacaoRREO8(publicacaoRREO);
				operacaoCreditoDadoAndamento.setIndPublicacaoRREO8Temp(indPublicacaoRREO);
				
				operacaoCreditoDadoAndamento.setDtPublicacaoRGF8(publicacaoRGF);
				operacaoCreditoDadoAndamento.setIndPublicacaoRGF8Temp(indPublicacaoRGF);
				
				if(!isOptanteSemestralidade){
					operacaoCreditoDadoAndamento.setIndOpcao8(IndSimNaoEnum.S);
					operacaoCreditoDadoAndamento.setDatBase8(IndSimNaoEnum.S);
				}
				break;
			case 10:
				operacaoCreditoDadoAndamento.setDtPublicacaoRREO10(publicacaoRREO);
				operacaoCreditoDadoAndamento.setIndPublicacaoRREO10Temp(indPublicacaoRREO);
				break;
			case 12:
				operacaoCreditoDadoAndamento.setDtPublicacaoRREO12(publicacaoRREO);
				operacaoCreditoDadoAndamento.setIndPublicacaoRREO12Temp(indPublicacaoRREO);
				
				operacaoCreditoDadoAndamento.setDtPublicacaoRGF12(publicacaoRGF);
				operacaoCreditoDadoAndamento.setIndPublicacaoRGF12Temp(indPublicacaoRGF);
				if(isOptanteSemestralidade){
					operacaoCreditoDadoAndamento.setIndOpcao12(IndSimNaoEnum.S);
				}
				operacaoCreditoDadoAndamento.setDatBase12(IndSimNaoEnum.S);
			}
		}
		
		//6 getNumMesBase
		
		//7
		
		return operacaoCreditoDadoAndamento;
		
	}
	
	private OperacaoCreditoExercicioAndamentoTab1 getTab1ExercicioAndamento(Long codMunicipioIbge, Integer exercicioAndamento) throws IOException {
		
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("operacaoCredito/OperacaoCreditoExercicioAndamentoTab1.sql"), OperacaoCreditoExercicioAndamentoTab1.class);
		nativeQuery.setParameter("municipioSelecionado", codMunicipioIbge);
		nativeQuery.setParameter("exercicioCursoSelecionado", exercicioAndamento);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		OperacaoCreditoExercicioAndamentoTab1 operacaoCreditoExercicioAndamentoTab1 = (OperacaoCreditoExercicioAndamentoTab1) nativeQuery.getSingleResult();
		
		return operacaoCreditoExercicioAndamentoTab1;
	}
	
	public boolean isOptanteSemestralidade(Long codMunicipio, Integer numAnoRef) {
		
		OptanteSemestralidade optanteSemestralidade;
		
		try {
			Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("operacaoCredito/OptanteSemestralidade.sql"), OptanteSemestralidade.class);
			nativeQuery.setParameter("exercicioSelecionado", numAnoRef);
			nativeQuery.setParameter("municipioSelecionado", codMunicipio);
			SicomUtil.setDataSelecionada(nativeQuery);
			optanteSemestralidade = (OptanteSemestralidade) nativeQuery.getSingleResult();
		} catch (Exception e) {
			optanteSemestralidade = new OptanteSemestralidade();
		}
		
		return "OPTANTE".equalsIgnoreCase(optanteSemestralidade.getOpsemestralidade());
	}

}
