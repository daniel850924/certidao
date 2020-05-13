package br.gov.mg.tce.dto.sicom.relatorio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PrePca {

	public static final int SAUDE = 1;
	public static final int ENSINO = 2;
	public static final int DESP_PESSOAL = 3;
	public static final int FUNDEB = 4;
	public static final int DESP_EXECUTIVO = 8;
	public static final int DESP_LEGISLATIVO = 9;
	
	private BigDecimal codmun;
	private String nommun;
	@Id
	private BigDecimal seqind;
	private String dscind;
	private BigDecimal numanoref;
	private BigDecimal vlrpctapl;
	
	public PrePca() {
	}
	
	public BigDecimal getCodmun() {
		return codmun;
	}
	public void setCodmun(BigDecimal codmun) {
		this.codmun = codmun;
	}
	public String getNommun() {
		return nommun;
	}
	public void setNommun(String nommun) {
		this.nommun = nommun;
	}
	public BigDecimal getSeqind() {
		return seqind;
	}
	public void setSeqind(BigDecimal seqind) {
		this.seqind = seqind;
	}
	public String getDscind() {
		return dscind;
	}
	public void setDscind(String dscind) {
		this.dscind = dscind;
	}
	public BigDecimal getNumanoref() {
		return numanoref;
	}
	public void setNumanoref(BigDecimal numanoref) {
		this.numanoref = numanoref;
	}
	public BigDecimal getVlrpctapl() {
		return vlrpctapl;
	}
	public void setVlrpctapl(BigDecimal vlrpctapl) {
		this.vlrpctapl = vlrpctapl;
	}
	
}
