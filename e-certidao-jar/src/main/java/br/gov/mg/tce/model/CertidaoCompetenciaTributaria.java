package br.gov.mg.tce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CERTIDAO_COMP_TRIB")
@PrimaryKeyJoinColumn(name="COD_CERTIDAO")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name=CertidaoCompetenciaTributaria.SOLICITACAO_EM_ANALISE,
			query="SELECT c FROM CertidaoCompetenciaTributaria c WHERE c.indSituacao = :indSituacao")
	
})
public class CertidaoCompetenciaTributaria extends Certidao {

	private static final long serialVersionUID = -8550382886515144438L;
	public static final String SOLICITACAO_EM_ANALISE = "CertidaoCompetenciaTributaria.SOLICITACAO_EM_ANALISE";
	
	@Column(name = "IND_PREVISAO_IPTU")
	private boolean previsaoIPTU;
	
	@Column(name = "IND_PREVISAO_ITBI")
	private boolean previsaoITBI;
	
	@Column(name = "IND_PREVISAO_IRRF")
	private boolean previsaoIRRF;
	
	@Column(name = "IND_PREVISAO_IRRF_OR")
	private boolean previsaoIRRF_OR;
	
	@Column(name = "IND_PREVISAO_IRRF_SAL")
	private boolean previsaoIRRF_SAL;
	
	@Column(name = "IND_PREVISAO_ISSQN")
	private boolean previsaoISSQN;
	
	@Column(name = "IND_ARRECADACAO_IPTU")
	private boolean arrecadacaoIPTU;
	
	@Column(name = "IND_ARRECADACAO_ITBI")
	private boolean arrecadacaoITBI;
	
	@Column(name = "IND_ARRECADACAO_IRRF")
	private boolean arrecadacaoIRRF;
	
	@Column(name = "IND_ARRECADACAO_IRRF_OR")
	private boolean arrecadacaoIRRF_OR;
	
	@Column(name = "IND_ARRECADACAO_IRRF_SAL")
	private boolean arrecadacaoIRRF_SAL;
	
	@Column(name = "IND_ARRECADACAO_ISSQN")
	private boolean arrecadacaoISSQN;
	
    @Column(name = "DSC_IMP_COMP_NAO_ARRECADADOS")
    private String dscImpCompNaoArrecadados;
    
    @Column(name = "DSC_IMP_COMP_NAO_PREVISTO")
    private String dscImpCompNaoPrevisto;
    
    @Transient
    private boolean isExercAndamento = false;
    @Transient
    private Integer numMesAndamento;
    
    public void reinicializarPrevisaoArrecadacao(){
    	
    	this.previsaoIPTU = false;
		this.previsaoITBI = false;
		this.previsaoIRRF = false;
		this.previsaoIRRF_OR = false;
		this.previsaoIRRF_SAL = false;
		this.previsaoISSQN = false;
		this.arrecadacaoIPTU = false;
		this.arrecadacaoITBI = false;
		this.arrecadacaoIRRF = false;
		this.arrecadacaoIRRF_OR = false;
		this.arrecadacaoIRRF_SAL = false;
		this.arrecadacaoISSQN = false;
		this.dscImpCompNaoArrecadados = "";
		this.dscImpCompNaoPrevisto = "";
    }
    
    public void inicializarPrevisaoArrecadacao(){
    	
    	this.previsaoIPTU = true;
		this.previsaoITBI = true;
		this.previsaoIRRF = true;
		this.previsaoIRRF_OR = true;
		this.previsaoIRRF_SAL = true;
		this.previsaoISSQN = true;
		this.arrecadacaoIPTU = true;
		this.arrecadacaoITBI = true;
		this.arrecadacaoIRRF = true;
		this.arrecadacaoIRRF_OR = true;
		this.arrecadacaoIRRF_SAL = true;
		this.arrecadacaoISSQN = true;
		this.dscImpCompNaoArrecadados = "";
		this.dscImpCompNaoPrevisto = "";
    }
	
	public String getImpostosNaoArrecadado() {

		boolean arrecadouTodos = true;
		StringBuilder impNaoArrecadado = new StringBuilder();
		if(!this.isArrecadacaoIPTU()){
			impNaoArrecadado.append("Imposto sobre a Propriedade Predial e Territorial Urbana – IPTU");
			arrecadouTodos = false;
		}
				
		if(!this.isArrecadacaoISSQN()){
			appendVirgula(impNaoArrecadado);
			impNaoArrecadado.append("Imposto sobre Serviços de Qualquer Natureza – ISSQN");
			arrecadouTodos = false;
		}
		
		if(!this.isArrecadacaoITBI()){
			appendVirgula(impNaoArrecadado);
			impNaoArrecadado.append("Imposto sobre Transmissão de Bens Imóveis – ITBI");
			arrecadouTodos = false;
		}
		
		if(super.getNumAnoRef() <= 2017){
			if(!this.isArrecadacaoIRRF()){
				appendVirgula(impNaoArrecadado);
				arrecadouTodos = false;
				impNaoArrecadado.append("Imposto Retido na Fonte – IRRF");
			}
		}else{
			
			if(!this.isArrecadacaoIRRF_OR()){
				appendVirgula(impNaoArrecadado);
				arrecadouTodos = false;
				impNaoArrecadado.append("Imposto Retido na Fonte – IRRF Outros Rendimentos");
			}
			if(!this.isArrecadacaoIRRF_SAL()){
				appendVirgula(impNaoArrecadado);
				arrecadouTodos = false;
				impNaoArrecadado.append("IRRF Salário");
			}
		}
		
		
		if(arrecadouTodos){
			impNaoArrecadado.append("OK");
		}
		return impNaoArrecadado.toString();
	}

