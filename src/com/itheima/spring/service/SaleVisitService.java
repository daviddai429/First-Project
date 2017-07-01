package com.itheima.spring.service;

import com.itheima.spring.domain.Pagination;
import com.itheima.spring.domain.SaleVisit;

public interface SaleVisitService {
	// 查询所有拜访记录
	public void findAll(Pagination<SaleVisit> pagination);
	//保存访问记录
	public void save(SaleVisit saleVisit);

}
