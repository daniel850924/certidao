package br.gov.mg.tce.certidao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends Date{

	
	private static final long serialVersionUID = 4316365515469017283L;
	private String dataFormatada = null;
	private Date data = null;
	private String dia ="";
	private String mes ="";
	private String ano="";
	private String hora="";
	private String Minutos="";
	private String mesTexto = "";
	
	public DateUtil(Date data) {
		super();
		this.data = data;
		String dataString = getDataInvertidaComMinutos();
		this.dia = dataString.substring(8,10);
		this.mes = dataString.substring(5,7);
		this.ano = dataString.substring(0,4);
		this.hora = dataString.substring(11,13);
		this.Minutos = dataString.substring(14,16);
	
	}
	
	public DateUtil(){
		
	}
	
	public DateUtil(long date){
		this.data = new Date(date);
	}
	
	@SuppressWarnings("unused")
	public static String retornaDataValida(String data){
	
	if(data.equalsIgnoreCase("")) return "";
	
		String ano = "";
		String mes = "";
		String dia = "";
		String hora = "";
		String minutos = "";
		String segundos = "00";
		
		boolean anoBoolean = false;
		boolean mesBoolean = false;
		boolean diaBoolean = false;
		boolean horaBoolean = false;
		boolean minutosBoolean = false;
		
		String resposta = "";
		
		for (char charRetorno : data.toCharArray()) {
			if(Character.isDigit(charRetorno)){
				if(!anoBoolean){
					ano+= charRetorno;
				}
				else if(!mesBoolean){
					mes += charRetorno;
				}
				else if(!diaBoolean){
					dia += charRetorno;
				}
				else if(!horaBoolean){
					hora += charRetorno;
				}
				else {
					minutos += charRetorno;
				}
			}
			else if(charRetorno == '/'){
				if(!anoBoolean){
					anoBoolean = true;
				}
				else if(!mesBoolean){
					mes = completaZeroEsquerda(2,mes);
					mesBoolean = true;
				}
			}
			else if(charRetorno == ' '){
				dia = completaZeroEsquerda(2,dia);
				diaBoolean = true;
			}
			else if(charRetorno == ':'){
				hora = completaZeroEsquerda(2, hora);
				horaBoolean  = true;
			}
		}
		
		minutos = completaZeroEsquerda(2,minutos);
		resposta = ano+"/"+mes+"/"+dia+" "+hora+":"+minutos;
		return resposta;
	}
	
	@SuppressWarnings("unused")
	public static String retornaDataParaPersistir(String data, boolean anoB,boolean mesB,boolean diaB,boolean horaB,boolean minutosB){
		
		String ano = "";
		String mes = "";
		String dia = "";
		String hora = "";
		String minutos = "";
		String segundos = "00";
		
		boolean anoBoolean = anoB;
		boolean mesBoolean = mesB;
		boolean diaBoolean = diaB;
		boolean horaBoolean = horaB;
		boolean minutosBoolean = minutosB;
		
		String resposta = "";
		
		for (char charRetorno : data.toCharArray()) {
			if(Character.isDigit(charRetorno)){
				if(!anoBoolean){
					ano+= charRetorno;
				}
				else if(!mesBoolean){
					mes += charRetorno;
				}
				else if(!diaBoolean){
					dia += charRetorno;
				}
				else if(!horaBoolean){
					hora += charRetorno;
				}
				else {
					minutos += charRetorno;
				}
			}
			else if(charRetorno == '/'){
				if(!anoBoolean){
					anoBoolean = true;
				}
				else if(!mesBoolean){
					mes = completaZeroEsquerda(2,mes);
					mesBoolean = true;
				}
			}
			else if(charRetorno == ' '){
				dia = completaZeroEsquerda(2,dia);
				diaBoolean = true;
			}
			else if(charRetorno == ':'){
				hora = completaZeroEsquerda(2, hora);
				horaBoolean  = true;
			}
		}
		
		minutos = completaZeroEsquerda(2,minutos);
		resposta = ano+"-"+mes+"-"+dia+" "+hora+":"+minutos+":"+segundos;
		return resposta;
	}
	
	public static String completaZeroEsquerda(int tamanho,String numero){
		while (tamanho > numero.length()) {
			numero = "0"+numero;		
		}
		return numero;
	}
	
	/*public DateUtil(String dataFormatada){
		if(dataFormatada == null || dataFormatada.equalsIgnoreCase("")){
			this.data = new Date();
		}
		else{		

			this.dia = dataFormatada.substring(8,10);
			this.mes = dataFormatada.substring(5,7);
			this.ano = dataFormatada.substring(0,4);
			this.hora = dataFormatada.substring(11,13);
			this.Minutos = dataFormatada.substring(14,16);
			GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.set(new Integer(ano), new Integer(mes)-1, new Integer(dia), new Integer(hora), new Integer(Minutos));
			this.data = gregorianCalendar.getTime();
			this.data = new Date(new Integer(ano), new Integer(mes), new Integer(dia), new Integer(hora), new Integer(Minutos));
		}
	}*/

	/**
	 * Método que retorna a data formatada no padrão ( dd/MM/yyyy )
	 * @return {@link String}
	 */
	public String getDataFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataFormatada =  sdf.format(data);
		return dataFormatada;
	}
	
	/**
	 * Método que retorna a data formatada no padrão ( dd/MM/yyyy )
	 * @return {@link String}
	 */
	public static String getDataFormatada(Date dataSemFormatacao,String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String formatada =  sdf.format(dataSemFormatacao);
		return formatada;
	}
	
	/**
	 * Método que retorna a data formatada no padrão ( dd/MM/yyyy )
	 * @return {@link String}
	 */
	public String getDataFormatadaComMinutos() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dataFormatada =  sdf.format(data);

		return dataFormatada;
	}
	
	/**
	 * Método que retorna o ano ( dd/MM/yyyy )
	 * @return {@link String}
	 */
	public String getAno() {
		if (ano == null||ano.equalsIgnoreCase("")){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			ano =  sdf.format(data);
		}
		return ano;
	}

	/**
	 * Método para setar a data formatada no objeto
	 * @param dataFormatada {@link void}
	 */
	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

	/**
	 * Método que retorna a data
	 * @return {@link Date}
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Metodo para setar a data
	 * @param Date - data {@link void}
	 */
	public void setData(Date data) {
		this.data = data;
	}
	
	/**
	 * Método que retorna a data invertida no padrão ( yyyy/MM/dd )
	 * @return {@link String}
	 */
	public String getDataInvertida() {
		if (dataFormatada == null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			dataFormatada =  sdf.format(data);
		}
		return dataFormatada;
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	public Date compararDataExpediente(){
		String dataString = this.getDataFormatadaComMinutos();
		Integer horas = new Integer(this.data.getHours());
		Date date = new Date();
		long MilisegundosFimExpediente = 18 * 3600 * 1000;
		long MilisegundosAtuais = date.getHours() * 3600 * 1000;
		MilisegundosAtuais+= date.getMinutes() * 60 * 1000;
		long MilisegundosAtuaisSLA = this.data.getHours() * 3600 * 1000;
		MilisegundosAtuaisSLA+= this.data.getMinutes() * 60 * 1000;
		long MilisegundosComplementares = 14 * 3600 * 1000;
		MilisegundosComplementares -= MilisegundosAtuais;
		long MilisegundosResposta = MilisegundosAtuaisSLA - MilisegundosFimExpediente;
		if(horas >= 18){
			MilisegundosResposta += MilisegundosComplementares;
			MilisegundosResposta +=MilisegundosFimExpediente;
			date = new Date(date.getTime() + MilisegundosResposta);
		}
		else{
			date = new Date(this.data.getTime());
		}
		
		return date;
	}
	
	public String getDataInvertidaComMinutos() {
		if (dataFormatada == null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dataFormatada =  sdf.format(data);
		}
		return dataFormatada;
	}
	
	public Date CoverteStringData(String data) throws Exception{
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		@SuppressWarnings("unused")
		Date date = new Date();
        try {
			date = (java.util.Date)formatter.parse(data);
			
		} catch (ParseException e) {
			throw new Exception(e);
		}
		
		return date;
	}
	
	public Date CoverteStringDataFormatada(String data) throws Exception{
		
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
        try {
			date = (java.util.Date)formatter.parse(data);
			
		} catch (ParseException e) {
			throw new Exception(e);
		}
		
		return date;
	}
	
	public static Date CoverteStringDataFormatadaMesAno(String data) throws Exception{
		
		DateFormat formatter = new SimpleDateFormat("MM/yyyy");

		Date date = new Date();
        try {
			date = (java.util.Date)formatter.parse(data);
			
		} catch (ParseException e) {
			throw new Exception(e);
		}
		
		return date;
	}
	
	public Date CoverteStringDataInvertida(String data) throws Exception{
		
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		@SuppressWarnings("unused")
		Date date = new Date();
        try {
			date = (java.util.Date)formatter.parse(data);
			
		} catch (ParseException e) {
			throw new Exception(e);
		}
		
		return null;
	}
	
	public static Date CoverteStringDataBanco(String data) throws Exception{
		
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		@SuppressWarnings("unused")
		Date date = new Date();
        try {
			date = (java.util.Date)formatter.parse(data);
			
		} catch (ParseException e) {
			throw new Exception(e);
		}
		
		return date;
	}
	
	/*public static boolean validaData(String string){
		DateUtil data = new DateUtil(string);
		return validaData(data);
	}*/
	
	
	public static boolean validaData(DateUtil data){
		
		Integer dia;
		Integer mes;
		Integer hora;
		Integer minutos;
		 if(!EhNumero(data.getDia())){
			 return false;
		 }else if(!EhNumero(data.getMes())){
			 return false;
		 }else if(!EhNumero(data.getAno())){
			 return false;
		 }else if(!EhNumero(data.getHora())){
			 return false;
		 }else if(!EhNumero(data.getMinutos())){
			 return false;
		 }
		 
		 dia = new Integer(data.getDia());
		 mes = new Integer(data.getMes());
		 hora = new Integer(data.getHora());
		 minutos = new Integer(data.getMinutos());
		 
		 if(mes > 12 || mes <= 0){
			 return false;
		 }	 
		 else if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
			 if(!(dia <= 31 && dia > 0)){
				 return false;
			 }
		 }
		 else if(mes == 2){
			 if(ehBisexto(data.getAnoString())){
				 if(!(dia <= 29 && dia > 0)){
					 return false;
				 }
			 }
			 else{
				 if(!(dia <= 28 && dia > 0)){
					 return false;
				 }
			 }
		 }
		 else if(!(dia <= 30 && dia >0)){
			 return false;
		 }
		 if(hora >23 || hora < 0){
			 return false;
		 }
		 if(minutos > 60 || minutos < 0){
			 return false;
		 }
		/* Data dataAtual = new Data(new Date());
		 dataAtual = new Data(dataAtual.getDataInvertidaComMinutos());
		 if(!ehDepois(data, dataAtual))
			 return false;*/
		 return true;
	}
	
	public static boolean ehBisexto(String ano){
		Integer anoInt = new Integer(ano);
		if(anoInt%400 == 0){
			return true;
		}
		else if(anoInt%4 == 0 && anoInt%100 != 0){
			return true;
		}
		return false;
	}

	
	public static boolean EhNumero(String valor){
		for(int i = 0; i < valor.length(); i++){
	        Character caractere = valor.charAt(i);
	        if(!Character.isDigit(caractere)){
	            return false;
	        }
	    }  
		return true;
	}
	
	public static boolean ehDepois(DateUtil maior, DateUtil menor){
		
		if(new Integer(menor.getAnoString())>new Integer(maior.getAnoString())){
			return false;
		}
		else if(new Integer(maior.getAnoString())>new Integer(menor.getAnoString())){
			return true;
		}
		else{
			
			if(new Integer(menor.getMes())>new Integer(maior.getMes())){
				return false;
			}
			else if(new Integer(maior.getMes())>new Integer(menor.getMes())){
				return true;
			}
			else{
				
				if(new Integer(menor.getDia())>new Integer(maior.getDia())){
					return false;
				}
				else if(new Integer(maior.getDia())>new Integer(menor.getDia())){
					return true;
				}
				else{
					if(new Integer(menor.getHora())>new Integer(maior.getHora())){
						return false;
					}
					else if(new Integer(maior.getHora())>new Integer(menor.getHora())){
						return true;
					}
					else{
						if(new Integer(menor.getMinutos())>new Integer(maior.getMinutos())){
							return false;
						}
						else if(new Integer(maior.getMinutos())>new Integer(menor.getMinutos())){
							return true;
						}
						else{
							return false;
						}
					}
				}
			}
		}
		
	}
	
	public DateUtil formataData(DateUtil data){
		
		if(data.getDia().length()==1){
			data.setDia("0"+data.getDia());
		}
		if(data.getMes().length() == 1){
			data.setMes("0"+data.getMes());
		}
		if(data.getHora().length() == 1){
			data.setHora("0"+data.getHora());
		}
		if(data.getMinutos().length() == 1){
			data.setMinutos("0"+data.getMinutos());
		}
		return data;
	}
	
	public static String diferencaEmHoras(DateUtil dataInicial,DateUtil dataFinal){
		long diferenca = dataFinal.getData().getTime() - dataInicial.getData().getTime();
		long diferencaEmHoras = (diferenca/1000)/60/60;
		long minutosRestantes = (diferenca/1000)/60%60;
		String horas = diferencaEmHoras+"";
		if(horas.length() == 1) horas = "0"+horas;
		String minutos = minutosRestantes+"";
		if(minutos.length() == 1) minutos = "0"+minutos;
		return horas+":"+minutos;
		
	}
	
	public static String diferencaEmDias(DateUtil dataInicial,DateUtil dataFinal){

		long diferenca = dataFinal.getData().getTime() - dataInicial.getData().getTime();
		long diferencaEmDias = (diferenca/1000)/60/60/24;
		/*long minutosRestantes = (diferenca/1000)/60/60%24;*/
		/*String horas = diferencaEmHoras+"";
		if(horas.length() == 1) horas = "0"+horas;
		String minutos = minutosRestantes+"";
		if(minutos.length() == 1) minutos = "0"+minutos;*/
		return ""+diferencaEmDias;
		
	}
	
	
	public String getAnoString(){
		return ano;
	}

	public String getDia() {
		if(dia != null && dia.length() == 1) return "0"+dia;
		return dia;
	}

	public String getMes() {
		if(mes != null && mes.length() == 1) return "0"+mes;
		return mes;
	}

	public String getHora() {
		if(hora != null && hora.length() == 1) return "0"+hora;
		return hora;
	}

	public String getMinutos() {
		if(Minutos != null && Minutos.length() == 1) return "0"+Minutos;
		return Minutos;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setMinutos(String minutos) {
		Minutos = minutos;
	}

	public String getMesTexto() {
		if(mes != null){
			if(mes.equalsIgnoreCase("1")||mes.equalsIgnoreCase("01")){
				return "Janeiro";
			}
			else if(mes.equalsIgnoreCase("2")||mes.equalsIgnoreCase("02")){
				return "Fevereiro";
			}
			else if(mes.equalsIgnoreCase("3")||mes.equalsIgnoreCase("03")){
				return "Março";
			}
			else if(mes.equalsIgnoreCase("4")||mes.equalsIgnoreCase("04")){
				return "Abril";
			}
			else if(mes.equalsIgnoreCase("5")||mes.equalsIgnoreCase("05")){
				return "Maio";
			}
			else if(mes.equalsIgnoreCase("6")||mes.equalsIgnoreCase("06")){
				return "Junho";
			}
			else if(mes.equalsIgnoreCase("7")||mes.equalsIgnoreCase("07")){
				return "Julho";
			}
			else if(mes.equalsIgnoreCase("8")||mes.equalsIgnoreCase("08")){
				return "Agosto";
			}
			else if(mes.equalsIgnoreCase("9")||mes.equalsIgnoreCase("09")){
				return "Setembro";
			}
			else if(mes.equalsIgnoreCase("10")){
				return "Outubro";
			}
			else if(mes.equalsIgnoreCase("11")){
				return "Novembro";
			}
			else if(mes.equalsIgnoreCase("12")){
				return "Dezembro";
			}
		}
		return mesTexto;
	}

	public void setMesTexto(String mesTexto) {
		this.mesTexto = mesTexto;
	}
	
	/**
	 * 
	 * @param data
	 * @param formato
	 * @return
	 * @throws ParseException
	 */
	public static String formataData(String data, String formato) throws ParseException{
		
		if( data != null && ! data.equals("null") ){
			
			SimpleDateFormat formato1 = new SimpleDateFormat(formato);   
			SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
			
			return formato2.format(formato1.parse(data));
		}
		return "";
			
	}

	public static String formataData(Date data, String formato) {
		
		SimpleDateFormat formato1 = new SimpleDateFormat(formato);
		
		return formato1.format(data).toString();
	}
	
	/**
	 * 
	 * @param data
	 * @param formato
	 * @return
	 * @throws ParseException
	 */
	public static boolean dataMaiorDataAtual(String data, String formato){
		
		if( data != null  ){
			
			try {
				SimpleDateFormat formato1 = new SimpleDateFormat(formato);   

				if(formato1.parse(data).after(new Date())){
					return true;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return false;
			
	}
	
    public static Integer mesesEntre(Date ini , Date fim ){  
        Calendar dataInicial = Calendar.getInstance();  
        dataInicial.setTime(ini);
        
        Calendar dataFinal = Calendar.getInstance();  
        dataFinal.setTime(fim);
        
        int count = 0;  
        
        dataInicial.add(Calendar.MONTH, 1);
          
        while (dataInicial.getTime().before(dataFinal.getTime())){  
        	dataInicial.add(Calendar.MONTH, 1);            
            count ++;  
        }  
          
        return count;  
          
        }  
    
    public static Date somarDias(Date date, Integer numDias){
    	Calendar calendar = Calendar.getInstance();  
    	calendar.setTime(date);
    	calendar.add(Calendar.DAY_OF_YEAR, numDias);
    	
    	return calendar.getTime();
    }
    
    //retorna o dia da semana dada uma data  
	public static String retornarDiaSemana(Date date) {
		return pesquisarDiaSemana(date.getDay()+1);
	}

	// faz a pesquisa, dado um inteiro de 1 a 7
	public static String pesquisarDiaSemana(int dia) {
		String diaSemana = null;

		switch (dia) {

			case 1: {
				diaSemana = "domingo";
				break;
			}
			case 2: {
				diaSemana = "segunda-feira";
				break;
			}
			case 3: {
				diaSemana = "terça-feira";
				break;
			}
			case 4: {
				diaSemana = "quarta-feira";
				break;
			}
			case 5: {
				diaSemana = "quinta-feira";
				break;
			}
			case 6: {
				diaSemana = "sexta-feira";
				break;
			}
			case 7: {
				diaSemana = "sábado";
				break;
			}

		}
		return diaSemana;
	}  
	
	public static String obterMesString(Date date) {
		String mes = null;
		
		switch (date.getMonth() + 1) {
			case 1: {
				mes = "Janeiro";
				break;
			}
			case 2: {
				mes = "Fevereiro";
				break;
			}
			case 3: {
				mes = "Março";
				break;
			}
			case 4: {
				mes = "Abril";
				break;
			}
			case 5: {
				mes = "Maio";
				break;
			}
			case 6: {
				mes = "Junho";
				break;
			}
			case 7: {
				mes = "Julho";
				break;
			}
			case 8: {
				mes = "Agosto";
				break;
			}
			case 9: {
				mes = "Setembro";
				break;
			}
			case 10: {
				mes = "Outubro";
				break;
			}
			case 11: {
				mes = "Novembro";
				break;
			}
			case 12: {
				mes = "Dezembro";
				break;
			}
		}
		return mes;
	}
	
	public String retornaStringAnoMesDia(String dataFormatoBrasil) {
    	if(!dataFormatoBrasil.equals("")) {
    		
    		if(dataFormatoBrasil.length() == 19) {
    			hora = dataFormatoBrasil.substring(11, dataFormatoBrasil.length());
    			dataFormatoBrasil = dataFormatoBrasil.substring(0,10);
    			String[] datas = dataFormatoBrasil.split("/");
    			String[] horas = hora.split(":");
    			return datas[2] + datas[1] + datas[0] + horas[0] + horas[1] + horas[2];
    		}
	    	String[] unidades = dataFormatoBrasil.split("/");
	    	return unidades[2] + unidades[1] + unidades[0];
    	}
    	return "";
    }
	
	public static boolean estaNoIntervalo(Calendar data, Calendar dataInicioPeriodo, Calendar dataFimPeriodo, boolean consideraMesmoDia){ 
		if(data==null){
			return false;
		}
		//verifica se a data esta no intervalo de um periodo, sem considerar os extremos
		if(data.after(dataInicioPeriodo) && (dataFimPeriodo==null||data.before(dataFimPeriodo))){
			return true;
		}
		//verifica se a data esta no intervalo de um perï¿½odo considerando os extremos.
		if(consideraMesmoDia==true){
			if(mesmoDia(data, dataInicioPeriodo) || dataFimPeriodo!=null && DateUtil.mesmoDia(data, dataFimPeriodo)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean mesmoDia(Calendar data1, Calendar data2) {
		if(data1==null&&data2==null){
			return true;
		}
		if(data1==null||data2==null){
			return false;
		}
		if(data1.equals(data2)){
			return true;
		}
		return false;
	}	
	
	public static boolean estaNoIntervalo(Date data, Date dataInicioPeriodo, Date dataFimPeriodo, boolean consideraMesmoDia){ 
		if(data==null){
			return false;
		}
		//verifica se a data esta no intervalo de um periodo, sem considerar os extremos
		if(data.after(dataInicioPeriodo) && (dataFimPeriodo==null||data.before(dataFimPeriodo))){
			return true;
		}
		//verifica se a data esta no intervalo de um perï¿½odo considerando os extremos.
		if(consideraMesmoDia==true){
			if(mesmoDia(data, dataInicioPeriodo) || dataFimPeriodo!=null && DateUtil.mesmoDia(data, dataFimPeriodo)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean mesmoDia(Date data1, Date data2) {
		if(data1==null&&data2==null){
			return true;
		}
		if(data1==null||data2==null){
			return false;
		}
		if(formatoPadrao(data1).equals(formatoPadrao(data2))){
			return true;
		}
		return false;
	}
	
	public static String formatoPadrao(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}
}
