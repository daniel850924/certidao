package br.gov.mg.tce.business;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.gov.mg.tce.dao.PeticaoArquivoDAO;
import br.gov.mg.tce.facade.PeticaoArquivoImplLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.VwArquivosPeticaoEletronica;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "PeticaoArquivoImpl", mappedName = "PeticaoArquivoImpl")
public class PeticaoArquivoImpl  extends TCEMGBusinessDomain<VwArquivosPeticaoEletronica> implements PeticaoArquivoImplLocal{

	@InjectDAO
	private PeticaoArquivoDAO peticaoArquivoDAO;

	@Override
	protected TCEMGDao<VwArquivosPeticaoEletronica> getDao() {
		return peticaoArquivoDAO;
	}

	public ArrayList<VwArquivosPeticaoEletronica> buscarArquivosPeticoes( BigInteger codPeticao ) {

		return peticaoArquivoDAO.buscarArquivosPeticoes(codPeticao );
	}
	
	public VwArquivosPeticaoEletronica buscarUltimoArquivoPeticao( BigInteger codPeticao ) {
		
		return peticaoArquivoDAO.buscarUltimoArquivoPeticao(codPeticao );
	}

	public boolean verificaExisteArquivo(BigInteger codPeticao) {

		return peticaoArquivoDAO.verificaExisteArquivo(codPeticao);
	}
	
	
}