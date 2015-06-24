package com.caocao.core.service;

import java.util.List;

import com.caocao.core.model.Labour;

public interface LabourManageService {
	
	Labour QueryOne(Labour labour);
	
	Labour QueryById(Labour labour);
	
	List<Labour> QueryPageList(Labour labour);

	public int insert(Labour labour);
	
	public int update(Labour labour);
}
