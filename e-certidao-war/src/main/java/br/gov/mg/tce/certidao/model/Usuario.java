package br.gov.mg.tce.certidao.model;

import java.io.Serializable;
import java.util.Date;

import br.gov.mg.tce.certidao.util.MascaraUtil;

public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5928131902706085881L;
	private Date dataNascimento;
	private String cpf;
	private String nis;
	private String rg;
	private String email;
	private String orgaoExpedidor;
	private String numInss;
	private String tituloEleitor;
	private String numZonaEleitoral;
	private String secao;
	private String municipio;
	private String nome;
	
	private String cpfFormatado;
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNis() {
		return nis;
	}
	public void setNis(String nis) {
		this.nis = nis;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}
	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}
	public String getNumInss() {
		return numInss;
	}
	public void setNumInss(String numInss) {
		this.numInss = numInss;
	}
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
	public String getNumZonaEleitoral() {
		return numZonaEleitoral;
	}
	public void setNumZonaEleitoral(String numZonaEleitoral) {
		this.numZonaEleitoral = numZonaEleitoral;
	}
	public String getSecao() {
		return secao;
	}
	public void setSecao(String secao) {
		this.secao = secao;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfFormatado() {
		
		cpfFormatado = "";
		if(cpf != null && !cpf.equalsIgnoreCase("")){
			
			cpfFormatado = MascaraUtil.formatar(cpf, "###.###.###-##");
		}
		
		return cpfFormatado;
	}
	public void setCpfFormatado(String cpfFormatado) {
		this.cpfFormatado = cpfFormatado;
	}
	
	
	
}
