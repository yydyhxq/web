package com.caocao.web.control;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caocao.core.model.Privilege;
import com.caocao.core.service.PrivilegeService;

@Controller
@RequestMapping("privilege")
public class PrivilegeController {
	private static final Logger logger = LoggerFactory
			.getLogger(PrivilegeController.class);

	@Resource
	private PrivilegeService privilegeService;
	
	@RequestMapping("query")
	@ResponseBody
	public List<Privilege> QueryPrivilegeList(Privilege privilege) {
		List<Privilege> list = privilegeService.QueryPrivilegeList(privilege);
		return list;
	}
}
