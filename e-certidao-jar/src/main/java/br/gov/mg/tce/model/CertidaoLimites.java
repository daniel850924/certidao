package br.gov.mg.tce.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel.paula
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "CERTIDAO_LIMITES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = CertidaoLimites.PESQUISAR_EM_ANALISE, 
    		query = "SELECT c FROM CertidaoLimites c WHERE c.indSituacao = 'ANA'")    		
})
public class CertidaoLimites extends Certidao {

	public static final String PESQUISAR_EM_ANALISE = "CertidaoLimites.pesquisarSolicitacoesEmAnalise";
	
    @Column(name = "DSC_OPCAO_SEMESTRALIDADE")
    private String dscOpcaoSemestralidade;
    @Column(name = "PCT_DESPESA_EXECUTIVO")
    private BigDecimal pctDespesaExecutivo;
    @Column(name = "PCT_DESPESA_LEGISLATIVO")
    private BigDecimal pctDespesaLegislativo;
    @Column(name = "PCT_DESPESA_TOTAL")
    private BigDecimal pctDespesaTotal;
    @Column(name = "DAT_PUBLICACAO_EXECUTIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datPublicacaoExecutivo;
    @Column(name = "PCT_DIVIDA_CONS_EXECUTIVO")
    private BigDecimal pctDividaConsExecutivo;
    @Column(name = "VLR_DIVIDA_CONS_LRF")
    private BigDecimal vlrDividaConsLrf;
    @Column(name = "PCT_CONC_GARANT_EXECUTIVO")
    private BigDecimal pctConcGarantExecutivo;
    @Column(name = "PCT_OPER_CRED_EXECUTIVO")
    private BigDecimal pctOperCredExecutivo;
    @Column(name = "PCT_ARO_EXECUTIVO")
    private BigDecimal pctAroExecutivo;
    @Column(name = "DSC_IMP_COMP_NAO_ARRECADADOS")
    private String dscImpCompNaoArrecadados;
    @Column(name = "DSC_IMP_COMP_NAO_PREVISTO")
    private String dscImpCompNaoPrevisto;
    @Column(name = "PCT_OPER_CRED_REAL_EXEC")
    private BigDecimal pctOperCredRealExec;
    @Column(name = "DSC_RESULTADO_RPPS")
    private String dscResultadoRpps;
    
    @Column(name = "VLR_IPTU_PREVISTA")
    private BigDecimal vlrIPTUPrevista;
    @Column(name = "VLR_IPTU_REALIZADA")
    private BigDecimal vlrIPTURealizada;
    
    @Column(name = "VLR_ISSQN_PREVISTA")
    private BigDecimal vlrISSQNPrevista;
    @Column(name = "VLR_ISSQN_REALIZADA")
    private BigDecimal vlrISSQNRealizada;
    
    @Column(name = "VLR_ITBI_PREVISTA")
    private BigDecimal vlrITBIPrevista;
    @Column(name = "VLR_ITBI_REALIZADA")
    private BigDecimal vlrITBIRealizada;
    
    @Column(name = "VLR_IRRF_PREVISTA")
    private BigDecimal vlrIRRFPrevista;
    @Column(name = "VLR_IRRF_REALIZADA")
    private BigDecimal vlrIRRFRealizada;
    
    @Column(name = "DSC_SIT_PUB_RFG")
    private String sitPubRgf;
    @Column(name = "DSC_SIT_PUB_RREO")
    private String sitPubRreo;

    public CertidaoLimites() {
    }

    public String getDscOpcaoSemestralidade() {
        return dscOpcaoSemestralidade;
    }

    public void setDscOpcaoSemestralidade(String dscOpcaoSemestralidade) {
        this.dscOpcaoSemestralidade = dscOpcaoSemestralidade;
    }

    public Date getDatPublicacaoExecutivo() {
        return datPublicacaoExecutivo;
    }

    public void setDatPublicacaoExecutivo(Date datPublicacaoExecutivo) {
        this.datPublicacaoExecutivo = datPublicacaoExecutivo;
    }

    public BigDecimal getPctDividaConsExecutivo() {
        return pctDividaConsExecutivo;
    }

    public void setPctDividaConsExecutivo(BigDecimal pctDividaConsExecutivo) {
        this.pctDividaConsExecutivo = pctDividaConsExecutivo;
    }

    public String getDscImpCompNaoArrecadados() {
        return dscImpCompNaoArrecadados;
    }

    public void setDscImpCompNaoArrecadados(String dscImpCompNaoArrecadados) {
        this.dscImpCompNaoArrecadados = dscImpCompNaoArrecadados;
    }

    public String getDscImpCompNaoPrevisto() {
        return dscImpCompNaoPrevisto;
    }

    public void setDscImpCompNaoPrevisto(String dscImpCompNaoPrevisto) {
        this.dscImpCompNaoPrevisto = dscImpCompNaoPrevisto;
    }

    public String getDscResultadoRpps() {
        return dscResultadoRpps;
    }

    public void setDscResultadoRpps(String dscResultadoRpps) {
        this.dscResultadoRpps = dscResultadoRpps;
    }

    /**
     * @return the vlrDividaConsLrf
     */
    public BigDecimal getVlrDividaConsLrf() {
        return vlrDividaConsLrf;
    }

    /**
     * @param vlrDividaConsLrf the vlrDividaConsLrf to set
     */
    public void setVlrDividaConsLrf(BigDecimal vlrDividaConsLrf) {
        this.vlrDividaConsLrf = vlrDividaConsLrf;
    }

	public BigDecimal getVlrIPTUPrevista() {
		return vlrIPTUPrevista;
	}

	public void setVlrIPTUPrevista(BigDecimal vlrIPTUPrevista) {
		this.vlrIPTUPrevista = vlrIPTUPrevista;
	}

	public BigDecimal getVlrISSQNPrevista() {
		return vlrISSQNPrevista;
	}

	public void setVlrISSQNPrevista(BigDecimal vlrISSQNPrevista) {
		this.vlrISSQNPrevista = vlrISSQNPrevista;
	}

	public BigDecimal getVlrISSQNRealizada() {
		return vlrISSQNRealizada;
	}

	public void setVlrISSQNRealizada(BigDecimal vlrISSQNRealizada) {
		this.vlrISSQNRealizada = vlrISSQNRealizada;
	}

	public BigDecimal getVlrITBIPrevista() {
		return vlrITBIPrevista;
	}

	public void setVlrITBIPrevista(BigDecimal vlrITBIPrevista) {
		this.vlrITBIPrevista = vlrITBIPrevista;
	}

	public BigDecimal getVlrITBIRealizada() {
		return vlrITBIRealizada;
	}

	public void setVlrITBIRealizada(BigDecimal vlrITBIRealizada) {
		this.vlrITBIRealizada = vlrITBIRealizada;
	}

	public BigDecimal getVlrIRRFPrevista() {
		return vlrIRRFPrevista;
	}

	public void setVlrIRRFPrevista(BigDecimal vlrIRRFPrevista) {
		this.vlrIRRFPrevista = vlrIRRFPrevista;
	}

	public BigDecimal getVlrIRRFRealizada() {
		return vlrIRRFRealizada;
	}

	public void setVlrIRRFRealizada(BigDecimal vlrIRRFRealizada) {
		this.vlrIRRFRealizada = vlrIRRFRealizada;
	}

	public BigDecimal getVlrIPTURealizada() {
		return vlrIPTURealizada;
	}

	public void setVlrIPTURealizada(BigDecimal vlrIPTURealizada) {
		this.vlrIPTURealizada = vlrIPTURealizada;
	}

	public BigDecimal getPctDespesaExecutivo() {
		return pctDespesaExecutivo;
	}

	public void setPctDespesaExecutivo(BigDecimal pctDespesaExecutivo) {
		this.pctDespesaExecutivo = pctDespesaExecutivo;
	}

	public BigDecimal getPctDespesaLegislativo() {
		return pctDespesaLegislativo;
	}

	public void setPctDespesaLegislativo(BigDecimal pctDespesaLegislativo) {
		this.pctDespesaLegislativo = pctDespesaLegislativo;
	}

	public BigDecimal getPctDespesaTotal() {
		return pctDespesaTotal;
	}

	public void setPctDespesaTotal(BigDecimal pctDespesaTotal) {
		this.pctDespesaTotal = pctDespesaTotal;
	}

	public BigDecimal getPctConcGarantExecutivo() {
		return pctConcGarantExecutivo;
	}

	public void setPctConcGarantExecutivo(BigDecimal pctConcGarantExecutivo) {
		this.pctConcGarantExecutivo = pctConcGarantExecutivo;
	}

	public BigDecimal getPctOperCredExecutivo() {
		return pctOperCredExecutivo;
	}

	public void setPctOperCredExecutivo(BigDecimal pctOperCredExecutivo) {
		this.pctOperCredExecutivo = pctOperCredExecutivo;
	}

	public BigDecimal getPctAroExecutivo() {
		return pctAroExecutivo;
	}

	public void setPctAroExecutivo(BigDecimal pctAroExecutivo) {
		this.pctAroExecutivo = pctAroExecutivo;
	}

	public BigDecimal getPctOperCredRealExec() {
		return pctOperCredRealExec;
	}

	public void setPctOperCredRealExec(BigDecimal pctOperCredRealExec) {
		this.pctOperCredRealExec = pctOperCredRealExec;
	}

	public String getImpostosNaoArrecadado() {

		StringBuilder impNaoArrecadado = new StringBuilder();
		if(this.getVlrIPTURealizada().doubleValue() == 0D){
			impNaoArrecadado.append("Imposto sobre a Propriedade Predial e Territorial Urbana – IPTU");
		}
				
		if(this.getVlrISSQNRealizada().doubleValue() == 0D){
			appendVirgula(impNaoArrecadado);
			impNaoArrecadado.append("Imposto sobre Serviços de Qualquer Natureza – ISSQN");
		}
		
		if(this.getVlrITBIRealizada().doubleValue() == 0D){
			appendVirgula(impNaoArrecadado);
			impNaoArrecadado.append("Imposto sobre Transmissão de Bens Imóveis – ITBI");
		}
		
		if(this.getVlrIRRFRealizada().doubleValue() == 0D){
			appendVirgula(impNaoArrecadado);
			impNaoArrecadado.append("Imposto Retido na Fonte – IRRF");
		}
		return impNaoArrecadado.toString();
	}

	private void appendVirgula(StringBuilder string) {
		
		if(!string.toString().isEmpty()){
			string.append(", ");
		}
	}

	public String getImpostosNaoPrevisto() {

		StringBuilder impNaoPrevisto = new StringBuilder();
		if(this.getVlrIPTUPrevista().doubleValue() == 0D){
			impNaoPrevisto.append("Imposto sobre a Propriedade Predial e Territorial Urbana – IPTU");
		}
				
		if(this.getVlrISSQNPrevista().doubleValue() == 0D){
			appendVirgula(impNaoPrevisto);
			impNaoPrevisto.append("Imposto sobre Serviços de Qualquer Natureza – ISSQN");
		}
		
		if(this.getVlrITBIPrevista().doubleValue() == 0D){
			appendVirgula(impNaoPrevisto);
			impNaoPrevisto.append("Imposto sobre Transmissão de Bens Imóveis – ITBI");
		}
		
		if(this.getVlrIRRFPrevista().doubleValue() == 0D){
			appendVirgula(impNaoPrevisto);
			impNaoPrevisto.append("Imposto Retido na Fonte – IRRF");
		}
		return impNaoPrevisto.toString();
	}

	public String getSitPubRgf() {
		return sitPubRgf;
	}

	public void setSitPubRgf(String sitPubRgf) {
		this.sitPubRgf = sitPubRgf;
	}

	public String getSitPubRreo() {
		return sitPubRreo;
	}

	public void setSitPubRreo(String sitPubRreo) {
		this.sitPubRreo = sitPubRreo;
	}

}

