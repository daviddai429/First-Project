package com.itheima.spring.service;

import java.util.List;

import com.itheima.spring.domain.User;

public interface UserService {

	public User login(User user);

	public User findUserInfo(Long user_id);

	public void saveUser(User user);
	//查找所有用户
	public List<User> findUserList();

}
