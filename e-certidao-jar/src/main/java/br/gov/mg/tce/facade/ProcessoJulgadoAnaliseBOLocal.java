package br.gov.mg.tce.facade;

import java.util.Map;

import javax.ejb.Local;

import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface ProcessoJulgadoAnaliseBOLocal extends BusinessDomainInterface<ProcessoJulgadoAnalise>{
	
	public Map<Long,ProcessoJulgadoAnalise> getMapTodosProcessos();
	
	public void salvarProcessoJulgadoAnalise(ProcessoJulgadoAnalise processoJulgadoAnalise);
	
	public ProcessoJulgadoAnalise findByNumeroProcesso(Long numeroProcesso);
}
