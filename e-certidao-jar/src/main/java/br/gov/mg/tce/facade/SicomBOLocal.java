package br.gov.mg.tce.facade;

import java.util.Map;

import javax.ejb.Local;

import br.gov.mg.tce.dto.sicom.relatorio.ExercicioAndamento;
import br.gov.mg.tce.dto.sicom.relatorio.MesEnvio;
import br.gov.mg.tce.dto.sicom.relatorio.PrePca;

@Local
public interface SicomBOLocal {

	public ExercicioAndamento consultarExercicioEmAndamento();
	
	public Map<Integer, PrePca> consultarIndicePrePca(Long codMunicipio, Integer numAnoRef) throws Exception;
	
	public MesEnvio consultarUltimoMesEnvio(Long codMunicipio, Integer numAnoRef) throws Exception;
	
}
