package br.gov.mg.tce.certidao.enums;

public enum SituacaoEnum {
	AGUARDANDO_ANALISE		(0, "Aguardando An�lise"),
	EM_ANALISE				(1, "Em An�lise"),
	CERTIDAO_DISPONIVEL		(2, "Certid�o Dispon�vel"),
	SOLICITACAO_REPROVADA	(3, "Solicita��o Reprovada");
	
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
