package com.j2ee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.j2ee.dao.BaseDAO.BaseDAOImpl;
import com.j2ee.pojo.Role;
import com.j2ee.util.HibernateUtil;

public class RoleDAOImpl extends BaseDAOImpl<Role> implements IRoleDAO{

	private Session session =null;
	private Transaction tx = null;
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}


	
	@Override
	public List<Role> queryForPage(String hql, int offset, int length) {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		tx.commit ();
		return q.list();
	}

	@Override
	public int getCount(String hql) {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		tx.commit ();
		return Integer.parseInt(q.list().get(0).toString());
	}
	

}
