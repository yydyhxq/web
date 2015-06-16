package com.caocao.service.integration.iget;

import java.util.ArrayList;
import java.util.List;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.http.IGtPush;

public class IosPushtoAll {
    static String appId = "应用的APPID";
    static String appKey = "应用的APPKEY";
    static String masterSecret = "应用的MASTERSECRET";
    static String devicetoken = "iOS设备唯一标识，由苹果那边生成";
    static String url ="http://sdk.open.api.igexin.com/serviceex";
    public static void apnpush() throws Exception {
        IGtPush push = new IGtPush(url, appKey, masterSecret);     

        ListMessage message = new ListMessage();
        message.setData(IosTransmissionTemplate.getSimpleTemplate("123"));
        String contentId = push.getAPNContentId(appId, message);
        System.out.println(contentId);
        List<String> dtl = new ArrayList<String>();
        dtl.add(devicetoken);
        System.setProperty("gexin.rp.sdk.pushlist.needDetails", "true");
        IPushResult ret = push.pushAPNMessageToList(appId, contentId, dtl);	
        System.out.println(ret.getResponse());
     }    
}
