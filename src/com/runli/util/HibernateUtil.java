package com.runli.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<>();
	
	private HibernateUtil() {}
	
	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session openSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		Session session = threadLocal.get();
		if(session == null) {
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}
		return session;
	}
	
}
