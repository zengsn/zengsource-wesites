package com.wesites.menu.dao;

import java.util.List;

import com.wesites.BaseDAO;
import com.wesites.menu.pojo.Menu;

public interface MenuDAO extends BaseDAO<Menu>{
	public List<Menu> queryForPage(String hql,int offset,int length);
	public int getCount(String hql);

}
