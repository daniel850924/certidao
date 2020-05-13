package br.gov.mg.tce.dao;

import javax.persistence.EntityManager;

import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tcemg.dao.TCEMGDao;

/**
 * DAO padrao para a entidade {@link ProcessoJulgadoAnalise}
 *
 */
public class ProcessoJulgadoAnaliseDAO extends TCEMGDao<ProcessoJulgadoAnalise>{

	public ProcessoJulgadoAnaliseDAO(EntityManager em) {
		super(em);
	}
	
}
