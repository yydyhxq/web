package com.caocao.service.integration.sms;

import javax.annotation.PostConstruct;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.caocao.util.StringUtils;

@Service("messageFactory")
public class MessageFactory {
	private static final Logger logger = LoggerFactory
			.getLogger(MessageFactory.class);
	@Value("${msg.url}")
	private String url;
	@Value("${msg.SpCode}")
	private String SpCode;
	@Value("${msg.LoginName}")
	private String LoginName;

	@Value("${msg.Password}")
	private String Password;
	private HttpClient httpclient;
	private PostMethod post;

	@PostConstruct
	public void initialize() {
		httpclient = new HttpClient();
		post = new PostMethod(url);
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public boolean sendSMS(String msg, String phoneNum, String ScheduleTime) {
		boolean result = false;
		System.out.println("LoginName:" + LoginName);
		try {
			post.getParams().setParameter(
					HttpMethodParams.HTTP_CONTENT_CHARSET, "gbk");
			post.addParameter("SpCode", SpCode);
			post.addParameter("LoginName", LoginName);
			post.addParameter("Password", Password);
			post.addParameter("MessageContent", msg);
			post.addParameter("UserNumber", phoneNum);
			post.addParameter("SerialNumber", "");
			if (StringUtils.isEmpty(ScheduleTime)) {
				post.addParameter("ScheduleTime", "");
			} else {
				post.addParameter("ScheduleTime", ScheduleTime);
			}
			post.addParameter("ExtendAccessNum", "");
			post.addParameter("f", "1");
			httpclient.executeMethod(post);
			String info = new String(post.getResponseBody(), "gbk");
			System.out.println("info:" + info);
			if (info.equals("0")) {
				result = true;
			}
		} catch (Exception e) {
			logger.error("发送给{}号码的消息{}发送失败", phoneNum, msg);
		}
		return result;

	}
}
