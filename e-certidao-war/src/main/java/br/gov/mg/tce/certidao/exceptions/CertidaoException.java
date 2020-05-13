package br.gov.mg.tce.certidao.exceptions;

public class CertidaoException extends Exception {

	private String message;
	
	public CertidaoException(String msgErro) {
		this.message = msgErro;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
