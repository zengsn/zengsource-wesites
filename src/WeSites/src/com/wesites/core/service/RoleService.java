package com.wesites.core.service;

import com.wesites.core.pojo.Role;
import com.wesites.util.PageBean;

public interface RoleService {

	public PageBean<Role> queryForPage(int pageSize, int currentPage, int rate);

}
