package br.gov.mg.tce.dto;

import br.gov.mg.tce.model.Certidao;

public class Email {

	private Certidao certidao;
	private String assunto;
	private Throwable erro;

	public Email() {
		super();
	}

	public Email(Certidao certidao, String assunto, Throwable erro) {
		super();
		this.certidao = certidao;
		this.assunto = assunto;
		this.erro = erro;
	}

	public Certidao getCertidao() {
		return certidao;
	}

	public void setCertidao(Certidao certidao) {
		this.certidao = certidao;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public Throwable getErro() {
		return erro;
	}

	public void setErro(Throwable erro) {
		this.erro = erro;
	}

}
