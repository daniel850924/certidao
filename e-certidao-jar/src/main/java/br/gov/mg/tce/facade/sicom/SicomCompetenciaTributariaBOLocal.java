package br.gov.mg.tce.facade.sicom;

import java.io.IOException;

import javax.ejb.Local;

import br.gov.mg.tce.dto.sicom.relatorio.PrevisaoArrecadacaoImpostos;
import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;

@Local
public interface SicomCompetenciaTributariaBOLocal {

	public void consultarDadosCertidaoCompetenciaTributaria(CertidaoCompetenciaTributaria certidao) throws Exception;
	
	public PrevisaoArrecadacaoImpostos consultarImpostoNaoPrevisto(Integer numAnoRef, Long codMunicipio) throws IOException;
	
	public PrevisaoArrecadacaoImpostos consultarImpostoNaoArrecadado(Integer numAnoRef, Long codMunicipio, Integer mesReferencia) throws IOException;
}
