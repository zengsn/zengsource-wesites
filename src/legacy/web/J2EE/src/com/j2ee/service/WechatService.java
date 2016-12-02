package com.j2ee.service;

import java.util.List;







import com.j2ee.dao.IWechatDAO;
import com.j2ee.dao.WechatDAOImpl;
import com.j2ee.pojo.Wechat;
import com.j2ee.util.PageBean;

public class WechatService implements IWechatService{

	private IWechatDAO dao = new WechatDAOImpl();
	
	public PageBean<Wechat> queryForPage(int pageSize, int page)
	{

		String hql = "select count(*) from Wechat ";
		int count = dao.getCount(hql); // 总记录数
		System.out.print(count);
		int totalPage = PageBean.countTotalPage(pageSize, count); // 总页数
		int offset = PageBean.countOffset(pageSize, page); // 当前页开始记录
		int length = pageSize; // 每页记录数
		int currentPage = PageBean.countCurrentPage(page);
		List<Wechat> list = dao.queryForPage("from Wechat ", offset, length); // 该分页的记录
		PageBean<Wechat> pageBean = new PageBean<Wechat>();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(count);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;
	}
	
	public Wechat queryWechatByID(Integer id) {
		Wechat wechat = this.dao.queryWechatByID(id);
		return wechat;
	}

	@Override
	public Wechat findWechatByName(String name) {
		// TODO Auto-generated method stub
		Wechat wechat = this.dao.findWechatByName(name);
		return null;
	}
	

}
