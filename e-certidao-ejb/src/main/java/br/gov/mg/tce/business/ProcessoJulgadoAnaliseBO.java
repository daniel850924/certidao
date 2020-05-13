package br.gov.mg.tce.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import br.gov.mg.tce.dao.ProcessoJulgadoAnaliseDAO;
import br.gov.mg.tce.facade.ProcessoJulgadoAnaliseBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.ProcessoJulgadoAnalise;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;

/**
 * Classe de negocio para tratar as regras relativa a entidade {@link ProcessoJulgadoAnalise}
 * 
 */
@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "ProcessoJulgadoAnaliseBO", mappedName = "ProcessoJulgadoAnaliseBO")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProcessoJulgadoAnaliseBO extends TCEMGBusinessDomain<ProcessoJulgadoAnalise> implements ProcessoJulgadoAnaliseBOLocal{
	
	@InjectDAO
	private ProcessoJulgadoAnaliseDAO processoJulgadoAnaliseDAO;

	@Override
	protected TCEMGDao<ProcessoJulgadoAnalise> getDao() {
		return processoJulgadoAnaliseDAO;
	}
	
	public Map<Long,ProcessoJulgadoAnalise> getMapTodosProcessos(){
		Map<Long,ProcessoJulgadoAnalise> mapaProcessoJulgadoAnalise = new HashMap<Long, ProcessoJulgadoAnalise>();
		List<ProcessoJulgadoAnalise> listProcessoJulgadoAnalise = processoJulgadoAnaliseDAO.listar();
		for (ProcessoJulgadoAnalise processoJulgadoAnalise : listProcessoJulgadoAnalise) {
			if (!mapaProcessoJulgadoAnalise.containsKey(processoJulgadoAnalise.getCodProcessoJulgadoAnalise())){
				mapaProcessoJulgadoAnalise.put(processoJulgadoAnalise.getCodProcesso(), processoJulgadoAnalise);
			}
		}
		
		return mapaProcessoJulgadoAnalise;
	}

	public void salvarProcessoJulgadoAnalise(ProcessoJulgadoAnalise processoJulgadoAnalise){
		processoJulgadoAnaliseDAO.saveOrUpdate(processoJulgadoAnalise);
	}
	
	public ProcessoJulgadoAnalise findByNumeroProcesso(Long numeroProcesso){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("numProcesso", numeroProcesso);
		return processoJulgadoAnaliseDAO.consultaUnicoRegistroPorNamedQuery(ProcessoJulgadoAnalise.BUSCAR_PROCESSO_POR_NUMERO_PROCESSO, params);
	}
	
}
