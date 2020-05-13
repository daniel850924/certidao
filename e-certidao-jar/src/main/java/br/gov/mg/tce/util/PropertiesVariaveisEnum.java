package br.gov.mg.tce.util;

public enum PropertiesVariaveisEnum {

	AMBIENTE("ambiente"),
	URL_WEBSERVICE_FUNDEB("URL_WEBSERVICE_FUNDEB"),
	URL_WEBSERVICE_CALENDARIO("URL_WEBSERVICE_CALENDARIO"),
	URL_WEBSERVICE_PROCESSO_JULGADO("URL_WEBSERVICE_PROCESSO_JULGADO"),
	URL_INTEGRACAO_WEB_CERTIDAO("URL_INTEGRACAO_WEB_CERTIDAO"),
	URL_INTEGRACAO_CORE_CERTIDAO("URL_INTEGRACAO_CORE_CERTIDAO"),
	WSDL_BUSCAR_ORGAO_SGI("wsdlBuscarOrgaoSGI"),
	WSDL_LOGIN_SGI("wsdlLoginSGI"),
	WSDL_SGAP_PCA_ANALISE("WSDL_SGAP_PCA_ANALISE"),
	URL_SICOM_REST("URL_SICOM_REST");
	
	private String variavel;

	private PropertiesVariaveisEnum(String variavel) {
		this.variavel = variavel;
	}

	public String getVariavel() {
		return variavel;
	}
	
	
}
