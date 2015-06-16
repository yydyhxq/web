/*
 * Copyright 2009-2012 Evun Technology. 
 * 
 * This software is the confidential and proprietary information of
 * Evun Technology. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with evun.cn.
 */
package com.caocao.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.ComparatorUtils;
import org.apache.commons.collections4.comparators.ComparatorChain;



/**
 * Collections工具集.
 * 
 * 在JDK的Collections和Guava的Collections2后, 命名为Collections3.
 * 
 * 函数主要由两部分组成，一是自反射提取元素的功能，二是源自Apache Commons Collection, 争取不用在项目里引入它。
 * 
 * @author calvin
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CollectionUtils {

	/**
	 * 正序
	 */
	public static final String SORT_ORDER_ASC = "asc";

	/**
	 * 逆序
	 */
	public static final String SORT_ORDER_DESC = "desc";

	/**
	 * 提取集合中的对象的两个属性(通过Getter函数), 组合成Map.
	 * 
	 * @param collection
	 *            来源集合.
	 * @param keyPropertyName
	 *            要提取为Map中的Key值的属性名.
	 * @param valuePropertyName
	 *            要提取为Map中的Value值的属性名.
	 */
	public static Map extractToMap(final Collection collection,
			final String keyPropertyName, final String valuePropertyName) {
		Map map = new HashMap(collection.size());

		try {
			for (Object obj : collection) {
				map.put(BeanUtils.getProperty(obj, keyPropertyName),
						BeanUtils.getProperty(obj, valuePropertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}

	/**
	 * 提取集合中的对象的一个属性(通过Getter函数), 组合成List.
	 * 
	 * @param collection
	 *            来源集合.
	 * @param propertyName
	 *            要提取的属性名.
	 */
	public static List extractToList(final Collection collection,
			final String propertyName) {
		List list = new ArrayList(collection.size());

		try {
			for (Object obj : collection) {
				list.add(BeanUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return list;
	}

	/**
	 * 提取集合中的对象的一个属性(通过Getter函数), 组合成由分割符分隔的字符串.
	 * 
	 * @param collection
	 *            来源集合.
	 * @param propertyName
	 *            要提取的属性名.
	 * @param separator
	 *            分隔符.
	 */
	public static String extractToString(final Collection collection,
			final String propertyName, final String separator) {
		List list = extractToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	/**
	 * 转换Collection所有元素(通过toString())为String, 中间以 separator分隔。
	 */
	public static String convertToString(final Collection collection,
			final String separator) {
		return StringUtils.join(collection, separator);
	}

	/**
	 * 转换Collection所有元素(通过toString())为String,
	 * 每个元素的前面加入prefix，后面加入postfix，如<div>mymessage</div>。
	 */
	public static String convertToString(final Collection collection,
			final String prefix, final String postfix) {
		StringBuilder builder = new StringBuilder();
		for (Object o : collection) {
			builder.append(prefix).append(o).append(postfix);
		}
		return builder.toString();
	}

	/**
	 * 判断是否为空.
	 */
	public static boolean isEmpty(Collection collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * 判断是否为空.
	 */
	public static boolean isNotEmpty(Collection collection) {
		return (collection != null && !(collection.isEmpty()));
	}

	/**
	 * 取得Collection的第一个元素，如果collection为空返回null.
	 */
	public static <T> T getFirst(Collection<T> collection) {
		if (isEmpty(collection)) {
			return null;
		}

		return collection.iterator().next();
	}

	/**
	 * 获取Collection的最后一个元素 ，如果collection为空返回null.
	 */
	public static <T> T getLast(Collection<T> collection) {
		if (isEmpty(collection)) {
			return null;
		}

		// 当类型为List时，直接取得最后一个元素 。
		if (collection instanceof List) {
			List<T> list = (List<T>) collection;
			return list.get(list.size() - 1);
		}

		// 其他类型通过iterator滚动到最后一个元素.
		Iterator<T> iterator = collection.iterator();
		while (true) {
			T current = iterator.next();
			if (!iterator.hasNext()) {
				return current;
			}
		}
	}

	/**
	 * 返回a+b的新List.
	 */
	public static <T> List<T> union(final Collection<T> a, final Collection<T> b) {
		List<T> result = new ArrayList<T>(a);
		result.addAll(b);
		return result;
	}

	/**
	 * 返回a-b的新List.
	 */
	public static <T> List<T> subtract(final Collection<T> a,
			final Collection<T> b) {
		List<T> list = new ArrayList<T>(a);
		for (T element : b) {
			list.remove(element);
		}

		return list;
	}

	/**
	 * 返回a与b的交集的新List.
	 */
	public static <T> List<T> intersection(Collection<T> a, Collection<T> b) {
		List<T> list = new ArrayList<T>();

		for (T element : a) {
			if (b.contains(element)) {
				list.add(element);
			}
		}
		return list;
	}

	/**
	 * Return <code>true</code> if the supplied Map is <code>null</code> or
	 * empty. Otherwise, return <code>false</code>.
	 * 
	 * @param map
	 *            the Map to check
	 * @return whether the given Map is empty
	 */
	public static boolean isEmpty(Map map) {
		return (map == null || map.isEmpty());
	}

	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of Objects is not empty or not {@code null}.
	 * </p>
	 *
	 * @param <T>
	 *            the component type of the array
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return (array != null && array.length != 0);
	}

	public static boolean isEmpty(int[] array) {
		return array == null || array.length == 0;
	}

	public static boolean isNotEmpty(int[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * <p>
	 * Checks if an array of primitive bytes is empty or {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is empty or {@code null}
	 * @since 2.1
	 */
	public static boolean isEmpty(byte[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * <p>
	 * Checks if an array of primitive bytes is not empty or not {@code null}.
	 * </p>
	 *
	 * @param array
	 *            the array to test
	 * @return {@code true} if the array is not empty or not {@code null}
	 * @since 2.5
	 */
	public static boolean isNotEmpty(byte[] array) {
		return (array != null && array.length != 0);
	}

	/**
	 * 方法名称：sortTheList 内容摘要：根据指定的字段数组对List中的对象进行排序
	 * 
	 * @param list
	 * @param sortFields
	 * @param sortOrder
	 */
	public static void sortTheList(List list, String[] sortFields,
			String sortOrder) {
		if (sortFields == null || sortFields.length <= 0) {
			return;
		}

		ArrayList sorts = new ArrayList();

		Comparator c = ComparatorUtils.NATURAL_COMPARATOR;
		c = ComparatorUtils.nullLowComparator(c); // 允许null
		if (StringUtils.isEquals(sortOrder, CollectionUtils.SORT_ORDER_DESC)) {
			c = ComparatorUtils.reversedComparator(c); // 逆序
		}
		
		String sortField = null;
		for (int i = 0; i < sortFields.length; i++) {
			sortField = sortFields[i];
			if (StringUtils.isNotEmpty(sortField)) {
				sorts.add(new BeanComparator(sortField, c));
			}
		}

		ComparatorChain multiSort = new ComparatorChain(sorts);

		Collections.sort(list, multiSort);
	}

	/**
	 * 方法名称：sortTheList 内容摘要：根据指定的字段对List中的对象进行排序
	 * 
	 * @param list
	 * @param sortFiled
	 * @param sortOrder
	 */
	public static void sortTheList(List list, String sortFiled, String sortOrder) {
		if (StringUtils.isEmpty(sortFiled)) {
			return;
		}

		String[] sortFields = new String[] { sortFiled };

		sortTheList(list, sortFields, sortOrder);
	}
	
	public static void orderByDesc(List list, String sortFiled){
		sortTheList(list, sortFiled, CollectionUtils.SORT_ORDER_DESC);
	}
	
	public static void orderByAsc(List list, String sortFiled){
		sortTheList(list, sortFiled, CollectionUtils.SORT_ORDER_ASC);
	}
}
