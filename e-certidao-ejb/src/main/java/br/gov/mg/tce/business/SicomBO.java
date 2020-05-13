package br.gov.mg.tce.business;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.mg.tce.business.sicom.SicomUtil;
import br.gov.mg.tce.dto.sicom.relatorio.ExercicioAndamento;
import br.gov.mg.tce.dto.sicom.relatorio.MesEnvio;
import br.gov.mg.tce.dto.sicom.relatorio.PrePca;
import br.gov.mg.tce.facade.SicomBOLocal;
import br.gov.mg.tcemg.util.DateUtil;

@SuppressWarnings("rawtypes")
@Stateless(name = "SicomBO", mappedName = "SicomBO")
public class SicomBO implements SicomBOLocal {

//	@PersistenceContext(unitName = "SICOMBI")
	private EntityManager entityManagerSICOM;
	
//	@PersistenceContext(unitName = "SICOMBI_NOVO")
	private EntityManager entityManagerSICOMNovo;
	  
	/**
	 * TODO CRIAR SERVICO NO SICOM REMESSA
	 */
	@Override
	public ExercicioAndamento consultarExercicioEmAndamento() {

		ExercicioAndamento exercicioAndamento = null;
		try {
			Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("ExercicioEmAndamento.sql"), ExercicioAndamento.class);
			exercicioAndamento = (ExercicioAndamento) nativeQuery.getSingleResult();
		} catch (IOException e) {
			exercicioAndamento = new ExercicioAndamento(new BigDecimal(DateUtil.getAnoData()));
		}
		
		return exercicioAndamento;
	}

	/**
	 * TODO CRIAR SERVICO NO SICOM REMESSA
	 */
	public MesEnvio consultarUltimoMesEnvio(Long codMunicipio, Integer numAnoRef) throws Exception {

		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("MesEnvio.sql"), MesEnvio.class);
		nativeQuery.setParameter("exercicioSelecionado", numAnoRef);
		nativeQuery.setParameter("municipioSelecionado", codMunicipio);
		MesEnvio mesEnvio = (MesEnvio) nativeQuery.getSingleResult();
		return mesEnvio;
	}
	
	@SuppressWarnings("unchecked")
	public Map<Integer, PrePca> consultarIndicePrePca(Long codMunicipio, Integer numAnoRef) throws Exception{
		
		Query nativeQuery = entityManagerSICOMNovo.createNativeQuery(SicomUtil.getSqlBI("PrePca.sql"), PrePca.class);
		nativeQuery.setParameter("exercicio", numAnoRef);
		nativeQuery.setParameter("codIbge", codMunicipio);
		List<PrePca> prePcas = (List<PrePca>) nativeQuery.getResultList();
		
		Map<Integer, PrePca> mapIndicePrePca = new HashMap<>();
		for (PrePca prePca : prePcas) {
			mapIndicePrePca.put(prePca.getSeqind().intValue(), prePca);
		}
		
		return mapIndicePrePca;
	}
}
