package com.wesites.menu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.wesites.core.pojo.Wechat;
import com.wesites.menu.dao.MenuDAO;
import com.wesites.menu.dao.MenuDAOImpl;
import com.wesites.menu.pojo.Menu;
import com.wesites.util.PageBean;



public class MenuServiceImpl implements MenuService{
	private MenuDAO dao = new MenuDAOImpl();
	
	public PageBean<Menu> queryForPage(int pageSize, int page)
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		Wechat wechat = (Wechat) request.getSession().getAttribute("wechat");
		String hql = "select count(*) from Menu where wechatid="+wechat.getWechatid();
		int count = dao.getCount(hql); // 鎬昏褰曟暟
		System.out.print(count);
		int totalPage = PageBean.countTotalPage(pageSize, count); // 鎬婚〉鏁�		
		int offset = PageBean.countOffset(pageSize, page); // 褰撳墠椤靛紑濮嬭褰�		
		int length = pageSize; // 姣忛〉璁板綍鏁�		
		int currentPage = PageBean.countCurrentPage(page);
		List<Menu> list = dao.queryForPage("from Menu where wechatid ="+wechat.getWechatid(), offset, length); // 璇ュ垎椤电殑璁板綍
		PageBean<Menu> pageBean = new PageBean<Menu>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}

}
