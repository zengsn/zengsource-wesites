package com.wechat.service;

import java.util.List;

import com.wechat.dao.BaseDao;
import com.wechat.dto.Pager;

/**
 * 基础服务类
 * @类名	BaseService.java
 */
public class BaseService<T> {

	private BaseDao<T> baseDao;

	public BaseDao<T> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(Object entity) {
		baseDao.save(entity);
	}
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(Object entity) {
		baseDao.saveOrUpdate(entity);
	}
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(Object entity) {
		baseDao.delete(entity);
	}

	/**
	 * 更新
	 * @param entity
	 */
	public void update(Object entity) {
		baseDao.update(entity);
	}
	
	/**
	 * 通过ID 查询
	 * @param c
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object getById(Class c, int id) {
		return baseDao.getById(c, id);
	}
	
	/**
	 * 分页查询
	 * @param hql
	 * @param args
	 * @return
	 */
	public Pager<T> find(String hql, Object[] args) {
		return baseDao.find(hql, args);
	}
	
	/**
	 * 分页查询
	 * @param hql
	 * @return
	 */
	public Pager<T> find(String hql) {
		return find(hql, null);
	}
	
	// -------------------------------------------------------
	/*
	 * 查询list
	 */
	public List<?> findList(String sql) {
		return baseDao.findList(sql);
	}
	
	/*
	 * 查询第一个
	 */
	public Object findFirst(String sql) {
		return baseDao.findFirst(sql);
	}
	
	/*
	 * 查询最后一个
	 */
	public Object findLast(String sql) {
		return baseDao.findLast(sql);
	}
	
	/*
	 * 查询最后一个
	 */
	public Object random(String sql) {
		return baseDao.random(sql);
	}
	
	/*
	 * 统计计数器
	 */
	public long findCount(String sql) {
		return baseDao.findCount(sql);
	}
}
