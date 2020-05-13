package br.gov.mg.tce.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.gov.mg.tce.enumerator.IndSimNaoEnum;

@Entity
@Table(name = "CERTIDAO_OPERACAO_CREDITO")
@PrimaryKeyJoinColumn(name="COD_CERTIDAO")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name=CertidaoOperacaoCredito.SOLICITACAO_EM_ANALISE,
			query="SELECT c FROM CertidaoOperacaoCredito c WHERE c.indSituacao = :indSituacao")
	
})
public class CertidaoOperacaoCredito extends Certidao {

	private static final long serialVersionUID = -5475195172850309983L;
	
	public static final String SOLICITACAO_EM_ANALISE = "CertidaoOperacaoCredito.SOLICITACAO_EM_ANALISE";

	@Column(name = "NUM_ULT_EXEC_ANALISADO")
	private Integer numUltExercAna;
	
	@Column(name = "DSC_DECISAO")
	private String dscDecisao;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
    @Column(name = "IND_CONTRATACAO_OP_2014")
    private IndSimNaoEnum indContratacaoOP2014;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
    @Column(name = "IND_REALIZACAO_OP_2014")
    private IndSimNaoEnum indRealizacaoOP2014;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
    @Column(name = "IND_CONTRATACAO_OP_2015")
    private IndSimNaoEnum indContratacaoOP2015;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
    @Column(name = "IND_REALIZACAO_OP_2015")
    private IndSimNaoEnum indRealizacaoOP2015;
	
	@OneToMany(mappedBy = "operacaoCredito", cascade = CascadeType.ALL)
	private List<OperacaoCreditoDados> dadosOperacaoCredito;
	
	@Transient
	private Map<Integer, OperacaoCreditoDados> mapOperacaoCreditoDados = null;
	@Transient
	private Integer exercicioAndamento;
	
	public CertidaoOperacaoCredito() {
		super();
	}
	
	public Map<Integer, OperacaoCreditoDados> getMapOperacaoCreditoDados(){
		
		if(mapOperacaoCreditoDados == null){
			mapOperacaoCreditoDados = new HashMap<Integer, OperacaoCreditoDados>();
			for (OperacaoCreditoDados operacaoCreditoDados : dadosOperacaoCredito) {
				mapOperacaoCreditoDados.put(operacaoCreditoDados.getNumExercicio(), operacaoCreditoDados);
			}
		}
		
		return mapOperacaoCreditoDados;
	}


	public List<OperacaoCreditoDados> getDadosOperacaoCredito() {
		return dadosOperacaoCredito;
	}


	public void setDadosOperacaoCredito(
			List<OperacaoCreditoDados> dadosOperacaoCredito) {
		this.dadosOperacaoCredito = dadosOperacaoCredito;
	}

	public Integer getNumUltExercAna() {
		return numUltExercAna;
	}

	public void setNumUltExercAna(Integer numUltExercAna) {
		this.numUltExercAna = numUltExercAna;
	}


	public String getDscDecisao() {
		return dscDecisao;
	}


	public void setDscDecisao(String dscDecisao) {
		this.dscDecisao = dscDecisao;
	}

	public void setMapOperacaoCreditoDados(
			Map<Integer, OperacaoCreditoDados> mapOperacaoCreditoDados) {
		this.mapOperacaoCreditoDados = mapOperacaoCreditoDados;
	}

	public IndSimNaoEnum getIndContratacaoOP2014() {
		return indContratacaoOP2014;
	}

	public void setIndContratacaoOP2014(IndSimNaoEnum indContratacaoOP2014) {
		this.indContratacaoOP2014 = indContratacaoOP2014;
	}

	public IndSimNaoEnum getIndRealizacaoOP2014() {
		return indRealizacaoOP2014;
	}

	public void setIndRealizacaoOP2014(IndSimNaoEnum indRealizacaoOP2014) {
		this.indRealizacaoOP2014 = indRealizacaoOP2014;
	}

	public IndSimNaoEnum getIndContratacaoOP2015() {
		return indContratacaoOP2015;
	}

	public void setIndContratacaoOP2015(IndSimNaoEnum indContratacaoOP2015) {
		this.indContratacaoOP2015 = indContratacaoOP2015;
	}

	public IndSimNaoEnum getIndRealizacaoOP2015() {
		return indRealizacaoOP2015;
	}

	public void setIndRealizacaoOP2015(IndSimNaoEnum indRealizacaoOP2015) {
		this.indRealizacaoOP2015 = indRealizacaoOP2015;
	}

	public CertidaoOperacaoCredito(IndSimNaoEnum indContratacaoOP2014, IndSimNaoEnum indRealizacaoOP2014, IndSimNaoEnum indContratacaoOP2015,
			IndSimNaoEnum indRealizacaoOP2015) {
		super();
		this.indContratacaoOP2014 = indContratacaoOP2014;
		this.indRealizacaoOP2014 = indRealizacaoOP2014;
		this.indContratacaoOP2015 = indContratacaoOP2015;
		this.indRealizacaoOP2015 = indRealizacaoOP2015;
	}

	public Integer getExercicioAndamento() {
		return exercicioAndamento;
	}

	public void setExercicioAndamento(Integer exercicioAndamento) {
		this.exercicioAndamento = exercicioAndamento;
	}


}
