package com.j2ee.service;


import java.util.List;

import com.j2ee.dao.IRoleDAO;
import com.j2ee.dao.RoleDAOImpl;
import com.j2ee.pojo.Role;
import com.j2ee.util.PageBean;

public class RoleService implements IRoleService{

	private IRoleDAO dao = new RoleDAOImpl();
	@Override
	public PageBean queryForPage(int pageSize, int page) {
		String hql = "select count(*) from Role";
		int count = dao.getCount(hql); // 总记录数
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);
		List<Role> list = dao.queryForPage("from Role", offset, length); // 该分页的记录
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
