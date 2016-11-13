package com.j2ee.service;

import com.j2ee.pojo.Role;
import com.j2ee.util.PageBean;

public interface IRoleService {

	public PageBean<Role> queryForPage(int pageSize, int currentPage, int rate);

}
