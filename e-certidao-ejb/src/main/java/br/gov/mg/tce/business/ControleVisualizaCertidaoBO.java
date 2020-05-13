package br.gov.mg.tce.business;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.gov.mg.tce.dao.ControleVisualizaCertidaoDAO;
import br.gov.mg.tce.facade.ControleVisualizaCertidaoBOLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.ControleVisualizaCertidao;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;
import br.gov.mg.tcemg.util.StringUtil;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "ControleVisualizaCertidaoBO", mappedName = "ControleVisualizaCertidaoBO")
public class ControleVisualizaCertidaoBO extends TCEMGBusinessDomain<ControleVisualizaCertidao> implements ControleVisualizaCertidaoBOLocal {

	private static final long NENHUM_REGISTRO = 0L;
	
	@InjectDAO
	private ControleVisualizaCertidaoDAO dao;

	@Override
	protected TCEMGDao<ControleVisualizaCertidao> getDao() {
		return dao;
	}

	@Override
	public Date obterDataVisualizacaoPorProtocolo(String numProtocoloCertidao) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		if ( ! StringUtil.isStringVazia(numProtocoloCertidao)) {
			params.put("numProtocoloCertidao", numProtocoloCertidao.replace(".", ""));
		} else {
			return null;
		}

		Object result = consultaUnicoAtributoPorNamedQuery(ControleVisualizaCertidao.OBTER_DATA_VISUALIZACAO_POR_PROTOCOLO, params);
		return (result == null) ? null : (Date) result;
	}
	
	@Override
	public Long obterCountVisualizacaoPorProtocolo(final String numProtocoloCertidao) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		if ( ! StringUtil.isStringVazia(numProtocoloCertidao)) {
			params.put("numProtocoloCertidao", numProtocoloCertidao.replace(".", ""));
		} else {
			return null;
		}
		
		return (Long) consultaUnicoAtributoPorNamedQuery(ControleVisualizaCertidao.OBTER_COUNT_VISUALIZACAO_POR_PROTOCOLO, params);
	}
	
	@Override
	public void gravarVisualizacaoCertidaoJurisdicionado(final String numCpf, final String numProtocoloCertidao) {
		Long countVisualizacao = obterCountVisualizacaoPorProtocolo(numProtocoloCertidao);
		
		if (countVisualizacao == NENHUM_REGISTRO) {
			ControleVisualizaCertidao controleVisualizaCert = new ControleVisualizaCertidao();
			controleVisualizaCert.setNumCpfVisualizador(numCpf);
			controleVisualizaCert.setNumProtocoloCertidao(numProtocoloCertidao);
			incluir(controleVisualizaCert);
		}
	}	
	
}
