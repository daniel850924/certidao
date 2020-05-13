package br.gov.mg.tce.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.mg.tce.model.Municipio;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class MunicipioDAO extends TCEMGDao<Municipio>  {

	public MunicipioDAO(EntityManager em) {
		super(em);
	}
	
	public ArrayList<Municipio> buscarMunicipios() {
		
		Query query = null;
		try {
			query = super.getNamedQuery("Municipio.findAll");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (ArrayList<Municipio>) query.getResultList();
	}

	public Municipio buscarMunicipioPorCod(Long codMunicipio) {		
		Query query = null;
		try {
			query = super.getNamedQuery("Municipio.findByCodMunicipio");
			query.setParameter("codMunicipio", codMunicipio);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (Municipio) query.getSingleResult();
	}
	
	public Municipio buscarMunicipioPorCodIbge(Long codMunicipioIBGE) {		
		Query query = null;
		try {
			query = super.getNamedQuery("Municipio.findByCodMunicipioIbge");
			query.setParameter("codMunicipioIBGE", codMunicipioIBGE.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (Municipio) query.getSingleResult();
	}
	
	public Municipio buscarMunicipioPorNomeMunicipio(String descMunicipio) {		
		Query query = null;
		try {
			query = super.getNamedQuery("Municipio.findByNomeMunicipio");
			query.setParameter("descMunicipio", descMunicipio);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (Municipio) query.getSingleResult();
	}
	
}
