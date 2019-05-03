package com.qltv.bll;

public class MyMatchet {
	public static boolean Chet(String regex,String line) {
		return line.matches(regex);
	}
	public static int ConvertMathe(String mathe) {
		return Integer.parseInt( mathe.replace("DG", ""));
	}
	public static int ConvertMasach(String masach) {
		return Integer.parseInt( masach.replace("MS", ""));
	}
	public static int ConvertMapm(String mapm) {
		return Integer.parseInt( mapm.replace("PM",""));
	}
	public static int ConvertMapt(String mapt) {
		return Integer.parseInt( mapt.replace("PT",""));
	}
	public interface Myregex{
		String MATHE = "^(DG)[0-9][0-9][0-9][0-9][0-9][0-9]";
		String MASACH = "^(MS)[0-9][0-9][0-9][0-9][0-9][0-9]";
		String MAPM = "^(PM)[0-9][0-9][0-9][0-9][0-9][0-9]";
		String MAPT = "^(PT)[0-9][0-9][0-9][0-9][0-9][0-9]";
		String EMAIL = ".+@.+\\..+";
	}
}
