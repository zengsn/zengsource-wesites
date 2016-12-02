package com.wesites;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wesites.util.HibernateUtil;

public class BaseDAOImpl<T> implements BaseDAO<T> {

	private Session session = null;
	private Transaction tx = null;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void init() {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
	}

	@Override
	public void save(T object) {
		// TODO Auto-generated method stub
		try {
			init();
			session.save(object);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void delete(T object) {
		// TODO Auto-generated method stub
		try {
			init();
			session.delete(object);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub
		try {
			init();
			session.update(object);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@Override
	public List<T> find(String hql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> find(String hqlString, Object[] param) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Class<T> c, Integer id) {
		// TODO Auto-generated method stub
		T a = null;
		try {
			init();
			a = (T) session.get(c, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

		}
		return a;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findByParam(String hqlString, Object[] param) {
		// TODO Auto-generated method stub
		init();
		Query query = session.createQuery(hqlString);
		query.setString(0, param.toString());
		@SuppressWarnings("rawtypes")
		ArrayList list = (ArrayList) query.list(); // 返回的是一个集合
		tx.commit();
		return (T) list.get(0);
	}

	@Override
	public T findByParam(String hqlString, List<Object> param) {
		// TODO Auto-generated method stub
		return null;
	}

}
