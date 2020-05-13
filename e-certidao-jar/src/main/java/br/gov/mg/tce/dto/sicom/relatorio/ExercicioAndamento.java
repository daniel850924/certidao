package br.gov.mg.tce.dto.sicom.relatorio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExercicioAndamento {

	@Id
	private BigDecimal ano;

	public ExercicioAndamento() {
		super();
	}

	public ExercicioAndamento(BigDecimal ano) {
		super();
		this.ano = ano;
	}

	public BigDecimal getAno() {
		return ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

}
