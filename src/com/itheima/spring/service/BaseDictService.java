package com.itheima.spring.service;

import java.util.List;

import com.itheima.spring.domain.BaseDict;

public interface BaseDictService {
	
	public List<BaseDict> listByTypeCode(BaseDict baseDict);

}
