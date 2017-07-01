package com.itheima.spring.domain;

import java.util.List;
import java.util.Map;

public class Pagination<T> {
	
	private Long totalCount;//数据总条数
	private int currentPage=1;//当前页面
	private int totalPage;//总页数
	private int pageSize=10;//每页显示条数
	private List<T> objects;//查询出的客户信息
	
	Map<String, String[]> parameterMap;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getObjects() {
		return objects;
	}

	public void setObjects(List<T> customers) {
		this.objects = customers;
	}

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
	
	

}
