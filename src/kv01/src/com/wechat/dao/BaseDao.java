package com.wechat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wechat.dto.Pager;
import com.wechat.dto.SystemContext;

/**
 * 数据库管理工具类
 * @类名	BaseDao.java
 */
public class BaseDao<T>{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity) {
		getSession().save(entity);
	}
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		getSession().saveOrUpdate(entity);
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity) {
		getSession().update(entity);
	}
	
	/**
	 * 通过ID 查询
	 * @param c
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object getById(Class c, int id) {
		return getSession().get(c, id);
	}
	
	/**
	 * 分页查询
	 * @param hql
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pager<T> find(String hql, Object[] args) {
		Pager<T> pages = new Pager<T>();
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = 10;
		Query q = this.getSession().createQuery(hql);
		Query cq = this.getSession().createQuery(getCountHql(hql));
		if(args!=null) {
			int index = 0;
			for(Object arg:args) {
				q.setParameter(index, arg);
				cq.setParameter(index, arg);
				index++;
			}
		}
		long totalRecord = (Long)cq.uniqueResult();
		q.setFirstResult(pageOffset == 1 ? 0 : pageOffset);
		q.setMaxResults(pageSize);
		List<T> datas = q.list();
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		long pageNum = totalRecord / pageSize;
		if (totalRecord % pageSize > 0){
			pageNum ++;
		}
		pages.setPageNum(pageNum);
		pages.setTotalRecord(totalRecord);
		return pages;
	}
	
	/**
	 * 计算分页数字
	 * @param hql
	 * @return
	 */
	private String getCountHql(String hql) {
		//1、获取from前面的字符串
		String f = hql.substring(0, hql.indexOf("from")).trim();
		//2、将from前面的字符串替换为select count(*) 
		if("".equals(f)) {
			hql = "select count(*) "+hql;
		} else {
			hql = hql.replace(f, "select count(*) ");
		}
		//3、将fetch替换为""，因为抓取查询不能使用count(*)
		hql = hql.replace("fetch"," ");
		return hql;
	}
	
	//---------------------------------------------------------
	/*
	 * 查询list
	 */
	public List<?> findList(String sql) {
		Query q = this.getSession().createQuery(sql);
		return q.list();
	}
	
	/*
	 * 查询第一个
	 */
	public Object findFirst(String sql) {
		List<?> list = findList(sql);
		if (list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	/*
	 * 查询最后一个
	 */
	public Object findLast(String sql) {
		List<?> list = findList(sql);
		if (list != null && list.size() > 0){
			return list.get(list.size() - 1);
		}
		return null;
	}
	
	/**
	 * 随机查询
	 * @param tableName
	 * @return
	 */
	public T random(String sql) {
		String hql = sql + " order by rand()";
		Query q = this.getSession().createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<T> list = q.list();
		if (list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	public long findCount(String sql) {
		Query cq = this.getSession().createQuery(sql);
		return (Long)cq.uniqueResult();
	}
}
