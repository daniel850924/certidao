/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.mg.tce.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.mg.tcemg.model.IEntidade;

/**
 * 
 * @author dasilva
 */
@Entity
@Table(name = "VW_PETICAO_ELETRONICA")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "VwPeticaoEletronica.findAll", query = "SELECT v FROM VwPeticaoEletronica v"),
		@NamedQuery(name = "VwPeticaoEletronica.findByCodPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.codPeticao = :codPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByCodTipoPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.codTipoPeticao = :codTipoPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findBySglTipoPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.sglTipoPeticao = :sglTipoPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByDscTipoPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.dscTipoPeticao = :dscTipoPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByCodTipoDocPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.codTipoDocPeticao = :codTipoDocPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findBySglTipoDocPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.sglTipoDocPeticao = :sglTipoDocPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByDscTipoDocPeticao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.dscTipoDocPeticao = :dscTipoDocPeticao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByDatSolicitacao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.datSolicitacao = :datSolicitacao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByCodPessoa", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.codPessoa = :codPessoa"),
		@NamedQuery(name = "VwPeticaoEletronica.findByNomPessoa", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.nomPessoa = :nomPessoa"),
		@NamedQuery(name = "VwPeticaoEletronica.findByNumCpfCnpf", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.numCpfCnpf = :numCpfCnpf"),
		@NamedQuery(name = "VwPeticaoEletronica.findByNumCpfCnpfEdt", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.numCpfCnpfEdt = :numCpfCnpfEdt"),
		@NamedQuery(name = "VwPeticaoEletronica.findByNumAnoRef", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.numAnoRef = :numAnoRef"),
		@NamedQuery(name = "VwPeticaoEletronica.findByCodDoc", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.codDoc = :codDoc"),
		@NamedQuery(name = "VwPeticaoEletronica.findByAnoDoc", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.anoDoc = :anoDoc"),
		@NamedQuery(name = "VwPeticaoEletronica.findByDatSituacao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.datSituacao = :datSituacao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByCodSituacao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.codSituacao = :codSituacao"),
		@NamedQuery(name = "VwPeticaoEletronica.findBySglSituacao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.sglSituacao = :sglSituacao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByDscSituacao", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.dscSituacao = :dscSituacao"),
		@NamedQuery(name = "VwPeticaoEletronica.findByDscMotivo", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.dscMotivo = :dscMotivo"),
		@NamedQuery(name = "VwPeticaoEletronica.findByNumMatrServ", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.numMatrServ = :numMatrServ"),
		@NamedQuery(name = "VwPeticaoEletronica.findByNomServ", query = "SELECT v FROM VwPeticaoEletronica v WHERE v.nomServ = :nomServ") })
public class VwPeticaoEletronica implements IEntidade {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "COD_PETICAO")
	private BigInteger codPeticao;
	@Basic(optional = false)
	@Column(name = "COD_TIPO_PETICAO")
	private Integer codTipoPeticao;
	@Basic(optional = false)
	@Column(name = "SGL_TIPO_PETICAO")
	private String sglTipoPeticao;
	@Basic(optional = false)
	@Column(name = "COD_TIPO_FINALIDADE")
	private Integer codFinalidade;

	@Column(name = "SGL_TIPO_FINALIDADE")
	private String sglFinalidade;

	@Column(name = "DSC_TIPO_FINALIDADE")
	private String dscTipoFinalidade;

	@Column(name = "DSC_TIPO_PETICAO")
	private String dscTipoPeticao;
	@Basic(optional = false)
	@Column(name = "COD_TIPO_DOC_PETICAO")
	private Integer codTipoDocPeticao;
	@Basic(optional = false)
	@Column(name = "SGL_TIPO_DOC_PETICAO")
	private String sglTipoDocPeticao;
	@Basic(optional = false)
	@Column(name = "DSC_TIPO_DOC_PETICAO")
	private String dscTipoDocPeticao;
	@Basic(optional = false)
	@Column(name = "DAT_SOLICITACAO")
	@Temporal(TemporalType.DATE)
	private Date datSolicitacao;
	@Basic(optional = false)
	@Column(name = "COD_PESSOA")
	private long codPessoa;

	@Column(name = "NOM_PESSOA")
	private String nomPessoa;
	@Basic(optional = false)
	@Column(name = "NUM_CPF_CNPF")
	private long numCpfCnpf;

	@Column(name = "NUM_CPF_CNPF_EDT")
	private String numCpfCnpfEdt;
	@Column(name = "NUM_ANO_REF")
	private Integer numAnoRef;
	@Column(name = "COD_DOC")
	private Long codDoc;
	@Column(name = "ANO_DOC")
	private Integer anoDoc;
	@Basic(optional = false)
	@Column(name = "DAT_SITUACAO")
	@Temporal(TemporalType.DATE)
	private Date datSituacao;
	@Basic(optional = false)
	@Column(name = "COD_SITUACAO")
	private Integer codSituacao;
	@Basic(optional = false)
	@Column(name = "SGL_SITUACAO")
	private String sglSituacao;
	@Basic(optional = false)
	@Column(name = "DSC_SITUACAO")
	private String dscSituacao;

	@Column(name = "DSC_MOTIVO")
	private String dscMotivo;
	@Column(name = "NUM_MATR_SERV")
	private Integer numMatrServ;

	@Column(name = "NOM_SERV")
	private String nomServ;

	@Column(name = "NUM_PROTOCOLO")
	private String protocolo;

	@Column(name = "NUM_PROTOCOLO_EDT")
	private String protocoloEditado;
	
	@Column(name = "COD_MUNICIPIO_IBGE")
	private String codMunicipioIbge;
	
	@Column(name = "NOM_MUNICIPIO")
	private String nomMunicipio;
	
	@Transient
	private Date dataIncioEmissao;
	@Transient
	private Date dataFimEmissao;
	    
	public VwPeticaoEletronica() {
	}

	public BigInteger getCodPeticao() {
		return codPeticao;
	}

	public void setCodPeticao(BigInteger codPeticao) {
		this.codPeticao = codPeticao;
	}

	public Integer getCodTipoPeticao() {
		return codTipoPeticao;
	}

	public void setCodTipoPeticao(Integer codTipoPeticao) {
		this.codTipoPeticao = codTipoPeticao;
	}

	public String getSglTipoPeticao() {
		return sglTipoPeticao;
	}

	public void setSglTipoPeticao(String sglTipoPeticao) {
		this.sglTipoPeticao = sglTipoPeticao;
	}

	public String getDscTipoPeticao() {
		return dscTipoPeticao;
	}

	public void setDscTipoPeticao(String dscTipoPeticao) {
		this.dscTipoPeticao = dscTipoPeticao;
	}

	public Integer getCodTipoDocPeticao() {
		return codTipoDocPeticao;
	}

	public void setCodTipoDocPeticao(Integer codTipoDocPeticao) {
		this.codTipoDocPeticao = codTipoDocPeticao;
	}

	public String getSglTipoDocPeticao() {
		return sglTipoDocPeticao;
	}

	public void setSglTipoDocPeticao(String sglTipoDocPeticao) {
		this.sglTipoDocPeticao = sglTipoDocPeticao;
	}

	public String getDscTipoDocPeticao() {
		return dscTipoDocPeticao;
	}

	public void setDscTipoDocPeticao(String dscTipoDocPeticao) {
		this.dscTipoDocPeticao = dscTipoDocPeticao;
	}

	public Date getDatSolicitacao() {
		return datSolicitacao;
	}

	public void setDatSolicitacao(Date datSolicitacao) {
		this.datSolicitacao = datSolicitacao;
	}

	public long getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getNomPessoa() {
		return nomPessoa;
	}

	public void setNomPessoa(String nomPessoa) {
		this.nomPessoa = nomPessoa;
	}

	public long getNumCpfCnpf() {
		return numCpfCnpf;
	}

	public void setNumCpfCnpf(long numCpfCnpf) {
		this.numCpfCnpf = numCpfCnpf;
	}

	public String getNumCpfCnpfEdt() {
		return numCpfCnpfEdt;
	}

	public void setNumCpfCnpfEdt(String numCpfCnpfEdt) {
		this.numCpfCnpfEdt = numCpfCnpfEdt;
	}

	public Long getCodDoc() {
		return codDoc;
	}

	public void setCodDoc(Long codDoc) {
		this.codDoc = codDoc;
	}

	public Integer getAnoDoc() {
		return anoDoc;
	}

	public void setAnoDoc(Integer anoDoc) {
		this.anoDoc = anoDoc;
	}

	public Date getDatSituacao() {
		return datSituacao;
	}

	public void setDatSituacao(Date datSituacao) {
		this.datSituacao = datSituacao;
	}

	public Integer getCodSituacao() {
		return codSituacao;
	}

	public void setCodSituacao(Integer codSituacao) {
		this.codSituacao = codSituacao;
	}

	public String getSglSituacao() {
		return sglSituacao;
	}

	public void setSglSituacao(String sglSituacao) {
		this.sglSituacao = sglSituacao;
	}

	public String getDscSituacao() {
		return dscSituacao;
	}

	public void setDscSituacao(String dscSituacao) {
		this.dscSituacao = dscSituacao;
	}

	public String getDscMotivo() {
		return dscMotivo;
	}

	public void setDscMotivo(String dscMotivo) {
		this.dscMotivo = dscMotivo;
	}

	public Integer getNumMatrServ() {
		return numMatrServ;
	}

	public void setNumMatrServ(Integer numMatrServ) {
		this.numMatrServ = numMatrServ;
	}

	public String getNomServ() {
		return nomServ;
	}

	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public Integer getNumAnoRef() {
		return numAnoRef;
	}

	public void setNumAnoRef(Integer numAnoRef) {
		this.numAnoRef = numAnoRef;
	}

	public String getDscTipoFinalidade() {
		return dscTipoFinalidade;
	}

	public void setDscTipoFinalidade(String dscTipoFinalidade) {
		this.dscTipoFinalidade = dscTipoFinalidade;
	}

	public Integer getCodFinalidade() {
		return codFinalidade;
	}

	public void setCodFinalidade(Integer codFinalidade) {
		this.codFinalidade = codFinalidade;
	}

	public String getSglFinalidade() {
		return sglFinalidade;
	}

	public void setSglFinalidade(String sglFinalidade) {
		this.sglFinalidade = sglFinalidade;
	}

	public String getProtocoloEditado() {
		return protocoloEditado;
	}

	public void setProtocoloEditado(String protocoloEditado) {
		this.protocoloEditado = protocoloEditado;
	}

	@Override
	public BigInteger getId() {
		return codPeticao;
	}

	@Override
	public BigInteger setId(Long id) {

		if(id != null){
			this.codPeticao = BigInteger.valueOf(id);
		}
		return codPeticao;
	}

	public String getCodMunicipioIbge() {
		return codMunicipioIbge;
	}

	public void setCodMunicipioIbge(String codMunicipioIbge) {
		this.codMunicipioIbge = codMunicipioIbge;
	}

	public String getNomMunicipio() {
		return nomMunicipio;
	}

	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}

	public Date getDataIncioEmissao() {
		return dataIncioEmissao;
	}

	public void setDataIncioEmissao(Date dataIncioEmissao) {
		this.dataIncioEmissao = dataIncioEmissao;
	}

	public Date getDataFimEmissao() {
		return dataFimEmissao;
	}

	public void setDataFimEmissao(Date dataFimEmissao) {
		this.dataFimEmissao = dataFimEmissao;
	}
	
}
