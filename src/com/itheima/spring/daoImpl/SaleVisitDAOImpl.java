package com.itheima.spring.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.spring.dao.SaleVisitDAO;
import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.SaleVisit;

public class SaleVisitDAOImpl extends HibernateDaoSupport implements SaleVisitDAO {

	@Override
	public List<SaleVisit> findAll() {
		return getHibernateTemplate().loadAll(SaleVisit.class);
	}
	
	@Override
	public Long findTotalCount() {
		// 查询客户总数据条数
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
		// 投影查询
		criteria.setProjection(Projections.rowCount());
		List<Long> count = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return count.isEmpty() ? Long.valueOf(0) : count.get(0);
	}
	
	@Override
	public List<SaleVisit> findByPage(DetachedCriteria criteria,int firstResult ,int maxResults) {
		// 查询当前页面客户信息
		List<SaleVisit> saleVisits = (List<SaleVisit>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
		return saleVisits;
	}

	@Override
	public void save(SaleVisit saleVisit) {
		// 保存访问记录
		getHibernateTemplate().save(saleVisit);
	}

}
