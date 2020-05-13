package br.gov.mg.tce.facade;

import java.util.List;

import javax.ejb.Local;

import br.gov.mg.tce.model.VwPeticaoEletronica;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface PeticaoImplLocal extends BusinessDomainInterface<VwPeticaoEletronica>{

	public List<VwPeticaoEletronica> buscarPeticaoPorFiltro(VwPeticaoEletronica vw) ;
	
	
}