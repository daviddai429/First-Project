package com.itheima.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.LinkMan;

public interface LinkManDAO {

	public Long findTotalCount();

	public List<LinkMan> findByPage(DetachedCriteria criteria, int firstResult, int maxResults);

	public LinkMan findLinkManById(Long lkm_id);

	// 修改联系人
	public void updateLinkMan(LinkMan linkMan);

	// 保存新增联系人
	public void saveLinkMan(LinkMan linkMan);

	// 删除联系人
	public void deleteLinkMan(LinkMan linkMan);

}
