package com.akhm.utils;

import java.io.Serializable;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private HibernateUtils() {

	}

	private static SessionFactory sessFact;

	static {
		try {
			Configuration cfg = new Configuration()
					.configure("hibernate.cfg.xml");
			sessFact = cfg.buildSessionFactory();

		} catch (Throwable t) {
			throw new ExceptionInInitializerError(t);

		}
	}

	public static SessionFactory getSessionFactory() {
		if (sessFact == null) {
			try {
				Configuration cfg = new Configuration()
						.configure("hibernate.cfg.xml");
				sessFact = cfg.buildSessionFactory();
			} catch (Throwable t) {
				throw new ExceptionInInitializerError(t);
			}

		}
		return sessFact;
	}

	private static final ThreadLocal<Session> threadLocalSession = new ThreadLocal();

	public static Session getSession() {
		Session session = threadLocalSession.get();
		if (session == null || !session.isOpen()) {
			threadLocalSession.set(session);
			session = getSessionFactory().openSession();
		}
		return session;
	}

	// Session = Connection
	public static void closeSession() {
		Session session = threadLocalSession.get();
		if (session != null && session.isOpen()) {
			session.close();
			threadLocalSession.remove();
		}
	}

	public static Serializable save(Object entity) {
		Serializable primaryKey = null;
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		primaryKey = session.save(entity);
		tx.commit();
		return primaryKey;
	}

}
