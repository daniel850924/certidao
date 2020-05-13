package br.gov.mg.tce.enumerator;




/**
 * Enum que descreve o nome do arquivo .jasper e seu relacionamento com o tipo de certidão.
 *
 */
public enum EnumRelatorioCertidaoJasper {

	C001("C001-ModeloCertidaoEnsino.jasper","C001"),
	C002("C002-ModeloCertidaoSaude.jasper","C002"),   
	C003("C003-ModeloCertidaoFundeb.jasper","C003"),   
	C004("C004-ModeloCertidaoPessoal.jasper","C004"),   
	C008("C008-ModeloCertidaoGeral.jasper","C008");   

	
	private String fileNameCertidao;
	private String tipoCertidao;
	
	private EnumRelatorioCertidaoJasper(String fileNameCertidao, String tipoCertidao) {
		this.fileNameCertidao = fileNameCertidao;
		this.tipoCertidao = tipoCertidao;
	}

	/**
	 * Recupera o asqruivo .jasper conforme o tipo de certidao.
	 * @param tipoCertidao
	 * @return
	 */
	public static String getRelatorioByTipoCertidao(String tipoCertidao){
		String nomeRelatorio = null;
		for (EnumRelatorioCertidaoJasper enumRelatorioCertidao : values()) {
			if(enumRelatorioCertidao.getTipoCertidao().equals(tipoCertidao)){
				nomeRelatorio = enumRelatorioCertidao.getFileNameCertidao();
			}
		}
		return nomeRelatorio;
	}
	
	public String getFileNameCertidao() {
		return fileNameCertidao;
	}
	
	public String getTipoCertidao() {
		return tipoCertidao;
	}
	
}
