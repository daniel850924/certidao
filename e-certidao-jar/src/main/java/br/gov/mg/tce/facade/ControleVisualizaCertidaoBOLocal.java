package br.gov.mg.tce.facade;

import java.util.Date;

import javax.ejb.Local;

import br.gov.mg.tce.model.ControleVisualizaCertidao;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface ControleVisualizaCertidaoBOLocal extends BusinessDomainInterface<ControleVisualizaCertidao> {

	public Date obterDataVisualizacaoPorProtocolo(String numProtocoloCertidao);

	public void gravarVisualizacaoCertidaoJurisdicionado(String numCpf, String numProtocoloCertidao);

	public Long obterCountVisualizacaoPorProtocolo(String numProtocoloCertidao);
	
}
