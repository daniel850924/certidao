package br.gov.mg.tce.certidao.enums;

public enum SituacaoEnum {
	AGUARDANDO_ANALISE		(0, "Aguardando Análise"),
	EM_ANALISE				(1, "Em Análise"),
	CERTIDAO_DISPONIVEL		(2, "Certidão Disponível"),
	SOLICITACAO_REPROVADA	(3, "Solicitação Reprovada");
	
	private int codigo;
	private String descricao;

	SituacaoEnum(int codigo, String descricao){
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo(){
		return codigo;
	}
	
	public String getDescricao(){
		return descricao;
	}
}
