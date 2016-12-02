package com.wesites.core.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wesites.BaseDAOImpl;
import com.wesites.core.pojo.Role;
import com.wesites.core.pojo.User;
import com.wesites.util.HibernateUtil;

public class RoleDAOImpl extends BaseDAOImpl<Role>implements RoleDAO {

	private Session session = null;
	private Transaction tx = null;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> queryForPage(String hql, int offset, int length, int rate) {
		HttpServletRequest request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("users");
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		q.setParameter(0, rate);
		q.setParameter(1, user.getId());
		q.setFirstResult(offset);
		q.setMaxResults(length);
		tx.commit();
		return q.list();
	}

	@Override
	public int getCount(String hql) {
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
		Query q = session.createQuery(hql);
		tx.commit();
		return Integer.parseInt(q.list().get(0).toString());
	}

}
