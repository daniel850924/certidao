package br.gov.mg.tce.business.sicom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.persistence.Query;

import br.gov.mg.tce.dto.MunicipioJson;
import br.gov.mg.tce.util.PropertiesUtil;
import br.gov.mg.tce.util.PropertiesVariaveisEnum;
import br.gov.mg.tcemg.enumerador.TipoChamadaRestEnum;
import br.gov.mg.tcemg.rest.RestUtil;
import br.gov.mg.tcemg.util.DateUtil;

import com.google.gson.Gson;

public class SicomUtil {

	public static boolean isMunicipioAdimplente(Long codMunicipioIbge){
		boolean isAdimplente = true;
		
		try {
			Gson gson = new Gson();
			RestUtil restUtil = new RestUtil();
			MunicipioJson municipioJson = new MunicipioJson(codMunicipioIbge, DateUtil.getAnoData());
			String jsonParameter = gson.toJson(municipioJson);
			String jsonRetorno = restUtil.executarChamadaRest(PropertiesUtil.getInstance().getPropertieValue(PropertiesVariaveisEnum.URL_SICOM_REST) + "municipio/isMunicipioAdimplente/", 
					jsonParameter, TipoChamadaRestEnum.POST);
			isAdimplente = Boolean.valueOf(gson.fromJson(jsonRetorno, String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return isAdimplente;
	}
	
	public static String getSqlBI(String nomeArquivoSql) throws IOException {
		
		InputStream inputStream = SicomUtil.class.getResourceAsStream("/consultasSicomBI/" + nomeArquivoSql);
		
		StringBuilder sql = new StringBuilder();
		try (Reader reader = new BufferedReader(new InputStreamReader
		  (inputStream, Charset.forName(StandardCharsets.ISO_8859_1.name())))) {
		    int c = 0;
		    while ((c = reader.read()) != -1) {
		    	sql.append((char) c);
		    }
		}
		
		return sql.toString();
	}
	
	public static void setDataSelecionada(Query nativeQuery){
		Date hoje = DateUtil.getDataAtualDescartandoHoras();
		Date ontem = DateUtil.subtraiDias(hoje, 1);
		String ontemFormatoPadrao = DateUtil.formatoPadrao(ontem);
		nativeQuery.setParameter("dataSelecionada",  ontemFormatoPadrao);
	}
}
