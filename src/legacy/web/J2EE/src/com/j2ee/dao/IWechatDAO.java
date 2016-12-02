package com.j2ee.dao;

import java.util.List;

import com.j2ee.dao.BaseDAO.IBaseDAO;
import com.j2ee.pojo.User;
import com.j2ee.pojo.Wechat;

public interface IWechatDAO  extends IBaseDAO<Wechat>{

	public List<Wechat> queryForPage(String hql,int offset,int length);
	public int getCount(String hql);
	public Wechat  queryWechatByID(Integer id);
	public Wechat findWechatByName(String name);
	public List<Wechat> queryAllWechat();
}
