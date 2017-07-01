package com.itheima.spring.dao;

import java.util.List;

import com.itheima.spring.domain.User;

public interface UserDAO {

	public User login(String user_code, String user_password);

	public User findUserInfo(Long user_id);

	public void saveUser(User user);

	public List<User> findAll();

}
