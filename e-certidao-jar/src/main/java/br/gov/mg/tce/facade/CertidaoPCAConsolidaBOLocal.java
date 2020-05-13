package br.gov.mg.tce.facade;

import javax.ejb.Local;

@Local
public interface CertidaoPCAConsolidaBOLocal {

	public void gerarCertidao(Integer qtde);
}
