package br.gov.mg.tce.certidao.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import br.gov.mg.tce.util.PropertiesUtil;

public abstract class PropertiesBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected final Properties properties = new Properties();
	
	protected PropertiesBase(final String nameProperties) {
		inicializarConfiguracao(nameProperties);
	}

	protected void inicializarConfiguracao(final String nameProperties) {
		
        try {
        	final InputStream resourceAsStream = PropertiesUtil.class.getResourceAsStream(nameProperties);
        	properties.load(resourceAsStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
