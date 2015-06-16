package com.caocao.server.dto;

import com.caocao.util.JsonUtil;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileHttpDto {

	public MobileHttpDto() {

	}

	private Integer status;
	private Error error;

	public static class Error {
		Integer code;
		String message;

		public Error(Integer code, String message) {
			this.code = code;
			this.message = message;
		}

		public Error() {

		}

		public Integer getCode() {
			return code;
		}

		public void setCode(Integer code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}
/**
 * 存放返回内容
 */
	private Object body;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}



	public static void main(String[] args) {
		MobileHttpDto m = new MobileHttpDto();
		m.setBody("123");
		m.setStatus(1);
		Error error = new Error(11, "abc");
		m.setError(error);
		System.out.println(JsonUtil.getJSONString(m));
		System.out.println(JsonUtil.getObjectFromJSONString(JsonUtil.getJSONString(m),
		MobileHttpDto.class).getBody());
	}
}