	private void appendVirgula(StringBuilder string) {
		
		if(!string.toString().isEmpty()){
			string.append(", ");
		}
	}

	public String getImpostosNaoPrevisto() {

		boolean previuTodos = true;
		StringBuilder impNaoPrevisto = new StringBuilder();
		if(!this.isPrevisaoIPTU()){
			impNaoPrevisto.append("Imposto sobre a Propriedade Predial e Territorial Urbana – IPTU");
			previuTodos = false;
		}
				
		if(!this.isPrevisaoISSQN()){
			appendVirgula(impNaoPrevisto);
			impNaoPrevisto.append("Imposto sobre Serviços de Qualquer Natureza – ISSQN");
			previuTodos = false;
		}
		
		if(!this.isPrevisaoITBI()){
			appendVirgula(impNaoPrevisto);
			impNaoPrevisto.append("Imposto sobre Transmissão de Bens Imóveis – ITBI");
			previuTodos = false;
		}
		
		if(super.getNumAnoRef() <= 2017){
			if(!this.isPrevisaoIRRF()){
				appendVirgula(impNaoPrevisto);
				impNaoPrevisto.append("Imposto Retido na Fonte – IRRF");
				previuTodos = false;
			}
		}else{
			
			if(!this.isPrevisaoIRRF_OR()){
				appendVirgula(impNaoPrevisto);
				impNaoPrevisto.append("Imposto Retido na Fonte – IRRF Outros Rendimentos");
				previuTodos = false;
			}
			
			if(!this.isPrevisaoIRRF_SAL()){
				appendVirgula(impNaoPrevisto);
				impNaoPrevisto.append("IRRF Salário");
				previuTodos = false;
			}
		}
		
		if(previuTodos){
			impNaoPrevisto.append("OK");
		}
		return impNaoPrevisto.toString();
	}

	public boolean isPrevisaoIPTU() {
		return previsaoIPTU;
	}

	public void setPrevisaoIPTU(boolean previsaoIPTU) {
		this.previsaoIPTU = previsaoIPTU;
	}

	public boolean isPrevisaoITBI() {
		return previsaoITBI;
	}

	public void setPrevisaoITBI(boolean previsaoITBI) {
		this.previsaoITBI = previsaoITBI;
	}

	public boolean isPrevisaoIRRF() {
		return previsaoIRRF;
	}

	public void setPrevisaoIRRF(boolean previsaoIRRF) {
		this.previsaoIRRF = previsaoIRRF;
	}

	public boolean isPrevisaoIRRF_OR() {
		return previsaoIRRF_OR;
	}

	public void setPrevisaoIRRF_OR(boolean previsaoIRRF_OR) {
		this.previsaoIRRF_OR = previsaoIRRF_OR;
	}

	public boolean isPrevisaoIRRF_SAL() {
		return previsaoIRRF_SAL;
	}

	public void setPrevisaoIRRF_SAL(boolean previsaoIRRF_SAL) {
		this.previsaoIRRF_SAL = previsaoIRRF_SAL;
	}

	public boolean isPrevisaoISSQN() {
		return previsaoISSQN;
	}

	public void setPrevisaoISSQN(boolean previsaoISSQN) {
		this.previsaoISSQN = previsaoISSQN;
	}

	public boolean isArrecadacaoIPTU() {
		return arrecadacaoIPTU;
	}

	public void setArrecadacaoIPTU(boolean arrecadacaoIPTU) {
		this.arrecadacaoIPTU = arrecadacaoIPTU;
	}

	public boolean isArrecadacaoITBI() {
		return arrecadacaoITBI;
	}

	public void setArrecadacaoITBI(boolean arrecadacaoITBI) {
		this.arrecadacaoITBI = arrecadacaoITBI;
	}

	public boolean isArrecadacaoIRRF() {
		return arrecadacaoIRRF;
	}

	public void setArrecadacaoIRRF(boolean arrecadacaoIRRF) {
		this.arrecadacaoIRRF = arrecadacaoIRRF;
	}

	public boolean isArrecadacaoIRRF_OR() {
		return arrecadacaoIRRF_OR;
	}

	public void setArrecadacaoIRRF_OR(boolean arrecadacaoIRRF_OR) {
		this.arrecadacaoIRRF_OR = arrecadacaoIRRF_OR;
	}

	public boolean isArrecadacaoIRRF_SAL() {
		return arrecadacaoIRRF_SAL;
	}

	public void setArrecadacaoIRRF_SAL(boolean arrecadacaoIRRF_SAL) {
		this.arrecadacaoIRRF_SAL = arrecadacaoIRRF_SAL;
	}

	public boolean isArrecadacaoISSQN() {
		return arrecadacaoISSQN;
	}

	public void setArrecadacaoISSQN(boolean arrecadacaoISSQN) {
		this.arrecadacaoISSQN = arrecadacaoISSQN;
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

	public boolean isExercAndamento() {
		return isExercAndamento;
	}

	public void setExercAndamento(boolean isExercAndamento) {
		this.isExercAndamento = isExercAndamento;
	}

	public Integer getNumMesAndamento() {
		return numMesAndamento;
	}

	public void setNumMesAndamento(Integer numMesAndamento) {
		this.numMesAndamento = numMesAndamento;
	}

}
