package br.gov.mg.tce.facade;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.ejb.Local;

import br.gov.mg.tce.model.VwArquivosPeticaoEletronica;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

@Local
public interface PeticaoArquivoImplLocal extends BusinessDomainInterface<VwArquivosPeticaoEletronica> {

	public ArrayList<VwArquivosPeticaoEletronica> buscarArquivosPeticoes( BigInteger codPeticao );

	public VwArquivosPeticaoEletronica buscarUltimoArquivoPeticao( BigInteger codPeticao ) ;
		
	public boolean verificaExisteArquivo(BigInteger codPeticao) ;
	
}
