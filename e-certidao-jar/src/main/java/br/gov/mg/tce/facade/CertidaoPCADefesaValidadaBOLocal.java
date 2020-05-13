package br.gov.mg.tce.facade;

import javax.ejb.Local;

@Local
public interface CertidaoPCADefesaValidadaBOLocal {

	public void gerarCertidao(Integer qtde);
}
