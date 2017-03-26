package com.wesites.core.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wesites.core.pojo.User;
import com.wesites.util.HibernateUtil;

public class UserDAOImpl implements UserDAO {

	// private SessionFactory sessionFactory = null;
	public Session session = null;
	Transaction tx = null;

	private void init() {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		try {
			init();
			session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

		}

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		try {
			init();
			session.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

		}
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		try {
			init();
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

		}
	}

	@Override
	public User queryUserByID(Integer id) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			init();
			user = (User) session.get(User.class, id);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		List<User> users = null;
		try {
			init();
			users = session.createQuery("from User a").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

		}
		return users;
	}

	@Override
	public Long count(String hql, Object[] param) {
		// TODO Auto-generated method stub
		init();
		Query q = session.createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++)
				q.setParameter(i, param[i]);
		}
		int size = q.list().size();
		tx.commit();

		return new Long((long) size);
	}

	@Override
	public User findUserByName(String name) {
		// TODO Auto-generated method stub
		init();
		String hql = "from User as u where u.username=?";
		Query query = session.createQuery(hql);
		query.setString(0, name);
		@SuppressWarnings("rawtypes")
		ArrayList list = (ArrayList) query.list(); // 杩斿洖鐨勬槸涓�釜闆嗗悎
		tx.commit();
		return (User) list.get(0);
	}

}
