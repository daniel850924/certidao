package br.gov.mg.tce.business.pca;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.xml.namespace.QName;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import tcemg.sicom.fundebService.IndiceFundebWS;
import tcemg.sicom.fundebService.IndiceFundebWSProxy;
import br.gov.mg.tce.client.pca.web.IndiceObservacao;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWS;
import br.gov.mg.tce.client.pca.web.IntegracaoWebECertidaoWSService;
import br.gov.mg.tce.client.pca.web.Municipio;
import br.gov.mg.tce.enumerator.EnumRelatorioCertidaoJasper;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.facade.CertidaoPCABOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tce.util.NumberUtil;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.exception.TceException;
import br.gov.mg.tcemg.exception.TceFault;
import br.gov.mg.tcemg.util.DateUtil;

public abstract class CertidaoPCAAanlise{

	@EJB
	protected CertidaoPCABOLocal peticaoCertidaoBO;
	@EJB
	protected EMailBOLocal eMailBO;
	
	/**
	 * Gera o documento em PDF utilizando JasperReport
	 * processoJulgadoAnalise obrigatorio para todos que nao sejam EnumOrigemIndicePCA.PCA
	 * 
	 * @param peticaoCertidao
	 * @return
	 * @throws Exception
	 */
	public byte[] gerarCertidao(CertidaoPCA peticaoCertidao, ProcessoJulgadoAnalise processoJulgadoAnalise) throws Exception {
		
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		String protocolo = String.valueOf(peticaoCertidao.getNumProtocolo());
		String protocoloFormatado = protocolo.substring(0,10);
		protocoloFormatado = protocoloFormatado +"/"+ protocolo.substring(10);
		parameters.put("P_NUM_PROTOCOLO", protocoloFormatado);
		parameters.put("P_IMG_TCE_LOGO", CertidaoPCAAanlise.class.getResourceAsStream("/relatorios"+"/tceLogo.png"));
		parameters.put("P_NUM_PORTARIA", "54/PRES./2018");
		parameters.put("P_LINK_ECERTIDAO", "http://www.tce.mg.gov.br/ecertidao/");
		parameters.put("P_ANO_REFERENCIA", String.valueOf(peticaoCertidao.getNumAnoRef()));
		parameters.put("P_DATA_VENCIMENTO", String.valueOf(DateUtil.adicionaDias(peticaoCertidao.getDataSolicitacao(),90)));

		parameters.put("P_INV_EDUCACAO", NumberUtil.formartDoubleDuasCasas(peticaoCertidao.getPercentInvEducacao()));
		parameters.put("P_INV_PESSOAL", NumberUtil.formartDoubleDuasCasas(peticaoCertidao.getPercentInvPessoal()));
		parameters.put("P_INV_PESSOAL_LEGISLATIVO", NumberUtil.formartDoubleDuasCasas(peticaoCertidao.getPercentInvPessoalLegislativo()));
		parameters.put("P_INV_PESSOAL_EXECUTIVO", NumberUtil.formartDoubleDuasCasas(peticaoCertidao.getPercentInvPessoalExecutivo()));
		parameters.put("P_INV_SAUDE", NumberUtil.formartDoubleDuasCasas(peticaoCertidao.getPercentInvSaude()));
		parameters.put("P_INV_FUNDEB", NumberUtil.formartDoubleDuasCasas(peticaoCertidao.getPercentInvFundeb()));
		
		String decisaoProcesso = null;
		if (EnumTipoAnalise.ANALISE_ATJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise())
				|| EnumTipoAnalise.ANALISE_IR.getSigla().equals(peticaoCertidao.getSglTipoAnalise())
				|| EnumTipoAnalise.ANALISE_TJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise())) {
			
			if (processoJulgadoAnalise.getCodDecisao() == 25L 
					|| processoJulgadoAnalise.getCodDecisao() == 1015L
					|| processoJulgadoAnalise.getCodDecisao() == 1048L){
				decisaoProcesso = "aprovação";
			}else if (processoJulgadoAnalise.getCodDecisao() == 24L){
				decisaoProcesso = "rejeição";
			}
			parameters.put("P_PROCESSO_DECISAO", decisaoProcesso);
			
		}
		
		StringBuilder registro = new StringBuilder();
		
		switch (EnumTipoAnalise.getEnumBySigla(peticaoCertidao.getSglTipoAnalise())) {
		case ANALISE_PRE_PCA:
			registro.append("Registre-se que a Prestação de Contas do referido exercício encontra-se em análise, não tendo sido ainda deliberada por este Tribunal.\n");
			break;
		case ANALISE_CONSOLIDADA:
			registro.append("Registre-se que a Prestação de Contas do referido exercício encontra-se em análise, não tendo sido ainda deliberada por este Tribunal.\n");
			break;
		case ANALISE_SUBSTITUA:
			registro.append("Registre-se que a Prestação de Contas do referido exercício encontra-se em análise, não tendo sido ainda deliberada por este Tribunal.\n");
			break;
		case ANALISE_DE_DEFESA:
			registro.append("Registre-se que a Prestação de Contas do referido exercício encontra-se em análise, não tendo sido ainda deliberada por este Tribunal.\n");
			break;
		case ANALISE_ATJ:
			registro.append("Registre-se que a Prestação de Contas do referido exercício foi objeto de deliberação, tendo este Tribunal emitido parecer prévio pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">") 
					.append(decisaoProcesso).append("</style> das contas.\n");
			break;
		case ANALISE_IR:
			registro.append("Registre-se que a Prestação de Contas do referido exercício foi objeto de deliberação, tendo este Tribunal emitido parecer prévio pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
				.append(decisaoProcesso).append("</style> das contas.\n Certifica-se, ainda, que existe pedido de reexame em tramitação nesta Casa, contra a referida decisão.\n");
			break;
		case ANALISE_TJ:
			registro.append("Registre-se que a Prestação de Contas do referido exercício foi objeto de deliberação, tendo este Tribunal emitido parecer prévio pela <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
				.append(decisaoProcesso).append("</style> das contas, cuja decisão transitou em julgado.\n");
			break;	
		}
		
		parameters.put("P_REGISTRO", registro.toString());
		
		StringBuilder nota = montarNotaExplicativa(peticaoCertidao);
		parameters.put("P_OBSERVACAO", nota.toString());
		
		IntegracaoWebECertidaoWS integracaoWebECertidaoWS = new IntegracaoWebECertidaoWSService(new URL(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_INTEGRACAO_WEB_CERTIDAO)), 
				new QName("http://integracaoweb.ecertidao.tcemg/", "IntegracaoWebECertidaoWSService")).getIntegracaoWebECertidaoWSPort();
		Municipio municipio = integracaoWebECertidaoWS.buscarMunicipioPorCodMunicipio(peticaoCertidao.getCodMunicipio().intValue());
		if(municipio != null){
			parameters.put("P_NOME_MUNICIPIO", municipio.getNomMunicipio() );
		}
		
		JasperPrint jpPrint;
		String relatorioByTipoCertidao = EnumRelatorioCertidaoJasper.getRelatorioByTipoCertidao(peticaoCertidao.getIndTipoCertidao().getId());
		if (relatorioByTipoCertidao != null){
			InputStream inputStream = CertidaoPCAAanlise.class.getResourceAsStream("/relatorios/" + relatorioByTipoCertidao);
			jpPrint = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
			return JasperExportManager.exportReportToPdf(jpPrint);
		}else{
			throw new TceException("Nao existe relatorio cadastrado para este tipo de certidao.", new TceFault());
		}
	}

	private StringBuilder montarNotaExplicativa(CertidaoPCA peticaoCertidao) {
		
		
		IndiceObservacao indObsEducacao = null;
		IndiceObservacao indObsPessoal = null;
		IndiceObservacao indObsSaude = null;
		if (EnumTipoAnalise.ANALISE_ATJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise())
				|| EnumTipoAnalise.ANALISE_IR.getSigla().equals(peticaoCertidao.getSglTipoAnalise())){
			
			switch (peticaoCertidao.getIndTipoCertidao()) {
			case GASTO_ENSINO:
				indObsEducacao = peticaoCertidao.getIndiceParecerPrevio().getIndObsEducacao();
				break;
			case GASTO_PESSOAL:
				indObsPessoal = peticaoCertidao.getIndiceParecerPrevio().getIndObsPessoal();
				break;
			case GASTO_SAUDE:
				indObsSaude = peticaoCertidao.getIndiceParecerPrevio().getIndObsSaude();
				break;
			case GERAL:
				indObsEducacao = peticaoCertidao.getIndiceParecerPrevio().getIndObsEducacao();
				indObsPessoal = peticaoCertidao.getIndiceParecerPrevio().getIndObsPessoal();
				indObsSaude = peticaoCertidao.getIndiceParecerPrevio().getIndObsSaude();
				break;
			default:
				break;
			}
			
			
		}else if(EnumTipoAnalise.ANALISE_TJ.getSigla().equals(peticaoCertidao.getSglTipoAnalise())){
			
			switch (peticaoCertidao.getIndTipoCertidao()) {
			case GASTO_ENSINO:
				indObsEducacao = peticaoCertidao.getIndiceTransitoJulgado().getIndObsEducacao();
				break;
			case GASTO_PESSOAL:
				indObsPessoal = peticaoCertidao.getIndiceTransitoJulgado().getIndObsPessoal();
				break;
			case GASTO_SAUDE:
				indObsSaude = peticaoCertidao.getIndiceTransitoJulgado().getIndObsSaude();
				break;
			case GERAL:
				indObsEducacao = peticaoCertidao.getIndiceTransitoJulgado().getIndObsEducacao();
				indObsPessoal = peticaoCertidao.getIndiceTransitoJulgado().getIndObsPessoal();
				indObsSaude = peticaoCertidao.getIndiceTransitoJulgado().getIndObsSaude();
				break;
			default:
				break;
			}
		}
		
		StringBuilder nota = new StringBuilder();
		Integer indice = 1;
		
		//retirado a pedido da HELIANE DA COSTA no dia 29/11/2019
//		if(peticaoCertidao.getIndTipoCertidao().equals(IndTipoCertidaoEnum.GASTO_PESSOAL)){
//			nota.append("<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">Nota explicativa:</style>");
//			nota.append("1 - Nos termos do art. 23 da Lei Complementar nº 101/2000, \"se a despesa total com pessoal, do Poder ou órgão referido no art. 20, ultrapassar os limites definidos no mesmo artigo, sem prejuízo das medidas previstas no art. 22, o percentual excedente terá de ser eliminado nos dois quadrimestres seguintes, sendo pelo menos um terço no primeiro, adotando-se, entre outras, as providências previstas nos §§ 3º e 4º do art. 169 da Constituição\".");
//		}
	     
		/*Em razão da Ordem de Serviço Conjunta nº 01/2019, para fins de cálculo com a despesa com pessoal  
			 * (Certidão de gasto com pessoal, limites e certidão para fins de operações de crédito) para o exercício de 2018, deverá ser considerado os valores devidos 
			 * pelo Estado aos municípios relativos ao Fundeb e ICMS do exercício de 2018, os quais deverão ser somados ao total da receita corrente líquida.*/
		 //solicitado a remessa da nota pela HELIANE DA COSTA no dia 21//11/2019  
//			if(peticaoCertidao.getNumAnoRef() == 2018){
//				nota.append("<br />2 - Conforme disposto nos §§ 5° e 6° do art. 1° da Ordem de Serviço Conjunta n° 01, de 29 de maio de 2019")
//				.append(", acrescentou-se ao total da Receita Corrente Líquida os valores devidos pelo Estado aos Municípios relativos ao Fundeb e ICMS do exercício de 2018. ");
//			}
		
		if(indObsEducacao != null){
			 nota.append(indice).append(indObsEducacao.getDscObservacao());
			 ++indice;
		}
		
		if(indObsPessoal != null){
			 nota.append(indice).append(indObsPessoal.getDscObservacao());
			 ++indice;
		}
		
		if(indObsSaude != null){
			 nota.append(indice).append(indObsSaude.getDscObservacao());
			 ++indice;
		}
		return nota;
	}
	
	public String recuperaIndiceFundeb(String codMunicipio, String anoExercicio, Long codAnalise) throws Exception {
		IndiceFundebWS indiceFundebWS = new IndiceFundebWSProxy(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_WEBSERVICE_FUNDEB)).getIndiceFundebWS();
		return indiceFundebWS.buscarIndiceFundeb(codMunicipio, anoExercicio, codAnalise);
	}
}
