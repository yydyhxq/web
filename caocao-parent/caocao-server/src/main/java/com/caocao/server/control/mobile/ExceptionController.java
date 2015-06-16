package com.caocao.server.control.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.server.constant.ResultCode;
import com.caocao.server.constant.ResultState;
import com.caocao.server.dto.MobileHttpDto;
import com.caocao.server.dto.MobileHttpDto.Error;

@Controller
@RequestMapping("exception")
public class ExceptionController {
	@RequestMapping(value = "/serverException", method = { RequestMethod.GET })
	@ResponseBody
	public MobileHttpDto serverException() {

		MobileHttpDto dto = new MobileHttpDto();
		dto.setStatus(ResultState.ERROR);

		dto.setError(new Error(ResultCode.MOBLE_SERVER_EXCEPTION.getCode(),
				ResultCode.MOBLE_SERVER_EXCEPTION.getMessage()));
		return dto;
	}
}
