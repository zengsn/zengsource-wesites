package com.j2ee.dao;

import java.util.List;
import com.j2ee.pojo.User;

public interface IUserDAO {

	public void save(User user);
	public void delete(User user);
	public void update(User user);
	public User  queryUserByID(Integer id);
	public User findUserByName(String name);
	public List<User> queryAllUser();
	public Long count(String hql,Object[] param);
}
