package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Button;
import com.caocao.core.model.UserToButton;

public interface ButtonService {

	List<Button> QueryButtonList(UserToButton userToButton);
}
