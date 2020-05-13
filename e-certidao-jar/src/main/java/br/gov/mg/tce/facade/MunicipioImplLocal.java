package br.gov.mg.tce.facade;

import java.util.List;

import javax.ejb.Local;

import br.gov.mg.tce.model.Municipio;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface MunicipioImplLocal extends BusinessDomainInterface<Municipio> {

	public List<Municipio> buscarMunicipios();
	
	public Municipio buscarMunicipioPorCod(Long codMunicipio);
	
	public Municipio buscarMunicipioPorCodIbge(Long codMunicipioIBGE);
	
	public Municipio buscarMunicipioPorNomeMunicipio(String nomeMunicipio);
	
}
