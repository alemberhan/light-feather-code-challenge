package com.lightfeather.code.util;

public class StringUtil {
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isNotEmpty(String str) {
		return (str != null && !str.trim().isEmpty());
	}
	
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().isEmpty());
	}

}
