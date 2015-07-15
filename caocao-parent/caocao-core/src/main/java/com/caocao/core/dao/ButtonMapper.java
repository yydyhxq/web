package com.caocao.core.dao;

import java.util.List;

import com.caocao.core.model.Button;
import com.caocao.core.model.UserToButton;

public interface ButtonMapper {

	List<Button> QueryButtonList(UserToButton userToButton);
}
