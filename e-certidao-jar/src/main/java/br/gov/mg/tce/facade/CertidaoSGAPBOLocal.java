package br.gov.mg.tce.facade;

import javax.ejb.Local;

@Local
public interface CertidaoSGAPBOLocal {

	public void gerarCertidao();
}
