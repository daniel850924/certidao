package br.gov.mg.tce.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	private static PropertiesUtil propertiesUtil;
	protected final Properties properties = new Properties();
	
	private PropertiesUtil() {
		inicializarConfiguracao();
	}

	private void inicializarConfiguracao() {
		
        try {
        	final InputStream resourceAsStream = PropertiesUtil.class.getResourceAsStream("/profile.properties");
			properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static PropertiesUtil getInstance(){
		
		if(propertiesUtil == null){
			propertiesUtil = new PropertiesUtil();
		}
		return propertiesUtil;
	}

	public String getPropertieValue(PropertiesVariaveisEnum variaveisEnum){
		return properties.getProperty(variaveisEnum.getVariavel());
	}
	
}
