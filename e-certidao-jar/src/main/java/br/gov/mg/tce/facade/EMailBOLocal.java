package br.gov.mg.tce.facade;

import javax.ejb.Local;

import br.gov.mg.tce.dto.Email;

@Local
public interface EMailBOLocal {

	public void enviarEmailECertidao(String msg, String assunto);
	
	public void enviarEmailErro(Email email);
	
}