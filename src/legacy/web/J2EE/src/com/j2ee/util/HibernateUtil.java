package com.j2ee.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



@SuppressWarnings("deprecation")
public class HibernateUtil {
		
	 	private static String CONFIG_FILE_LOCATION = "/config/hibernate.cfg.xml";

	    private static final ThreadLocal threadLocal = new ThreadLocal();

	    private static final Configuration cfg = new Configuration();

	    private static SessionFactory sessionFactory;
	    
	    @SuppressWarnings("unchecked")
		public static Session currentSession() throws HibernateException {
	        Session session = (Session) threadLocal.get();

	        if (session == null) {
	            if (sessionFactory == null) {
	                try {
	                    cfg.configure(CONFIG_FILE_LOCATION);
	                    sessionFactory = cfg.buildSessionFactory();
	                }
	                catch (Exception e) {
	                    System.err.println("%%%% Error Creating SessionFactory %%%%");
	                    e.printStackTrace();
	                }
	            }
	            session = sessionFactory.openSession();
	            threadLocal.set(session);
	        }

	        return session;
	    }
	    
	    public static void closeSession() throws HibernateException {
	        Session session = (Session) threadLocal.get();
	        threadLocal.set(null);

	        if (session != null) {
	            session.close();
	            System.out.println("close session");
	        }
	        
	    }
	
	/*
	public static final SessionFactory sessionFactory;
	static 
	{
		try{
			sessionFactory=new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
		}catch (Throwable ex) 
		{
			System.err.println("Initial SessionFactory creation failed." +ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public Transaction beginTransaction()
	{
		Transaction trans=this.getCurrentSession().beginTransaction();
		return trans;
	}
	*/
}
