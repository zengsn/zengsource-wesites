package com.wesites.autoReply.dao;

import java.util.List;

import com.wesites.BaseDAO;
import com.wesites.autoReply.pojo.AutoReply;

public interface AutoReplyDAO extends BaseDAO<AutoReply> {
	public List<AutoReply> queryForPage(String hql, int offset, int length);

	public int getCount(String hql);

}
