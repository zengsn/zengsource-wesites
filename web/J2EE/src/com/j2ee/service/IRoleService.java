package com.j2ee.service;

import com.j2ee.util.PageBean;

public interface IRoleService {

	public PageBean queryForPage(int pageSize, int currentPage);

}
