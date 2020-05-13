package br.gov.mg.tce.dao;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.mg.tce.model.VwArquivosPeticaoEletronica;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class PeticaoArquivoDAO extends TCEMGDao<VwArquivosPeticaoEletronica> {

	public PeticaoArquivoDAO(EntityManager em) {
		super(em);
	}
	
	public ArrayList<VwArquivosPeticaoEletronica> buscarArquivosPeticoes( BigInteger codPeticao ) {

		Criteria c = super.createCriteria();
		
		c.add(Restrictions.eq("codPeticao", codPeticao));
		c.add(Restrictions.or(Restrictions.eq( "sglSituacao", "DF" ), Restrictions.eq( "sglSituacao", "DFR" )));
		c.add(Restrictions.eq("sglSituacaoAssinatura", "AT"));
		
		
		ArrayList<VwArquivosPeticaoEletronica> retorno = (ArrayList<VwArquivosPeticaoEletronica>) c.list();
		
		return retorno;
		
	}
	
	public VwArquivosPeticaoEletronica buscarUltimoArquivoPeticao( BigInteger codPeticao ) {
		
		Criteria c = super.createCriteria();
		
		c.add(Restrictions.eq("codPeticao", codPeticao));
		c.add(Restrictions.or( Restrictions.eq( "sglSituacao", "DF" ), Restrictions.eq( "sglSituacao", "DFR" )));
		c.add(Restrictions.or( Restrictions.eq("sglSituacaoAssinatura", "AT"), Restrictions.eq("sglSituacaoAssinatura", "D")));
		c.addOrder(Order.desc("sglSituacaoAssinatura"));
		c.setMaxResults(1);

		VwArquivosPeticaoEletronica retorno = (VwArquivosPeticaoEletronica) c.uniqueResult();
		
		return retorno;
		
	}

	public boolean verificaExisteArquivo(BigInteger codPeticao) {

		return (buscarArquivosPeticoes(codPeticao).size() > 0 ? true : false);
	}

}
