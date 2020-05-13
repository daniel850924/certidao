package br.gov.mg.tce.business;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.gov.mg.tce.dao.MunicipioDAO;
import br.gov.mg.tce.facade.MunicipioImplLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.Municipio;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "MunicipioImpl", mappedName = "MunicipioImpl")
public class MunicipioImpl extends TCEMGBusinessDomain<Municipio> implements MunicipioImplLocal{
	
	@InjectDAO
	private MunicipioDAO municipioDAO;
	
	@Override
	protected TCEMGDao<Municipio> getDao() {
		return municipioDAO;
	}

	public ArrayList<Municipio> buscarMunicipios(){
		return municipioDAO.buscarMunicipios();
	}
	
	public Municipio buscarMunicipioPorCod(Long codMunicipio){
		return municipioDAO.buscarMunicipioPorCod(codMunicipio);
	}
	
	public Municipio buscarMunicipioPorNomeMunicipio(String nomeMunicipio){
		return municipioDAO.buscarMunicipioPorNomeMunicipio(nomeMunicipio);
	}

	@Override
	public Municipio buscarMunicipioPorCodIbge(Long codMunicipioIBGE) {
		return municipioDAO.buscarMunicipioPorCodIbge(codMunicipioIBGE);
	}
}
