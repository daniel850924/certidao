package br.gov.mg.tce.certidao.enumerator;

/**
 * Enum para identificar o tipo de Certidao
 *
 */
public enum EnumTipoCertidao {
	AADM("AADM","PETIÇÃO ADMINISTRATIVA"),
	C001("C001","Aplicação de recursos na Manutenção e Desenvolvimento do Ensino"),
	C002("C002","Aplicação de recursos nas Ações e Serviços Públicos de Saúde"),
	C003("C003","Aplicação de recursos do FUNDEB na Remuneração dos Profissionais do Magistério"),
	C004("C004","Despesa Total com Pessoal em Relação à Receita Corrente Líquida"),
	C005("C005","Competência Tributária Municipal"),
	C006("C006","Cumprimento dos Limites Impostos pela LRF"),
	C007("C007","Para fins de celebração de Operações de Crédito");
	
	private String sigla;
	private String descricao;
	
	private EnumTipoCertidao(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static EnumTipoCertidao getEnumBySigla(String sigla){
		for (EnumTipoCertidao enumTipoCertidao : EnumTipoCertidao.values()) {
			if (enumTipoCertidao.getSigla().equals(sigla)){
				return enumTipoCertidao;
			}
		}
		return null;
	}
	
}
