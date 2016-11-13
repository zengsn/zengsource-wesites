package com.j2ee.service;

import com.j2ee.pojo.Menu;
import com.j2ee.util.PageBean;

public interface IMenuService {
	public PageBean<Menu> queryForPage(int pageSize, int currentPage);

}
