package com.caocao.service.integration.iget;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

@Component("androidPushtoSingle")
public class AndroidPushtoSingle {
	private static final Logger logger = LoggerFactory
			.getLogger(AndroidPushtoSingle.class);
	@Value("${iget.appId}")
	private String appId;
	@Value("${iget.appKey}")
	private String appkey;
	@Value("${iget.masterSecret}")
	private String master;
	@Value("${iget.url}")
	private String igeturl;
	@Value("${iget.logoUrl}")
	private String logourl;
	private IGtPush push;

	@PostConstruct
	public void initialize() {
		push = new IGtPush(igeturl, appkey, master);
		try {
			push.connect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("连接个推服务器时出错{}", e);
		}
	}

	public boolean pushtoSingle(String clientId, String content) {
		System.out.println("appkey:" + appkey);
		boolean result = false;
		try {
			if (push.connect()) {
				SingleMessage message = new SingleMessage();
				message.setOffline(true);
				// 离线有效时间，单位为毫秒，可选
				message.setOfflineExpireTime(24 * 3600 * 1000);
				message.setData(getTransmissionTemplate(content)); // 透传消息模板
				message.setPushNetWorkType(0); // 可选。判断是否客户端是否wifi环境下推送，1为在WIFI环境下，0为不限制网络环境。
				Target target = new Target();
				target.setAppId(appId);
				target.setClientId(clientId);
				// 用户别名推送，cid和用户别名只能2者选其一
				// target.setAlias(alias);
				IPushResult ret = push.pushMessageToSingle(message, target);
				String bacVal = ret.getResponse().toString();
				System.out.println("bacVal:"+bacVal);
				if (bacVal.equalsIgnoreCase("successed_online")
						|| bacVal.equalsIgnoreCase("successed_offline")) {
					result = true;
				}
			}
		} catch (Exception e) {
			try {
				push.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				logger.error("关闭个推连接时报错{}",e1);
			}
			logger.error("发送给{}的个推消息{}发生错误", clientId, content);
			logger.error("causeBy{}", e.getCause());
		}
		return result;
	}

	/**
	 * 点击通知打开应用模板
	 * 
	 * @return
	 */
	public NotificationTemplate getNotificationTemplate(String content) {
		NotificationTemplate template = new NotificationTemplate();
		// 设置APPID与APPKEY
		template.setAppId(appId);
		template.setAppkey(appkey);
		// 设置通知栏标题与内容
		template.setTitle("请输入通知栏标题");
		template.setText("请输入通知栏内容");
		// 配置通知栏图标
		template.setLogo("icon.png");
		// 配置通知栏网络图标
		template.setLogoUrl(logourl);
		// 设置通知是否响铃，震动，或者可清除
		template.setIsRing(true);
		template.setIsVibrate(true);
		template.setIsClearable(true);
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(2);
		template.setTransmissionContent(content);
		return template;
	}

	/**
	 * 透传消息模板
	 * 
	 * @return
	 */
	public TransmissionTemplate getTransmissionTemplate(String content) {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		// 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
		template.setTransmissionType(2);
		template.setTransmissionContent(content);
		return template;
	}

}
