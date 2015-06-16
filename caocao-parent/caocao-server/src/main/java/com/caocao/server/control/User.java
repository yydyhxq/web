package com.caocao.server.control;

import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.httpclient.util.DateUtil;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
	private String username;
	private String psw;
	@NotNull
	@NotBlank(message="{username.not.empty}")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotNull
    @NotBlank(message="{psw.not.empty}")
	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
