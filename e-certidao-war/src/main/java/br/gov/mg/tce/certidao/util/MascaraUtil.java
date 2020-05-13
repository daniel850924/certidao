/**
 * 
 */
package br.gov.mg.tce.certidao.util;


/**
 * @author dasilva
 *
 */
public class MascaraUtil {
	
	public static boolean EhNumero(String valor){
		for(int i = 0; i < valor.length(); i++){
	        Character caractere = valor.charAt(i);
	        if(!Character.isDigit(caractere)){
	            return false;
	        }
	    }  
		return true;
	}
	/*
	 * realiza a formatação do valor de acordo com a mascara enviada
	 */
	public static String formatar(String valor, String mascara) {

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
	
	public static boolean cpfValido(String cpfDigitado) {
		boolean retorno = true;
		
		int iDigito1Aux = 0, iDigito2Aux = 0, iDigitoCPF;
		int iDigito1 = 0, iDigito2 = 0, iRestoDivisao = 0;
		String strDigitoVerificador, strDigitoResultado;

		try {
			cpfDigitado = cpfDigitado.replace(".", "");
			cpfDigitado = cpfDigitado.replace("-", "");
			
			if (cpfDigitado.equals("00000000000") || cpfDigitado.equals("11111111111") || cpfDigitado.equals("22222222222") || cpfDigitado.equals("33333333333") || 
					cpfDigitado.equals("44444444444") || cpfDigitado.equals("55555555555") || cpfDigitado.equals("66666666666") || cpfDigitado.equals("77777777777") || 
					cpfDigitado.equals("88888888888") || cpfDigitado.equals("99999999999")) {
				return false;
			}
			
			for (int iCont = 1; iCont < cpfDigitado.length() - 1; iCont++) {
				iDigitoCPF = Integer.valueOf(cpfDigitado.substring(iCont - 1, iCont)).intValue();
				iDigito1Aux = iDigito1Aux + (11 - iCont) * iDigitoCPF;
				iDigito2Aux = iDigito2Aux + (12 - iCont) * iDigitoCPF;
			}
			iRestoDivisao = (iDigito1Aux % 11);
			
			if (iRestoDivisao < 2) {
				iDigito1 = 0;
			} else {
				iDigito1 = 11 - iRestoDivisao;
			}
			
			iDigito2Aux += 2 * iDigito1;
			iRestoDivisao = (iDigito2Aux % 11);
			
			if (iRestoDivisao < 2) {
				iDigito2 = 0;
			} else {
				iDigito2 = 11 - iRestoDivisao;
			}
			
			strDigitoVerificador = cpfDigitado.substring(cpfDigitado.length() - 2, cpfDigitado.length());
			strDigitoResultado = String.valueOf(iDigito1) + String.valueOf(iDigito2);
			retorno = strDigitoVerificador.equals(strDigitoResultado);
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;
	}
	
	public static boolean validaCNPJ(String strCNPJ) {
	    int iSoma = 0, iDigito;
	    char[] chCaracteresCNPJ;
	    String strCNPJ_Calculado;
	 
	    if (! strCNPJ.substring(0,1).equals("")){
	        try{
	            strCNPJ=strCNPJ.replace('.',' ');
	            strCNPJ=strCNPJ.replace('/',' ');
	            strCNPJ=strCNPJ.replace('-',' ');
	            strCNPJ=strCNPJ.replaceAll(" ","");
	            strCNPJ_Calculado = strCNPJ.substring(0,12);
	            if ( strCNPJ.length() != 14 ) return false;
	            chCaracteresCNPJ = strCNPJ.toCharArray();
	            for(int i = 0; i < 4; i++) {
	                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i] - 48 ) * (6 - (i + 1)) ;
	                }
	            }
	            for( int i = 0; i < 8; i++ ) {
	                if ((chCaracteresCNPJ[i+4]-48 >= 0) && (chCaracteresCNPJ[i+4]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i+4] - 48 ) * (10 - (i + 1)) ;
	                }
	            }
	            iDigito = 11 - (iSoma % 11);
	            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
	               /* Segunda parte */
	            iSoma = 0;
	            for (int i = 0; i < 5; i++) {
	                if ((chCaracteresCNPJ[i]-48 >= 0) && (chCaracteresCNPJ[i]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1)) ;
	                }
	            }
	            for (int i = 0; i < 8; i++) {
	                if ((chCaracteresCNPJ[i+5]-48 >= 0) && (chCaracteresCNPJ[i+5]-48 <= 9)) {
	                    iSoma += (chCaracteresCNPJ[i+5] - 48) * (10 - (i + 1)) ;
	                }
	            }
	            iDigito = 11 - (iSoma % 11);
	            strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
	            return strCNPJ.equals(strCNPJ_Calculado);
	        } catch (Exception e) {
	            return false;
	        }
	    } else return false;
	}
	
	public static String retiraMascaraCpfCnpj(String cpfCnpj){
		String retorno = "";
		try{
			retorno = cpfCnpj;
			retorno = retorno.replace(".", "");
			retorno = retorno.replace("-", "");
			retorno = retorno.replace("/", "");
			
		}catch (Exception e) {

			retorno = "";
		}
		
		return retorno;
	}

}
