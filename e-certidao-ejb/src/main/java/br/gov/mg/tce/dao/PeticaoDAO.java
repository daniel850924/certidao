package br.gov.mg.tce.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.gov.mg.tce.model.VwPeticaoEletronica;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.util.StringUtil;

public class PeticaoDAO extends TCEMGDao<VwPeticaoEletronica> {

	public PeticaoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<VwPeticaoEletronica> buscarPeticaoPorFiltro(VwPeticaoEletronica vw) {
		
		 Criteria criteria = super.createCriteria();
		 criteria.add(Restrictions.eq("codTipoPeticao", 235));
		 
		 if (vw.getNumCpfCnpf() != 0L) {
			 criteria.add(Restrictions.eq("numCpfCnpf", vw.getNumCpfCnpf()));
		 }
		 
		 if(vw.getNumAnoRef()!= null){
			 criteria.add(Restrictions.eq("numAnoRef", vw.getNumAnoRef()));
		 }
		 
		 if(vw.getCodFinalidade()!= null){
			 criteria.add(Restrictions.eq("codFinalidade", vw.getCodFinalidade()));
		 }
		 
		 if(vw.getCodTipoDocPeticao()!= null){
			 criteria.add(Restrictions.eq("codTipoDocPeticao", vw.getCodTipoDocPeticao()));
		 }
		 
		 if(vw.getProtocoloEditado()!= null && !vw.getProtocoloEditado().equalsIgnoreCase("")){
			 criteria.add(Restrictions.eq("protocoloEditado", vw.getProtocoloEditado()));
		 }
		 
		 if( ! StringUtil.isStringVazia(vw.getCodMunicipioIbge())){
			 criteria.add(Restrictions.eq("codMunicipioIbge", vw.getCodMunicipioIbge()));
		 }
		 
		 if( ! StringUtil.isStringVazia(vw.getSglSituacao())){
			 criteria.add(Restrictions.eq("sglSituacao", vw.getSglSituacao()));
		 }

		 if(vw.getDataIncioEmissao() != null){
			 criteria.add(Restrictions.ge("datSituacao", vw.getDataIncioEmissao()));
		 }
		 if(vw.getDataFimEmissao() != null){
			 criteria.add(Restrictions.le("datSituacao", vw.getDataFimEmissao()));
		 }
		 
		return (ArrayList<VwPeticaoEletronica>) criteria.list();
	}

}
