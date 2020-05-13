package br.gov.mg.tce.business;

import javax.ejb.Stateless;

import org.codehaus.plexus.util.ExceptionUtils;
import org.datacontract.schemas._2004._07.SendMailService.Destinatarios;
import org.tempuri.ISendMailService;
import org.tempuri.SendMailServiceLocator;

import br.gov.mg.tce.dto.Email;
import br.gov.mg.tce.facade.EMailBOLocal;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.util.DateUtil;

@Stateless(name = "EMailBO", mappedName = "EMailBO")
public class EMailBO implements EMailBOLocal {

	@Override
	public void enviarEmailECertidao(String msg, String assunto) {

		try {
			ISendMailService email = new SendMailServiceLocator().getBasicHttpBinding_ISendMailService();
			email.enviarEmail(getDestinatarios(), assunto, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void enviarEmailErro(Email email) {

		try {
			if("producao".equals(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.AMBIENTE))){
			
				ISendMailService emailMailService = new SendMailServiceLocator().getBasicHttpBinding_ISendMailService();
				StringBuilder erro = new StringBuilder();
				Certidao certidao = email.getCertidao();

				if(certidao != null){
					erro.append("<b>IBGE: </b>").append(certidao.getCodMunicipio()).append("</br>");
					erro.append("<b>MUNICIPIO: </b>").append(certidao.getNomeMunicipio().toUpperCase()).append("</br>");
					erro.append("<b>CODIGO CERTIDAO: </b>").append(certidao.getCodCertidao()).append("</br>");
					erro.append("<b>EXERCICIO: </b>").append(certidao.getNumAnoRef()).append("</br>");
					erro.append("<b>TIPO CERTIDAO: </b>").append(certidao.getIndTipoCertidao().toString()).append("</br>");
					erro.append("<b>DATA SOLICITACAO: </b>").append(DateUtil.formatoDataPorExtenso(certidao.getDataSolicitacao())).append("</br>").append("</br>");
				}
				erro.append("<b>STACKTRACE: </b>").append(ExceptionUtils.getFullStackTrace(email.getErro())).append("</br>").append("</br>");
				
				emailMailService.enviarEmail(getDestinatariosDTI(), email.getAssunto(), erro.toString());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private Destinatarios[] getDestinatariosDTI() {

		String[] destinatarios = new String[] {"daniel.paula@tce.mg.gov.br"};

		Destinatarios[] arrayOfDestinatarios = new Destinatarios[destinatarios.length];

		int i = 0;
		for (String email : destinatarios) {
			Destinatarios destinatario = new Destinatarios();
			destinatario.setEmail(email);
			arrayOfDestinatarios[i] = destinatario;
			++i;
		}

		return arrayOfDestinatarios;
	}
	
	private Destinatarios[] getDestinatarios(){
		
		
		String [] destinatarios = null;
		if("producao".equalsIgnoreCase(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.AMBIENTE))){
			destinatarios = new String[]{"daniel.paula@tce.mg.gov.br", "jsaturno@tce.mg.gov.br", "mediniz@tce.mg.gov.br", "hbrum@tce.mg.gov.br"};
		}else{
			destinatarios = new String[]{"daniel.paula@tce.mg.gov.br"};
		}
		Destinatarios[] arrayOfDestinatarios = new Destinatarios[destinatarios.length];
		
		int i = 0;
		for (String email : destinatarios) {
			Destinatarios destinatario = new Destinatarios();
			destinatario.setEmail(email);
			arrayOfDestinatarios[i] = destinatario;
			++i;
		}
		
		return arrayOfDestinatarios;
	}
	
}