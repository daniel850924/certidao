package br.gov.mg.tce.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.mg.tcemg.model.IEntidade;


/**
 * The persistent class for the PROCESSO_JULGADO_ANALISE database table.
 * 
 */
@Entity
@Table(name="PROCESSO_JULGADO_ANALISE")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "ProcessoJulgadoAnalise.findByNumProcesso", query = "SELECT p FROM ProcessoJulgadoAnalise p WHERE p.codProcesso = :numProcesso"),
	@NamedQuery(name = "ProcessoJulgadoAnalise.getMapTodosProcessos", query = "SELECT p FROM ProcessoJulgadoAnalise p WHERE p.sglSituacaoProcesso != 'TJ'")
})
public class ProcessoJulgadoAnalise implements Serializable, IEntidade {

	private static final long serialVersionUID = -703922802199413409L;

	public static final String BUSCAR_PROCESSO_POR_NUMERO_PROCESSO = "ProcessoJulgadoAnalise.findByNumProcesso";
	public static final String MAPA_TODOS_PROCESSOS = "ProcessoJulgadoAnalise.getMapTodosProcessos";
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "SQ_PROCESSO_JULGADO_ANALISE", sequenceName = "SQ_PROCESSO_JULGADO_ANALISE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO_JULGADO_ANALISE")
	@Column(name="COD_PROCESSO_JULGADO_ANALISE")
	private long codProcessoJulgadoAnalise;

	@Column(name="COD_ANALISE")
	private Long codAnalise;

	@Column(name="SGL_SITUACAO_PROCESSO")
	private String sglSituacaoProcesso;

	@Column(name="COD_PROCESSO")
	private Long codProcesso;
	
	@Column(name="COD_DECISAO")
	private Long codDecisao;
	
	@Column(name="DSC_DECISAO")
	private String dscDecisao;
	
	public ProcessoJulgadoAnalise() {
	}

	public long getCodProcessoJulgadoAnalise() {
		return this.codProcessoJulgadoAnalise;
	}

	public void setCodProcessoJulgadoAnalise(long codProcessoJulgadoAnalise) {
		this.codProcessoJulgadoAnalise = codProcessoJulgadoAnalise;
	}

	public Long getCodAnalise() {
		return this.codAnalise;
	}

	public void setCodAnalise(Long codAnalise) {
		this.codAnalise = codAnalise;
	}

	public String getSglSituacaoProcesso() {
		return this.sglSituacaoProcesso;
	}

	public void setSglSituacaoProcesso(String sglSituacaoProcesso) {
		this.sglSituacaoProcesso = sglSituacaoProcesso;
	}

	@Override
	public Serializable getId() {
		return this.codProcessoJulgadoAnalise;
	}

	@Override
	public Serializable setId(Long id) {
		this.codProcessoJulgadoAnalise = id;
		return this.codProcessoJulgadoAnalise;
	}

	public Long getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(Long codProcesso) {
		this.codProcesso = codProcesso;
	}

	public Long getCodDecisao() {
		return codDecisao;
	}

	public void setCodDecisao(Long codDecisao) {
		this.codDecisao = codDecisao;
	}

	public String getDscDecisao() {
		return dscDecisao;
	}

	public void setDscDecisao(String dscDecisao) {
		this.dscDecisao = dscDecisao;
	}
	
}