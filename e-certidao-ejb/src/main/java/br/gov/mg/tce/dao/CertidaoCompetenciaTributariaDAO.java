package br.gov.mg.tce.dao;

import javax.persistence.EntityManager;

import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class CertidaoCompetenciaTributariaDAO extends TCEMGDao<CertidaoCompetenciaTributaria>{

	public CertidaoCompetenciaTributariaDAO(EntityManager em) {
		super(em);
	}
	
}
