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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.mg.tcemg.model.IEntidade;


/**
 *
 * @author dasilva
 */
@Entity
@Table(name = "VW_ARQUIVOS_PETICAO_ELETRONICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findAll", query = "SELECT v FROM VwArquivosPeticaoEletronica v"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodControle", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codControle = :codControle"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodArquivo", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codArquivo = :codArquivo"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodTipoArquivo", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codTipoArquivo = :codTipoArquivo"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findBySglTipoArquivo", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.sglTipoArquivo = :sglTipoArquivo"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDscTipoArquivo", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.dscTipoArquivo = :dscTipoArquivo"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codPeticao = :codPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodTipoPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codTipoPeticao = :codTipoPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findBySglTipoPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.sglTipoPeticao = :sglTipoPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDscTipoPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.dscTipoPeticao = :dscTipoPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodTipoDocPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codTipoDocPeticao = :codTipoDocPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findBySglTipoDocPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.sglTipoDocPeticao = :sglTipoDocPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDscTipoDocPeticao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.dscTipoDocPeticao = :dscTipoDocPeticao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDatSolicitacao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.datSolicitacao = :datSolicitacao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodPessoa", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codPessoa = :codPessoa"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByNomPessoa", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.nomPessoa = :nomPessoa"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByNumCpfCnpf", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.numCpfCnpf = :numCpfCnpf"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByNumCpfCnpfEdt", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.numCpfCnpfEdt = :numCpfCnpfEdt"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByNumAnoRef", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.numAnoRef = :numAnoRef"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodDoc", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codDoc = :codDoc"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByAnoDoc", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.anoDoc = :anoDoc"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDatSituacao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.datSituacao = :datSituacao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByCodSituacao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.codSituacao = :codSituacao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findBySglSituacao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.sglSituacao = :sglSituacao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDscSituacao", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.dscSituacao = :dscSituacao"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByDscMotivo", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.dscMotivo = :dscMotivo"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByNumMatrServ", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.numMatrServ = :numMatrServ"),
    @NamedQuery(name = "VwArquivosPeticaoEletronica.findByNomServ", query = "SELECT v FROM VwArquivosPeticaoEletronica v WHERE v.nomServ = :nomServ")})
public class VwArquivosPeticaoEletronica implements IEntidade {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	
	@Column(name = "ID")
	private BigInteger id;
    
	@Basic(optional = false)
    
    @Column(name = "COD_SITUACAO_ASSINATURA")
    private short codSituacaoAssinatura;
    @Basic(optional = false)
    
    @Column(name = "SGL_SITUACAO_ASSINATURA")
    private String sglSituacaoAssinatura;
    @Basic(optional = false)
    
    @Column(name = "DSC_SITUACAO_ASSINATURA")
    private String dscSituacaoAssinatura;
    
    @Basic(optional = false)
    
    @Column(name = "COD_CONTROLE")
    private BigInteger codControle;
    @Basic(optional = false)
    
    @Column(name = "COD_ARQUIVO")
    private BigInteger codArquivo;
    @Basic(optional = false)
    
    @Column(name = "COD_TIPO_ARQUIVO")
    private short codTipoArquivo;
    @Basic(optional = false)
    
    @Column(name = "SGL_TIPO_ARQUIVO")
    private String sglTipoArquivo;
    @Basic(optional = false)
    
    @Column(name = "DSC_TIPO_ARQUIVO")
    private String dscTipoArquivo;
    @Basic(optional = false)
    
    @Column(name = "COD_PETICAO")
    private BigInteger codPeticao;
    @Basic(optional = false)
    
    @Column(name = "COD_TIPO_PETICAO")
    private short codTipoPeticao;
    @Basic(optional = false)
    
    @Column(name = "SGL_TIPO_PETICAO")
    private String sglTipoPeticao;
    @Basic(optional = false)
    
    @Column(name = "DSC_TIPO_PETICAO")
    private String dscTipoPeticao;
    @Basic(optional = false)
    
