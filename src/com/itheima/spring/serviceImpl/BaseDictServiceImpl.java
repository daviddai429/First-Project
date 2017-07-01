package com.itheima.spring.serviceImpl;

import java.util.List;

import com.itheima.spring.dao.BaseDictDAO;
import com.itheima.spring.domain.BaseDict;
import com.itheima.spring.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{
	//注入
	private BaseDictDAO baseDictDAO;
	public void setBaseDictDAO(BaseDictDAO baseDictDAO) {
		this.baseDictDAO = baseDictDAO;
	}
	public List<BaseDict> listByTypeCode(BaseDict baseDict){
		return baseDictDAO.listByTypeCode(baseDict.getDict_type_code());
	}

}
