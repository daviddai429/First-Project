package com.itheima.spring.service;

import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.LinkMan;
import com.itheima.spring.domain.Pagination;

public interface LinkManService {
	
	public void saveLinkMan(LinkMan linkMan);

	public void findAll(Pagination<LinkMan> pagination);

	public LinkMan findLinkManById(Long cust_id);

	// 删除客户信息
	public void deleteLinkMan(LinkMan linkMan);

	// 保存修改的用户信息
	public void updateLinkMan(LinkMan linkMan);

}
