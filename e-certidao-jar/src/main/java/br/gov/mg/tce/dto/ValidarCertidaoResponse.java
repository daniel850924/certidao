package br.gov.mg.tce.dto;

import java.io.Serializable;

import br.gov.mg.tce.model.Certidao;

/**
 * Classe que contém as informacoes de retorno do servico de validar certidao
 */
public class ValidarCertidaoResponse implements Serializable{

	private static final long serialVersionUID = -4276724476019410542L;
	
	private String msgRetorno;	
	private Boolean downloadFile = false;
	private Certidao certidao;
	
	public String getMsgRetorno() {
		return msgRetorno;
	}
	public void setMsgRetorno(String msgRetorno) {
		this.msgRetorno = msgRetorno;
	}
	public Certidao getCertidao() {
		return certidao;
	}
	public void setCertidao(Certidao certidao) {
		this.certidao = certidao;
	}
	public Boolean getDownloadFile() {
		return downloadFile;
	}
	public void setDownloadFile(Boolean downloadFile) {
		this.downloadFile = downloadFile;
	}
	
}
