package com.itheima.spring.intercepter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.spring.domain.User;
import com.itheima.spring.service.UserService;
import com.itheima.spring.serviceImpl.UserServiceImpl;
import com.itheima.spring.utils.CookieUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginIntercepter extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		User loginUser = (User) request.getSession().getAttribute("loginUser");

		String username = CookieUtils.getCookieValue(request, "username");

		if (null == loginUser || StringUtils.isBlank(username)) {
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("您还没有登录，请先登录");
			return "login";
		}
		// 执行下一个拦截器
		return invocation.invoke();

	}

}
