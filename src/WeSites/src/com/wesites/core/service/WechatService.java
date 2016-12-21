package com.wesites.core.service;

import com.wesites.core.pojo.User;
import com.wesites.core.pojo.Wechat;
import com.wesites.util.PageBean;

public interface WechatService {
	public PageBean<Wechat> queryForPage(int pageSize, int currentPage);

	public Wechat queryWechatByID(Integer id);

	public Wechat findWechatByName(String name);
	
	public Wechat findWechatByUser(User user);
}
