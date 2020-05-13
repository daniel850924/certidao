package br.gov.mg.tce.util;

import java.text.DecimalFormat;

public class NumberUtil {

	public static String formartDoubleDuasCasas(Double valor){
		DecimalFormat df = new DecimalFormat();
        df.applyPattern("#,##0.00");
        return df.format(valor);
	}
}
