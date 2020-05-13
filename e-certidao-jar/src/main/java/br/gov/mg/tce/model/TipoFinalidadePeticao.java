package br.gov.mg.tce.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import br.gov.mg.tcemg.model.IEntidade;

@Entity
@Table(name = "VW_TIPO_FINALIDADE_PETICAO", catalog = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFinalidadePeticao.findAll", query = "SELECT i FROM TipoFinalidadePeticao i"),
    @NamedQuery(name = "TipoFinalidadePeticao.findByCodIndicador", query = "SELECT i FROM TipoFinalidadePeticao i where i.codIndicador = :codIndicador "),
    @NamedQuery(name = TipoFinalidadePeticao.CONSULTAR_POR_SGL, query = "SELECT i FROM TipoFinalidadePeticao i where i.sglIndicador = :sglIndicador ")
})

public class TipoFinalidadePeticao implements IEntidade {
    private static final long serialVersionUID = 1L;

	public static final String CONSULTAR_POR_SGL = "TipoFinalidadePeticao.CONSULTAR_POR_SGL";
    
    @Id
    @Basic(optional = false)
    @Column(name = "COD_INDICADOR", nullable = false)
    private Integer codIndicador;
    
    @Basic(optional = false)
    @Column(name = "SGL_INDICADOR", nullable = false, length = 4)
    private String sglIndicador;
    
    @Basic(optional = false)
    @Column(name = "DSC_INDICADOR", nullable = false, length = 100)
    private String dscIndicador;
    

    public TipoFinalidadePeticao() {}

    public TipoFinalidadePeticao(Integer codIndicador) {
        this.codIndicador = codIndicador;
    }

    public TipoFinalidadePeticao(Integer codIndicador, String sglIndicador, String dscIndicador, Date datInicio) {
        this.codIndicador = codIndicador;
        this.sglIndicador = sglIndicador;
        this.dscIndicador = dscIndicador;

    }

    public String getSglIndicador() {
        return sglIndicador;
    }

    public void setSglIndicador(String sglIndicador) {
        this.sglIndicador = sglIndicador;
    }

    public String getDscIndicador() {
        return dscIndicador;
    }

    public void setDscIndicador(String dscIndicador) {
        this.dscIndicador = dscIndicador;
    }

     @Override
    public String toString() {
        return "modelo.Indicador[ codIndicador=" + codIndicador + " ]";
    }

	public Integer getCodIndicador() {
		return codIndicador;
	}

	public void setCodIndicador(Integer codIndicador) {
		this.codIndicador = codIndicador;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoFinalidadePeticao other = (TipoFinalidadePeticao) obj;
		if (codIndicador == null) {
			if (other.codIndicador != null)
				return false;
		} else if (!codIndicador.equals(other.codIndicador))
			return false;
		return true;
	}

	@Override
	public Integer getId() {
		return codIndicador;
	}

	@Override
	public Serializable setId(Long id) {
		if(id != null){
			this.codIndicador = id.intValue();
		}
		return codIndicador;
	}

}
