package com.j2ee.dao;

import java.util.List;

import com.j2ee.dao.BaseDAO.IBaseDAO;
import com.j2ee.pojo.Role;

public interface IRoleDAO extends IBaseDAO<Role>{
	
	public List<Role> queryForPage(String hql,int offset,int length);
	public int getCount(String hql);

}
