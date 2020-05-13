package br.gov.mg.tce.enumerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.gov.mg.tce.base.BaseEnum;

public enum IndSimNaoEnum implements BaseEnum, Serializable{

	S("S", "Sim"),  
	N("N", "N\u00E3o");

	private String id;
	private String label;
	private static Map<String, IndSimNaoEnum> relations;

	static {
		relations = new HashMap<String, IndSimNaoEnum>();
		for (final IndSimNaoEnum indSimNaoEnum : values()) {
			relations.put(indSimNaoEnum.getId(), indSimNaoEnum);
		}
	}

	public static IndSimNaoEnum getPorId(final String id) {
		return relations.get(id);
	}

	IndSimNaoEnum(String id, String label){
		this.label = label;
		this.id = id;
	}
	
	IndSimNaoEnum(){
		
	}
	
	public static List<String> getListaIdString() {
		List<String> listaIds = new ArrayList<String>();
		for (final IndSimNaoEnum simNao : values()) {
			listaIds.add(simNao.getId());
		}
		return listaIds;
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