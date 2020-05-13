package br.gov.mg.tce.enumerator;

import java.util.HashMap;
import java.util.Map;

import br.gov.mg.tce.base.BaseEnum;

public enum IndFinalidadeCertidaoEnum implements BaseEnum {
	
	CONVENIO("CC","CELEBRAÇÃO DE CONVÊNIO"),
	OPERACAO_CREDITO("OC","OPERAÇÕES DE CRÉDITO"),
	OUTRAS("OUTR", "OUTRAS"),
	PRORROGACAO_PRAZO("PPPZ", "PEDIDO DE PRORROGAÇÃO DE PRAZO"),
	PEDIDO_SUBSTITUA("PESU", "PEDIDO SUBSTITUTA");
	
	private String id;
	private String label;
	
	private IndFinalidadeCertidaoEnum(String id, String label) {
		this.id = id;
		this.label = label;
	}

	private static Map<String, IndFinalidadeCertidaoEnum> relations;

	static {
		relations = new HashMap<String, IndFinalidadeCertidaoEnum>();
		for (final IndFinalidadeCertidaoEnum enumerator : IndFinalidadeCertidaoEnum.values()) {
			relations.put(enumerator.getId(), enumerator);
		}
	}
	
	public static IndFinalidadeCertidaoEnum getPorId(final String id) {
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
