package br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OperacaoCreditoParecerPrevioTab1 {

	@Id
	private BigDecimal codibge;
	private BigDecimal ano;
	private BigDecimal valor_receita;
	private BigDecimal valor_despesa;
	private String resultado;
	private String contopcredito;
	private String realizopcredito;

	public OperacaoCreditoParecerPrevioTab1() {
		super();
	}

	public BigDecimal getCodibge() {
		return codibge;
	}

	public void setCodibge(BigDecimal codibge) {
		this.codibge = codibge;
	}

	public BigDecimal getAno() {
		return ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	public BigDecimal getValor_receita() {
		return valor_receita;
	}

	public void setValor_receita(BigDecimal valor_receita) {
		this.valor_receita = valor_receita;
	}

	public BigDecimal getValor_despesa() {
		return valor_despesa;
	}

	public void setValor_despesa(BigDecimal valor_despesa) {
		this.valor_despesa = valor_despesa;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getContopcredito() {
		return contopcredito;
	}

	public void setContopcredito(String contopcredito) {
		this.contopcredito = contopcredito;
	}

	public String getRealizopcredito() {
		return realizopcredito;
	}

	public void setRealizopcredito(String realizopcredito) {
		this.realizopcredito = realizopcredito;
	}

}
