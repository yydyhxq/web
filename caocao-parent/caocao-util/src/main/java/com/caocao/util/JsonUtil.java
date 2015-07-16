package com.caocao.util;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 使用此类时需要注意的地方
 * 1.将对象转换成JSON时候需要提供方法的GET,SET方法;
 * 2.将json字符串转换成对象时需要提供空的构造函数
 * @author peizilong
 *
 */
public class JsonUtil {
	  public static ObjectMapper objectMapper;  
	  
	    /** 
	     * 使用泛型方法，把json字符串转换为相应的JavaBean对象。 
	     * (1)转换为普通JavaBean：readValue(json,Student.class) 
	     * (2)转换为List,如List<Student>,将第二个参数传递为Student 
	     * [].class.然后使用Arrays.asList();方法把得到的数组转换为特定类型的List 
	     *  
	     * @param jsonStr 
	     * @param valueType 
	     * @return 
	     */  
	    public static <T> T getObjectFromJSONString(String jsonStr, Class<T> valueType) {  
	        if (objectMapper == null) {  
	            objectMapper = new ObjectMapper();  
	        }  
	        objectMapper.setSerializationInclusion(Include.NON_NULL);
	        try {  
	            return objectMapper.readValue(jsonStr, valueType);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        return null;  
	    }  
	      
	    /** 
	     * json数组转List 
	     * @param jsonStr 
	     * @param valueTypeRef 
	     * @return 
	     */  
	    public static <T> T getColectionFromJsonString(String jsonStr, TypeReference<T> valueTypeRef){  
	        if (objectMapper == null) {  
	            objectMapper = new ObjectMapper();  
	        }  
	  
	        try {  
	            return objectMapper.readValue(jsonStr, valueTypeRef);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        return null;  
	    }  
	  
	    /** 
	     * 把JavaBean转换为json字符串 
	     *  
	     * @param object 
	     * @return 
	     */  
	    public static String getJSONString(Object object) {  
	        if (objectMapper == null) {  
	            objectMapper = new ObjectMapper();       
	        }  
	        objectMapper.setSerializationInclusion(Include.NON_NULL);
	        try {  
	            return objectMapper.writeValueAsString(object);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	  
	        return null;  
	    }  
	  

/*    public static void main(String[] args) throws Exception {  
    	Persion p=	new Persion(100,"JACK");  
    	Persion p2=	new Persion(10,"JACK2"); 
    	List<Persion> b = new ArrayList<Persion>();  
          b.add(p);
          b.add(p2);
        String str = JsonUtil.getJSONString(b);  
          System.out.println(str);
          //数组json转 List  
          List<Persion> jsonToUserBeans = JsonUtil.readValue(str, new TypeReference<List<Persion>>() {  
          });  

      }  */
    
}
