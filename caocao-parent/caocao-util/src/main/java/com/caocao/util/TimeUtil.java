package com.caocao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getTimeStap() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return dateformat.format(new Date());
	}
}