    @Column(name = "COD_TIPO_DOC_PETICAO")
    private short codTipoDocPeticao;
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
    private Short numAnoRef;
    @Column(name = "COD_DOC")
    private Long codDoc;
    @Column(name = "ANO_DOC")
    private Short anoDoc;
    @Basic(optional = false)
    
    @Column(name = "DAT_SITUACAO")
    @Temporal(TemporalType.DATE)
    private Date datSituacao;
    @Basic(optional = false)
    
    @Column(name = "COD_SITUACAO")
    private short codSituacao;
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
    @Lob
    @Column(name = "ARQ_PROCESSO_PDF")
    private byte[] arqProcessoPdf;

    public VwArquivosPeticaoEletronica() {
    }

    public BigInteger getCodControle() {
        return codControle;
    }

    public void setCodControle(BigInteger codControle) {
        this.codControle = codControle;
    }

    public BigInteger getCodArquivo() {
        return codArquivo;
    }

    public void setCodArquivo(BigInteger codArquivo) {
        this.codArquivo = codArquivo;
    }

    public short getCodTipoArquivo() {
        return codTipoArquivo;
    }

    public void setCodTipoArquivo(short codTipoArquivo) {
        this.codTipoArquivo = codTipoArquivo;
    }

    public String getSglTipoArquivo() {
        return sglTipoArquivo;
    }

    public void setSglTipoArquivo(String sglTipoArquivo) {
        this.sglTipoArquivo = sglTipoArquivo;
    }

    public String getDscTipoArquivo() {
        return dscTipoArquivo;
    }

    public void setDscTipoArquivo(String dscTipoArquivo) {
        this.dscTipoArquivo = dscTipoArquivo;
    }

    public BigInteger getCodPeticao() {
        return codPeticao;
    }

    public void setCodPeticao(BigInteger codPeticao) {
        this.codPeticao = codPeticao;
    }

    public short getCodTipoPeticao() {
        return codTipoPeticao;
    }

    public void setCodTipoPeticao(short codTipoPeticao) {
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

    public short getCodTipoDocPeticao() {
        return codTipoDocPeticao;
    }

    public void setCodTipoDocPeticao(short codTipoDocPeticao) {
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

    public Short getNumAnoRef() {
        return numAnoRef;
    }

    public void setNumAnoRef(Short numAnoRef) {
        this.numAnoRef = numAnoRef;
    }

    public Long getCodDoc() {
        return codDoc;
    }

    public void setCodDoc(Long codDoc) {
        this.codDoc = codDoc;
    }

    public Short getAnoDoc() {
        return anoDoc;
    }

    public void setAnoDoc(Short anoDoc) {
        this.anoDoc = anoDoc;
    }

    public Date getDatSituacao() {
        return datSituacao;
    }

    public void setDatSituacao(Date datSituacao) {
        this.datSituacao = datSituacao;
    }

    public short getCodSituacao() {
        return codSituacao;
    }

    public void setCodSituacao(short codSituacao) {
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

    public short getCodSituacaoAssinatura() {
        return codSituacaoAssinatura;
    }

    public void setCodSituacaoAssinatura(short codSituacaoAssinatura) {
        this.codSituacaoAssinatura = codSituacaoAssinatura;
    }

    public String getSglSituacaoAssinatura() {
        return sglSituacaoAssinatura;
    }

    public void setSglSituacaoAssinatura(String sglSituacaoAssinatura) {
        this.sglSituacaoAssinatura = sglSituacaoAssinatura;
    }

    public String getDscSituacaoAssinatura() {
        return dscSituacaoAssinatura;
    }

    public void setDscSituacaoAssinatura(String dscSituacaoAssinatura) {
        this.dscSituacaoAssinatura = dscSituacaoAssinatura;
    }

	public byte[] getArqProcessoPdf() {
		return arqProcessoPdf;
	}

	public void setArqProcessoPdf(byte[] arqProcessoPdf) {
		this.arqProcessoPdf = arqProcessoPdf;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	@Override
	public BigInteger setId(Long id) {
		if(id != null){
			this.id = BigInteger.valueOf(id);
		}
		return this.id;
	}
 
}
