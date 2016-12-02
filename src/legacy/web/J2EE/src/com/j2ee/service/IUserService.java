package com.j2ee.service;

import java.util.List;
import com.j2ee.pojo.User;

public interface IUserService {

	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User queryUserByID(Integer id);
	public User findUserByName(String username);
	public List<User> queryAllUser();

	
}
