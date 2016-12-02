package com.wesites.core.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.wesites.core.dao.UserDAO;
import com.wesites.core.dao.UserDAOImpl;
import com.wesites.core.pojo.User;

public class UserServiceImpl implements UserService{

	private UserDAO dao = new UserDAOImpl();
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		this.dao.save(user);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		this.dao.delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			User user2 = this.dao.queryUserByID(user.getId());
			BeanUtils.copyProperties(user,user2);
			this.dao.update(user2);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User queryUserByID(Integer id) {
		User user = this.dao.queryUserByID(id);
		return user;
	}

	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> users = this.dao.queryAllUser();
		return users;
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		User user = this.dao.findUserByName(username);
		return user;
	}

	

}
