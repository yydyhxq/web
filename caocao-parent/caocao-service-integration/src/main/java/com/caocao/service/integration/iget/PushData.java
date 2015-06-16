package com.caocao.service.integration.iget;

import java.io.Serializable;

public class PushData implements Serializable {
	private static final long serialVersionUID = 6508660128001276753L;
	private String content;
    private String title;
    private int type;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}


}
