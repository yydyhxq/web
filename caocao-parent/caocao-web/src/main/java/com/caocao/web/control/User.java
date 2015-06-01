package com.caocao.web.control;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

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
