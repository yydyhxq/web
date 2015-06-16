package com.caocao.service.integration.gis;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.caocao.util.JsonUtil;
@Component("yunTu")
public class YunTu {
	
	private static final Logger logger = LoggerFactory.getLogger(YunTu.class);
	@Value("${yuntu.insertUrl}")
	public String insertUrl;
	@Value("${yuntu.updateUrl}")
	public String updateUrl;
	@Value("${yuntu.deleteUrl}")
	public String deleteUrl;
	@Value("${yuntu.searchUrl}")
	public String searchUrl;
	@Value("${yuntu.key}")
	public String key;
	@Value("${yuntu.tableid}")
	public String tableid;
	public boolean insert(DataDto dto) {
		boolean result = false;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(insertUrl);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		post.addParameter("key", key);
		post.addParameter("tableid", tableid);
		post.addParameter("loctype", "1");
		post.addParameter("data", JsonUtil.getJSONString(dto));
/*		post.addParameter("data", JsonUtil.getJSONString(new DataDto(null,"颐和园",
				"50.4532,40.3556", "gps",null)));*/	
		try {
			httpclient.executeMethod(post);
			String info = new String(post.getResponseBody(), "UTF-8");
			ResultInfo rst = JsonUtil.getObjectFromJSONString(info,
					ResultInfo.class);
	//		System.out.println(rst.getStatus());
			if (rst.getStatus() == 1) {
				result = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("插入新数据{}失败,原因{}", dto, e.getMessage());
		}
		return result;
	}

	public boolean update(DataDto dto) {
		boolean result = false;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(updateUrl);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		post.addParameter("key", key);
		post.addParameter("tableid", tableid);
		post.addParameter("loctype", "1");
		post.addParameter("data", JsonUtil.getJSONString(dto));
/*		post.addParameter("data", JsonUtil.getJSONString(new DataDto("6","韩拓",
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
			logger.error("更新新数据{}失败,原因{}", dto, e.getMessage());
		}
		return result;
	}
	public boolean delete(String ides) {
		boolean result = false;
		HttpClient httpclient = new HttpClient();
		PostMethod post = new PostMethod(deleteUrl);
		post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		post.addParameter("key", key);
		post.addParameter("tableid", tableid);
		post.addParameter("ids", ides);	//ides,一次请求限制1-50条数据，多个_id用逗号隔开	
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
			logger.error("删除数据{}失败,原因{}", ides, e.getMessage());
		}
		return result;
	}
	
	/**
	 * 用于搜索周边点
	 * @param center
	 * @param radius
	 */
	public RoundDto searchAround(String center,String radius)
	{
		RoundDto dto=null;
		HttpClient httpclient = new HttpClient();
		PostMethod get=new PostMethod(searchUrl);
		get.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
				"UTF-8");
		get.addParameter("key", key);
		get.addParameter("tableid",tableid);
	//	parm.setParameter("keywords", "");//后期可以作为车型关键字使用
		get.addParameter("center", center);
		get.addParameter("radius", radius);
		/**
		 * 支持对建立了排序筛选索引的字段进行筛选（请在 数据管理台 中为字段建立排序筛选索引）
		 * 规则： 
				filter=key1:value1+key2:[value2,value3] 
				示例： 
				filter=type:酒店+star:[3,5] 
				（等同于SQL语句的： 
				WHERE type = "酒店" 
				AND star BETWEEN 3 AND 5
		 */
	//	parm.setParameter("filter", null);
		/**
		 * 1、当keywords存在时：默认按_weight权重排序；
		 * 2、当keywords不存在时，默认按_distance距离排序；
		 */
	//	parm.setParameter("sortrule", null);
		get.addParameter("limit", "30");
	//	get.setParams(parm);
		try{
		httpclient.executeMethod(get);
		String info = new String(get.getResponseBody(), "UTF-8");
	//	System.out.println("info:"+info);
		dto=JsonUtil.getObjectFromJSONString(info,RoundDto.class);
	//	System.out.println(dto.getDatas().get(0).get_name());
		}catch(Exception e)
		{			
			logger.error("查询{}附近{}范围数据失败", center,radius,e);
		}
		return dto;
	}
/*	public static void main(String[] args) {
		YunTu.insert(null);
		YunTu.searchAround(null,null);
	}*/
}
