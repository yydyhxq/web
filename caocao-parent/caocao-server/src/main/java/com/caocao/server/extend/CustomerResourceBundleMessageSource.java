package com.caocao.server.extend;

import com.caocao.util.CollectionUtils;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.caocao.util.StringUtils;


public class CustomerResourceBundleMessageSource extends ResourceBundleMessageSource {

	@Override
	public void setBasenames(final String... basenames) {
		List<String> list = new LinkedList<String>();
		if (CollectionUtils.isEmpty(basenames))
			return;
		for (String baseName : basenames) {
			if (StringUtils.isEmpty(baseName))
				continue;
			String[] bases = StringUtils.split(baseName, ',');
			for (String base : bases) {
				list.add("classpath:i18n/"+base);
			}
		}
		String[] bases = new String[list.size()];
		list.toArray(bases);
		list.clear();
		list = null;
		super.setBasenames(bases);
	}
}