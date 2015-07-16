package com.caocao.service.integration.gis;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo {
	private int status;
	private String info;
	private String _id;
	private String success;
	private String fail;

	public ResultInfo() {

	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFail() {
		return fail;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
}
