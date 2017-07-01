package com.itheima.spring.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.itheima.spring.dao.CustomerDAO;
import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.Pagination;
import com.itheima.spring.service.CustomerService;


public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// 保存用户
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	public void findAll(Pagination pagination) {
		// 分页查询数据
		//查询数据总条数
		Long totalCount = customerDAO.findTotalCount();
		//计算总页面数
		int totalPage = (int) Math.ceil(totalCount/pagination.getPageSize())+1;
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		String cust_name = parameterMap.get("cust_name")==null?null:parameterMap.get("cust_name")[0];
		String cust_mobile = parameterMap.get("cust_mobile")==null?null:parameterMap.get("cust_mobile")[0];
		//查询当前页面客户信息
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(cust_name)) {
			criteria.add(Restrictions.like("cust_name", cust_name,MatchMode.ANYWHERE));
		}
		if (StringUtils.isNotBlank(cust_mobile)) {
			criteria.add(Restrictions.eq("cust_mobile", cust_mobile));
		}
		//firstResult:起始    maxResults：
		List<Customer> customers = customerDAO.findByPage(criteria, (pagination.getCurrentPage()-1)*pagination.getPageSize(), pagination.getCurrentPage()*pagination.getPageSize());
		//封装Pagination
		pagination.setTotalCount(totalCount);
		pagination.setTotalPage(totalPage);
		pagination.setObjects(customers);
	}

	@Override
	public Customer findCustomerById(Long cust_id) {
		// 通过ID查询到客户信息
		return customerDAO.findCustomerById(cust_id);
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// 删除选中用户
		customerDAO.deleteCustomer(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		// 保存修改的用户信息
		customerDAO.updateCustomer(customer);
		
	}

	@Override
	public List<Customer> findCustomerList() {
		
		return customerDAO.findCustomerList();
	}
	

}
