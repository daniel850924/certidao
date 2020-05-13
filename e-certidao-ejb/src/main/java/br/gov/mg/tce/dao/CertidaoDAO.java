package br.gov.mg.tce.dao;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.gov.mg.tce.enumerator.IndTipoCertidaoEnum;
import br.gov.mg.tce.model.Certidao;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.exception.TceException;
import br.gov.mg.tcemg.exception.TceFault;


/**
 * DAO padrao para entidade {@link Certidao}
 *
 */
public class CertidaoDAO extends TCEMGDao<Certidao>{

	private static AtomicBoolean executarNumProtocolo = new AtomicBoolean(true);

	public CertidaoDAO(EntityManager em) {
		super(em);
	}
	
	/**
	 * Salva ou atualiza a entidade {@link Certidao} 
	 * 
	 * @param peticaoCertidao
	 * @return
	 * @throws Exception
	 */
	public Long salvarCertidao(Certidao peticaoCertidao) throws Exception {
		if (peticaoCertidao.getNumProtocolo() == null){
			String numeroProtocolo = recuperarNumeroProtocolo(peticaoCertidao.getIndTipoCertidao());
			peticaoCertidao.setNumProtocolo(Long.valueOf(numeroProtocolo));
		}
		saveOrUpdate(peticaoCertidao);
		return peticaoCertidao.getNumProtocolo();
	}
	
	/**
	 * Recupera o proximo numero a ser utilizado como protocolo. Verifica se o
	 * ano atual e o mesmo do ultimo numero de protocolo, caso nao seja inicia o
	 * contador para 0 novamente.
	 * 
	 * O numero do protocolo segue este padrao: 8000XXXXX0YYYY 
	 * XXXXX - sequencial
	 * YYYY - ano atual
	 * Ex: 80000000102017
	 * @throws TceException 
	 */
	public String recuperarNumeroProtocolo(IndTipoCertidaoEnum indTipoCertidao) throws TceException {	
		try{
			while (!executarNumProtocolo.get()){
				Thread.sleep(1000);
			}
			executarNumProtocolo.set(false);
			StringBuilder retorno = new StringBuilder();
			
			final String anoAtual = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			Long idProxNumProtocolo;
			String anoProtocolo;
			String idTipoCertidao = indTipoCertidao.getId();
			int length = idTipoCertidao.length();
			String codTipo = idTipoCertidao.substring(length-1, length);
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("anoAtual", anoAtual);
			params.put("indTipoCertidao", indTipoCertidao);
			params.put("codTipo", codTipo);

			Long numProtocoloCompleto = (Long) super.consultaUnicoAtributoPorNamedQuery(Certidao.BUSCAR_ULTIMO_NUMERO_PROTOCOLO, params);
			
			//Se n�o existir numero de protocolo gerado zera o protocolo
			if (numProtocoloCompleto == null || numProtocoloCompleto == 0L){
				idProxNumProtocolo = 0L;
			}else{
				idProxNumProtocolo = Long.valueOf(String.valueOf(numProtocoloCompleto).substring(4,9));
				//Se o ano atual for diferente do ano do ultimo protocolo gerado, reinicia o contador.
				anoProtocolo = String.valueOf(numProtocoloCompleto).substring(10,14);
				if (!anoAtual.equals(anoProtocolo)){
					idProxNumProtocolo = 0L;	
				}
			}
			
			idProxNumProtocolo++;
	
			retorno.append(codTipo).append("000");
			retorno.append(String.format("%05d", idProxNumProtocolo));
			retorno.append("0");
			retorno.append(anoAtual);
			executarNumProtocolo.set(true);
			return retorno.toString();
		}catch (Exception e){
			executarNumProtocolo.set(true);
			throw new TceException("Erro ao gerar número do protocolo.",new TceFault(),e);
		}finally{
			executarNumProtocolo.set(true);
		}
	}

	/**
	 * Retorna lista de {@link Certidao} conforme filtros preenchidos.
	 * 
	 * @param peticaoCertidao
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Certidao> consultarCertidoesPorFiltros(Certidao peticaoCertidao, int paginacao){
		Criteria criteria = this.createCriteria();

		if (peticaoCertidao.getNumCpfCnpf() != null) {
			criteria.add(Restrictions.eq("numCpfCnpf", peticaoCertidao.getNumCpfCnpf()));
		}

		if (peticaoCertidao.getNumAnoRef() != null) {
			criteria.add(Restrictions.eq("numAnoRef", peticaoCertidao.getNumAnoRef()));
		}

		if (peticaoCertidao.getIndFinalidade() != null) {
			criteria.add(Restrictions.eq("indFinalidade", peticaoCertidao.getIndFinalidade()));
		}

		if (peticaoCertidao.getIndTipoCertidao() != null) {
			criteria.add(Restrictions.eq("indTipoCertidao", peticaoCertidao.getIndTipoCertidao()));
		}

		if (peticaoCertidao.getNumProtocolo() != null) {
			criteria.add(Restrictions.eq("numProtocolo", peticaoCertidao.getNumProtocolo()));
		}

		if (peticaoCertidao.getCodMunicipio() != null) {
			criteria.add(Restrictions.eq("codMunicipio", peticaoCertidao.getCodMunicipio()));
		}
		
		if (peticaoCertidao.getIndSituacao() != null) {
			criteria.add(Restrictions.eq("indSituacao", peticaoCertidao.getIndSituacao()));
		}
		
		 if(peticaoCertidao.getDataIncioEmissao() != null){
			 criteria.add(Restrictions.ge("dataGeracaoCertidao", peticaoCertidao.getDataIncioEmissao()));
		 }
		 if(peticaoCertidao.getDataFimEmissao() != null){
			 criteria.add(Restrictions.le("dataGeracaoCertidao", peticaoCertidao.getDataFimEmissao()));
		 }
		
		criteria.addOrder(Order.asc("dataSolicitacao"));
		
		if(paginacao > 0){
			criteria.setMaxResults(paginacao);
		}
		
		return (List<Certidao>) criteria.list();
		
	}

}
