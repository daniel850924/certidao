package br.gov.mg.tce.business;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioItemResult;
import org.datacontract.schemas._2004._07.BR_GOV_MG_TCE_SGAP_Service_DataContractsAnalisePCA_Results.SituacaoPCAPorMunicipioResult;
import org.tempuri.ISgapPcaAnaliseService;

import br.gov.mg.tce.business.sicom.SicomUtil;
import br.gov.mg.tce.dao.CertidaoOperacaoCreditoDAO;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.enumerator.IndSimNaoEnum;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.CertidaoOperacaoCreditoBOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.sicom.SicomOperacacaoCreditoBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.CertidaoOperacaoCredito;
import br.gov.mg.tce.model.OperacaoCreditoDados;
import br.gov.mg.tce.sgap.pcaanaliseservice.SgapPcaAnaliseServiceLocator;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.util.DateUtil;
import br.gov.mg.tcemg.util.Paginacao;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "CertidaoOperacaoCreditoBO", mappedName = "CertidaoOperacaoCreditoBO")
public class CertidaoOperacaoCreditoBO extends TCEMGBusinessDomain<CertidaoOperacaoCredito> implements CertidaoOperacaoCreditoBOLocal {

	@InjectDAO
	private CertidaoOperacaoCreditoDAO operacaoCreditoDAO;
	
	@EJB
	private SicomOperacacaoCreditoBOLocal sicomOperacacaoCreditoBO;
    @EJB
    private EMailBOLocal eMailBO;
	
	@Override
	protected TCEMGDao<CertidaoOperacaoCredito> getDao() {
		return operacaoCreditoDAO;
	}
	
