package br.gov.mg.tce.interceptor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.gov.mg.tcemg.interceptor.InjectInterceptorBase;

@SuppressWarnings("serial")
public class InjectInterceptorCertidao extends InjectInterceptorBase{

//	@PersistenceContext(unitName = "ECERTIDAO")
	private EntityManager entityManager;
	
	@Override
	public EntityManager obterEntityManager() {
		return entityManager;
	}

}
