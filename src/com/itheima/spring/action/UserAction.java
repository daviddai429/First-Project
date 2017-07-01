package com.itheima.spring.action;

import com.itheima.spring.domain.User;
import com.itheima.spring.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.servlet.Servlet;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//注入
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//管理员登录
	public String login(){
		User loginUser = userService.login(user);
		if (null==loginUser) {
			addActionError("用户名或密码错误");
			return LOGIN;
		}else{
			//放入session
            ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
            //放入cookie
            Cookie cookieUsername = new Cookie("username", user.getUser_code());
            Cookie cookiePassword = new Cookie("password", user.getUser_password());
            cookieUsername.setPath("/");
            cookiePassword.setPath("/");
            cookieUsername.setMaxAge(60*60*24*7);
            cookiePassword.setMaxAge(60*60*24*7);
            ServletActionContext.getResponse().addCookie(cookieUsername);
            ServletActionContext.getResponse().addCookie(cookiePassword);
            
			return SUCCESS;
		}
	}
	//修改用户信息时回显
	public String showUserInfo(){
		User userFinded = userService.findUserInfo(user.getUser_id());
		ActionContext.getContext().getValueStack().push(userFinded);
		return "updatejsp";
	}
	//保存修改信息
	public String saveUser(){
		userService.saveUser(user);
		return "login";
	}
	//退出登录
	public String loginOut(){
		
		ServletActionContext.getRequest().getSession().removeAttribute("loginUser");
		
		return "login";
	}
	

}
