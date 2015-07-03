package com.caocao.web.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndStr {

	public static String DateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
	
	public static String DateToStrHour(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}
	
	public static String Year(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String str = sdf.format(date);
		return str;
	}
	
	public static String Month(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String str = sdf.format(date);
		return str;
	}
}
