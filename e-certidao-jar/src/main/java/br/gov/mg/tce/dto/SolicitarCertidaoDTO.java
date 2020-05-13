package br.gov.mg.tce.dto;

import java.io.Serializable;

/**
 *Este DTO � o retorno do webservice de SolicitarCertidao {@link PeticaoCertidaoWS}
 */
public class SolicitarCertidaoDTO implements Serializable{
	
	private static final long serialVersionUID = -8593247552132935441L;
	
	private String numProtocolo;
	private Boolean aviso2Dias;
	
	public String getNumProtocolo() {
		return numProtocolo;
	}
	public void setNumProtocolo(String numProtocolo) {
		this.numProtocolo = numProtocolo;
	}
	public Boolean getAviso2Dias() {
		return aviso2Dias;
	}
	public void setAviso2Dias(Boolean aviso2Dias) {
		this.aviso2Dias = aviso2Dias;
	}

	
}