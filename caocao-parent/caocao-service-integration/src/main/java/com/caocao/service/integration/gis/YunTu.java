package com.caocao.service.integration.gis;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caocao.service.integration.sms.MessageFactory;
import com.caocao.util.JsonUtil;

public class YunTu {
	private static final Logger logger = LoggerFactory.getLogger(YunTu.class);
	public static final String insertUrl = "http://yuntuapi.amap.com/datamanage/data/create";
	public static final String updateUrl = "http://yuntuapi.amap.com/datamanage/data/update";
	public static final String deleteUrl = "http://yuntuapi.amap.com/datamanage/data/delete";
	public static boolean insert(DataDto dto) {
		boolean result = false;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(insertUrl);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		post.addParameter("key", "155a5c83e7f05f153a05ad54f80836f2");
		post.addParameter("tableid", "557ab3c3e4b062df8bc978b4");
		post.addParameter("loctype", "1");
//		post.addParameter("data", JsonUtil.getJSONString(dto));
		post.addParameter("data", JsonUtil.getJSONString(new DataDto(null,"张三毛",
				"104.394729,31.125698", "autonavi", "浙江杭州")));
		try {
			httpclient.executeMethod(post);
			String info = new String(post.getResponseBody(), "UTF-8");
			ResultInfo rst = JsonUtil.getObjectFromJSONString(info,
					ResultInfo.class);
			System.out.println(rst.getStatus());
			if (rst.getStatus() == 1) {
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("插入新数据{}失败,原因{}", dto, e.getMessage());
		}
		return result;
	}

	public static boolean update(DataDto dto) {
		boolean result = false;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(updateUrl);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		post.addParameter("key", "155a5c83e7f05f153a05ad54f80836f2");
		post.addParameter("tableid", "557ab3c3e4b062df8bc978b4");
		post.addParameter("loctype", "1");
		post.addParameter("data", JsonUtil.getJSONString(dto));
/*		post.addParameter("data", JsonUtil.getJSONString(new DataDto("5","张三qian",
				"104.394729,31.125698", "autonavi", "安徽黄山")));*/
		try {
			httpclient.executeMethod(post);
			String info = new String(post.getResponseBody(), "UTF-8");
			ResultInfo rst = JsonUtil.getObjectFromJSONString(info,
					ResultInfo.class);
			System.out.println(rst.getStatus());
			if (rst.getStatus() == 1) {
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("插入新数据{}失败,原因{}", dto, e.getMessage());
		}
		return result;
	}
	public static boolean delete(DataDto dto) {
		boolean result = false;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(deleteUrl);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		post.addParameter("key", "155a5c83e7f05f153a05ad54f80836f2");
		post.addParameter("tableid", "557ab3c3e4b062df8bc978b4");
		post.addParameter("ids", "5");		
		try {
			httpclient.executeMethod(post);
			String info = new String(post.getResponseBody(), "UTF-8");
			ResultInfo rst = JsonUtil.getObjectFromJSONString(info,
					ResultInfo.class);
			System.out.println(rst.getStatus());
			if (rst.getStatus() == 1) {
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("插入新数据{}失败,原因{}", dto, e.getMessage());
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(YunTu.delete(null));
	}
}
