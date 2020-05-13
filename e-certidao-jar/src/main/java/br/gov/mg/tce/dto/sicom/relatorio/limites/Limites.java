package br.gov.mg.tce.dto.sicom.relatorio.limites;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Limites {

	@Id
	private BigDecimal ano;
	private BigDecimal vlrrc;
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
	private BigDecimal vlrdivcon;
	private BigDecimal vlrdivconliq;
	private BigDecimal prcdivconliq;
	private BigDecimal vlraro;
	private BigDecimal prcaro;
	private BigDecimal vlropsemaro;
	private BigDecimal prcopsemaro;
	private BigDecimal vlrconcgrt;
	private BigDecimal prcconcgrt;
	private BigDecimal vlrinsrsp;
	private BigDecimal vlrdispfinanc;

	public Limites() {
		super();
	}

	public BigDecimal getAno() {
		return ano;
	}

	public void setAno(BigDecimal ano) {
		this.ano = ano;
	}

	public BigDecimal getVlrrc() {
		return vlrrc;
	}

	public void setVlrrc(BigDecimal vlrrc) {
		this.vlrrc = vlrrc;
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

	public BigDecimal getVlrdivcon() {
		return vlrdivcon;
	}

	public void setVlrdivcon(BigDecimal vlrdivcon) {
		this.vlrdivcon = vlrdivcon;
	}

	public BigDecimal getVlrdivconliq() {
		return vlrdivconliq;
	}

	public void setVlrdivconliq(BigDecimal vlrdivconliq) {
		this.vlrdivconliq = vlrdivconliq;
	}

	public BigDecimal getPrcdivconliq() {
		return prcdivconliq;
	}

	public void setPrcdivconliq(BigDecimal prcdivconliq) {
		this.prcdivconliq = prcdivconliq;
	}

	public BigDecimal getVlraro() {
		return vlraro;
	}

	public void setVlraro(BigDecimal vlraro) {
		this.vlraro = vlraro;
	}

	public BigDecimal getPrcaro() {
		return prcaro;
	}

	public void setPrcaro(BigDecimal prcaro) {
		this.prcaro = prcaro;
	}

	public BigDecimal getVlropsemaro() {
		return vlropsemaro;
	}

	public void setVlropsemaro(BigDecimal vlropsemaro) {
		this.vlropsemaro = vlropsemaro;
	}

	public BigDecimal getPrcopsemaro() {
		return prcopsemaro;
	}

	public void setPrcopsemaro(BigDecimal prcopsemaro) {
		this.prcopsemaro = prcopsemaro;
	}

	public BigDecimal getVlrconcgrt() {
		return vlrconcgrt;
	}

	public void setVlrconcgrt(BigDecimal vlrconcgrt) {
		this.vlrconcgrt = vlrconcgrt;
	}

	public BigDecimal getPrcconcgrt() {
		return prcconcgrt;
	}

	public void setPrcconcgrt(BigDecimal prcconcgrt) {
		this.prcconcgrt = prcconcgrt;
	}

	public BigDecimal getVlrinsrsp() {
		return vlrinsrsp;
	}

	public void setVlrinsrsp(BigDecimal vlrinsrsp) {
		this.vlrinsrsp = vlrinsrsp;
	}

	public BigDecimal getVlrdispfinanc() {
		return vlrdispfinanc;
	}

	public void setVlrdispfinanc(BigDecimal vlrdispfinanc) {
		this.vlrdispfinanc = vlrdispfinanc;
	}

}
