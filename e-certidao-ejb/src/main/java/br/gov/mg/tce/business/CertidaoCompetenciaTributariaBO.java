package br.gov.mg.tce.business;

import java.io.InputStream;
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
import br.gov.mg.tce.dao.CertidaoCompetenciaTributariaDAO;
import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.enumerator.MesEnum;
import br.gov.mg.tce.facade.CertidaoCompetenciaTributariaBOLocal;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.facade.SiaceBOLocal;
import br.gov.mg.tce.facade.sicom.SicomCompetenciaTributariaBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.util.DateUtil;
import br.gov.mg.tcemg.util.Paginacao;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "CertidaoCompetenciaTributariaBO", mappedName = "CertidaoCompetenciaTributariaBO")
public class CertidaoCompetenciaTributariaBO extends TCEMGBusinessDomain<CertidaoCompetenciaTributaria> implements CertidaoCompetenciaTributariaBOLocal {

	@InjectDAO
	private CertidaoCompetenciaTributariaDAO competenciaTributariaDAO;
	
	@EJB
	private SiaceBOLocal siaceBO;
	@EJB
	private SicomCompetenciaTributariaBOLocal sicomCompetenciaTributariaBOLocal;
    @EJB
    private EMailBOLocal eMailBO;
	
	@Override
	protected TCEMGDao<CertidaoCompetenciaTributaria> getDao() {
		return competenciaTributariaDAO;
	}
	
	@Override
	public void gerarCertidao(Integer qtde) {
		
	
//			CertidaoCompetenciaTributaria obter = super.obter(74784L);
//            List<CertidaoCompetenciaTributaria> certidoes = new ArrayList<>();
//            certidoes.add(obter);
        List<CertidaoCompetenciaTributaria> certidoes = this.pesquisarSolicitacoesEmAnalise(qtde);
        for (CertidaoCompetenciaTributaria certidao : certidoes) {
			
			try {
				
				certidao.reinicializarPrevisaoArrecadacao();
				if(certidao.getNumAnoRef() <= 2017){
					siaceBO.setDadosCertidaoCompetenciaTributaria(certidao);
				}else{
					sicomCompetenciaTributariaBOLocal.consultarDadosCertidaoCompetenciaTributaria(certidao);
				}
				if(IndSituacaoCertidaoEnum.CONCLUIDA.equals(certidao.getIndSituacao())){
					certidao.setArqCertidaoPdf(gerarArquivoCertidao(certidao));
					certidao.setDataGeracaoCertidao(new Date());
					certidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
				}
				
			} catch (Exception e) {
				certidao.setIndSituacao(IndSituacaoCertidaoEnum.ERRO);
				eMailBO.enviarEmailErro(new Email(certidao, "Competencia Triburaria", e));
			}finally{
				alterar(certidao);
			}
			
		}
	}
	
