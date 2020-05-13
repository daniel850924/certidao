package br.gov.mg.tce.enumerator;

import java.util.HashMap;
import java.util.Map;

public enum EnumFormaEmissao {
	
	MANUAL(1L, "MANUAL"),
	ELETRONICA(2L, "ELETRÔNICA");
	
	private Long id;
	private String descricao;
	
	private static Map<Long, EnumFormaEmissao> relations;

	static {
		relations = new HashMap<Long, EnumFormaEmissao>();
		for (final EnumFormaEmissao situacao : values()) {
			relations.put(situacao.getId(), situacao);
		}
	}
	
	private EnumFormaEmissao(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EnumFormaEmissao getPorId(final Long id) {
		return relations.get(id);
	}
}
