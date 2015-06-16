package com.caocao.nio.tools;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;


public class MsgProtocol {
	public static Charset CHARSET = CharsetUtil.UTF_8;
	public final static int CMD_HEART_BEAT= 1;//心跳
	public final static int CMD_CONNECT= 2;//初次连接（要传入User信息还是UserId）
	public final static int CMD_RECONNECT= 3;//断线重连（UserId）
	public final static int CMD_UPDATE_DRIVER_LOCATION = 4;//司机端更新位置信息（GeoCode, Lantitude, Longtitude）
	public final static int CMD_UPDATE_DRIVER_SERVICE_STATE= 5;//司机端更新（GeoCode, Lantitude, Longtitude）
	

}
