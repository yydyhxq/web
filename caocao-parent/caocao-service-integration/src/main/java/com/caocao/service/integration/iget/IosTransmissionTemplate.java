package com.caocao.service.integration.iget;

import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.template.APNTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;

public class IosTransmissionTemplate {
	// 透传消息模板
	public static TransmissionTemplate getTemplate(String appId, String appkey) {
		TransmissionTemplate template = new TransmissionTemplate();
		template.setAppId(appId);
		template.setAppkey(appkey);
		template.setTransmissionContent("透传内容");
		template.setTransmissionType(2);
		APNPayload payload = new APNPayload();
		payload.setBadge(1);
		payload.setContentAvailable(1);
		payload.setSound("default");
		payload.setCategory("$由客户端定义");
		payload.setAlertMsg(new APNPayload.SimpleAlertMsg("hello"));
		// 字典模式使用下者
		// payload.setAlertMsg(getDictionaryAlertMsg());
		template.setAPNInfo(payload);
		return template;
	}

	// **********APN简单推送********//
	public static APNTemplate getSimpleTemplate(String content) {
		APNTemplate template = new APNTemplate();
		APNPayload apnpayload = new APNPayload();
		APNPayload.SimpleAlertMsg alertMsg = new APNPayload.SimpleAlertMsg(
				content);
		apnpayload.setAlertMsg(alertMsg);
		apnpayload.setBadge(5);
		apnpayload.setContentAvailable(1);
		apnpayload.setCategory("ACTIONABLE");
		apnpayload.setSound("test1.wav");
		template.setAPNInfo(apnpayload);
		return template;
	}
	// ** APN高级推送**//
	public static APNTemplate getAdvancedTemplate() {
		APNTemplate template = new APNTemplate();
		APNPayload apnpayload = new APNPayload();
		apnpayload.setBadge(4);
		apnpayload.setSound("test2.wav");
		apnpayload.setContentAvailable(1);
		apnpayload.setCategory("ACTIONABLE");
		APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
		alertMsg.setBody("body");
		alertMsg.setActionLocKey("ActionLockey");
		alertMsg.setLocKey("LocKey");
		alertMsg.addLocArg("loc-args");
		alertMsg.setLaunchImage("launch-image");
		// // IOS8.2以上版本支持
		/*
		 * alertMsg.setTitle("Title"); alertMsg.setTitleLocKey("TitleLocKey");
		 * alertMsg.addTitleLocArg("TitleLocArg");
		 */
		apnpayload.setAlertMsg(alertMsg);
		template.setAPNInfo(apnpayload);
		return template;
	}	
}
