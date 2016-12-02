package com.wesites.core.dao;

import java.util.List;

import com.wesites.BaseDAO;
import com.wesites.core.pojo.Role;

public interface RoleDAO extends BaseDAO<Role>{
	
	public List<Role> queryForPage(String hql,int offset,int length,int rate);
	public int getCount(String hql);

}
