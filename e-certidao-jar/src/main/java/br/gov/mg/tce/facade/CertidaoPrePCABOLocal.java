package br.gov.mg.tce.facade;

import javax.ejb.Local;

@Local
public interface CertidaoPrePCABOLocal {

	public void gerarCertidao(Integer qtde);

}
