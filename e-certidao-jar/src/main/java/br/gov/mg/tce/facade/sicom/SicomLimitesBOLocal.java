package br.gov.mg.tce.facade.sicom;

import java.io.IOException;

import javax.ejb.Local;

import br.gov.mg.tce.model.CertidaoLimites;

@Local
public interface SicomLimitesBOLocal {
	
	public void consultarDadosCertidaoLimites(CertidaoLimites certidao) throws IOException;

}
