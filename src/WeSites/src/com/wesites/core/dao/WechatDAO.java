package com.wesites.core.dao;

import java.util.List;

import com.wesites.BaseDAO;
import com.wesites.core.pojo.User;
import com.wesites.core.pojo.Wechat;

public interface WechatDAO extends BaseDAO<Wechat> {

	public List<Wechat> queryForPage(String hql, int offset, int length);

	public int getCount(String hql);

	public Wechat queryWechatByID(Integer id);

	public Wechat findWechatByName(String name);

	public List<Wechat> queryAllWechat();

	Wechat findWechatByUser(User user);
}
