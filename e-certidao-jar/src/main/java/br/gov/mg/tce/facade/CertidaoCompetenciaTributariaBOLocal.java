package br.gov.mg.tce.facade;

import javax.ejb.Local;

import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface CertidaoCompetenciaTributariaBOLocal extends BusinessDomainInterface<CertidaoCompetenciaTributaria>{

	public void gerarCertidao(Integer qtde);
	
}
