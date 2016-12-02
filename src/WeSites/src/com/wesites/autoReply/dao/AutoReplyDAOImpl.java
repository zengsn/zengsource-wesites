package com.wesites.autoReply.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wesites.BaseDAOImpl;
import com.wesites.autoReply.pojo.AutoReply;
import com.wesites.util.HibernateUtil;

public class AutoReplyDAOImpl extends BaseDAOImpl<AutoReply>implements AutoReplyDAO {

	private Session session = null;
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

	@SuppressWarnings("unchecked")
	public List<AutoReply> queryForPage(String hql, int offset, int length) {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		tx.commit();
		return q.list();
	}

	public int getCount(String hql) {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		tx.commit();
		return Integer.parseInt(q.list().get(0).toString());
	}

}
