package com.itheima.spring.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.spring.content.SystemContent;
import com.itheima.spring.domain.BaseDict;
import com.itheima.spring.domain.Customer;
import com.itheima.spring.domain.Pagination;
import com.itheima.spring.service.CustomerService;
import com.itheima.spring.utils.UploadUtils;
import com.mchange.v1.lang.NullUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}

	// 注入CustomerService
	CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 跳转到添加页面
	public String add() {
		return "addjsp";
	}

	// 上传组件
	private File upload;// 上传文件的引用对象
	private String uploadContentType;// 上传文件的Mime类型
	private String uploadFileName;// 上传文件的文件名

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	// 新增用户
	public String saveCustomer() throws Exception {
		// 完成上传功能
		if (null != upload) {
			String randomFileName = UploadUtils.generateRandonFileName(uploadFileName);// 生成随机文件名
			String randomDirName = UploadUtils.generateRandomDir(randomFileName);// 生成随机文件夹名
			String realFileName = UploadUtils.subFileName(uploadFileName);// 截取真实文件名称
			// 在Customer中保存服务器中上传文件的相对路劲
			String filePath = randomDirName + "/" + randomFileName;
			// 绝对路径
			String distFilePath = SystemContent.FILE_UPLOAD_BASE_PATH + filePath;
			// 封装文件的真实名
			customer.setCust_fileName(realFileName);
			// 封装相对路径名
			customer.setCust_filePath(filePath);
			FileUtils.copyFile(upload, new File(distFilePath));
		}
		customerService.saveCustomer(customer);
		// 添加成功以后跳转到查询界面
		return "listaction";
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

	// 分页查找客户列表
	public String findAll() {
		Pagination<Customer> pagination = new Pagination<>();
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		// 第一次访问时，页面pageSize为0，此时pageSize为默认值2
		if (pageSize > 0) {
			pagination.setPageSize(pageSize);
		}
		if (currentPage > 0) {
			pagination.setCurrentPage(currentPage);
		}
		customerService.findAll(pagination);
		// 将查询到的结果存到值栈
		ServletActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}

	// 删除客户
	public String deleteCustomer() {
		// 删除文件
		Customer cust = customerService.findCustomerById(customer.getCust_id());
		// 获取该客户保存的文件绝对路径
		String cust_filePath = cust.getCust_filePath();
		if (StringUtils.isNotBlank(cust_filePath)) {// 如果用保存文件
			// 删除文件
			String distPath = SystemContent.FILE_UPLOAD_BASE_PATH + "/" + cust_filePath;
			new File(distPath).delete();
		}
		// 删除表中客户信息,必须删除持久态
		customerService.deleteCustomer(cust);

		return "listaction";
	}

	// 修改前回显客户
	public String showCustomer() {

		Customer cust = customerService.findCustomerById(customer.getCust_id());
		// 压入root值栈
		ActionContext.getContext().getValueStack().push(cust);

		return "editjsp";
	}

	// 修改客户
	@InputConfig(resultName = "updateInput")
	public String updateCustomer() throws Exception {
		if (null != upload) {// 修改了上传文件
			// //获取原文件的路径
			String oldFilePath = SystemContent.FILE_UPLOAD_BASE_PATH + customer.getCust_filePath();
			// 上传新文件
			String randomFileName = UploadUtils.generateRandonFileName(uploadFileName);// 生成随机文件名
			String randomDirName = UploadUtils.generateRandomDir(randomFileName);// 生成随机文件夹名
			// 在Customer中保存服务器中上传文件的相对路径
			String filePath = randomDirName + "/" + randomFileName;
			// 绝对路径
			String distFilePath = SystemContent.FILE_UPLOAD_BASE_PATH + filePath;
			FileUtils.copyFile(upload, new File(distFilePath));
			// 封装文件的真实名
			customer.setCust_fileName(uploadFileName);
			// 封装相对路径名
			customer.setCust_filePath(filePath);
			// 删除旧文件
			new File(oldFilePath).delete();
		}
		// 上传其他信息
		customerService.updateCustomer(customer);
		return "listaction";
	}
}
