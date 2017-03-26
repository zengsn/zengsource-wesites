package com.wesites.core.service;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.wesites.core.dao.RoleDAO;
import com.wesites.core.dao.RoleDAOImpl;
import com.wesites.core.pojo.Role;
import com.wesites.core.pojo.User;
import com.wesites.util.PageBean;

public class RoleServiceImpl implements RoleService{

	private RoleDAO dao = new RoleDAOImpl();
	@Override
	public PageBean<Role> queryForPage(int pageSize, int page,int rate) {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("users");
		String hql = "select count(*) from Role where rolerate = " + rate+"and userid="+user.getId();
		int count = dao.getCount(hql); // 鎬昏褰曟暟
		System.out.print(count);
		int totalPage = PageBean.countTotalPage(pageSize, count); // 鎬婚〉鏁�		
		int offset = PageBean.countOffset(pageSize, page); // 褰撳墠椤靛紑濮嬭褰�		
		int length = pageSize; // 姣忛〉璁板綍鏁�		
		int currentPage = PageBean.countCurrentPage(page);
		List<Role> list = dao.queryForPage("from Role where rolerate=? and userid=?", offset, length,rate); // 璇ュ垎椤电殑璁板綍
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
