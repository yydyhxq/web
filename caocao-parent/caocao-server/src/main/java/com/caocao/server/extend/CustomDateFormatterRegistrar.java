/*
 * Copyright 2009-2012 Evun Technology. 
 * 
 * This software is the confidential and proprietary information of
 * Evun Technology. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with evun.cn.
 */
package com.caocao.server.extend;

import java.util.Calendar;

import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;

/**
 * 扩展Spring日期注册类的实现
 * @author  xiaoyaoyao
 * @created 2014-6-4 下午4:20:39
 * @since   v2.1.2
 */
public class CustomDateFormatterRegistrar extends DateFormatterRegistrar {
	
	private DateFormatter dateFormatter;

	public void setFormatter(DateFormatter dateFormatter) {
		super.setFormatter(dateFormatter);
		this.dateFormatter = dateFormatter;
	}

	public void registerFormatters(FormatterRegistry registry) {
		addDateConverters(registry);
		if (this.dateFormatter != null) {
			registry.addFormatter(this.dateFormatter);
			registry.addFormatterForFieldType(Calendar.class, this.dateFormatter);
		}
		registry.addFormatterForFieldAnnotation(new DateTimeFormatAnnotationFormatterFactory());
	}
}