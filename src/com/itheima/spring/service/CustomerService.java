package com.itheima.spring.service;

import java.util.List;

import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.Pagination;

public interface CustomerService {

	public void saveCustomer(Customer customer);

	public void findAll(Pagination<Customer> pagination);

	public Customer findCustomerById(Long cust_id);

	// 删除客户信息
	public void deleteCustomer(Customer customer);

	// 保存修改的用户信息
	public void updateCustomer(Customer customer);

	public List<Customer> findCustomerList();

}
