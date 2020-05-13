package br.gov.mg.tce.business.sicom;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.gov.mg.tce.dto.sicom.relatorio.ExercicioAndamento;
import br.gov.mg.tce.dto.sicom.relatorio.MesEnvio;
import br.gov.mg.tce.dto.sicom.relatorio.PrevisaoArrecadacaoImpostos;
import br.gov.mg.tce.enumerator.IndSituacaoCertidaoEnum;
import br.gov.mg.tce.facade.SicomBOLocal;
import br.gov.mg.tce.facade.sicom.SicomCompetenciaTributariaBOLocal;
import br.gov.mg.tce.model.CertidaoCompetenciaTributaria;
import br.gov.mg.tce.util.Constantes;
import br.gov.mg.tcemg.util.StringUtil;

@Stateless(name = "SicomCompetenciaTributariaBO", mappedName = "SicomCompetenciaTributariaBO")
public class SicomCompetenciaTributariaBO implements SicomCompetenciaTributariaBOLocal {

//	@PersistenceContext(unitName = "SICOMBI_NOVO")
	private EntityManager entityManagerSICOM;
	
	@EJB
	private SicomBOLocal sicomBO;
	
	@Override
	public void consultarDadosCertidaoCompetenciaTributaria(CertidaoCompetenciaTributaria certidao) throws Exception {
		
		ExercicioAndamento exercicioEmAndamento = sicomBO.consultarExercicioEmAndamento();
		boolean isExercicioAndamento = certidao.getNumAnoRef().toString().equals(exercicioEmAndamento.getAno().toString());
		
		if(isExercicioAndamento && !SicomUtil.isMunicipioAdimplente(certidao.getCodMunicipio())){
			certidao.setIndSituacao(IndSituacaoCertidaoEnum.INDEFERIDA);
			certidao.setDataGeracaoCertidao(new Date());
			certidao.setDscIndeferidoJustificativa(Constantes.MSG_INDEFERIMENTO_SICOM);
		}else{
			
			certidao.setExercAndamento(isExercicioAndamento);
			Integer mesReferencia;
			if(isExercicioAndamento){
				MesEnvio mesEnvio = sicomBO.consultarUltimoMesEnvio(certidao.getCodMunicipio(), certidao.getNumAnoRef());
				mesReferencia = mesEnvio.getMaior_posicao().intValue();
				certidao.setNumMesAndamento(mesReferencia);
			}else{
				mesReferencia = 12;
			}
			
			
			PrevisaoArrecadacaoImpostos naoPrevistos = consultarImpostoNaoPrevisto(certidao.getNumAnoRef(), certidao.getCodMunicipio());
			PrevisaoArrecadacaoImpostos naoArrecadados = consultarImpostoNaoArrecadado(certidao.getNumAnoRef(), certidao.getCodMunicipio(), mesReferencia);
			certidao.inicializarPrevisaoArrecadacao();
			
			if(!StringUtil.isStringVazia(naoPrevistos.getDemostrativo())){
				for (String imposto : naoPrevistos.getDemostrativo().split(",")) {
					switch (imposto) {
					case "IPTU":
						certidao.setPrevisaoIPTU(false);
						break;
					case "IRRF Outros Rendimentos":
						certidao.setPrevisaoIRRF_OR(false);				
						break;
					case "IRRF Salário":
						certidao.setPrevisaoIRRF_SAL(false);				
						break;
					case "ISSQN":
						certidao.setPrevisaoISSQN(false);
						break;
					case "ITBI":
						certidao.setPrevisaoITBI(false);
						break;
					default:
						break;
					}
				}
			}
			
			if(!StringUtil.isStringVazia(naoArrecadados.getDemostrativo())){
				for (String imposto : naoArrecadados.getDemostrativo().split(",")) {
					switch (imposto) {
					case "IPTU":
						certidao.setArrecadacaoIPTU(false);
						break;
					case "IRRF Outros Rendimentos":
						certidao.setArrecadacaoIRRF_OR(false);				
						break;
					case "IRRF Salário":
						certidao.setArrecadacaoIRRF_SAL(false);				
						break;
					case "ISSQN":
						certidao.setArrecadacaoISSQN(false);
						break;
					case "ITBI":
						certidao.setArrecadacaoITBI(false);
						break;
					default:
						break;
					}
				}
			}
			
			certidao.setDscImpCompNaoArrecadados(certidao.getImpostosNaoArrecadado());
			certidao.setDscImpCompNaoPrevisto(certidao.getImpostosNaoPrevisto());
			certidao.setDataGeracaoCertidao(new Date());
			certidao.setIndSituacao(IndSituacaoCertidaoEnum.CONCLUIDA);
		}
	}
	
	public PrevisaoArrecadacaoImpostos consultarImpostoNaoPrevisto(Integer numAnoRef, Long codMunicipio) throws IOException {
		
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("competenciaTributaria/CompetenciaTribPrevisaoIgualZero.sql"), PrevisaoArrecadacaoImpostos.class);
		nativeQuery.setParameter("exercicioSelecionado", numAnoRef);
		nativeQuery.setParameter("municipioSelecionado", codMunicipio);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		PrevisaoArrecadacaoImpostos naoPrevistos = (PrevisaoArrecadacaoImpostos) nativeQuery.getSingleResult();
		
		return naoPrevistos;
	}
	
	public PrevisaoArrecadacaoImpostos consultarImpostoNaoArrecadado(Integer numAnoRef, Long codMunicipio, Integer mesReferencia) throws IOException {
		
		Query nativeQuery = entityManagerSICOM.createNativeQuery(SicomUtil.getSqlBI("competenciaTributaria/CompetenciaTribArrecadacaoIgualZero.sql"), PrevisaoArrecadacaoImpostos.class);
		nativeQuery.setParameter("exercicioSelecionado", numAnoRef);
		nativeQuery.setParameter("municipioSelecionado", codMunicipio);
		nativeQuery.setParameter("mesSelecionado", mesReferencia);
		SicomUtil.setDataSelecionada(nativeQuery);
		
		PrevisaoArrecadacaoImpostos naoArrecadado = (PrevisaoArrecadacaoImpostos) nativeQuery.getSingleResult();
		
		return naoArrecadado;
	}

}
