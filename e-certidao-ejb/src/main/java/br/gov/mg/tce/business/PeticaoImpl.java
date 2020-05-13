package br.gov.mg.tce.business;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.gov.mg.tce.dao.PeticaoDAO;
import br.gov.mg.tce.facade.PeticaoImplLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.VwPeticaoEletronica;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "PeticaoImpl", mappedName = "PeticaoImpl")
public class PeticaoImpl extends TCEMGBusinessDomain<VwPeticaoEletronica> implements PeticaoImplLocal{

	@InjectDAO
	private PeticaoDAO peticaoDAO;

	@Override
	protected TCEMGDao<VwPeticaoEletronica> getDao() {
		return peticaoDAO;
	}
	
	public ArrayList<VwPeticaoEletronica> buscarPeticaoPorFiltro(VwPeticaoEletronica vw) {
		return peticaoDAO.buscarPeticaoPorFiltro(vw) ;
	}
	
}