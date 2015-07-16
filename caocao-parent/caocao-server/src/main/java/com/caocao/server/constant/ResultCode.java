package com.caocao.server.constant;

public enum ResultCode {
	/** 输入的手机验证码不对 **/
	MOBLECODE_VALIDATE_FAIL(10001, "您输入手机验证码不正确"),
	/** 登录-不存在该用户 **/
	LOGIN_VALIDATE_FAIL(10002, "该用户不存在"),
	/** 服务器内部出错 **/
	MOBLE_SERVER_EXCEPTION(10003, "服务器内部出错"),
	/** 服务器内部出错 **/
	MOBLE_EXISTS(10003, "您所注册的用户已存在"),
	/** 撤单原因 **/
	REVOKE_RESION1(1, "车太少"),

	REVOKE_RESION2(2, "司机素质太低"),

	REVOKE_RESION3(3, "车档次不够"),

	REVOKE_RESION4(4, "收费太贵");
	private int code;
	private String message;

	private ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static String acquireMsg(int code) {
		for (ResultCode rt : ResultCode.values()) {
			if (rt.getCode() == code) {
				return rt.getMessage();
			}
		}
		return null;
	}

}
