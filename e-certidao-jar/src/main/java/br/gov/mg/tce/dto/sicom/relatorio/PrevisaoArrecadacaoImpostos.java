package br.gov.mg.tce.dto.sicom.relatorio;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PrevisaoArrecadacaoImpostos {

	@Id
	private String demostrativo;
	private BigDecimal cod_municipio;
	private String nom_municipio;

	public PrevisaoArrecadacaoImpostos() {
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

	public String getDemostrativo() {
		return demostrativo;
	}

	public void setDemostrativo(String demostrativo) {
		this.demostrativo = demostrativo;
	}
	
}
