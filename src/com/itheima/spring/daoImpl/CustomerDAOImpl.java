package com.itheima.spring.daoImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.spring.dao.CustomerDAO;
import com.itheima.spring.domain.Customer;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO {
	// 保存用户
	@Override
	public void saveCustomer(Customer customer) {
		getHibernateTemplate().save(customer);
	}

	@Override
	public Long findTotalCount() {
		// 查询客户总数据条数
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 投影查询
		criteria.setProjection(Projections.rowCount());
		List<Long> count = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return count.isEmpty() ? Long.valueOf(0) : count.get(0);
	}

	@Override
	public List<Customer> findByPage(DetachedCriteria criteria,int firstResult ,int maxResults) {
		// 查询当前页面客户信息
		List<Customer> customers = (List<Customer>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
		return customers;
	}

	@Override
	public Customer findCustomerById(Long cust_id) {
		// 查找需要删除的客户信息
//		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
//		criteria.add(Restrictions.eq("cust_id", cust_id));
		Customer customer = getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// 删除选中客户，支持托管态和持久态的删除
		getHibernateTemplate().delete(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// 修改客户信息
		getHibernateTemplate().update(customer);
	}

	@Override
	public List<Customer> findCustomerList() {
		return getHibernateTemplate().loadAll(Customer.class);
	}

}
