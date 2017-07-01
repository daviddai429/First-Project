package com.itheima.spring.dao;

import java.util.List;

import com.itheima.spring.domain.BaseDict;

public interface BaseDictDAO{
	
	public List<BaseDict> listByTypeCode(String dict_type_code);

}
