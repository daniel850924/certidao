package br.gov.mg.tce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.mg.tce.client.pca.web.IndiceDelibInv;
import br.gov.mg.tce.client.pca.web.IndiceParecerPrevio;

@Entity
@Table(name = "CERTIDAO_PCA")
@XmlRootElement 
@NamedQueries({
	@NamedQuery(name=CertidaoPCA.BUSCAR_PETICAO_MAIS_RECENTE,
			query="select p from CertidaoPCA p where p.codMunicipio = :codMunicipio and p.numAnoRef = :anoExercicio and p.indSituacao = 'CONC' order by p.dataSolicitacao desc"),
	
	@NamedQuery(name=CertidaoPCA.SOLICITACAO_EM_ANALISE,
			query="select p from CertidaoPCA p where  p.indSituacao = :indSituacao and p.sglTipoAnalise = :sglTipoAnalise order by p.dataSolicitacao desc"),
	
	@NamedQuery(name=CertidaoPCA.BUSCAR_POR_TIPO_ANALISE,
			query=	" select p from CertidaoPCA p " +
					" where p.codMunicipio = :codMunicipio and " +
					" p.numAnoRef = :anoExercicio and " +
					" p.sglTipoAnalise = :sglTipoAnalise and " +
					" p.dataGeracaoCertidao is not null " +
					" order by p.dataSolicitacao desc ")
})
public class CertidaoPCA extends Certidao {
    
	private static final long serialVersionUID = 6429778478203113796L;
	
	public static final String BUSCAR_PETICAO_MAIS_RECENTE = "PeticaoCertidao.getUltimaPeticao";
	public static final String BUSCAR_POR_TIPO_ANALISE = "BUSCAR_POR_TIPO_ANALISE";

	public static final String SOLICITACAO_EM_ANALISE = "CertidaoPCA.SOLICITACAO_EM_ANALISE";
	
	@Column(name = "PCT_INV_EDUCACAO")
	private Double percentInvEducacao;

	@Column(name = "PCT_INV_SAUDE")
	private Double percentInvSaude;

	@Column(name = "PCT_INV_PESSOAL_LEGISLATIVO")
	private Double percentInvPessoalLegislativo;
	
	@Column(name = "PCT_INV_PESSOAL_EXECUTIVO")
	private Double percentInvPessoalExecutivo;
	
	@Column(name = "PCT_INV_PESSOAL")
	private Double percentInvPessoal;
	
	@Column(name = "PCT_INV_FUNDEB")
	private Double percentInvFundeb;
	
	@Column(name = "cod_analise")
	private Long codAnalise;
	
    @Column(name = "SGL_TIPO_ANALISE")
    private String sglTipoAnalise;
	
    @Column(name = "IND_INSIGNIFICANCIA")
	private Boolean indInsignificancia;
    
    @Column(name = "IND_RECONDUZIDO")
	private Boolean indReconduzido;
    
	@Transient
	private String nomeMunicipio;
	
	@Transient
	private IndiceParecerPrevio indiceParecerPrevio;
	
	@Transient
	private IndiceDelibInv indiceTransitoJulgado;
	

	public Double getPercentInvEducacao() {
		return percentInvEducacao;
	}

	public void setPercentInvEducacao(Double percentInvEducacao) {
		this.percentInvEducacao = percentInvEducacao;
	}

	public Long getCodAnalise() {
		return codAnalise;
	}

	public void setCodAnalise(Long codAnalise) {
		this.codAnalise = codAnalise;
	}

	public Double getPercentInvSaude() {
		return percentInvSaude;
	}

	public void setPercentInvSaude(Double percentInvSaude) {
		this.percentInvSaude = percentInvSaude;
	}

	public Double getPercentInvPessoalLegislativo() {
		return percentInvPessoalLegislativo;
	}

	public void setPercentInvPessoalLegislativo(Double percentInvPessoalLegislativo) {
		this.percentInvPessoalLegislativo = percentInvPessoalLegislativo;
	}

	public Double getPercentInvPessoalExecutivo() {
		return percentInvPessoalExecutivo;
	}

	public void setPercentInvPessoalExecutivo(Double percentInvPessoalExecutivo) {
		this.percentInvPessoalExecutivo = percentInvPessoalExecutivo;
	}

	public Double getPercentInvFundeb() {
		return percentInvFundeb;
	}

	public void setPercentInvFundeb(Double percentInvFundeb) {
		this.percentInvFundeb = percentInvFundeb;
	}

	public String getSglTipoAnalise() {
		return sglTipoAnalise;
	}

	public void setSglTipoAnalise(String sglTipoAnalise) {
		this.sglTipoAnalise = sglTipoAnalise;
	}

	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}

	public Double getPercentInvPessoal() {
		return percentInvPessoal;
	}

	public void setPercentInvPessoal(Double percentInvPessoal) {
		this.percentInvPessoal = percentInvPessoal;
	}

	public Boolean getIndInsignificancia() {
		return indInsignificancia;
	}

	public void setIndInsignificancia(Boolean indInsignificancia) {
		this.indInsignificancia = indInsignificancia;
	}

	public Boolean getIndReconduzido() {
		return indReconduzido;
	}

	public void setIndReconduzido(Boolean indReconduzido) {
		this.indReconduzido = indReconduzido;
	}

	public IndiceParecerPrevio getIndiceParecerPrevio() {
		return indiceParecerPrevio;
	}

	public void setIndiceParecerPrevio(IndiceParecerPrevio indiceParecerPrevio) {
		this.indiceParecerPrevio = indiceParecerPrevio;
	}

	public IndiceDelibInv getIndiceTransitoJulgado() {
		return indiceTransitoJulgado;
	}

	public void setIndiceTransitoJulgado(IndiceDelibInv indiceTransitoJulgado) {
		this.indiceTransitoJulgado = indiceTransitoJulgado;
	}

}