package com.caocao.core.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.caocao.core.dao.ButtonMapper;
import com.caocao.core.model.Button;
import com.caocao.core.model.UserToButton;
import com.caocao.core.service.ButtonService;

@Service("buttonService")
public class ButtonServiceImpl implements ButtonService {

	@Resource
	private ButtonMapper buttonMapper;
	
	public List<Button> QueryButtonList(UserToButton userToButton) {
		List<Button> buttonList = buttonMapper.QueryButtonList(userToButton);
		return buttonList;
	}
}
