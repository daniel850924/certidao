package br.gov.mg.tce.enumerator;

import java.util.HashMap;
import java.util.Map;

import br.gov.mg.tce.base.BaseEnum;

public enum IndTipoCertidaoEnum implements BaseEnum {
	
	GASTO_ENSINO("C001","1 - Aplicação de recursos na Manutenção e Desenvolvimento do Ensino"),
	GASTO_SAUDE("C002","2 - Aplicação de recursos nas Ações e Serviços Públicos de Saúde"),
	FUNDEB("C003", "3 - Aplicação de recursos do FUNDEB na Remuneração dos Profissionais do Magistério"),
	GASTO_PESSOAL("C004", "4 - Despesa Total com Pessoal em Relação à Receita Corrente Líquida"),
	COMPETENCIA_TRIBUTARIA("C005", "5 - Competência Tributária Municipal"),
	LIMITES("C006", "6 - Cumprimento dos Limites Impostos pela LRF"),
	OPERACAO_CREDITO("C007", "7 - Para fins de celebração de Operações de Crédito"),
	GERAL("C008", "8 - Certidão Geral (Ensino/Saúde/FUNDEB/Pessoal)");
	
	private String id;
	private String label;
	
	private IndTipoCertidaoEnum(String id, String label) {
		this.id = id;
		this.label = label;
	}

	private static Map<String, IndTipoCertidaoEnum> relations;

	static {
		relations = new HashMap<String, IndTipoCertidaoEnum>();
		for (final IndTipoCertidaoEnum enumerator : IndTipoCertidaoEnum.values()) {
			relations.put(enumerator.getId(), enumerator);
		}
	}
	
	public static IndTipoCertidaoEnum getPorId(final String id) {
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

	@Override
	public String toString() {
		return label;
	}
	
}
