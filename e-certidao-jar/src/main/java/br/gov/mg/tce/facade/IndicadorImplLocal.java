package br.gov.mg.tce.facade;

import java.util.List;

import javax.ejb.Local;

import br.gov.mg.tce.model.TipoDocumentoPeticao;
import br.gov.mg.tce.model.TipoFinalidadePeticao;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface IndicadorImplLocal extends BusinessDomainInterface<TipoDocumentoPeticao>{

	public TipoDocumentoPeticao buscarIndicadorTipoCertidao(Integer codIndicador);
	
	public TipoDocumentoPeticao buscarIndicadorTipoCertidao(String sglIndicador);

	public TipoFinalidadePeticao buscarIndicadorTipoFinalidadePeticao(Integer codIndicador);
	
	public TipoFinalidadePeticao buscarIndicadorTipoFinalidadePeticao(String sglIndicador);
	
	public List<TipoFinalidadePeticao> buscarTipoFinalidadeCertidao();
	
	public List<TipoDocumentoPeticao> buscarTipoCertidao();
}
