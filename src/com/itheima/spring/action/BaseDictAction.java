
package com.itheima.spring.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.spring.domain.BaseDict;
import com.itheima.spring.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	//注入
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	public String listByTypeCode() throws Exception{
		List<BaseDict> lists = baseDictService.listByTypeCode(baseDict);
		JSONArray jsonArray = JSONArray.fromObject(lists);
		//写会响应
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());;
		return NONE;
	}

}
