package br.gov.mg.tce.dto.sicom.relatorio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MesEnvio {

	@Id
	private BigDecimal cod_municipio;
	private String nom_municipio;
	private BigDecimal menor_posicao;
	private BigDecimal maior_posicao;

	public MesEnvio() {
		super();
	}

	public BigDecimal getCod_municipio() {
		return cod_municipio;
	}

	public void setCod_municipio(BigDecimal cod_municipio) {
		this.cod_municipio = cod_municipio;
	}

	public String getNom_municipio() {
		return nom_municipio;
	}

	public void setNom_municipio(String nom_municipio) {
		this.nom_municipio = nom_municipio;
	}

	public BigDecimal getMenor_posicao() {
		return menor_posicao;
	}

	public void setMenor_posicao(BigDecimal menor_posicao) {
		this.menor_posicao = menor_posicao;
	}

	public BigDecimal getMaior_posicao() {
		return maior_posicao;
	}

	public void setMaior_posicao(BigDecimal maior_posicao) {
		this.maior_posicao = maior_posicao;
	}

}
