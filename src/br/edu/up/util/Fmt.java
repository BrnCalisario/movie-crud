package br.edu.up.util;

import br.edu.up.model.Filme;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Fmt {

	public static String pularLinhas(int qntLinhas) {

		StringBuilder linhas = new StringBuilder();
		if (qntLinhas <= 0) {
			return linhas.toString();
		}

		for (int i = 0; i < qntLinhas; i++) {
			linhas.append("\n");
		}

		return linhas.toString();
	}

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}

		return true;
	}

	public static boolean isValid(String value, int optSize) {

		if (!isNumeric(value)) {
			return false;
		}

		int parsedValue = Integer.parseInt(value);
		return (parsedValue > 0) && (parsedValue <= optSize);
	}

	public static Object emCouch(Object string) {

		String new_str;
		try {
			new_str = String.valueOf(string);
		} catch (Exception e) {
			return string;
		}

		if (new_str == null) {
			return string;
		}

		return "[" + string + "]";
	}

	public static void print(String str) {
		System.out.print(str);
	}

	public static void println(String str){
		System.out.println(str);
	}


	public static List<String> getFields(Object o) {

		List<String> listaCampos = new ArrayList();
		Class<?> classeFilme = o.getClass();

		for(Field field : classeFilme.getDeclaredFields()) {
			listaCampos.add(field.getName());
		}

		return listaCampos;
	}


}
