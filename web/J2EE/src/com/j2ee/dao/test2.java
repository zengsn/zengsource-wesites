package com.j2ee.dao;


import com.j2ee.pojo.User;

public class test2 {

	public static void main(String[] args)
	{
		UserDAOImpl adi=new UserDAOImpl();
		User user=new User();
		user.setUsername("qwe");
		user.setPassword("qwe");
		user.setEmail("qwe");
		adi.save(user);
		System.out.println("添加了agency,name为:"+user.getUsername());
	}
}
