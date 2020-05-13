package br.gov.mg.tce.facade;

import java.util.List;

import javax.ejb.Local;

import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;
import br.gov.mg.tce.model.CertidaoLimites;
import br.gov.mg.tce.model.CertidaoOperacaoCredito;
import br.gov.mg.tce.model.OperacaoCreditoDados;

@Local
public interface SiaceBOLocal {

	public List<OperacaoCreditoDados> consultarDadosCertidaoOperacaoCredito(CertidaoOperacaoCredito certidaoOperacaoCredito);
	
	public void setDadosCertidaoLimites(CertidaoLimites certidao);
	
	public void setDadosCertidaoCompetenciaTributaria(CertidaoCompetenciaTributaria certidao);
}
