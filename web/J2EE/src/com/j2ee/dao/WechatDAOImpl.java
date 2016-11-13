package com.j2ee.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.j2ee.dao.BaseDAO.BaseDAOImpl;
import com.j2ee.pojo.User;
import com.j2ee.pojo.Wechat;
import com.j2ee.util.HibernateUtil;

public class WechatDAOImpl extends BaseDAOImpl<Wechat> implements IWechatDAO{
	
	private Session session =null;
	private Transaction tx = null;
	
	
	public void init()
	{
		session = HibernateUtil.currentSession();
		tx = session.beginTransaction();
	}
	
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
	public List<Wechat> queryForPage(String hql,int offset,int length)
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
	
	@Override
	public Wechat queryWechatByID(Integer id) {
		// TODO Auto-generated method stub
		Wechat wechat = null;
		try
		{
			init();
			wechat = (Wechat) session.get(Wechat.class,id);
			tx.commit ();
		}catch(HibernateException e){
			if (tx!=null) {
				tx.rollback();
			}
		}finally{

		}
		return wechat;
	}
	@Override
	public Wechat findWechatByName(String name) {
		// TODO Auto-generated method stub
		 init();
		 String hql = "from Wechat as u where u.appid=?";
		  Query query = session.createQuery(hql);
		  query.setString(0, name);
		  ArrayList list= (ArrayList) query.list();    //返回的是一个集合
		  tx.commit();
		  return (Wechat)list.get(0);
	}
	@Override
	public List<Wechat> queryAllWechat() {
		// TODO Auto-generated method stub
		List<Wechat> wechats = null;
		try
		{
			init();
			wechats = session.createQuery("from Wechat a").list();
			tx.commit ();
		}catch(HibernateException e){
			if (tx!=null) {
				tx.rollback();
			}
		}finally{

		}
		return wechats;
	}

}
