package com.wesites.core.service;

import java.util.List;

import com.wesites.core.pojo.User;

public interface UserService {

	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User queryUserByID(Integer id);
	public User findUserByName(String username);
	public List<User> queryAllUser();

	
}
