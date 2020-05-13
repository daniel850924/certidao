package br.gov.mg.tce.dao;

import javax.persistence.EntityManager;

import br.gov.mg.tce.model.CertidaoLimites;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class CertidaoLimitesDAO extends TCEMGDao<CertidaoLimites> {

    public CertidaoLimitesDAO(EntityManager em) {
        super(em);
    }
}
