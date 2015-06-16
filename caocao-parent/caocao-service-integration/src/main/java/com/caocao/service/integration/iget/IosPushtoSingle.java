package com.caocao.service.integration.iget;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.http.IGtPush;

@Component("iosPushtoSingle")
public class IosPushtoSingle {
	private static final Logger logger = LoggerFactory
			.getLogger(AndroidPushtoSingle.class);
	@Value("${iget.appId}")
	private String appId;
	@Value("${iget.appKey}")
	private String appKey;
	@Value("${iget.masterSecret}")
	private String master;
	// private String devicetoken = "iOS设备唯一标识，由苹果那边生成";
	@Value("${iget.url}")
	private String igeturl;
	private IGtPush push;

	@PostConstruct
	public void initialize() {
		push = new IGtPush(igeturl, appKey, master);
		try {
			push.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("连接个推服务器时出错{}", e);
		}
	}

	public boolean apnpush(String devicetoken, String content) {

		boolean result = false;
		try {
			if (push.connect()) {
				SingleMessage singMsg = new SingleMessage();
				singMsg.setData(IosTransmissionTemplate
						.getSimpleTemplate(content));
				IPushResult ret = push.pushAPNMessageToSingle(appId,
						devicetoken, singMsg);
				String bacVal = ret.getResponse().toString();
				if (bacVal.equalsIgnoreCase("successed_online")
						|| bacVal.equalsIgnoreCase("successed_offline")) {
					result = true;
				}
				System.out.println("bacVal:"+bacVal);
			}
		} catch (Exception e) {
			try {
				push.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				logger.error("关闭个推连接时报错{}", e1);
			}
			e.printStackTrace();
			logger.error("发送给{}的个推消息{}发生错误", devicetoken, content);
			logger.error("causeBy{}", e.getCause());
		}
		return result;
	}
}
