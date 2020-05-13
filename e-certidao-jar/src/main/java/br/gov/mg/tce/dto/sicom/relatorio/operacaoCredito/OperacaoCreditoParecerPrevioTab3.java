package br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OperacaoCreditoParecerPrevioTab3 {

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
	private String opcsem;
	private BigDecimal operacoescreditoprevinicial;
	private BigDecimal despesacapitaldotacaoinicial;
	private String resultadosiace;

	public OperacaoCreditoParecerPrevioTab3() {
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

	public String getOpcsem() {
		return opcsem;
	}

	public void setOpcsem(String opcsem) {
		this.opcsem = opcsem;
	}

	public BigDecimal getOperacoescreditoprevinicial() {
		return operacoescreditoprevinicial;
	}

	public void setOperacoescreditoprevinicial(
			BigDecimal operacoescreditoprevinicial) {
		this.operacoescreditoprevinicial = operacoescreditoprevinicial;
	}

	public BigDecimal getDespesacapitaldotacaoinicial() {
		return despesacapitaldotacaoinicial;
	}

	public void setDespesacapitaldotacaoinicial(
			BigDecimal despesacapitaldotacaoinicial) {
		this.despesacapitaldotacaoinicial = despesacapitaldotacaoinicial;
	}

	public String getResultadosiace() {
		return resultadosiace;
	}

	public void setResultadosiace(String resultadosiace) {
		this.resultadosiace = resultadosiace;
	}

}
