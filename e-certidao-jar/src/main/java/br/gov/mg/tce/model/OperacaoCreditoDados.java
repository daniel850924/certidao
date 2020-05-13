package br.gov.mg.tce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.gov.mg.tce.enumerator.IndSimNaoEnum;
import br.gov.mg.tcemg.model.IEntidade;

@Entity
@Table(name = "OPERACAO_CREDITO_DADOS")
public class OperacaoCreditoDados implements IEntidade{

	private static final long serialVersionUID = -8486959741590300382L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "SQ_OPERACAO_CREDITO_DADOS", sequenceName = "SQ_OPERACAO_CREDITO_DADOS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_OPERACAO_CREDITO_DADOS")
	@Column(name = "COD_OPERACAO_CREDITO_DADOS")
	private Long codOperacaoCreditoDados;
	
	@Column(name = "VLR_RCL_EXECUTIVO")
	private BigDecimal vlrRclExecutivo;
	
	@Column(name = "VLR_REC_OPERACAO_CREDITO")
	private BigDecimal vlrRecOperacaoCredito;
	
	@Column(name = "VLR_DESPESA_CAPITAL_DOT_INI")
	private BigDecimal vlrDespesaCapitalDotIni;
	
	@Column(name = "VLR_DESPESA_TOT_PESSOAL_EXEC")
	private BigDecimal vlrDespesaTotPessoalExec;
	
	@Column(name = "PCT_DESPESA_TOT_PESSOAL_EXEC")
	private BigDecimal pctDespesaTotPessoalExec;
	
	@Column(name = "VLR_DESPESA_TOT_PESSOAL_LEG")
	private BigDecimal vlrDespesaTotPessoalLeg;
	
	@Column(name = "PCT_DESPESA_TOT_PESSOAL_LEG")
	private BigDecimal pctDespesaTotPessoalLeg;
	
	@Column(name = "DAT_PUBLICACAO_RREO2")
	private Date dtPublicacaoRREO2;
	@Column(name = "DAT_PUBLICACAO_RREO4")
	private Date dtPublicacaoRREO4;
	@Column(name = "DAT_PUBLICACAO_RREO6")
	private Date dtPublicacaoRREO6;
	@Column(name = "DAT_PUBLICACAO_RREO8")
	private Date dtPublicacaoRREO8;
	@Column(name = "DAT_PUBLICACAO_RREO10")
	private Date dtPublicacaoRREO10;
	@Column(name = "DAT_PUBLICACAO_RREO12")
	private Date dtPublicacaoRREO12;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RREO2_TEMP")
	private IndSimNaoEnum indPublicacaoRREO2Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RREO4_TEMP")
	private IndSimNaoEnum indPublicacaoRREO4Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RREO6_TEMP")
	private IndSimNaoEnum indPublicacaoRREO6Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RREO8_TEMP")
	private IndSimNaoEnum indPublicacaoRREO8Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RREO10_TEMP")
	private IndSimNaoEnum indPublicacaoRREO10Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RREO12_TEMP")
	private IndSimNaoEnum indPublicacaoRREO12Temp = IndSimNaoEnum.N;
	
	@Column(name = "DAT_PUBLICACAO_RGF4")
	private Date dtPublicacaoRGF4;
	@Column(name = "DAT_PUBLICACAO_RGF6")
	private Date dtPublicacaoRGF6;
	@Column(name = "DAT_PUBLICACAO_RGF8")
	private Date dtPublicacaoRGF8;
	@Column(name = "DAT_PUBLICACAO_RGF12")
	private Date dtPublicacaoRGF12;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RGF4_TEMP")
	private IndSimNaoEnum indPublicacaoRGF4Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RGF6_TEMP")
	private IndSimNaoEnum indPublicacaoRGF6Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RGF8_TEMP")
	private IndSimNaoEnum indPublicacaoRGF8Temp = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_PUBLICACAO_RGF12_TEMP")
	private IndSimNaoEnum indPublicacaoRGF12Temp = IndSimNaoEnum.N;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_OPCAO_SEMES_4")
	private IndSimNaoEnum indOpcao4 = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_OPCAO_SEMES_6")
	private IndSimNaoEnum indOpcao6 = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_OPCAO_SEMES_8")
	private IndSimNaoEnum indOpcao8 = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_OPCAO_SEMES_12")
	private IndSimNaoEnum indOpcao12 = IndSimNaoEnum.N;
	
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_DAT_BASE_4")
	private IndSimNaoEnum datBase4 = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_DAT_BASE_6")
	private IndSimNaoEnum datBase6 = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_DAT_BASE_8")
	private IndSimNaoEnum datBase8 = IndSimNaoEnum.N;
	@Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
	@Column(name = "IND_DAT_BASE_12")
	private IndSimNaoEnum datBase12 = IndSimNaoEnum.N;
	
	@Column(name = "IND_SIT_PUBLICACAO")
	private String sitPublicacao;
	
	@Column(name = "NUM_EXERCICIO")
	private Integer numExercicio;
	
	@Column(name = "COD_CERTIDAO", insertable = false, updatable = false)
	private Long codCertidao;
	
	@Column(name = "IND_CONTRATACAO_OP")
	private Boolean indContratacaoOp;
	
	@Column(name = "IND_REALIZACAO_OP")
	private Boolean indRealizacaoOp;
	
    @Type(type = "br.gov.mg.tce.base.BaseEnumType", parameters = {@Parameter(name = "BaseEnum", value = "br.gov.mg.tce.enumerator.IndSimNaoEnum")} )
    @Column(name = "IND_EXERC_COMPLETO")
    private IndSimNaoEnum indExercCompleto = IndSimNaoEnum.S;
	
	@Column(name = "DSC_MOT_DADO_IMCOMP")
	private String motivoDadoIncompleto;
    
	@ManyToOne
	@JoinColumn(name = "COD_CERTIDAO")
	private CertidaoOperacaoCredito operacaoCredito;
	
	@Column(name = "NUM_MES_BASE")
	private Integer numMesBase;

	public Long getCodOperacaoCreditoDados() {
		return codOperacaoCreditoDados;
	}

	public void setCodOperacaoCreditoDados(Long codOperacaoCreditoDados) {
		this.codOperacaoCreditoDados = codOperacaoCreditoDados;
	}

	public BigDecimal getVlrRclExecutivo() {
		return vlrRclExecutivo;
	}

	public void setVlrRclExecutivo(BigDecimal vlrRclExecutivo) {
		this.vlrRclExecutivo = vlrRclExecutivo;
	}

	public BigDecimal getVlrRecOperacaoCredito() {
		return vlrRecOperacaoCredito;
	}

	public void setVlrRecOperacaoCredito(BigDecimal vlrRecOperacaoCredito) {
		this.vlrRecOperacaoCredito = vlrRecOperacaoCredito;
	}

	public BigDecimal getVlrDespesaCapitalDotIni() {
		return vlrDespesaCapitalDotIni;
	}

	public void setVlrDespesaCapitalDotIni(BigDecimal vlrDespesaCapitalDotIni) {
		this.vlrDespesaCapitalDotIni = vlrDespesaCapitalDotIni;
	}

	public BigDecimal getVlrDespesaTotPessoalExec() {
		return vlrDespesaTotPessoalExec;
	}

	public void setVlrDespesaTotPessoalExec(BigDecimal vlrDespesaTotPessoalExec) {
		this.vlrDespesaTotPessoalExec = vlrDespesaTotPessoalExec;
	}

	public BigDecimal getPctDespesaTotPessoalExec() {
		return pctDespesaTotPessoalExec;
	}

	public void setPctDespesaTotPessoalExec(BigDecimal pctDespesaTotPessoalExec) {
		this.pctDespesaTotPessoalExec = pctDespesaTotPessoalExec;
	}

	public BigDecimal getVlrDespesaTotPessoalLeg() {
		return vlrDespesaTotPessoalLeg;
	}

	public void setVlrDespesaTotPessoalLeg(BigDecimal vlrDespesaTotPessoalLeg) {
		this.vlrDespesaTotPessoalLeg = vlrDespesaTotPessoalLeg;
	}

	public BigDecimal getPctDespesaTotPessoalLeg() {
		return pctDespesaTotPessoalLeg;
	}

	public void setPctDespesaTotPessoalLeg(BigDecimal pctDespesaTotPessoalLeg) {
		this.pctDespesaTotPessoalLeg = pctDespesaTotPessoalLeg;
	}

	public String getSitPublicacao() {
		return sitPublicacao;
	}

	public void setSitPublicacao(String sitPublicacao) {
		this.sitPublicacao = sitPublicacao;
		
		if("tempestivo".equalsIgnoreCase(this.sitPublicacao)){
			this.setIndPublicacaoRREO12Temp(IndSimNaoEnum.S);
			this.setIndPublicacaoRGF12Temp(IndSimNaoEnum.S);
		}else{
			this.setIndPublicacaoRREO12Temp(IndSimNaoEnum.N);
			this.setIndPublicacaoRGF12Temp(IndSimNaoEnum.N);
		}
		
	}

	public Long getCodCertidao() {
		return codCertidao;
	}

	public void setCodCertidao(Long codCertidao) {
		this.codCertidao = codCertidao;
	}

	public CertidaoOperacaoCredito getOperacaoCredito() {
		return operacaoCredito;
	}

	public void setOperacaoCredito(CertidaoOperacaoCredito operacaoCredito) {
		this.operacaoCredito = operacaoCredito;
	}

	public OperacaoCreditoDados() {
		super();
	}

	public Boolean getIndContratacaoOp() {
		return indContratacaoOp;
	}

	public void setIndContratacaoOp(Boolean indContratacaoOp) {
		this.indContratacaoOp = indContratacaoOp;
	}

	public Boolean getIndRealizacaoOp() {
		return indRealizacaoOp;
	}

	public void setIndRealizacaoOp(Boolean indRealizacaoOp) {
		this.indRealizacaoOp = indRealizacaoOp;
	}

	@Override
	public Long getId() {
		return codOperacaoCreditoDados;
	}

	@Override
	public Serializable setId(Long codOperacaoCreditoDados) {
		this.codOperacaoCreditoDados = codOperacaoCreditoDados;
		return this.codOperacaoCreditoDados;
	}

	public IndSimNaoEnum getIndExercCompleto() {
		return indExercCompleto;
	}

	public void setIndExercCompleto(IndSimNaoEnum indExercCompleto) {
		this.indExercCompleto = indExercCompleto;
	}

	public String getMotivoDadoIncompleto() {
		return motivoDadoIncompleto;
	}

	public void setMotivoDadoIncompleto(String motivoDadoIncompleto) {
		this.motivoDadoIncompleto = motivoDadoIncompleto;
	}

	public Date getDtPublicacaoRREO2() {
		return dtPublicacaoRREO2;
	}

	public void setDtPublicacaoRREO2(Date dtPublicacaoRREO2) {
		this.dtPublicacaoRREO2 = dtPublicacaoRREO2;
	}

	public Date getDtPublicacaoRREO4() {
		return dtPublicacaoRREO4;
	}

	public void setDtPublicacaoRREO4(Date dtPublicacaoRREO4) {
		this.dtPublicacaoRREO4 = dtPublicacaoRREO4;
	}

	public Date getDtPublicacaoRREO6() {
		return dtPublicacaoRREO6;
	}

	public void setDtPublicacaoRREO6(Date dtPublicacaoRREO6) {
		this.dtPublicacaoRREO6 = dtPublicacaoRREO6;
	}

	public Date getDtPublicacaoRREO8() {
		return dtPublicacaoRREO8;
	}

	public void setDtPublicacaoRREO8(Date dtPublicacaoRREO8) {
		this.dtPublicacaoRREO8 = dtPublicacaoRREO8;
	}

	public Date getDtPublicacaoRREO12() {
		return dtPublicacaoRREO12;
	}

	public void setDtPublicacaoRREO12(Date dtPublicacaoRREO12) {
		this.dtPublicacaoRREO12 = dtPublicacaoRREO12;
	}

	public Integer getNumExercicio() {
		return numExercicio;
	}

	public void setNumExercicio(Integer numExercicio) {
		this.numExercicio = numExercicio;
	}

	public IndSimNaoEnum getDatBase4() {
		return datBase4;
	}

	public void setDatBase4(IndSimNaoEnum datBase4) {
		this.datBase4 = datBase4;
	}

	public IndSimNaoEnum getDatBase6() {
		return datBase6;
	}

	public void setDatBase6(IndSimNaoEnum datBase6) {
		this.datBase6 = datBase6;
	}

	public IndSimNaoEnum getDatBase8() {
		return datBase8;
	}

	public void setDatBase8(IndSimNaoEnum datBase8) {
		this.datBase8 = datBase8;
	}

	public IndSimNaoEnum getDatBase12() {
		return datBase12;
	}

	public void setDatBase12(IndSimNaoEnum datBase12) {
		this.datBase12 = datBase12;
	}

	public List<Integer> getMesesPublicacao() {
	
		List<Integer> mesesPublicacao = new ArrayList<Integer>();
		
		if(IndSimNaoEnum.S.equals(datBase4)){
			mesesPublicacao.add(4);
		}
		if(IndSimNaoEnum.S.equals(datBase6)){
			mesesPublicacao.add(6);
		}
		if(IndSimNaoEnum.S.equals(datBase8)){
			mesesPublicacao.add(8);
		}
		if(IndSimNaoEnum.S.equals(datBase12)){
			mesesPublicacao.add(12);
		}
		
		return mesesPublicacao;
	}

	public Date getDtPublicacaoRGF4() {
		return dtPublicacaoRGF4;
	}

	public void setDtPublicacaoRGF4(Date dtPublicacaoRGF4) {
		this.dtPublicacaoRGF4 = dtPublicacaoRGF4;
	}

	public Date getDtPublicacaoRGF6() {
		return dtPublicacaoRGF6;
	}

	public void setDtPublicacaoRGF6(Date dtPublicacaoRGF6) {
		this.dtPublicacaoRGF6 = dtPublicacaoRGF6;
	}

	public Date getDtPublicacaoRGF8() {
		return dtPublicacaoRGF8;
	}

	public void setDtPublicacaoRGF8(Date dtPublicacaoRGF8) {
		this.dtPublicacaoRGF8 = dtPublicacaoRGF8;
	}

	public Date getDtPublicacaoRGF12() {
		return dtPublicacaoRGF12;
	}

	public void setDtPublicacaoRGF12(Date dtPublicacaoRGF12) {
		this.dtPublicacaoRGF12 = dtPublicacaoRGF12;
	}

	public IndSimNaoEnum getIndOpcao4() {
		return indOpcao4;
	}

	public void setIndOpcao4(IndSimNaoEnum indOpcao4) {
		this.indOpcao4 = indOpcao4;
	}

	public IndSimNaoEnum getIndOpcao6() {
		return indOpcao6;
	}

	public void setIndOpcao6(IndSimNaoEnum indOpcao6) {
		this.indOpcao6 = indOpcao6;
	}

	public IndSimNaoEnum getIndOpcao8() {
		return indOpcao8;
	}

	public void setIndOpcao8(IndSimNaoEnum indOpcao8) {
		this.indOpcao8 = indOpcao8;
	}

	public IndSimNaoEnum getIndOpcao12() {
		return indOpcao12;
	}

	public void setIndOpcao12(IndSimNaoEnum indOpcao12) {
		this.indOpcao12 = indOpcao12;
	}

	public IndSimNaoEnum getIndPublicacaoRREO2Temp() {
		return indPublicacaoRREO2Temp;
	}

	public void setIndPublicacaoRREO2Temp(IndSimNaoEnum indPublicacaoRREO2Temp) {
		this.indPublicacaoRREO2Temp = indPublicacaoRREO2Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRREO4Temp() {
		return indPublicacaoRREO4Temp;
	}

	public void setIndPublicacaoRREO4Temp(IndSimNaoEnum indPublicacaoRREO4Temp) {
		this.indPublicacaoRREO4Temp = indPublicacaoRREO4Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRREO6Temp() {
		return indPublicacaoRREO6Temp;
	}

	public void setIndPublicacaoRREO6Temp(IndSimNaoEnum indPublicacaoRREO6Temp) {
		this.indPublicacaoRREO6Temp = indPublicacaoRREO6Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRREO8Temp() {
		return indPublicacaoRREO8Temp;
	}

	public void setIndPublicacaoRREO8Temp(IndSimNaoEnum indPublicacaoRREO8Temp) {
		this.indPublicacaoRREO8Temp = indPublicacaoRREO8Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRREO12Temp() {
		return indPublicacaoRREO12Temp;
	}

	public void setIndPublicacaoRREO12Temp(IndSimNaoEnum indPublicacaoRREO12Temp) {
		this.indPublicacaoRREO12Temp = indPublicacaoRREO12Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRGF4Temp() {
		return indPublicacaoRGF4Temp;
	}

	public void setIndPublicacaoRGF4Temp(IndSimNaoEnum indPublicacaoRGF4Temp) {
		this.indPublicacaoRGF4Temp = indPublicacaoRGF4Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRGF6Temp() {
		return indPublicacaoRGF6Temp;
	}

	public void setIndPublicacaoRGF6Temp(IndSimNaoEnum indPublicacaoRGF6Temp) {
		this.indPublicacaoRGF6Temp = indPublicacaoRGF6Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRGF8Temp() {
		return indPublicacaoRGF8Temp;
	}

	public void setIndPublicacaoRGF8Temp(IndSimNaoEnum indPublicacaoRGF8Temp) {
		this.indPublicacaoRGF8Temp = indPublicacaoRGF8Temp;
	}

	public IndSimNaoEnum getIndPublicacaoRGF12Temp() {
		return indPublicacaoRGF12Temp;
	}

	public void setIndPublicacaoRGF12Temp(IndSimNaoEnum indPublicacaoRGF12Temp) {
		this.indPublicacaoRGF12Temp = indPublicacaoRGF12Temp;
	}

	public Integer getNumMesBase() {
		return numMesBase;
	}

	public void setNumMesBase(Integer numMesBase) {
		this.numMesBase = numMesBase;
	}

	public Date getDtPublicacaoRREO10() {
		return dtPublicacaoRREO10;
	}

	public void setDtPublicacaoRREO10(Date dtPublicacaoRREO10) {
		this.dtPublicacaoRREO10 = dtPublicacaoRREO10;
	}

	public IndSimNaoEnum getIndPublicacaoRREO10Temp() {
		return indPublicacaoRREO10Temp;
	}

	public void setIndPublicacaoRREO10Temp(IndSimNaoEnum indPublicacaoRREO10Temp) {
		this.indPublicacaoRREO10Temp = indPublicacaoRREO10Temp;
	}

}
