package com.j2ee.service;

import com.j2ee.pojo.User;
import com.j2ee.pojo.Wechat;
import com.j2ee.util.PageBean;

public interface IWechatService {
	public PageBean<Wechat> queryForPage(int pageSize, int currentPage);
	public Wechat queryWechatByID(Integer id);
	public Wechat findWechatByName(String name);
}
