package com.caocao.web.constant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndStr {

	public static String DateToStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}
}
