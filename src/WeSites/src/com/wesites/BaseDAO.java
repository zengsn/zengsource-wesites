package com.wesites;

import java.util.List;

public interface BaseDAO<T> {
	
	public void save(T object);
	public void delete(T object);
	public void update(T object);
	public List<T>find(String hql);
	@SuppressWarnings("rawtypes")
	public List find(String hqlString,Object[] param);
	public T findById(Class<T> c,Integer id);
	public T findByParam(String hqlString,Object[] param);
	public T findByParam(String hqlString,List<Object> param);
}
