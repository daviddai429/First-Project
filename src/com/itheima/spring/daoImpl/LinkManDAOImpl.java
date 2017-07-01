package com.itheima.spring.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.spring.dao.LinkManDAO;
import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.LinkMan;

public class LinkManDAOImpl extends HibernateDaoSupport implements LinkManDAO {

	@Override
	public Long findTotalCount() {
		// 查询客户总数据条数
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		// 投影查询
		criteria.setProjection(Projections.rowCount());
		List<Long> count = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return count.isEmpty() ? Long.valueOf(0) : count.get(0);
	}

	@Override
	public List<LinkMan> findByPage(DetachedCriteria criteria, int firstResult, int maxResults) {
		// 查询当前页面客户信息
		List<LinkMan> linkMans = (List<LinkMan>) getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
		return linkMans;
	}

	@Override
	public LinkMan findLinkManById(Long lkm_id) {
		
		return (LinkMan) getHibernateTemplate().get(LinkMan.class, lkm_id);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		// 保存联系人信息
		getHibernateTemplate().update(linkMan);
	}

	@Override
	public void saveLinkMan(LinkMan linkMan) {
		// 保存新增用户
		getHibernateTemplate().save(linkMan);
	}

	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		// 删除联系人
		getHibernateTemplate().delete(linkMan);
	}
}
