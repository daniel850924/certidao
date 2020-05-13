package br.gov.mg.tce.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.IndFinalidadeCertidaoEnum;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.enumerator.IndTipoCertidaoEnum;
import br.gov.mg.tcemg.model.IEntidade;

@Entity
@Table(name = "CERTIDAO")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement 
@NamedQueries({
	@NamedQuery(name=Certidao.BUSCAR_PETICAO_POR_NUMERO_PROTOCOLO,query="select p from Certidao p where p.numProtocolo = :numProtocolo"),
	
	@NamedQuery(name=Certidao.BUSCAR_ULTIMO_NUMERO_PROTOCOLO, 
		query="select max(p.numProtocolo) from Certidao p WHERE "
				+ "to_char(p.dataSolicitacao, 'yyyy') = :anoAtual "
				+ "and p.indTipoCertidao = :indTipoCertidao "
				+ "and substring(to_char(p.numProtocolo),0,1) = :codTipo"),
	
	@NamedQuery(name=Certidao.BUSCAR_PETICAO_POR_ID,query="select p from Certidao p where p.codCertidao = :codCertidao")
	
})
public class Certidao implements Serializable,IEntidade {
    
	@Override
	public String toString() {
		return "Certidao [codCertidao=" + codCertidao + ", numProtocolo="
				+ numProtocolo + ", numAnoRef=" + numAnoRef + ", codMunicipio="
				+ codMunicipio + ", nomeMunicipio=" + nomeMunicipio + "]";
	}

	private static final long serialVersionUID = 6429778478203113796L;
	
	public static final String BUSCAR_PETICAO_POR_NUMERO_PROTOCOLO = "Certidao.findByNumProtocolo";
	public static final String BUSCAR_PETICAO_POR_ID = "Certidao.findById";
	public static final String BUSCAR_ULTIMO_NUMERO_PROTOCOLO = "Certidao.getMaxProtocolo";
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "SQ_CERTIDAO", sequenceName = "SQ_CERTIDAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CERTIDAO")
    @Column(name = "COD_CERTIDAO")
    private Long codCertidao;
    
    @Column(name = "NUM_PROTOCOLO")
    private Long numProtocolo;
    
    @Column(name = "NUM_ANO_REF",nullable = false)
    private Integer numAnoRef;
    
    @Column(name = "DAT_SOLICITACAO",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataSolicitacao;
    
    @Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndTipoCertidaoEnum")} )
    @Column(name = "IND_TIPO_CERTIDAO")
    private IndTipoCertidaoEnum indTipoCertidao;
    
    @Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndFinalidadeCertidaoEnum")} )
    @Column(name = "IND_FINALIDADE")
    private IndFinalidadeCertidaoEnum indFinalidade;
    
    @Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum")} )
    @Column(name = "IND_SITUACAO")
    private IndSituacaoCertidaoEnum indSituacao;
    
    @Column(name = "NUM_CPF_CNPF",nullable = false)
    private Long numCpfCnpf;    
	
	@Column(name = "COD_MUNICIPIO")
	private Long codMunicipio;
	
	@Column(name = "DSC_INDEFERIDO_JUSTIFICATIVA")
	private String dscIndeferidoJustificativa;
	
	@Lob
    @Column(name = "ARQ_CERTIDAO_PDF")
    private byte[] arqCertidaoPdf;
	
    @Column(name = "DAT_GERACAO_CERTIDAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracaoCertidao;
    
    @Column(name = "DSC_MUNICIPIO")
	private String nomeMunicipio;
    
    @Transient
    private EnumTipoAnalise tipoAnalise;
    @Transient
    private Date dataIncioEmissao;
    @Transient
	private Date dataFimEmissao;
	
	@Override
	public Long getId() {
		return codCertidao;
	}

	@Override
	public Long setId(Long id) {
		this.codCertidao = id;
		return codCertidao;
	}

	public Long getNumProtocolo() {
		return numProtocolo;
	}

	public void setNumProtocolo(Long numProtocolo) {
		this.numProtocolo = numProtocolo;
	}

	public Integer getNumAnoRef() {
		return numAnoRef;
	}

	public void setNumAnoRef(Integer numAnoRef) {
		this.numAnoRef = numAnoRef;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public Long getNumCpfCnpf() {
		return numCpfCnpf;
	}

	public void setNumCpfCnpf(Long numCpfCnpf) {
		this.numCpfCnpf = numCpfCnpf;
	}

	public Long getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Long codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public byte[] getArqCertidaoPdf() {
		return arqCertidaoPdf;
	}

	public void setArqCertidaoPdf(byte[] arqCertidaoPdf) {
		this.arqCertidaoPdf = arqCertidaoPdf;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public String getDscIndeferidoJustificativa() {
		return dscIndeferidoJustificativa;
	}

	public void setDscIndeferidoJustificativa(String dscIndeferidoJustificativa) {
		this.dscIndeferidoJustificativa = dscIndeferidoJustificativa;
	}

	public Date getDataGeracaoCertidao() {
		return dataGeracaoCertidao;
	}

	public void setDataGeracaoCertidao(Date dataGeracaoCertidao) {
		this.dataGeracaoCertidao = dataGeracaoCertidao;
	}

	public Long getCodCertidao() {
		return codCertidao;
	}

	public void setCodCertidao(Long codCertidao) {
		this.codCertidao = codCertidao;
	}

	public IndTipoCertidaoEnum getIndTipoCertidao() {
		return indTipoCertidao;
	}

	public void setIndTipoCertidao(IndTipoCertidaoEnum indTipoCertidao) {
		this.indTipoCertidao = indTipoCertidao;
	}

	public IndFinalidadeCertidaoEnum getIndFinalidade() {
		return indFinalidade;
	}

	public void setIndFinalidade(IndFinalidadeCertidaoEnum indFinalidade) {
		this.indFinalidade = indFinalidade;
	}

	public IndSituacaoCertidaoEnum getIndSituacao() {
		return indSituacao;
	}

	public void setIndSituacao(IndSituacaoCertidaoEnum indSituacao) {
		this.indSituacao = indSituacao;
	}

	public EnumTipoAnalise getTipoAnalise() {
		return tipoAnalise;
	}

	public void setTipoAnalise(EnumTipoAnalise tipoAnalise) {
		this.tipoAnalise = tipoAnalise;
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