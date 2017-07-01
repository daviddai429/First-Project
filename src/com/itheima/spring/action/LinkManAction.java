package com.itheima.spring.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.LinkMan;
import com.itheima.spring.domain.Pagination;
import com.itheima.spring.service.CustomerService;
import com.itheima.spring.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan = new LinkMan();

	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
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

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 分页查询联系人
	public String showLinkMan() {
		Pagination<LinkMan> pagination = new Pagination<>();
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		// 第一次访问时，页面pageSize为0，此时pageSize为默认值2
		if (pageSize > 0) {
			pagination.setPageSize(pageSize);
		}
		if (currentPage > 0) {
			pagination.setCurrentPage(currentPage);
		}
		linkManService.findAll(pagination);
		// 将查询到的结果存到值栈
		ServletActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}

	// 跳转到增加联系人界面
	public String showAdd() {
		List<Customer> customerList = customerService.findCustomerList();
		//将查询到的客户信息压入root栈
		ActionContext.getContext().getValueStack().set("customerList", customerList);
		return "addjsp";
	}

	// 修改页面回显
	public String showEdit() {

		List<Customer> customerList = customerService.findCustomerList();
		//将查询到的客户信息压入root栈
		ActionContext.getContext().getValueStack().set("customerList", customerList);
		LinkMan linkmanQuery = linkManService.findLinkManById(linkMan.getLkm_id());
		// 压入root值栈
		ActionContext.getContext().getValueStack().push(linkmanQuery);
		return "editjsp";

	}

	// 保存修改用户
	public String updateLinkMan() {
		linkManService.updateLinkMan(linkMan);
		return "updatejsp";
	}
	//保存新增用户
	public String saveLinkMan(){
		linkManService.saveLinkMan(linkMan);
		return "updatejsp";
	}
	//删除用户
	public String deleteLinkMan(){
		linkManService.deleteLinkMan(linkMan);
		return "updatejsp";
	}

}
