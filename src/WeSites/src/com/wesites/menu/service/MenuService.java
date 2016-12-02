package com.wesites.menu.service;

import com.wesites.menu.pojo.Menu;
import com.wesites.util.PageBean;

public interface MenuService {
	public PageBean<Menu> queryForPage(int pageSize, int currentPage);

}
