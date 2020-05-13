package br.gov.mg.tce.enumerator;

import java.util.HashMap;
import java.util.Map;

/**
 * Enum para identificar a situacao da analise
 * em comum com o SGAP.
 * 
 * Na base do E-Certidao noa se usa a situacao 
 * AGUARDANDO_ANALISE, apenas na  VW do SGAP.
 *
 */
public enum EnumTipoSituacaoComumPeticaoCertidaoVwSgap {
	
	AGUARDANDO_ANALISE(1L, IndSituacaoCertidaoEnum.EM_ANALISE.getId(), "AA", "AGUARDANDO ANÁLISE"),
	EM_ANALISE(2L, IndSituacaoCertidaoEnum.EM_ANALISE.getId(), "EA", "EM ANÁLISE"),
	DEFERIDA(3L, IndSituacaoCertidaoEnum.CONCLUIDA.getId(), "DF", "DEFERIDA"),
	INDEFERIDA(4L, IndSituacaoCertidaoEnum.INDEFERIDA.getId(), "INDF", "INDEFERIDA");
	
	private Long id;
	private String siglaSituacaoPeticao;
	private String siglaSituacaoVwSgap;
	private String descricao;
	
	private static Map<Long, EnumTipoSituacaoComumPeticaoCertidaoVwSgap> relations;

	static {
		relations = new HashMap<Long, EnumTipoSituacaoComumPeticaoCertidaoVwSgap>();
		for (final EnumTipoSituacaoComumPeticaoCertidaoVwSgap situacao : values()) {
			relations.put(situacao.getId(), situacao);
		}
	}
	
	private EnumTipoSituacaoComumPeticaoCertidaoVwSgap(Long id, String siglaSituacaoPeticao, String siglaSituacaoVwSgap, String descricao) {
		this.id = id;
		this.siglaSituacaoPeticao = siglaSituacaoPeticao;
		this.siglaSituacaoVwSgap = siglaSituacaoVwSgap;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getSiglaSituacaoPeticao() {
		return siglaSituacaoPeticao;
	}

	public String getSiglaSituacaoVwSgap() {
		return siglaSituacaoVwSgap;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EnumTipoSituacaoComumPeticaoCertidaoVwSgap getPorId(final Long id) {
		return relations.get(id);
	}

	public static EnumTipoSituacaoComumPeticaoCertidaoVwSgap obterPorsiglaSituacaoPeticao(String siglaSituacaoPeticao){
		for (EnumTipoSituacaoComumPeticaoCertidaoVwSgap enumTipoSituacaoComumSgapEnum : EnumTipoSituacaoComumPeticaoCertidaoVwSgap.values()) {
			if (enumTipoSituacaoComumSgapEnum.siglaSituacaoPeticao.equals(siglaSituacaoPeticao)){
				return enumTipoSituacaoComumSgapEnum;
			}
		}
		return null;
	}
	
	public static EnumTipoSituacaoComumPeticaoCertidaoVwSgap obterPorsiglaSituacaoVwSgap(String siglaSituacaoVwSgap){
		for (EnumTipoSituacaoComumPeticaoCertidaoVwSgap enumTipoSituacaoComumSgapEnum : EnumTipoSituacaoComumPeticaoCertidaoVwSgap.values()) {
			if (enumTipoSituacaoComumSgapEnum.siglaSituacaoVwSgap.equals(siglaSituacaoVwSgap)){
				return enumTipoSituacaoComumSgapEnum;
			}
		}
		return null;
	}	
}
