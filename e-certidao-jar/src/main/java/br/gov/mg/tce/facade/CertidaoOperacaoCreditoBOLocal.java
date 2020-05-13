package br.gov.mg.tce.facade;

import javax.ejb.Local;

import br.gov.mg.tce.model.CertidaoOperacaoCredito;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface CertidaoOperacaoCreditoBOLocal extends BusinessDomainInterface<CertidaoOperacaoCredito>{

	public void gerarCertidao(Integer qtde) throws Exception;
	
}
