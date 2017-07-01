package com.itheima.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.spring.domain.SaleVisit;

public interface SaleVisitDAO {
	// 查询所有拜访信息
	public List<SaleVisit> findAll();
	
	public Long findTotalCount();
	
	public List<SaleVisit> findByPage(DetachedCriteria criteria,int firstResult ,int maxResults);
	//保存访问记录
	public void save(SaleVisit saleVisit);

}
