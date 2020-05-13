package br.gov.mg.tce.certidao.datamodel;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import br.gov.mg.tce.certidao.util.DateUtil;
import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tce.model.VwPeticaoEletronica;

/**
 * DTO para apresentar na tela de Consultar Certidao. Este DTO contempla tanto
 * as certidoes recuperadas pela view {@link VwPeticaoEletronica} quanto para as
 * certidos geradas automaticamente pelo SGAP {@link CertidaoPCA}.
 * 
 */
public class ConsultarSolicitacaoDTO implements Comparable<ConsultarSolicitacaoDTO>{
	
	private VwPeticaoEletronica viewPeticaoEletronica;
	private Certidao peticaoCertidao;
	private String protocoloEditado;
	private Integer numAnoRef;
	private Date datSolicitacao;
	private Date datEmissao;
	private String dscTipoDocPeticao;
	private String dscTipoFinalidade;
	private String dscSituacao;
	private String dscTipoAnalise;
	private String dscMunicipio;
	private Long codMunicipio;
	private Date datVisualizacaoCertidao;
	
	public ConsultarSolicitacaoDTO() {
		super();
	}

	/**
	 * Construtor para gerar DTO a partir da view {@link VwPeticaoEletronica}
	 * 
	 * @param viewPeticaoEletronica
	 */
	public ConsultarSolicitacaoDTO(VwPeticaoEletronica viewPeticaoEletronica) {
		super();
		this.viewPeticaoEletronica = viewPeticaoEletronica;
		this.protocoloEditado = viewPeticaoEletronica.getProtocoloEditado();
		this.numAnoRef = viewPeticaoEletronica.getNumAnoRef();
		this.datSolicitacao = viewPeticaoEletronica.getDatSolicitacao();
		this.dscTipoDocPeticao = viewPeticaoEletronica.getDscTipoDocPeticao();
		this.dscTipoFinalidade = viewPeticaoEletronica.getDscTipoFinalidade();
		this.dscSituacao = viewPeticaoEletronica.getDscSituacao();
		this.datEmissao = viewPeticaoEletronica.getDatSituacao();
	}

	/**
	 * Construtor para gerar DTO a partir da {@link CertidaoPCA}
	 * 
	 * @param peticaoCertidao
	 */
	public ConsultarSolicitacaoDTO(Certidao peticaoCertidao) {
		super();
		this.peticaoCertidao = peticaoCertidao;
		this.protocoloEditado = formataProtocolo(peticaoCertidao.getNumProtocolo().toString());
		this.numAnoRef = peticaoCertidao.getNumAnoRef();
		this.datSolicitacao = peticaoCertidao.getDataSolicitacao();
		if (peticaoCertidao.getIndTipoCertidao() != null) {
			this.dscTipoDocPeticao = peticaoCertidao.getIndTipoCertidao().getLabel();
		}
		if (peticaoCertidao.getIndFinalidade() != null) {
			this.dscTipoFinalidade = peticaoCertidao.getIndFinalidade().getLabel();
		}
		if (peticaoCertidao.getIndSituacao() != null) {
			this.dscSituacao = peticaoCertidao.getIndSituacao().getLabel();
		}
		if (peticaoCertidao.getNomeMunicipio() != null) {
			this.dscMunicipio = peticaoCertidao.getNomeMunicipio();
		}
		this.codMunicipio = peticaoCertidao.getCodMunicipio();
		
		this.datEmissao = peticaoCertidao.getDataGeracaoCertidao();
	}

	private String formataProtocolo(String numProtocolo) {
		StringBuilder builder = new StringBuilder();
		builder.append(numProtocolo.substring(0, 2));
		builder.append(".");
		builder.append(numProtocolo.substring(2, 6));
		builder.append(".");
		builder.append(numProtocolo.substring(6, 10));
		builder.append(".");
		builder.append(numProtocolo.substring(10));
		return builder.toString();
	}

	public VwPeticaoEletronica getViewPeticaoEletronica() {
		return viewPeticaoEletronica;
	}

	public void setViewPeticaoEletronica(VwPeticaoEletronica viewPeticaoEletronica) {
		this.viewPeticaoEletronica = viewPeticaoEletronica;
	}

	public Certidao getPeticaoCertidao() {
		return peticaoCertidao;
	}

	public void setPeticaoCertidao(Certidao peticaoCertidao) {
		this.peticaoCertidao = peticaoCertidao;
	}

	public String getProtocoloEditado() {
		return protocoloEditado;
	}

	public void setProtocoloEditado(String protocoloEditado) {
		this.protocoloEditado = protocoloEditado;
	}

	public Integer getNumAnoRef() {
		return numAnoRef;
	}

	public void setNumAnoRef(Integer numAnoRef) {
		this.numAnoRef = numAnoRef;
	}

	public Date getDatSolicitacao() {
		return datSolicitacao;
	}

	public void setDatSolicitacao(Date datSolicitacao) {
		this.datSolicitacao = datSolicitacao;
	}

	public String getDscTipoDocPeticao() {
		return dscTipoDocPeticao;
	}

	public void setDscTipoDocPeticao(String dscTipoDocPeticao) {
		this.dscTipoDocPeticao = dscTipoDocPeticao;
	}

	public String getDscTipoFinalidade() {
		return dscTipoFinalidade;
	}

	public void setDscTipoFinalidade(String dscTipoFinalidade) {
		this.dscTipoFinalidade = dscTipoFinalidade;
	}

	public String getDscSituacao() {
		return dscSituacao;
	}

	public void setDscSituacao(String dscSituacao) {
		this.dscSituacao = dscSituacao;
	}
	
	public String getDscTipoAnalise() {
		return dscTipoAnalise;
	}

	public void setDscTipoAnalise(String dscTipoAnalise) {
		this.dscTipoAnalise = dscTipoAnalise;
	}

	public String getDscMunicipio() {
		return dscMunicipio;
	}

	public void setDscMunicipio(String dscMunicipio) {
		this.dscMunicipio = dscMunicipio;
	}

	public Long getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Long codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
	
	public Date getDatVisualizacaoCertidao() {
		return datVisualizacaoCertidao;
	}

	public void setDatVisualizacaoCertidao(Date datVisualizacaoCertidao) {
		this.datVisualizacaoCertidao = datVisualizacaoCertidao;
	}

	@Override
	public int compareTo(ConsultarSolicitacaoDTO other) {
		return Integer.valueOf(DateUtil.diferencaEmDias(new DateUtil(this.getDatSolicitacao()), new DateUtil(other.getDatSolicitacao())));
	}

	public Date getDatEmissao() {
		return datEmissao;
	}

	public void setDatEmissao(Date datEmissao) {
		this.datEmissao = datEmissao;
	}

}
