package com.caocao.web.extend;

public class SmsTemplate {
	public static String mobileValidateCode(String code) {
		return "您本次验证码为" + code + "请在1分钟内使用.";
	}

	public static String driverOnRoadnotify(String userNike, String time) {
		return userNike + "你的司机正在途中,将于约" + time + "分钟内抵达您上车位置.";
	}

	public static String driverNotify(String userNike) {
		return "亲爱的" + userNike + ",您的司机即将抵达.";
	}

	public static String userNotify(String userNike) {
		return "亲爱的" + userNike + "您现在已上车,开始行程,祝您旅途愉快.";
	}

	public static String costNotify(String userNike, String userTime,
			String km, double money) {
		return userNike + "您现在已抵达目的地行程结束.行驶" + userTime + "分钟" + km + "公里,应付"
				+ money + "元,系统会自动从您账户中扣款,感谢您对曹操专车支持.";
	}

	public static String orderNotifyUser(String msg) {
		return "您已预约" + msg;
	}

	public static String orderNotifyDriver(String userNike, String oderMsg,
			String location) {
		return "尊敬的" + userNike + "您有一预约单xxxxxxxxxxxx}" + oderMsg
				+ "请准时抵达乘客上车地" + location + "避免耽误乘客行程.";
	}
}
