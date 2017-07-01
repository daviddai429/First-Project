package com.itheima.spring.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.Pagination;
import com.itheima.spring.domain.SaleVisit;
import com.itheima.spring.domain.User;
import com.itheima.spring.service.CustomerService;
import com.itheima.spring.service.SaleVisitService;
import com.itheima.spring.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit = new SaleVisit();

	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private SaleVisitService saleVisitService;

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}

	// 使用属性驱动获取页面插入的分页信息
	private int currentPage;
	private int pageSize;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	// 分页查询所有拜访记录
	public String findAll() {
		Pagination<SaleVisit> pagination = new Pagination<>();
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		// 第一次访问时，页面pageSize为0，此时pageSize为默认值2
		if (pageSize > 0) {
			pagination.setPageSize(pageSize);
		}
		if (currentPage > 0) {
			pagination.setCurrentPage(currentPage);
		}
		saleVisitService.findAll(pagination);
		// 将查询到的结果存到值栈
		ServletActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}

	// 显示添加页面
	public String showAdd() {
		List<Customer> customers = customerService.findCustomerList();
		ActionContext.getContext().put("customers", customers);

		List<User> users = userService.findUserList();
		ActionContext.getContext().put("users", users);
		return "showjsp";
	}

	// 保存用户
	public String save() {
		saleVisitService.save(saleVisit);
		return "listaction";
	}

}
