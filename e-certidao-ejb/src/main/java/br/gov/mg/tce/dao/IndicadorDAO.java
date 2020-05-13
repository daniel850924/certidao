package br.gov.mg.tce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.gov.mg.tce.model.TipoDocumentoPeticao;
import br.gov.mg.tce.model.TipoFinalidadePeticao;
import br.gov.mg.tcemg.dao.TCEMGDao;

public class IndicadorDAO extends TCEMGDao<TipoDocumentoPeticao> {

	public IndicadorDAO(EntityManager em) {
		super(em);
	}
	
	public List<TipoDocumentoPeticao> buscarTipoCertidao() {
		
		Query query = null;
		
		try {

			query = super.getNamedQuery("TipoDocumentoPeticao.findAll");
			
			
		} catch (Exception e) {
			
			//@TODO TRATAR EXECE��O
			
			e.printStackTrace();
		}
		
		return (List<TipoDocumentoPeticao>) query.getResultList();

	}
	
	public TipoDocumentoPeticao buscarIndicadorTipoCertidao(Integer codIndicador) {
		
		Query query = null;
		
		try {
			
			query = super.getNamedQuery("TipoDocumentoPeticao.findByCodIndicador");
			query.setParameter("codIndicador", codIndicador);
			
			
		} catch (Exception e) {
			
			//@TODO TRATAR EXECE��O
			
			e.printStackTrace();
		}
		
		return (TipoDocumentoPeticao) query.getSingleResult();
		
	}



	public List<TipoFinalidadePeticao> buscarTipoFinalidadeCertidao() {
		
		Query query = null;
		
		try {

			query = super.getNamedQuery("TipoFinalidadePeticao.findAll");
			
			
		} catch (Exception e) {
			
			//@TODO TRATAR EXECE��O
			
			e.printStackTrace();
		}
		
		return (List<TipoFinalidadePeticao>) query.getResultList();
	}

	public TipoFinalidadePeticao buscarIndicadorTipoFinalidadePeticao(Integer codIndicador) {

		Query query = null;
		try {
			query = super.getNamedQuery("TipoFinalidadePeticao.findByCodIndicador");
			query.setParameter("codIndicador", codIndicador);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return (TipoFinalidadePeticao) query.getSingleResult();
	}
	
}
