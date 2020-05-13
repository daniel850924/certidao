package br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OperacaoCreditoExercFechado {

	@Id
	private BigDecimal ano;
	private BigDecimal vlrrclliq;
	private BigDecimal vlrdspexe;
	private BigDecimal prcdspexe;
	private BigDecimal vlrdspleg;
	private BigDecimal prcdspleg;
	private String datpubrreo;
	private String sitpubrreo;
	private String datpubrgf;
	private String sitpubrgf;
	private String opsemestralidade;
	private BigDecimal prevrecopcrd;
	private BigDecimal dspcapdotini;
	private String resultado;
	
	public OperacaoCreditoExercFechado() {
		super();
	}

	public BigDecimal getAno() {
		return ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	public BigDecimal getVlrrclliq() {
		return vlrrclliq;
	}

	public void setVlrrclliq(BigDecimal vlrrclliq) {
		this.vlrrclliq = vlrrclliq;
	}

	public BigDecimal getVlrdspexe() {
		return vlrdspexe;
	}

	public void setVlrdspexe(BigDecimal vlrdspexe) {
		this.vlrdspexe = vlrdspexe;
	}

	public BigDecimal getPrcdspexe() {
		return prcdspexe;
	}

	public void setPrcdspexe(BigDecimal prcdspexe) {
		this.prcdspexe = prcdspexe;
	}

	public BigDecimal getVlrdspleg() {
		return vlrdspleg;
	}

	public void setVlrdspleg(BigDecimal vlrdspleg) {
		this.vlrdspleg = vlrdspleg;
	}

	public BigDecimal getPrcdspleg() {
		return prcdspleg;
	}

	public void setPrcdspleg(BigDecimal prcdspleg) {
		this.prcdspleg = prcdspleg;
	}

	public String getDatpubrreo() {
		return datpubrreo;
	}

	public void setDatpubrreo(String datpubrreo) {
		this.datpubrreo = datpubrreo;
	}

	public String getSitpubrreo() {
		return sitpubrreo;
	}

	public void setSitpubrreo(String sitpubrreo) {
		this.sitpubrreo = sitpubrreo;
	}

	public String getDatpubrgf() {
		return datpubrgf;
	}

	public void setDatpubrgf(String datpubrgf) {
		this.datpubrgf = datpubrgf;
	}

	public String getSitpubrgf() {
		return sitpubrgf;
	}

	public void setSitpubrgf(String sitpubrgf) {
		this.sitpubrgf = sitpubrgf;
	}

	public String getOpsemestralidade() {
		return opsemestralidade;
	}

	public void setOpsemestralidade(String opsemestralidade) {
		this.opsemestralidade = opsemestralidade;
	}

	public BigDecimal getPrevrecopcrd() {
		return prevrecopcrd;
	}

	public void setPrevrecopcrd(BigDecimal prevrecopcrd) {
		this.prevrecopcrd = prevrecopcrd;
	}

	public BigDecimal getDspcapdotini() {
		return dspcapdotini;
	}

	public void setDspcapdotini(BigDecimal dspcapdotini) {
		this.dspcapdotini = dspcapdotini;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