	@Override
	public void gerarCertidao(Integer qtde) throws Exception {
			
//		CertidaoOperacaoCredito obter = super.obter(89050L);
//        List<CertidaoOperacaoCredito> certidoes = new ArrayList<>();
//        certidoes.add(obter);
        List<CertidaoOperacaoCredito> certidoes = this.pesquisarSolicitacoesEmAnalise(qtde);
        ISgapPcaAnaliseService iSgapPcaAnaliseService = new SgapPcaAnaliseServiceLocator()
        .getBasicHttpBinding_ISgapPcaAnaliseService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.WSDL_SGAP_PCA_ANALISE)));
        
		
		for (CertidaoOperacaoCredito certidaoOperacaoCredito : certidoes) {
			
			try {
				
				certidaoOperacaoCredito.setIndSituacao(IndSituacaoCertidaoEnum.EM_PROCESSAMENTO);
				getDao().alterar(certidaoOperacaoCredito);
				
				SituacaoPCAPorMunicipioResult situacaoPCAPorMunicipio = iSgapPcaAnaliseService.obterSituacaoPCAPorMunicipio(certidaoOperacaoCredito.getCodMunicipio());
				SituacaoPCAPorMunicipioItemResult[] situacoes = situacaoPCAPorMunicipio.getSituacoes();
				Integer ultimoExercicioParecerPrevio = 0;
				String dscDecisao = null;
				for (SituacaoPCAPorMunicipioItemResult situacaoPCAPorMunicipioItemResult : situacoes) {
					if(situacaoPCAPorMunicipioItemResult.getDecisao() != null && situacaoPCAPorMunicipioItemResult.getExercicio() > ultimoExercicioParecerPrevio){
						ultimoExercicioParecerPrevio = situacaoPCAPorMunicipioItemResult.getExercicio();
						dscDecisao = situacaoPCAPorMunicipioItemResult.getDecisao();
						
						if(dscDecisao != null){
							if(dscDecisao.toUpperCase().contains("APROV")){
								dscDecisao = "APROVAÇÃO";
							}else if(dscDecisao.toUpperCase().contains("REJEI")){
								dscDecisao = "REJEIÇÃO";
							}
						}
					}
				}
				
				certidaoOperacaoCredito.setNumUltExercAna(ultimoExercicioParecerPrevio);
				certidaoOperacaoCredito.setDscDecisao(dscDecisao);
				
				
				boolean isDadosSicomOk = SicomUtil.isMunicipioAdimplente(certidaoOperacaoCredito.getCodMunicipio());
				if(isDadosSicomOk){
					sicomOperacacaoCreditoBO.consultarDadosCertidaoOperacaoCredito(certidaoOperacaoCredito);
				}
				
				if(isDadosSicomOk){
					
					certidaoOperacaoCredito.setArqCertidaoPdf(gerarArquivoCertidao(certidaoOperacaoCredito));
					certidaoOperacaoCredito.setDataGeracaoCertidao(new Date());
					certidaoOperacaoCredito.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
					
//						FileOutputStream fileOutputStream = new FileOutputStream("D:\\certidao\\operacao\\" + certidaoOperacaoCredito.getNomeMunicipio() + "_" + certidaoOperacaoCredito.getNumAnoRef() + ".pdf");
//						fileOutputStream.write(certidaoOperacaoCredito.getArqCertidaoPdf());
//						fileOutputStream.close();
				}else{
					
					certidaoOperacaoCredito.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
					certidaoOperacaoCredito.setDataGeracaoCertidao(new Date());
					certidaoOperacaoCredito.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_SICOM);

				}
			} catch (Exception e) {
				certidaoOperacaoCredito.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
				eMailBO.enviarEmailErro(new Email(certidaoOperacaoCredito, "Operacao de Credito", e));
			}finally{
				super.alterar(certidaoOperacaoCredito);
			}
			
		}
	}
	
	 private byte[] gerarArquivoCertidao(CertidaoOperacaoCredito certidao) throws Exception {

		 
		 HashMap<String, Object> parameters = new HashMap<String, Object>();
		 String protocolo = String.valueOf(certidao.getNumProtocolo());
		 String protocoloFormatado = protocolo.substring(0, 10);
		 protocoloFormatado = protocoloFormatado + "/" + protocolo.substring(10);
		 parameters.put("P_NUM_PROTOCOLO", protocoloFormatado);
		 parameters.put("P_DATA_VENCIMENTO", String.valueOf(DateUtil.adicionaDias(certidao.getDataSolicitacao(), 90)));
		 parameters.put("P_IMG_TCE_LOGO", CertidaoOperacaoCreditoBO.class.getResourceAsStream("/relatorios" + "/tceLogo.png"));
		 parameters.put("P_LINK_ECERTIDAO", "http://www.tce.mg.gov.br/ecertidao/");
	     parameters.put("P_NOME_MUNICIPIO", "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">" + certidao.getNomeMunicipio() + "</style>");
	     parameters.put("P_ULTIMO_EXEC_ANA", certidao.getNumUltExercAna());
	     
	     gerarParte1(certidao, parameters);
	     gerarParte2(certidao, parameters);
	     gerarParte3(certidao, parameters);
	     
	     InputStream inputStream = CertidaoOperacaoCredito.class.getResourceAsStream("/relatorios/" + "ModeloCertidaoOperacaoCredito.jasper");
	     JasperPrint jpPrint = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
	     return JasperExportManager.exportReportToPdf(jpPrint);
	 }

	private void gerarParte3(CertidaoOperacaoCredito certidao,	HashMap<String, Object> parameters) {

		StringBuilder param3 = new StringBuilder("");
		Integer execEmAndamento = certidao.getExercicioAndamento();
		OperacaoCreditoDados operacaoCreditoDados = certidao.getMapOperacaoCreditoDados().get(execEmAndamento);
		param3.append("Com referência ao exercício de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
		.append(execEmAndamento).append("</style>, ").append("de acordo com os dados contidos no Relatório Resumido da Execução Orçamentária,")//e no Relatório de Gestão Fiscal
		.append(" gerados com base nas informações enviadas pelo Sicom, e relativos, respectivamente, ao ")
		.append(gerarTextoRREO(operacaoCreditoDados)).append(gerarTextoRGF(operacaoCreditoDados)).append(": <br />");		
		param3.append("1 – ").append(gerarItem1(operacaoCreditoDados)).append(" <br />");
		param3.append("2 – ").append(gerarItem4(operacaoCreditoDados)).append(" <br />");
		
		boolean optanteSemestralidade = false;
		try {
			optanteSemestralidade = sicomOperacacaoCreditoBO.isOptanteSemestralidade(certidao.getCodMunicipio(), execEmAndamento);
		} catch (IOException e) {
		}
		if((operacaoCreditoDados.getNumMesBase() > 3 && !optanteSemestralidade) || operacaoCreditoDados.getNumMesBase() >= 6 ){
			param3.append("3 – ").append(gerarItem5(operacaoCreditoDados)).append(" <br />");
			param3.append("4 – ").append(gerarItem6(operacaoCreditoDados)).append(" <br />");
		}
		
		String item7 = gerarItem7(operacaoCreditoDados, execEmAndamento);
		if(item7 != null){
			param3.append("– ").append(item7).append(" <br />");
		}
		
		/*Em razão da Ordem de Serviço Conjunta nº 01/2019, para fins de cálculo com a despesa com pessoal  
		 * (Certidão de gasto com pessoal, limites e certidão para fins de operações de crédito) para o exercício de 2018, deverá ser considerado os valores devidos 
		 * pelo Estado aos municípios relativos ao Fundeb e ICMS do exercício de 2018, os quais deverão ser somados ao total da receita corrente líquida.*/
		//solicitado a remessa da nota pela HELIANE DA COSTA no dia 21//11/2019 
//		if(certidao.getNumUltExercAna() <= 2018){
//			param3.append("<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Nota explicativa:</style> Conforme disposto nos §§ 5° e 6° do art. 1° da Ordem de Serviço Conjunta n° 01, de 29 de maio de 2019")
//			.append(", acrescentou-se ao total da Receita Corrente Líquida os valores devidos pelo Estado aos Municípios relativos ao Fundeb e ICMS do exercício de 2018.  <br />");
//		}
		
		if(execEmAndamento == 2019){
			param3.append("<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Observação:</style> Esta certidão não contempla os dados relativos ao Relatório Resumido da Execução Orçamentária do primeiro bimestre de 2020, ")
			.append("em virtude da suspensão dos prazos por este Tribunal, estabelecida na PORTARIA Nº 20/PRES./2020, que prorrogou o prazo de envio das informações até o dia 15/06/2020.  <br />");
		}
		
		param3.append("Os dados certificados poderão sujeitar-se à retificação em decorrência de deliberação da Prestação de Contas Anual e de inspeção ordinária,")
			.append(" extraordinária ou especial e tomada de contas que venham a ser realizadas no município ou de qualquer outro processo que venha a ser apreciado por esta Corte.");
		parameters.put("P_PARAM3", param3.toString());
		
	}

	private void gerarParte2(CertidaoOperacaoCredito certidao,	HashMap<String, Object> parameters) {
		
		StringBuilder param2 = new StringBuilder("");
		Map<Integer, OperacaoCreditoDados> mapOperacaoCreditoDados = certidao.getMapOperacaoCreditoDados();
		Integer numUltExercAna = certidao.getNumUltExercAna();	
		Integer exercFechado = numUltExercAna + 1;
		Integer execEmAndamento = certidao.getExercicioAndamento();
		for (; exercFechado < execEmAndamento; exercFechado++) {
			
			
			OperacaoCreditoDados operacaoCreditoDados = mapOperacaoCreditoDados.get(exercFechado);
			param2.append("- Com referência ao exercício de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">").append(exercFechado).append("</style>")
			.append(", de acordo com os dados contidos no Relatório Resumido da Execução Orçamentária")
			.append(" e no Relatório de Gestão Fiscal, gerados com base nas informações enviadas pelo Sicom e pelo Siace/LRF, e relativos, ")
			.append("respectivamente, aos primeiro/ segundo/ terceiro/ quarto/ quinto/ sexto bimestres e aos ");
			
			param2.append(gerarTextoRGF(operacaoCreditoDados)).append(": <br />");
			param2.append("1 – ").append(gerarItem1(operacaoCreditoDados)).append(" <br />");
			param2.append("2 – ").append(gerarItem4(operacaoCreditoDados)).append(" <br />");
			param2.append("3 – ").append(gerarItem5(operacaoCreditoDados)).append(" <br />");
			param2.append("4 – ").append(gerarItem6(operacaoCreditoDados)).append(" <br />");
			
		}
		
		parameters.put("P_PARAM2", param2.toString());
	}
	
	private void gerarParte1(CertidaoOperacaoCredito certidao,	HashMap<String, Object> parameters) {
		
		String numPortaria = "54/PRES./2018";
	    StringBuilder param1 = new StringBuilder("Certifica-se, nos termos da Portaria nº ").append(numPortaria)
	    		 .append(", com base nos dados enviados por meio do Sicom e do Siace/LRF, para fins do disposto no art. 21, IV, da Resolução nº 43/2001 ")
	    		 .append("do Senado Federal, que este Tribunal emitiu parecer prévio pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
	    		 .append(certidao.getDscDecisao()).append("</style> das contas anuais prestadas pelo Chefe do Poder Executivo do Município de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
	    		 .append(certidao.getNomeMunicipio()).append("</style>")
	    		 .append(" relativas ao exercício de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">").append(certidao.getNumUltExercAna()).append("</style>")
	     		 .append(" – último exercício analisado. Certifica-se, também em relação à Lei Complementar nº 101/2000 (Lei de Responsabilidade Fiscal - LRF): <br />")
	     		 .append("- Com referência ao exercício de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
	     		 .append(certidao.getNumUltExercAna()).append("</style>").append(" – último exercício analisado: <br />");	
	     
	     
	     Map<Integer, OperacaoCreditoDados> mapOperacaoCreditoDados = certidao.getMapOperacaoCreditoDados();
	     OperacaoCreditoDados opCredDadosUltimoExercAna = mapOperacaoCreditoDados.get(certidao.getNumUltExercAna());
	     
	     param1.append("1 – ").append(gerarItem1(opCredDadosUltimoExercAna)).append(" <br />");
	     param1.append("2 – ").append(gerarItem2(opCredDadosUltimoExercAna)).append(" <br />");
	     param1.append("3 – ").append(gerarItem3(opCredDadosUltimoExercAna)).append(" <br />");
	     param1.append("4 – ").append(gerarItem4(opCredDadosUltimoExercAna)).append(" <br />");
	     param1.append("5 – ").append(gerarItem5(opCredDadosUltimoExercAna)).append(" <br />");
	     param1.append("6 – ").append(gerarItem6(opCredDadosUltimoExercAna)).append(" <br />");
	     
	     parameters.put("P_PARAM1", param1.toString());
	}

	private String gerarTextoRREO(OperacaoCreditoDados operacaoCreditoDados){
		
		String textoRREO = "";
		
//		 Integer ultimoMesBimestre = sicomBO.getUltimoMesBimestre(); 
			 
			 
		 switch (operacaoCreditoDados.getNumMesBase()) {
		 case 2:
			 textoRREO = "primeiro bimestre ";
			 break;
		case 4:
			textoRREO = "primeiro/ segundo bimestre ";		
			break;
		case 6:
			textoRREO = "primeiro/ segundo/ terceiro bimestre ";
			break;
		case 8:
			textoRREO = "primeiro/ segundo/ terceiro/ quarto bimestre ";		
			break;
		case 10:
			textoRREO = "primeiro/ segundo/ terceiro/ quarto/ quinto bimestre ";	
			break;
		case 12:
			textoRREO = "primeiro/ segundo/ terceiro/ quarto/ quinto/ sexto bimestre ";		
			break;
		}
		 
		return textoRREO;
	}
	
	
	private String gerarTextoRGF(OperacaoCreditoDados operacaoCreditoDados) {

		String textoRGF = "";
		
		if(operacaoCreditoDados.getNumExercicio().equals(operacaoCreditoDados.getOperacaoCredito().getExercicioAndamento())){
//			Integer ultimoMesBimestre = sicomBO.getUltimoMesBimestre();
			for (int mes = 4; mes <= operacaoCreditoDados.getNumMesBase(); mes += 2) {
				
				switch (mes) {
				case 4:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getDatBase4()) &&
							IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao4())){
						textoRGF = "e primeiro quadrimestre";
					}
					break;
				case 6:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getDatBase6()) &&
							IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao6())){
						textoRGF = "e primeiro semestre";
					}
					break;
				case 8:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getDatBase8()) &&
							IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao8())){
						textoRGF += "/ segundo quadrimestre";
					}
					break;
				case 12:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao12())){
						textoRGF += "/ segundo semestre";
					}else{
						textoRGF += "/ terceiro quadrimestre";
					}
					break;
				}
			}
		}else{
			//exercicio fechado 
			if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao12())){
				textoRGF = "e primeiro/ segundo semestres";
			}else{
				textoRGF = "e primeiro/ segundo/ terceiro quadrimestres";
			}
		}
			
		return textoRGF;
	}

	private String gerarItem7(OperacaoCreditoDados operacaoCreditoDados, Integer execEmAndamento) {
		
		Date dataAtual = DateUtil.getDataAtual();
		if(DateUtil.estaNoIntervalo(dataAtual, DateUtil.newDate(1, 2, execEmAndamento), DateUtil.newDate(31, 3, execEmAndamento), true)){
			
			StringBuilder item = new StringBuilder();
			BigDecimal vlrRecOperacaoCredito = operacaoCreditoDados.getVlrRecOperacaoCredito();
			BigDecimal vlrDespesaCapitalDotIni = operacaoCreditoDados.getVlrDespesaCapitalDotIni();
			
			if(vlrRecOperacaoCredito.longValue() == 0L){
				item.append("No que tange à Lei Orçamentária Anual, em relação ao art. 12, § 2º, da LRF, não houve previsão orçamentária para Receitas de Operação de Crédito;");
			}else if (vlrRecOperacaoCredito.subtract(vlrDespesaCapitalDotIni).longValue() < 0 || vlrRecOperacaoCredito.equals(vlrDespesaCapitalDotIni)){
				item.append("No que tange à Lei Orçamentária Anual, foi cumprido o disposto no art. 12, § 2º, da LRF;");
			}else if(vlrRecOperacaoCredito.subtract(vlrDespesaCapitalDotIni).longValue() > 0){
				item.append("No que tange à Lei Orçamentária Anual, em relação ao disposto no art. 12, § 2°, da LRF, a previsão orçamentária da Receita de Operação de Crédito excedeu a fixação da Despesa de Capital; ");
			}
			return item.toString();
		}else{
			return null;
		}
		
	}
	
	private String gerarItem6(OperacaoCreditoDados operacaoCreditoDados) {
		 
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		DecimalFormat df = new DecimalFormat();
        df.applyPattern("#,##0.00");
		StringBuilder item = new StringBuilder();
		String vlrDespesaTotPessoalExecFormat = numberFormat.format(operacaoCreditoDados.getVlrDespesaTotPessoalExec());
		String vlrDespesaTotPessoalLegFormat = numberFormat.format(operacaoCreditoDados.getVlrDespesaTotPessoalLeg());
		
		String pctDespesaTotPessoalExecFormat = null;
		if(operacaoCreditoDados.getPctDespesaTotPessoalExec().doubleValue() > 54D){
			pctDespesaTotPessoalExecFormat = "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">" + df.format(operacaoCreditoDados.getPctDespesaTotPessoalExec()) + "</style>";
		}else{
			pctDespesaTotPessoalExecFormat = df.format(operacaoCreditoDados.getPctDespesaTotPessoalExec());
		}
		
		String pctDespesaTotPessoalLegFormat = null;
		if(operacaoCreditoDados.getPctDespesaTotPessoalLeg().doubleValue() > 6){
			pctDespesaTotPessoalLegFormat = "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">" + df.format(operacaoCreditoDados.getPctDespesaTotPessoalLeg()) + "</style>";
		}else{
			pctDespesaTotPessoalLegFormat = df.format(operacaoCreditoDados.getPctDespesaTotPessoalLeg());
		}
		
		
		item.append("Quanto ao cumprimento do art. 23 da LRF, foram despendidos com Pessoal os seguintes montantes, no exercício especificado,")
		 .append(" sem as deduções objeto das Instruções Normativas deste Tribunal de Contas nº 1 e nº 5, ambas de 2001: <br />")
		 .append("Poder Executivo: ")
		 .append(vlrDespesaTotPessoalExecFormat).append(" (").append(pctDespesaTotPessoalExecFormat).append("% da RCL); <br />")
		 .append("Poder Legislativo: ")
		 .append(vlrDespesaTotPessoalLegFormat).append(" (").append(pctDespesaTotPessoalLegFormat).append("% da RCL). <br />");
		 return item.toString();
	 }
 
	 private String gerarItem5(OperacaoCreditoDados operacaoCreditoDados) {
		 
		 StringBuilder item = new StringBuilder();
		 int ano = operacaoCreditoDados.getNumExercicio();
			 
		 if(operacaoCreditoDados.getOperacaoCredito().getExercicioAndamento() != ano){
			 
			 if(operacaoCreditoDados.getDtPublicacaoRGF12() == null){
				 item.append("Poder Executivo não informou a data de publicação os Relatórios, contrariando o previsto no art. 55, § 2º, da LRF;");
			 }else{
				 if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRGF12Temp())){
					 item.append("O Poder Executivo publicou o Relatório de Gestão Fiscal tempestivamente, conforme previsto no art. 55, § 2º, da LRF;");
				 }else{
					 item.append("O Poder Executivo publicou o Relatório de Gestão Fiscal intempestivamente, contrariando o previsto no art. 55, § 2º, da LRF;");
				 }
			 }
		 }else{
			 
			 item.append("No tocante às disposições dos art. 55, § 2º, da LRF, quanto ao Relatório de Gestão Fiscal, ");
			 String textoQuadrimestreSemestre = getTextoQuadrimestreSemestre(operacaoCreditoDados);
			 item.append(textoQuadrimestreSemestre);
		 }
		 
		 return item.toString();
	 }
 
	 private String getTextoQuadrimestreSemestre(OperacaoCreditoDados operacaoCreditoDados) {

		 StringBuilder textoQuadrimestreSemestre = new StringBuilder();
		 StringBuilder tempestivoSem = new StringBuilder();
		 StringBuilder intempestivoSem = new StringBuilder();
		 StringBuilder naoPublicouSem = new StringBuilder();
		 StringBuilder tempestivoQuad = new StringBuilder();
		 StringBuilder intempestivoQuad = new StringBuilder();
		 StringBuilder naoPublicouQuad = new StringBuilder();
		 
//		 Integer ultimoMesBimestre = sicomBO.getUltimoMesBimestre();
		 for (int mes = 4; mes <= operacaoCreditoDados.getNumMesBase(); mes += 2) {
				
			 switch (mes) {
				case 4:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao4())){
						if(operacaoCreditoDados.getDtPublicacaoRGF4() == null){
							naoPublicouQuad.append("primeiro");
						}else{
							if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRGF4Temp())){
								tempestivoQuad.append("primeiro");
							}else{
								intempestivoQuad.append("primeiro");
							}
						}
					}
					break;
				case 6:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao6())){
						if(operacaoCreditoDados.getDtPublicacaoRGF6() == null){
							naoPublicouSem.append("primeiro");
						}else{
							if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRGF6Temp())){
								tempestivoSem.append("primeiro");
							}else{
								intempestivoSem.append("primeiro");
							}
						}
					}
					break;
				case 8:
					if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao8())){
						if(operacaoCreditoDados.getDtPublicacaoRGF8() == null){
							naoPublicouQuad.append("/ segundo");
						}else{
							if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRGF8Temp())){
								tempestivoQuad.append("/ segundo");
							}else{
								intempestivoQuad.append("/ segundo");
							}
						}
					}
					break;
				case 12:
					if(operacaoCreditoDados.getDtPublicacaoRGF12() == null){
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao12())){
							naoPublicouSem.append("/ segundo");
						}else{
							naoPublicouQuad.append("/ terceiro");
						}
					}else{
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRGF12Temp())){
							if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao12())){
								tempestivoSem.append("/ segundo");
							}else{
								tempestivoQuad.append("/ terceiro");
							}
						}else{
							if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndOpcao12())){
								intempestivoSem.append("/ segundo");
							}else{
								intempestivoQuad.append("/ terceiro");
							}
						}
					}
					break;
				}
		 }
		 
		if(tempestivoQuad.length() > 0){
			tempestivoQuad.append(" quadrimestre");
		}
		if(intempestivoQuad.length() > 0){
			intempestivoQuad.append(" quadrimestre");
		}
		if(naoPublicouQuad.length() > 0){
			naoPublicouQuad.append(" quadrimestre");
		}
		
		if(tempestivoSem.length() > 0){
			tempestivoSem.append(" semestre");
		}
		if(intempestivoSem.length() > 0){
			intempestivoSem.append(" semestre");
		}
		if(naoPublicouSem.length() > 0){
			naoPublicouSem.append(" semestre");
		}

		 if(tempestivoQuad.length() > 0 || tempestivoSem.length() > 0){
			 textoQuadrimestreSemestre.append("foi tempestiva no(s) ");
			 
			  if(tempestivoQuad.length() > 0){
				  textoQuadrimestreSemestre.append(tempestivoQuad);
			  }
			  if(tempestivoSem.length() > 0){
				  textoQuadrimestreSemestre.append(tempestivoSem);
			  }
		 }
		 
		 if(intempestivoQuad.length() > 0 || intempestivoSem.length() > 0){
			 if(textoQuadrimestreSemestre.length() > 0){
				 textoQuadrimestreSemestre.append(", ");
			 }else{
				 textoQuadrimestreSemestre.append("foi ");
			 }
			 textoQuadrimestreSemestre.append("intempestivo no(s) ");
			 
			 if(intempestivoQuad.length() > 0){
				  textoQuadrimestreSemestre.append(intempestivoQuad);
			  }
			  if(intempestivoSem.length() > 0){
				  textoQuadrimestreSemestre.append(intempestivoSem);
			  }
		 }
		 
		 if(naoPublicouQuad.length() > 0 || naoPublicouSem.length() > 0){
			 if(textoQuadrimestreSemestre.length() > 0){
				 textoQuadrimestreSemestre.append(" e");
			 }
			 textoQuadrimestreSemestre.append(" não foi informada a publicação do(s) ");
			 if(naoPublicouQuad.length() > 0){
				  textoQuadrimestreSemestre.append(naoPublicouQuad);
			  }
			  if(naoPublicouSem.length() > 0){
				  textoQuadrimestreSemestre.append(naoPublicouSem);
			  }
		 }
		 
		 return textoQuadrimestreSemestre.append(";").toString();
	}

	private String gerarItem4(OperacaoCreditoDados operacaoCreditoDados) {
		 
		 StringBuilder item = new StringBuilder();
		 int ano = operacaoCreditoDados.getNumExercicio();
		 
		 if(operacaoCreditoDados.getOperacaoCredito().getExercicioAndamento() != ano){
			 
			 if(operacaoCreditoDados.getDtPublicacaoRREO12() == null){
				 item.append("O Poder Executivo não informou a data de publicação os Relatórios, contrariando o previsto no art. 52, da LRF;");
			 }else{
				 if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO12Temp())){
					 item.append("O Poder Executivo publicou o Relatório Resumido da Execução Orçamentária tempestivamente, conforme previsto no art. 52, da LRF;");
				 }else{
					 item.append("O Poder Executivo publicou o Relatório Resumido da Execução Orçamentária intempestivamente, contrariando o previsto no art. 52, da LRF;");
				 }
			 }
		 }else{
			 
			 item.append("No tocante às disposições dos art. 52, da LRF, quanto ao Relatório Resumido da Execução Orçamentária,");
			 String textoBimestres = getTextoBimestreRREO(operacaoCreditoDados);
			 item.append(textoBimestres);
		 }
		 
		 return item.toString();
	 }
	 
	 private String getTextoBimestreRREO(OperacaoCreditoDados operacaoCreditoDados) {

		 StringBuilder textoBimestres = new StringBuilder();
		 StringBuilder tempestivo = new StringBuilder();
		 StringBuilder intempestivo = new StringBuilder();
		 StringBuilder naoPublicou = new StringBuilder();
		 
//		 Integer ultimoMesBimestre = sicomBO.getUltimoMesBimestre();
		 for (int mes = 2; mes <= operacaoCreditoDados.getNumMesBase(); mes += 2) {
			 
			 switch (mes) {
				case 2:
					
					if(operacaoCreditoDados.getNumExercicio() == 2018){
						//primeiro bimestre de 2018 é sempre tempestivo
						tempestivo.append("primeiro");
					}else{
						if(operacaoCreditoDados.getDtPublicacaoRREO2() == null){
							naoPublicou.append("primeiro");
						}else{
							if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO2Temp())){
								tempestivo.append("primeiro");
							}else{
								intempestivo.append("primeiro");
							}
						}
					}
					break;
				case 4:
					if(operacaoCreditoDados.getDtPublicacaoRREO4() == null){
						naoPublicou.append("/ segundo");
					}else{
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO4Temp())){
							tempestivo.append("/ segundo");
						}else{
							intempestivo.append("/ segundo");
						}
					}
					break;
				case 6:
					if(operacaoCreditoDados.getDtPublicacaoRREO6() == null){
						naoPublicou.append("/ terceiro");
					}else{
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO6Temp())){
							tempestivo.append("/ terceiro");
						}else{
							intempestivo.append("/ terceiro");
						}
					}
					break;
				case 8:
					if(operacaoCreditoDados.getDtPublicacaoRREO8() == null){
						naoPublicou.append("/ quarto");
					}else{
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO8Temp())){
							tempestivo.append("/ quarto");
						}else{
							intempestivo.append("/ quarto");
						}
					}
					break;
				case 10:
					if(operacaoCreditoDados.getDtPublicacaoRREO10() == null){
						naoPublicou.append("/ quinto");
					}else{
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO10Temp())){
							tempestivo.append("/ quinto");
						}else{
							intempestivo.append("/ quinto");
						}
					}
					break;
				case 12:
					if(operacaoCreditoDados.getDtPublicacaoRREO12() == null){
						naoPublicou.append("/ sexto");
					}else{
						if(IndSimNaoEnum.S.equals(operacaoCreditoDados.getIndPublicacaoRREO12Temp())){
							tempestivo.append("/ sexto");
						}else{
							intempestivo.append("/ sexto");
						}
					}
					break;
					
				}
		 }
		 
		 if(tempestivo.length() > 0){
			 textoBimestres.append("foi tempestiva no(s) ").append(tempestivo).append(" bimestre(s)");
		 }
		 if(intempestivo.length() > 0){
			 if(textoBimestres.length() > 0){
				 textoBimestres.append(", ");
			 }else{
				 textoBimestres.append("foi ");
			 }
			 textoBimestres.append("intempestivo no(s) ").append(intempestivo).append(" bimestre(s)");
		 }
		 if(naoPublicou.length() > 0){
			 if(textoBimestres.length() > 0){
				 textoBimestres.append(" e");
			 }
			 textoBimestres.append(" não foi informada a publicação do(s) ").append(naoPublicou).append(" bimestre(s)");
		 }
		 
		 return textoBimestres.append(";").toString();
	}

	private String gerarItem3(OperacaoCreditoDados operacaoCreditoDados) {
		 
		 StringBuilder item = new StringBuilder();
		 
		 if(!operacaoCreditoDados.getIndRealizacaoOp()){
			 item.append("Foi cumprido o disposto no art. 37 da LRF;");
		 }else{
			 item.append("O Poder Executivo contratou Operações de Crédito vedadas pelo art. 37 da LRF;");
		 }
		 
		 return item.toString();
	 }
 
 
	 private String gerarItem2(OperacaoCreditoDados operacaoCreditoDados) {
		 
		 StringBuilder item = new StringBuilder();
		 
		 if(!operacaoCreditoDados.getIndContratacaoOp()){
			 item.append("Foi cumprido o disposto no art. 33 da LRF;");
		 }else{
			 item.append("No tocante ao disposto no art. 33 da LRF, o Poder Executivo não atendeu às condições e limites estabelecidos para contratação de Operação de Crédito junto a instituição financeira.");
		 }
		 
		 return item.toString();
	 }
	 
	 private String gerarItem1(OperacaoCreditoDados operacaoCreditoDados) {
		
		StringBuilder item = new StringBuilder();
		BigDecimal vlrRecOperacaoCredito = operacaoCreditoDados.getVlrRecOperacaoCredito();
		BigDecimal vlrDespesaCapitalDotIni = operacaoCreditoDados.getVlrDespesaCapitalDotIni();
	     
		if(vlrRecOperacaoCredito.longValue() == 0L){
			item.append("Em relação disposto no art. 12, § 2º, da LRF, não houve previsão orçamentária para Receitas de Operação de Crédito;");
	    }else if (vlrRecOperacaoCredito.subtract(vlrDespesaCapitalDotIni).longValue() < 0 || vlrRecOperacaoCredito.equals(vlrDespesaCapitalDotIni)){
	    	item.append("Foi cumprido o disposto no art. 12, § 2º, da LRF;");
	    }else if(vlrRecOperacaoCredito.subtract(vlrDespesaCapitalDotIni).longValue() > 0){
	    	item.append("Em relação ao disposto no art. 12, § 2°, da LRF, a previsão orçamentária da Receita de Operação de Crédito excedeu a fixação da Despesa de Capital;");
	    }
		
		return item.toString();
	 }
	 
	 private List<CertidaoOperacaoCredito> pesquisarSolicitacoesEmAnalise(Integer qtde) {
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("indSituacao", IndSituacaoCertidaoEnum.EM_ANALISE);
			return super.consultarPorNamedQuery(CertidaoOperacaoCredito.SOLICITACAO_EM_ANALISE, param, new Paginacao(0, qtde));
		}

}
