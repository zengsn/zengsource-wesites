package com.j2ee.dao;


import com.j2ee.pojo.Role;
import com.j2ee.pojo.User;

public class test2 {

	public static void main(String[] args)
	{
		RoleDAOImpl adi=new RoleDAOImpl();
		Role role=new Role();
		role.setRolename("qwe");
		role.setRolerate(1);
		adi.save(role);
		System.out.println("添加了user,name为:"+role.getRolename());
		adi.delete(role);
		System.out.println("delete了user,name为:"+role.getRolename());
		
	}
}
