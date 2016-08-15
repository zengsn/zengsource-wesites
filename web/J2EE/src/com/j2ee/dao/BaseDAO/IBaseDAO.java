package com.j2ee.dao.BaseDAO;

import java.util.List;

public interface IBaseDAO<T> {
	
	public void save(T object);
	public void delete(T object);
	public void update(T object);
	public List<T>find(String hql);
	public List find(String hqlString,Object[] param);
	public T findById(Class<T> c,Integer id);
	public T findByParam(String hqlString,Object[] param);
	public T findByParam(String hqlString,List<Object> param);
}
