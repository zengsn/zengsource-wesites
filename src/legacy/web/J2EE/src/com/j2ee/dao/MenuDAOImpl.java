package com.j2ee.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.j2ee.dao.BaseDAO.BaseDAOImpl;
import com.j2ee.pojo.Menu;
import com.j2ee.util.HibernateUtil;

public class MenuDAOImpl extends BaseDAOImpl<Menu> implements IMenuDAO{
	
	private Session session =null;
	private Transaction tx = null;
	
	
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public Transaction getTx() {
		return tx;
	}
	public void setTx(Transaction tx) {
		this.tx = tx;
	}

	@Override
	public List<Menu> queryForPage(String hql, int offset, int length) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		tx.commit ();
		return Integer.parseInt(q.list().get(0).toString());
	}

}
