package br.gov.mg.tce.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.gov.mg.tce.dao.IndicadorDAO;
import br.gov.mg.tce.facade.IndicadorImplLocal;
import br.gov.mg.tce.interceptor.InjectInterceptorCertidao;
import br.gov.mg.tce.model.TipoDocumentoPeticao;
import br.gov.mg.tce.model.TipoFinalidadePeticao;
import br.gov.mg.tcemg.annotation.InjectDAO;
import br.gov.mg.tcemg.business.TCEMGBusinessDomain;
import br.gov.mg.tcemg.dao.TCEMGDao;

@Interceptors(InjectInterceptorCertidao.class)
@Stateless(name = "IndicadorImpl", mappedName = "IndicadorImpl")
public class IndicadorImpl extends TCEMGBusinessDomain<TipoDocumentoPeticao> implements IndicadorImplLocal{
	
	@InjectDAO
	private IndicadorDAO indicadorDAO;

	@Override
	protected TCEMGDao<TipoDocumentoPeticao> getDao() {
		return indicadorDAO;
	}
	
	public List<TipoDocumentoPeticao> buscarTipoCertidao(){
		return indicadorDAO.buscarTipoCertidao();
	}
	
	public TipoDocumentoPeticao buscarIndicadorTipoCertidao(Integer codIndicador){
		return indicadorDAO.buscarIndicadorTipoCertidao(codIndicador);
	}


	public List<TipoFinalidadePeticao> buscarTipoFinalidadeCertidao() {
		return indicadorDAO.buscarTipoFinalidadeCertidao();
	}

	@Override
	public TipoFinalidadePeticao buscarIndicadorTipoFinalidadePeticao(Integer codIndicador) {
		return indicadorDAO.buscarIndicadorTipoFinalidadePeticao(codIndicador);
	}

	@Override
	public TipoDocumentoPeticao buscarIndicadorTipoCertidao(String sglIndicador) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sglIndicador", sglIndicador);
		return super.consultaUnicoRegistroPorNamedQuery(TipoDocumentoPeticao.CONSULTAR_POR_SGL, param);
	}

	@Override
	public TipoFinalidadePeticao buscarIndicadorTipoFinalidadePeticao(String sglIndicador) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sglIndicador", sglIndicador);
		return (TipoFinalidadePeticao) super.consultaDTOPorNamedQuery(TipoFinalidadePeticao.CONSULTAR_POR_SGL, param);
	}
	
}
