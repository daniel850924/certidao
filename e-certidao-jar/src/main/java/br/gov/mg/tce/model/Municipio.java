package br.gov.mg.tce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.gov.mg.tcemg.model.IEntidade;

@Entity
@Table(name = "MUNICIPIOS")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAll", query = "SELECT m FROM Municipio m where m.ufMunicipio = 'MG' ORDER BY m.descMunicipio ASC"),
    @NamedQuery(name = "Municipio.findByCodMunicipio", query = "SELECT m FROM Municipio m where m.codMunicipio = :codMunicipio ORDER BY m.descMunicipio ASC"),
    @NamedQuery(name = "Municipio.findByCodMunicipioIbge", query = "SELECT m FROM Municipio m where m.codMunicipioIBGE = :codMunicipioIBGE "),
    @NamedQuery(name = "Municipio.findByNomeMunicipio", query = "SELECT m FROM Municipio m where m.descMunicipio = :descMunicipio and m.ufMunicipio = 'MG'"),
})
public class Municipio implements IEntidade{

	@Id
    @Column(name = "COD_MUNIC")
	private Long codMunicipio;
	
    @Column(name = "DESC_MUNIC")
    private String descMunicipio;

    @Column(name = "UF_MUNIC")
    private String ufMunicipio;
	
    @Column(name = "MESO_MUNIC")
    private String mesoMunicipio;
	
    @Column(name = "MICRO_MUNIC")
    private String microMunicipio;
	
    @Column(name = "COD_REAU_MUNIC")
    private Long codReauMunicipio;
	
    @Column(name = "COD_REGIAO")
    private Long codRegiaoMunicipio;
	
    @Column(name = "COD_MUNICIPIO_IBGE")
    private String codMunicipioIBGE;

	public Long getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(Long codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getDescMunicipio() {
		return descMunicipio;
	}

	public void setDescMunicipio(String descMunicipio) {
		this.descMunicipio = descMunicipio;
	}

	public String getUfMunicipio() {
		return ufMunicipio;
	}

	public void setUfMunicipio(String ufMunicipio) {
		this.ufMunicipio = ufMunicipio;
	}

	public String getMesoMunicipio() {
		return mesoMunicipio;
	}

	public void setMesoMunicipio(String mesoMunicipio) {
		this.mesoMunicipio = mesoMunicipio;
	}

	public String getMicroMunicipio() {
		return microMunicipio;
	}

	public void setMicroMunicipio(String microMunicipio) {
		this.microMunicipio = microMunicipio;
	}

	public Long getCodReauMunicipio() {
		return codReauMunicipio;
	}

	public void setCodReauMunicipio(Long codReauMunicipio) {
		this.codReauMunicipio = codReauMunicipio;
	}

	public Long getCodRegiaoMunicipio() {
		return codRegiaoMunicipio;
	}

	public void setCodRegiaoMunicipio(Long codRegiaoMunicipio) {
		this.codRegiaoMunicipio = codRegiaoMunicipio;
	}

	public String getCodMunicipioIBGE() {
		return codMunicipioIBGE;
	}

	public void setCodMunicipioIBGE(String codMunicipioIBGE) {
		this.codMunicipioIBGE = codMunicipioIBGE;
	}

	@Override
	public Long getId() {
		return codMunicipio;
	}

	@Override
	public Long setId(Long id) {
		this.codMunicipio = id;
		return codMunicipio;
	}
	
}
