package br.gov.mg.tce.dto.sicom.relatorio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OptanteSemestralidade {

	@Id
	private BigDecimal numano;
	private String opsemestralidade;

	public OptanteSemestralidade() {
		super();
	}

	public BigDecimal getNumano() {
		return numano;
	}

	public void setNumano(BigDecimal numano) {
		this.numano = numano;
	}

	public String getOpsemestralidade() {
		return opsemestralidade;
	}

	public void setOpsemestralidade(String opsemestralidade) {
		this.opsemestralidade = opsemestralidade;
	}

}
