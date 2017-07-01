package com.itheima.spring.serviceImpl;

import java.util.List;

import com.itheima.spring.dao.UserDAO;
import com.itheima.spring.domain.User;
import com.itheima.spring.service.UserService;

public class UserServiceImpl implements UserService {
	// 注入
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User login(User user) {
		return userDAO.login(user.getUser_code(), user.getUser_password());
	}

	@Override
	public User findUserInfo(Long user_id) {
		
		return userDAO.findUserInfo(user_id);
	}

	@Override
	public void saveUser(User user) {
		userDAO.saveUser(user);
		
	}

	@Override
	public List<User> findUserList() {
		return userDAO.findAll();
		
	}

}
