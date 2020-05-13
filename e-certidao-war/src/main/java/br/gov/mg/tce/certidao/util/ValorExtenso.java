package br.gov.mg.tce.certidao.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class ValorExtenso {
	
	private ArrayList nro;
	private BigInteger num;

	private String qualificadores[][] = {
			{ "centésimo percentual", "centésimos percentuais" }};
	private String numeros[][] = {
			{ "zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove" },
			{ "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa" },
			{ "cem"}};

	public ValorExtenso() {
		nro = new ArrayList();
	}

	public ValorExtenso(BigDecimal dec) {
		this();
		setNumber(dec);
	}

	public ValorExtenso(double dec) {
		this();
		setNumber(dec);
	}

	public void setNumber(BigDecimal dec) {
		// Converte para inteiro arredondando os centavos
		num = dec.setScale(2, BigDecimal.ROUND_HALF_UP)
				.multiply(BigDecimal.valueOf(100)).toBigInteger();

		// Adiciona valores
		nro.clear();
		if (num.equals(BigInteger.ZERO)) {
			// Centavos
			nro.add(new Integer(0));
			// Valor
			nro.add(new Integer(0));
		} else {
			// Adiciona centavos
			addRemainder(100);

			// Adiciona grupos de 1000
			while (!num.equals(BigInteger.ZERO)) {
				addRemainder(1000);
			}
		}
	}

	public void setNumber(double dec) {
		setNumber(new BigDecimal(dec));
	}

	private boolean ehPrimeiroGrupoUm() {
		if (((Integer) nro.get(nro.size() - 1)).intValue() == 1)
			return true;
		return false;
	}

	private void addRemainder(int divisor) {
		// Encontra newNum[0] = num modulo divisor, newNum[1] = num dividido
		// divisor
		BigInteger[] newNum = num.divideAndRemainder(BigInteger
				.valueOf(divisor));

		// Adiciona modulo
		nro.add(new Integer(newNum[1].intValue()));

		// Altera numero
		num = newNum[0];
	}

	private boolean temMaisGrupos(int ps) {
		for (; ps > 0; ps--) {
			if (((Integer) nro.get(ps)).intValue() != 0) {
				return true;
			}
		}

		return false;
	}

	private boolean ehUltimoGrupo(int ps) {
		return (ps > 0) && ((Integer) nro.get(ps)).intValue() != 0
				&& !temMaisGrupos(ps - 1);
	}

	private boolean ehUnicoGrupo() {
		if (nro.size() <= 3)
			return false;
		if (!ehGrupoZero(1) && !ehGrupoZero(2))
			return false;
		boolean hasOne = false;
		for (int i = 3; i < nro.size(); i++) {
			if (((Integer) nro.get(i)).intValue() != 0) {
				if (hasOne)
					return false;
				hasOne = true;
			}
		}
		return true;
	}

	boolean ehGrupoZero(int ps) {
		if (ps <= 0 || ps >= nro.size())
			return true;
		return ((Integer) nro.get(ps)).intValue() == 0;
	}

	public String valorExtenso() {
		StringBuffer buf = new StringBuffer();

		int numero = ((Integer) nro.get(0)).intValue();
		int ct;

		for (ct = nro.size() - 1; ct > 0; ct--) {
			buf.append(numToString(((Integer) nro.get(ct)).intValue(), ct, "inteiros"));
		}
		if (buf.length() > 0) {
			if (ehUnicoGrupo()) {
				buf.append(" de ");
			}
			while (buf.toString().endsWith(" ")) {
				buf.setLength(buf.length() - 1);
			}
			if (ehPrimeiroGrupoUm()) {
				buf.insert(0, "h");
			}
			if (nro.size() == 2 && ((Integer) nro.get(1)).intValue() == 1) {
				buf.append(" inteiro");
			} else {
				buf.append(" inteiros");
			}
			if (((Integer) nro.get(0)).intValue() != 0) {
				buf.append(" e ");
			}
		}
		if (((Integer) nro.get(0)).intValue() != 0) {
			buf.append(numToString(((Integer) nro.get(0)).intValue(), 0, "centesimos"));
		}
		return buf.toString();
	}

	
	private String numToString(int numero, int escala, String casas) {
		int unidade = (numero % 10);
		int dezena = (numero % 100);
		int centena = (numero / 100);
		StringBuffer buf = new StringBuffer();

		if (numero != 0) {
			if (centena != 0) {
				buf.append(numeros[2][0]);
			}

			if ((buf.length() > 0) && (dezena != 0)) {
				buf.append(" e ");
			}
			if (dezena > 19) {
				dezena /= 10;
				buf.append(numeros[1][dezena - 2]);
				if (unidade != 0) {
					buf.append(" e ");
					buf.append(numeros[0][unidade]);
				}
			} else if (centena == 0 || dezena != 0) {
				buf.append(numeros[0][dezena]);
			}

			if(casas.equalsIgnoreCase("centesimos")) {
				buf.append(" ");
				if (numero == 1) {
					buf.append(qualificadores[escala][0]);
				} else {
					buf.append(qualificadores[escala][1]);
				}
			}
		}
		return buf.toString();
	}

	public String toString() {
		Integer numeroInteiros = ((Integer) nro.get(1)).intValue();
		Integer numeroCentesimos = ((Integer) nro.get(0)).intValue();
		
		if(numeroInteiros != 0 && numeroCentesimos != 0) {
			return numeroInteiros.toString() + "," + numeroCentesimos.toString();
		} else if(numeroInteiros != 0) {
			return "0," + numeroInteiros.toString();
		} else if(numeroCentesimos != 0) {
			return numeroCentesimos.toString() + ",0";
		} else {
			return "0,0";
		}
	}
}