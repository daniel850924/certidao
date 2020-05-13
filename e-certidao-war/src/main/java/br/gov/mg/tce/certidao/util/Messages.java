package br.gov.mg.tce.certidao.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Messages {
	
	private static Messages instance;
	private ResourceBundle rb;

	private Messages() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		rb = ResourceBundle
				.getBundle("message", ctx.getViewRoot().getLocale());
	}

	/**
	 * Retorna uma string do arquivo de mensagens
	 * 
	 * @param key
	 * @return mensagem referente a chave
	 */
	public synchronized String getString(String key) {
		try {
			return (rb.getString(key));
		} catch (Exception e) {
			return ("Chave não encontrada no messages properties.");
		}
	}

	/**
	 * Retorna uma string contida no arquivo de propriedades através da chave passada
	 * e mesclando com o valor das chaves contidas no objeto params.
	 * Os valores das chaves contidas no objeto params também são obtidos no arquivo de propriedades.
	 * 
	 * @param key
	 * @param params
	 * @return string
	 */
	public synchronized  String getString(String key, String...params) {
		try {
			String msg = rb.getString(key);
			for (int i = 0; i<params.length; i++) {
				msg = msg.replace("{"+i+"}",params[i]);
			}
			return msg;
		} catch (Exception e) {
			return ("Chave não encontrada no messages properties.");
		}
	}		

	/**
	 * Retorna uma string contida no arquivo de propriedades através da chave passada
	 * e mesclando com as strings passadas como parâmetro
	 * 
	 * @param key
	 * @param params
	 * @return string
	 */
	public synchronized  String getStringFixa(String key, String...params) {
		try {
			String msg = rb.getString(key);
			for (int i = 0; i<params.length; i++) {
				msg = msg.replace("{"+i+"}", params[i]);
			}
			return msg;
		} catch (Exception e) {
			return ("Chave não encontrada no messages properties.");
		}
	}		

	/**
	 * Retorna a instancia da classe
	 * @return instancia da classe
	 */
	public static synchronized Messages getInstance() {
		if (instance == null) {
			instance = new Messages();
		}
		return instance;
	}
	
	/**
	 * Cria uma mensagem para adiciona-la ao contexto
	 * 
	 * @param mensagem
	 * @return mensagem
	 */
	public synchronized FacesMessage getMessage(String mensagem) {
		String msg = getString(mensagem);
		return (new FacesMessage(msg));
	}
	
	/**
	 * Cria uma mensagem para adiciona-la ao contexto
	 * 
	 * @param severity
	 * @param mensagem
	 * @return mensagem
	 */
	public synchronized FacesMessage getMessage(Severity severity, String mensagem) {
		String msg = getString(mensagem);
		return (new FacesMessage(severity,msg,null));
	}
	
	/**
	 * Cria uma mensagem para adiciona-la ao contexto
	 * 
	 * @param mensagem
	 * @param parametros
	 * @return mensagem
	 */
	public synchronized FacesMessage getMessage(String mensagem, String... parametros) {
		String msg = getString(mensagem);
		int i = 0;
		for (String key : parametros){
			String param = getString(key);
			msg = msg.replace("{"+i+"}",param);
			i++;
		}
		return (new FacesMessage(msg));
	}
	
	/**
	 * Cria uma mensagem para adiciona-la ao contexto
	 * 
	 * @param severity
	 * @param mensagem
	 * @param parametros
	 * @return mensagem
	 */
	public synchronized FacesMessage getMessage(Severity severity, String mensagem, String... parametros) {
		String msg = getString(mensagem);
		int i = 0;
		for (String key : parametros){
			String param = getString(key);
			msg = msg.replace("{"+i+"}",param);
			i++;
		}
		return (new FacesMessage(severity, msg, null));
	}

}
