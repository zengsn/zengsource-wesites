package com.j2ee.dao;

import java.util.List;

import com.j2ee.dao.BaseDAO.IBaseDAO;
import com.j2ee.pojo.AutoReply;


public interface IAutoReplyDAO extends IBaseDAO<AutoReply>
{
	public List<AutoReply> queryForPage(String hql,int offset,int length);
	public int getCount(String hql);
	
}
