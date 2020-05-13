package br.gov.mg.tce.dto;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class ValidaTramitacaoDoProcessoDTO implements Serializable{
	
	private Boolean permiteTramitacao;
	private List<Long> ocorrencias;
	private String dscSituacao;
	
	public ValidaTramitacaoDoProcessoDTO() {
		super();
	}

	public Boolean getPermiteTramitacao() {
		return permiteTramitacao;
	}

	public void setPermiteTramitacao(Boolean permiteTramitacao) {
		this.permiteTramitacao = permiteTramitacao;
	}

	public List<Long> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Long> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public String getDscSituacao() {
		return dscSituacao;
	}

	public void setDscSituacao(String dscSituacao) {
		this.dscSituacao = dscSituacao;
	}

}