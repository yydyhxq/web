package com.caocao.web.constant;

public enum ResultCode {
/**输入的手机验证码不对**/
MOBLECODE_VALIDATE_FAIL(0001,"您输入手机验证码不正确"),
/**登录-不存在该用户**/
LOGIN_VALIDATE_FAIL(0002,"该用户不存在");
private int code;
private String message;
private ResultCode(int code,String message)
{
	this.code=code;
	this.message=message;
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

}
