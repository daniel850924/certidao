package br.gov.mg.tce.facade;

import java.util.List;

import javax.ejb.Local;

import br.gov.mg.tce.client.pca.web.AnaliseDTO;
import br.gov.mg.tce.dto.SolicitarCertidaoDTO;
import br.gov.mg.tce.dto.ValidarCertidaoResponse;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tcemg.facade.BusinessDomainInterface;

/**
 * Interface local de {@link CertidaoBO}
 *
 */
@Local
public interface CertidaoBOLocal extends BusinessDomainInterface<Certidao> {
	
	/**
	 * Salva a {@link Certidao}.
	 * 
	 * @param peticaoCertidao
	 * @return
	 * @throws Exception
	 */
	public Long salvarCertidao(Certidao peticaoCertidao) throws Exception;
	
	/**
	 * Consulta {@link Certidao} conforme preenchimento do filtro.
	 * 
	 * @param peticaoCertidao
	 * @return
	 */
	public List<Certidao> consultarPeticoesPorFiltros(Certidao peticaoCertidao);
	
	/**
	 * Recupera a {@link Certidao} especifica conforme numero do protocolo.
	 * 
	 * @param numProtocolo
	 * @return
	 */
	public Certidao recuperarPeticaoPorNumProtocolo(String numProtocolo);

	/**
	 * Recupera os bytes da certidao gerada automaticamente pelo sistema.
	 * @param codCertidao
	 * @return
	 */
	public byte[] recuperaArquivoCertidaoPorId(Long codCertidao);

	public String solicitacaoCertidao(String cpf, String nome, String email, String nomeMunicipio, String uf, String cnpj, 
			String nomeOrgao, String tipoCertidao, int certidaoSelecionada, int anoExercicio,
			int codigoFinalidade, String extensaoArquivo, byte[] arquivo, Long codOrgaoSGI) throws Exception;
	
	public Boolean indicesDentroLimite(AnaliseDTO analiseAtual) throws Exception;
	
	public SolicitarCertidaoDTO solicitarCertidao(Certidao peticaoCertidao) throws Exception;
	
	public List<Certidao> consultarPeticoesPorFiltrosDTO(Certidao peticaoCertidaoFiltro);
	
	/**
	 * Valida se os indices da certidao sao validos e retorna os indices atuais.
	 * 
	 * @param numProtocolo
	 * @return
	 * @throws Exception
	 */
	public ValidarCertidaoResponse validarCertidaoPorNumProtocolo(String numProtocolo) throws Exception;
}
