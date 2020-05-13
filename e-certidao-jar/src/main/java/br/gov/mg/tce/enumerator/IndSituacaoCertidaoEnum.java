package br.gov.mg.tce.enumerator;

import java.util.HashMap;
import java.util.Map;

import br.gov.mg.tce.base.BaseEnum;

public enum IndSituacaoCertidaoEnum implements BaseEnum {
	
	EM_PROCESSAMENTO("EMP","EM PROCESSAMENTO"),
	CONCLUIDA("CONC","DEFERIDA"),
	EM_ANALISE("ANA", "EM ANÁLISE"),
	ERRO("ERR", "ERRO"),
	INDEFERIDA("IND", "INDEFERIDA");
	
	private String id;
	private String label;
	
	private IndSituacaoCertidaoEnum(String id, String label) {
		this.id = id;
		this.label = label;
	}

	private static Map<String, IndSituacaoCertidaoEnum> relations;

	static {
		relations = new HashMap<String, IndSituacaoCertidaoEnum>();
		for (final IndSituacaoCertidaoEnum enumerator : IndSituacaoCertidaoEnum.values()) {
			relations.put(enumerator.getId(), enumerator);
		}
	}
	
	public static IndSituacaoCertidaoEnum getPorId(final String id) {
		return relations.get(id);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
