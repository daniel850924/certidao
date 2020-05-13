package br.gov.mg.tce.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.mg.tcemg.model.IEntidade;

/**
 * Classe representando a entidade CONTROLE_VISUALIZA_CERTIDAO
 */
@Entity
@Table(name = "CONTROLE_VISUALIZA_CERTIDAO")
@XmlRootElement 
@NamedQueries({
	@NamedQuery(name = ControleVisualizaCertidao.OBTER_DATA_VISUALIZACAO_POR_PROTOCOLO, query = "SELECT c.datVisualizacao from ControleVisualizaCertidao c "
			+ " WHERE c.numProtocoloCertidao = :numProtocoloCertidao"),
	@NamedQuery(name = ControleVisualizaCertidao.OBTER_COUNT_VISUALIZACAO_POR_PROTOCOLO, query = "SELECT COUNT(c.codCtrlVisualizaCertidao) FROM ControleVisualizaCertidao c "
			+ " WHERE c.numProtocoloCertidao = :numProtocoloCertidao"),		
})
public class ControleVisualizaCertidao implements Serializable,IEntidade {
    
	private static final long serialVersionUID = 1L;

	public static final String OBTER_DATA_VISUALIZACAO_POR_PROTOCOLO = "ControleVisualizaCertidao.OBTER_DATA_VISUALIZACAO_POR_PROTOCOLO";

	public static final String OBTER_COUNT_VISUALIZACAO_POR_PROTOCOLO = "ControleVisualizaCertidao.OBTER_COUNT_VISUALIZACAO_POR_PROTOCOLO";
	
	@Id
	@SequenceGenerator(allocationSize = 1, name = "SQ_PK_COD_CTRL_VISUALIZA_CERTI", sequenceName = "SQ_PK_COD_CTRL_VISUALIZA_CERTI")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PK_COD_CTRL_VISUALIZA_CERTI")
    @Column(name = "COD_CTRL_VISUALIZA_CERTIDAO", nullable = false)
    private Long codCtrlVisualizaCertidao;
    
    @Column(name = "NUM_PROTOCOLO_CERTIDAO", nullable = false)
    private String numProtocoloCertidao;
    
    @Column(name = "DAT_VISUALIZACAO", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date datVisualizacao;
    
    @Column(name = "NUM_CPF_VISUALIZADOR", nullable = false)
    private String numCpfVisualizador;
    
	@Override
	public Long getId() {
		return codCtrlVisualizaCertidao;
	}

	public Long setId(Long id) {
		this.codCtrlVisualizaCertidao = id;
		return codCtrlVisualizaCertidao;
	}

	public Long getCodCtrlVisualizaCertidao() {
		return codCtrlVisualizaCertidao;
	}

	public void setCodCtrlVisualizaCertidao(Long codCtrlVisualizaCertidao) {
		this.codCtrlVisualizaCertidao = codCtrlVisualizaCertidao;
	}

	public String getNumProtocoloCertidao() {
		return numProtocoloCertidao;
	}

	public void setNumProtocoloCertidao(String numProtocoloCertidao) {
		this.numProtocoloCertidao = numProtocoloCertidao;
	}

	public Date getDatVisualizacao() {
		return datVisualizacao;
	}

	public void setDatVisualizacao(Date datVisualizacao) {
		this.datVisualizacao = datVisualizacao;
	}

	public String getNumCpfVisualizador() {
		return numCpfVisualizador;
	}

	public void setNumCpfVisualizador(String numCpfVisualizador) {
		this.numCpfVisualizador = numCpfVisualizador;
	}

	@Override
	public String toString() {
		return "ControleVisualizaCertidao [codCtrlVisualizaCertidao = " + codCtrlVisualizaCertidao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codCtrlVisualizaCertidao == null) ? 0
						: codCtrlVisualizaCertidao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ControleVisualizaCertidao other = (ControleVisualizaCertidao) obj;
		if (codCtrlVisualizaCertidao == null) {
			if (other.codCtrlVisualizaCertidao != null)
				return false;
		} else if (!codCtrlVisualizaCertidao
				.equals(other.codCtrlVisualizaCertidao))
			return false;
		return true;
	}
	
}