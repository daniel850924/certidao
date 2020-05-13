package br.gov.mg.tce.enumerator;

/**
 * Enum para identificar o tipo de Analise
 *
 */
public enum EnumTipoAnalise {
	
	
	ANALISE_PRE_PCA("ANAP","ANALISE PRE-PCA", "PRE-PCA"),
	ANALISE_CONSOLIDADA("ANAC","ANALISE CONSOLIDADA", "CONSOLIDADA"),
	ANALISE_SUBSTITUA("ANASB","ANALISE SUBSTITUTA", "SUBSTITUTA"),
	
	ANALISE_DE_DEFESA("ANDF","DEFESA DOCUMENTAL/ELETRONICA", "DEFESA"),
	
	ANALISE_ATJ("ANAAT","AGUARD. TRANSITADO JULGADO", "AGUARD. TRANSITADO JULGADO"),
	ANALISE_IR("ANAIR","PEDIDO DE REEXAME", "PEDIDO DE REEXAME"),
	
	ANALISE_TJ("ANATJ", "TRANSITADO JULGADO", "TRANSITADO JULGADO");
	
	private String sigla;
	private String descricao;
	private String descricaoFiltro;
	
	private EnumTipoAnalise(String sigla, String descricao, String descricaoFiltro) {
		this.sigla = sigla;
		this.descricao = descricao;
		this.descricaoFiltro = descricaoFiltro;
	}
	public String getSigla() {
		return sigla;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public String getDescricaoFiltro() {
		return descricaoFiltro;
	}
	
	public static EnumTipoAnalise getEnumBySigla(String sigla){
		for (EnumTipoAnalise enumTipoAnalise : EnumTipoAnalise.values()) {
			if (enumTipoAnalise.getSigla().equals(sigla)){
				return enumTipoAnalise;
			}
		}
		return null;
	}
	
}
