package com.itheima.spring.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.spring.domain.Customer;

public interface CustomerDAO {
	//保存客户信息
	public void saveCustomer(Customer customer);

	public Long findTotalCount();
	
	//查询当前页面客户信息
	public List<Customer> findByPage(DetachedCriteria criteria, int firstResult, int maxResults);
	//通过ID查找
	public Customer findCustomerById(Long cust_id);
	//删除选中的客户
	public void deleteCustomer(Customer customer);
	//修改用户信息
	public void updateCustomer(Customer customer);

	public List<Customer> findCustomerList();

}
