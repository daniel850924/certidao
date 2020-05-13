package br.gov.mg.tce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.mg.tce.enumerator.EnumTipoAnalise;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tcemg.dao.TCEMGDao;


/**
 * DAO padrao para entidade {@link CertidaoPCA}
 *
 */
public class CertidaoPCADAO extends TCEMGDao<CertidaoPCA>{

	public CertidaoPCADAO(EntityManager em) {
		super(em);
	}

	public List<CertidaoPCA> consultarPeticoesParaJobAnalisesComProcessos(int paginacao) {
		Criteria criteria = this.createCriteria();
		
		criteria.add(Restrictions.eq("indSituacao", IndSituacaoCertidaoEnum.EM_ANALISE));
		
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(Restrictions.eq("sglTipoAnalise", EnumTipoAnalise.ANALISE_ATJ.getSigla()));
		disjunction.add(Restrictions.eq("sglTipoAnalise", EnumTipoAnalise.ANALISE_TJ.getSigla()));
		disjunction.add(Restrictions.eq("sglTipoAnalise", EnumTipoAnalise.ANALISE_IR.getSigla()));
		criteria.add(disjunction);

		criteria.addOrder(Order.asc("dataSolicitacao"));
		
		if(paginacao > 0){
			criteria.setMaxResults(paginacao);
		}
		
		return (List<CertidaoPCA>) criteria.list();
	}
}
