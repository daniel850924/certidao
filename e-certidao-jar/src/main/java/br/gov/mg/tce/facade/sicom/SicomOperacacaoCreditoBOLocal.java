package br.gov.mg.tce.facade.sicom;

import java.io.IOException;

import javax.ejb.Local;

import br.gov.mg.tce.model.CertidaoOperacaoCredito;

@Local
public interface SicomOperacacaoCreditoBOLocal {

	public void consultarDadosCertidaoOperacaoCredito(CertidaoOperacaoCredito certidaoOperacaoCredito) throws Exception;
	
	public boolean isOptanteSemestralidade(Long codMunicipio, Integer numAnoRef) throws IOException;
	
}
