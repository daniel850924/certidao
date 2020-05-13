package br.gov.mg.tce.dao;

import javax.persistence.EntityManager;

import br.gov.mg.tce.model.ControleVisualizaCertidao;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class ControleVisualizaCertidaoDAO extends TCEMGDao<ControleVisualizaCertidao>{

	public ControleVisualizaCertidaoDAO(EntityManager em) {
		super(em);
	}
	
}
