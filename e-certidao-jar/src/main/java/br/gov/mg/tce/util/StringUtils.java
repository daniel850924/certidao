package br.gov.mg.tce.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StringUtils {

	public static String validaValoresNumericos(String valor){
		
		if(valor.contains(",") && valor.contains(".")) return valor.replace(".", "").replace(",", ".");
		else if(valor.contains(",")) return valor.replace(",", ".");


		return valor;
	}
	
	public static String formataZerosEsquerda(String valor,Integer nummeroCasas){
		String retorno = valor;
		for (int i = valor.length(); i < nummeroCasas; i++) {
			retorno = "0"+retorno;
		}
		
		return retorno;
	}
	
	public static String formataCPForCNPJ(String valor, String mascara) {

		String dado = "";
		// remove caracteres nao numericos
		for (int i = 0; i < valor.length(); i++) {
			char c = valor.charAt(i);
			if (Character.isDigit(c)) {
				dado += c;
			}
		}

		int indMascara = mascara.length();
		int indCampo = dado.length();

		for (; indCampo > 0 && indMascara > 0;) {
			if (mascara.charAt(--indMascara) == '#') {
				indCampo--;
			}
		}

		String saida = "";
		for (; indMascara < mascara.length(); indMascara++) {
			saida += ((mascara.charAt(indMascara) == '#') ? dado.charAt(indCampo++) : mascara.charAt(indMascara));
		}
		return saida;
	}

	/**
	 * M�todo para formatar o CNJP. Remo��o dos caracteres especiais.
	 * 
	 * @param cnpj
	 * @return
	 */
	public static String formataCNJP(String cnpj) {
		String retorno = cnpj.replace('-', ' ');
		retorno = retorno.replace('.', ' ');
		retorno = retorno.replace('/', ' ');
		// Retira espa�o em branco
		retorno = retorno.replaceAll(" ", "");

		return retorno;
	}

	/**
	 * M�todo p/ retirar o caracter '/' de datas. Utilizado no UC AdicionarMulta
	 * 
	 * @param data
	 * @return
	 */
	public static String retiraCharData(String data) {
		String retorno = data.replace('/', ' ');
		retorno = retorno.trim();
		return retorno;
	}

	/**
	 * M�todo para formatar os valores do Enum SituacaoProcesso.
	 * 
	 * @param name
	 * @return
	 */
	public static String formataEnumSituacao(String name) {
		String retorno = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		retorno = retorno.replace("analise", "an�lise");
		retorno = retorno.replace("partes cadm", "partes");
		retorno = retorno.replace("cdm", "CDM");
		return retorno.replace('_', ' ');
	}

	/**
	 * M�todo que formata valor monet�rio p/ Float e assim habilitar a
	 * realiza��o de opera��es.
	 * 
	 * @param valorMoeda
	 * @return
	 */
	public static String retiraCharMoeda(String valorMoeda) {
		String retorno = valorMoeda;
		// Condicional p/ verificar se � necess�rio a formata��o. Quando o
		// usu�rio est� EDITANDO(UC AdicionarMulta) essa formata��o n�o �
		// necess�ria.
		if (valorMoeda.contains(",")) {
			retorno = valorMoeda.replace('.', ' ');
			retorno = retorno.replace(',', '.'); // Char ',' substitu�do por '.'
													// porque Float decimal char
													// � o '.' .
			retorno = retorno.replaceAll(" ", "");
		}
		return retorno.trim();
	}

	/**
	 * M�todo que formata valor Float p/ Moeda e assim habilitar a exibi��o da
	 * string correta.
	 * 
	 * @param valorMoeda
	 * @return
	 */
	public static String formataFloatParaString(Float valor) {
		String retorno = valor.toString();
		if (retorno.contains(".")) {
			retorno = retorno.replace('.', ',');
		}
		return retorno;
	}
	
	public static String formataValorSemArredondamento(Double valorCorrigido){
		
		int indexPonto = String.valueOf(valorCorrigido).indexOf(".");
		String depoisPonto;
		
		if(String.valueOf(valorCorrigido).substring(indexPonto+1, String.valueOf(valorCorrigido).length()).length() == 1){
			depoisPonto = String.valueOf(valorCorrigido).substring(indexPonto+1, indexPonto+2)+"0";
		}else{
			depoisPonto = String.valueOf(valorCorrigido).substring(indexPonto+1, indexPonto+3);
		}
		
		String novoValor = String.valueOf(valorCorrigido.intValue()).concat("."+depoisPonto); 
		
		return novoValor;
	}
	
	//M�todo para formata��o de CEP
	public static String formataCEP(String cep){
		cep = cep.substring(0, 5) + "-" + cep.substring(5);  	
		return cep;
	}
	
	//M�todo retorna (data atual - 365 dias)
	public static Date anoAnterior(){
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.getTime();
		calendar.add(Calendar.DAY_OF_YEAR, -365);
		return calendar.getTime();		
	}
	
	public static String formataValorSemArredondamento(BigDecimal valorCorrigido){
		
		int indexPonto = String.valueOf(valorCorrigido).indexOf(".");
		String depoisPonto;
		
		if(String.valueOf(valorCorrigido).substring(indexPonto+1, String.valueOf(valorCorrigido).length()).length() == 1){
			depoisPonto = String.valueOf(valorCorrigido).substring(indexPonto+1, indexPonto+2)+"0";
		}else{
			depoisPonto = String.valueOf(valorCorrigido).substring(indexPonto+1, indexPonto+3);
		}
		
		String novoValor = String.valueOf(valorCorrigido.intValue()).concat("."+depoisPonto); 
		
		return novoValor;
	}
	
	public static String formataMoeda(double vlr){
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(vlr);
	} 
	
	public static String formataMoeda(BigDecimal vlr){
		java.text.DecimalFormat df = new java.text.DecimalFormat("###,###,##0.00");
		return df.format(vlr);
	} 
	
	/**
	 * Formata cpf ou cnpj de acordo com os par�metros passados
	 * value = cpf/cnpj, size = tamanho do cpf/cnpj, tipo = CPF OU CNPJ
	 * @param value
	 * @param size
	 * @param tipo
	 * @return
	 * @throws ParseException
	 */
	public static String formataCPFCNPJ(String value, int size, String tipo) throws ParseException{
	     String result = value;  
	     String c = "0";
	    	    
	     while (result.length() < size) {  
	           result = c + result;  
	     }  
	     if(tipo.toString().equals("CPF")){
	    	 result = formataCPForCNPJ(result, "###.###.###-##");
	     }else result = formataCPForCNPJ(result, "##.###.###/####-##");  
	     
	     return result;      
	}
	
}
