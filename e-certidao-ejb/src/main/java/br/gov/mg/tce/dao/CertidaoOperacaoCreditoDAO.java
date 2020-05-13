package br.gov.mg.tce.dao;

import javax.persistence.EntityManager;

import br.gov.mg.tce.model.CertidaoOperacaoCredito;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class CertidaoOperacaoCreditoDAO extends TCEMGDao<CertidaoOperacaoCredito>{

	public CertidaoOperacaoCreditoDAO(EntityManager em) {
		super(em);
	}
	
}