	 private byte[] gerarArquivoCertidao(CertidaoCompetenciaTributaria certidao) throws Exception {

		 
		 HashMap<String, Object> parameters = new HashMap<String, Object>();
		 String protocolo = String.valueOf(certidao.getNumProtocolo());
		 String protocoloFormatado = protocolo.substring(0, 10);
		 protocoloFormatado = protocoloFormatado + "/" + protocolo.substring(10);
		 parameters.put("P_NUM_PROTOCOLO", protocoloFormatado);
		 parameters.put("P_DATA_VENCIMENTO", String.valueOf(DateUtil.adicionaDias(certidao.getDataSolicitacao(), 90)));
		 parameters.put("P_IMG_TCE_LOGO", CertidaoCompetenciaTributariaBO.class.getResourceAsStream("/relatorios" + "/tceLogo.png"));
		 parameters.put("P_LINK_ECERTIDAO", "http://www.tce.mg.gov.br/ecertidao/");
	     parameters.put("P_NOME_MUNICIPIO", "<style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">" + certidao.getNomeMunicipio() + "</style>");
	     
	     String numPortaria = "54/PRES./2018";
	     String sistema =  certidao.getNumAnoRef() <= 2017 ? "Siace/LRF" : "Sicom"; 
	     StringBuilder param1 = new StringBuilder();
	     
	     if(certidao.isExercAndamento()){
	    	 
	    	 param1.append("Certifica-se, nos termos da Portaria nº ").append(numPortaria)
				 .append(", com base nos dados enviados por meio do ").append(sistema)
				 .append(" que, até a remessa do mês de ").append(MesEnum.getDescricaoPorMes(certidao.getNumMesAndamento()))
				 .append(", o Município de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
				 .append(certidao.getNomeMunicipio()).append("</style>")	
				 .append(", referente ao exercício de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">").append(certidao.getNumAnoRef()).append("</style>,");
	     }else{
	    	 param1 = new StringBuilder("Certifica-se, nos termos da Portaria nº ").append(numPortaria)
	    		 .append(", com base nos dados enviados por meio do ").append(sistema)
	    		 .append(", referentes ao exercício de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">").append(certidao.getNumAnoRef())
	    		 .append("</style>, que o Município de <style isBold=\"true\" pdfFontName=\"Helvetica-Bold\">")
	    		 .append(certidao.getNomeMunicipio()).append("</style>");
	     }
	     
		 
	     String ok = "OK";
	     String dscImpCompNaoArrecadados = certidao.getDscImpCompNaoArrecadados();
	     String dscImpCompNaoPrevisto = certidao.getDscImpCompNaoPrevisto();	
	     if(ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
	    	 param1.append(" previu e arrecadou todos os tributos de sua competência, conforme estabelecido no artigo 11, parágrafo único, da Lei Complementar nº 101/2000.");
	     } else {
	    	 if(ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && !ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
	    		 param1.append(" não fez a previsão do "+ dscImpCompNaoPrevisto + ", contudo, arrecadou todos os tributos de sua competência, conforme estabelecido no artigo 11, parágrafo único, da Lei Complementar nº 101/2000.");
	    	 }else if(!ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
	    		 param1.append(" fez a previsão de todos os tributos de sua competência, contudo, não arrecadou o " + dscImpCompNaoArrecadados + ", conforme estabelecido no artigo 11, parágrafo único, da Lei Complementar nº 101/2000.");
	    	 }else if(!ok.equalsIgnoreCase(dscImpCompNaoArrecadados) && !ok.equalsIgnoreCase(dscImpCompNaoPrevisto)){
	    		 param1.append(" não fez a previsão do " + dscImpCompNaoPrevisto + " e não arrecadou o " + dscImpCompNaoArrecadados + ", contrariando o estabelecido no artigo 11, parágrafo único, da Lei Complementar nº 101/2000.");
	    	 }
	     }

	     param1.append(" <br />Os dados certificados poderão sujeitar-se à retificação em decorrência de inspeção ordinária, extraordinária ou especial e tomada de contas que venham a ser realizadas no município ou de qualquer outro processo que venha a ser apreciado por esta Corte. ");
	     
	     parameters.put("P_PARAM1", param1.toString());
	     
	     InputStream inputStream = CertidaoCompetenciaTributaria.class.getResourceAsStream("/relatorios/" + "ModeloCertidaoCompetenciaTributaria.jasper");
	     JasperPrint jpPrint = JasperFillManager.fillReport(inputStream, parameters, new JREmptyDataSource());
	     return JasperExportManager.exportReportToPdf(jpPrint);
	 }

	private List<CertidaoCompetenciaTributaria> pesquisarSolicitacoesEmAnalise(Integer qtde) {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("indSituacao", IndSituacaoCertidaoEnum.EM_ANALISE);
		return super.consultarPorNamedQuery(CertidaoCompetenciaTributaria.SOLICITACAO_EM_ANALISE, param, new Paginacao(0, qtde));
	}

}
