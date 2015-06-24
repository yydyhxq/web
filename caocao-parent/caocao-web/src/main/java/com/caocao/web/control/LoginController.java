package com.caocao.web.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.Admin;
import com.caocao.core.service.LoginService;
import com.caocao.service.integration.sms.MessageFactory;
import com.caocao.util.MobileCode;
import com.caocao.web.constant.ResultState;
import com.caocao.web.dto.MobileHttpDto;
import com.caocao.web.extend.SmsTemplate;

@Controller
@RequestMapping("login")
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	@Resource
	private LoginService loginService;
	
	@Resource(name = "messageFactory")
	private MessageFactory messageFactory;
	
	/**
	 * 获取手机验证码(需调用短信接口)-登录/注册
	 * 
	 * @param mobile
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/acquireCode", method = { RequestMethod.GET})
	@ResponseBody
	public MobileHttpDto acquireCode(@RequestParam String mobile,
			@RequestParam(required = false) Double version,
			@RequestParam(required = false) String token,
			HttpSession session)
			throws Exception {
		String code = MobileCode.createRandom(true, 6);
		// 发送短信
		boolean result = messageFactory.sendSMS(SmsTemplate.driverNotify(code),
				mobile, null);
		MobileHttpDto dto = new MobileHttpDto();
		if (result == true) {
			dto.setStatus(ResultState.SUCCESS);
			session.setMaxInactiveInterval(60 *10);
			session.setAttribute(mobile, code);
		} else {
			dto.setStatus(ResultState.FAIL);
		}
		
		return dto;
	
		}
	//返回的result中  0：用户不存在；1：验证码不正确；2：账号为启用；3：账号已过期；4：登录成功
	@RequestMapping(value = "/userLogin", method = {RequestMethod.GET})
	@ResponseBody
	public int UserLogin(@RequestParam String mobile, @RequestParam String pin, HttpSession session) {
		Admin admin = new Admin();
		admin.setPhone(mobile);
		int result = 100;
		String mobileCode = String.valueOf(session.getAttribute(mobile));
		if(!pin.equalsIgnoreCase(mobileCode)) {
			result = 1;
			return result;
		}
		Admin modelDO = loginService.QueryOne(admin);
		if(StringUtils.isEmpty(modelDO.getPhone())) {
			result = 0;
			return result;
		}
		if(!StringUtils.isEmpty(modelDO.getPhone()) && 0 == modelDO.getIsactive()) {
			result = 2;
			return result;
		}
		result = 4;
		return result;
	}
}
