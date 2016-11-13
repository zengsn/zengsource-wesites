package com.j2ee.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.j2ee.dao.BaseDAO.BaseDAOImpl;
import com.j2ee.pojo.AutoReply;
import com.j2ee.pojo.User;
import com.j2ee.util.HibernateUtil;


public class AutoReplyDAOImpl extends BaseDAOImpl<AutoReply> implements IAutoReplyDAO{
	
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
	
	
	public List<AutoReply> queryForPage(String hql,int offset,int length)
	{
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		tx.commit ();
		return q.list();
	}
	public int getCount(String hql)
	{
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		tx.commit ();
		return Integer.parseInt(q.list().get(0).toString());
	}

}
