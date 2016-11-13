package com.j2ee.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.j2ee.dao.IRoleDAO;
import com.j2ee.dao.RoleDAOImpl;
import com.j2ee.pojo.Role;
import com.j2ee.pojo.User;
import com.j2ee.util.PageBean;

public class RoleService implements IRoleService{

	private IRoleDAO dao = new RoleDAOImpl();
	@Override
	public PageBean<Role> queryForPage(int pageSize, int page,int rate) {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("users");
		String hql = "select count(*) from Role where rolerate = " + rate+"and userid="+user.getId();
		int count = dao.getCount(hql); // 总记录数
		System.out.print(count);
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);
		List<Role> list = dao.queryForPage("from Role where rolerate=? and userid=?", offset, length,rate); // 该分页的记录
		PageBean<Role> pageBean = new PageBean<Role>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
