package br.gov.mg.tce.dto.sicom.relatorio.operacaoCredito;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OperacaoCreditoExercicioAndamentoTab2 {

	
	@Id
	private String dt_base;
	private BigDecimal cod_municipio;
	private String ano;
	private BigDecimal vlr_dsp_legislativo;
	private BigDecimal prc_dps_leg;
	private BigDecimal vlr_dsp_executivo;
	private BigDecimal prc_dps_exe;
	private BigDecimal vlr_dsp_total;
	private BigDecimal prc_dps_mun;
	private BigDecimal vlr_rcl;
	private BigDecimal vlr_rcl_aju;
	private String dta_pub_rel_lrf;
	private String situacaorreo;
	private String dat_publicrgf;
	private String situacaorgf;
	private BigDecimal maiormes;

	public OperacaoCreditoExercicioAndamentoTab2() {
		super();
	}

	public BigDecimal getCod_municipio() {
		return cod_municipio;
	}

	public void setCod_municipio(BigDecimal cod_municipio) {
		this.cod_municipio = cod_municipio;
	}

	public String getDt_base() {
		return dt_base;
	}

	public void setDt_base(String dt_base) {
		this.dt_base = dt_base;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public BigDecimal getVlr_dsp_legislativo() {
		return vlr_dsp_legislativo;
	}

	public void setVlr_dsp_legislativo(BigDecimal vlr_dsp_legislativo) {
		this.vlr_dsp_legislativo = vlr_dsp_legislativo;
	}

	public BigDecimal getPrc_dps_leg() {
		return prc_dps_leg;
	}

	public void setPrc_dps_leg(BigDecimal prc_dps_leg) {
		this.prc_dps_leg = prc_dps_leg;
	}

	public BigDecimal getVlr_dsp_executivo() {
		return vlr_dsp_executivo;
	}

	public void setVlr_dsp_executivo(BigDecimal vlr_dsp_executivo) {
		this.vlr_dsp_executivo = vlr_dsp_executivo;
	}

	public BigDecimal getPrc_dps_exe() {
		return prc_dps_exe;
	}

	public void setPrc_dps_exe(BigDecimal prc_dps_exe) {
		this.prc_dps_exe = prc_dps_exe;
	}

	public BigDecimal getVlr_dsp_total() {
		return vlr_dsp_total;
	}

	public void setVlr_dsp_total(BigDecimal vlr_dsp_total) {
		this.vlr_dsp_total = vlr_dsp_total;
	}

	public BigDecimal getPrc_dps_mun() {
		return prc_dps_mun;
	}

	public void setPrc_dps_mun(BigDecimal prc_dps_mun) {
		this.prc_dps_mun = prc_dps_mun;
	}

	public BigDecimal getVlr_rcl() {
		return vlr_rcl;
	}

	public void setVlr_rcl(BigDecimal vlr_rcl) {
		this.vlr_rcl = vlr_rcl;
	}

	public BigDecimal getVlr_rcl_aju() {
		return vlr_rcl_aju;
	}

	public void setVlr_rcl_aju(BigDecimal vlr_rcl_aju) {
		this.vlr_rcl_aju = vlr_rcl_aju;
	}

	public String getDta_pub_rel_lrf() {
		return dta_pub_rel_lrf;
	}

	public void setDta_pub_rel_lrf(String dta_pub_rel_lrf) {
		this.dta_pub_rel_lrf = dta_pub_rel_lrf;
	}

	public String getSituacaorreo() {
		return situacaorreo;
	}

	public void setSituacaorreo(String situacaorreo) {
		this.situacaorreo = situacaorreo;
	}

	public String getDat_publicrgf() {
		return dat_publicrgf;
	}

	public void setDat_publicrgf(String dat_publicrgf) {
		this.dat_publicrgf = dat_publicrgf;
	}

	public String getSituacaorgf() {
		return situacaorgf;
	}

	public void setSituacaorgf(String situacaorgf) {
		this.situacaorgf = situacaorgf;
	}

	public BigDecimal getMaiormes() {
		return maiormes;
	}

	public void setMaiormes(BigDecimal maiormes) {
		this.maiormes = maiormes;
	}

}
