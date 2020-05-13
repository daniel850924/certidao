package br.gov.mg.tce.dto.sicom.relatorio.limites;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EnvioCompletoExercicioFechado {

	@Id
	private BigDecimal cod;
	private String visibilidade = "false";

	public BigDecimal getCod() {
		return cod;
	}

	public void setCod(BigDecimal cod) {
		this.cod = cod;
	}

	public String getVisibilidade() {
		return visibilidade;
	}

	public void setVisibilidade(String visibilidade) {
		this.visibilidade = visibilidade;
	}

	public EnvioCompletoExercicioFechado() {
		super();
	}

}
