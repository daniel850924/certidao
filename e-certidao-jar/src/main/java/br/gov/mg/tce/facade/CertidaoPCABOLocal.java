package br.gov.mg.tce.facade;

import java.util.List;

import javax.ejb.Local;

import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tce.model.CertidaoPCA;
import br.gov.mg.tcemg.exception.TceException;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

/**
 * Interface local de {@link PeticaoCertidaoBO}
 *
 */
@Local
public interface CertidaoPCABOLocal extends BusinessDomainInterface<CertidaoPCA> {
	
	public CertidaoPCA criarCertidaoPCA(Integer exercicio, String codMunicipio) throws TceException;
	
	List<CertidaoPCA> consultarPeticoesParaJobAnalisesComProcessos(int paginacao);

	public CertidaoPCA consultarPeticaoGeradaPorTipoAnalise(Long codMunicipio, Integer anoExercicio, String sglTipoAnalise);
	
	List<CertidaoPCA> consultarPeticoesPorFiltros(CertidaoPCA filtro, Integer qtde);
	
	List<Certidao> consultarCertidaoPCAPorFiltros(Certidao filtro);
	
}
