package org.bmb.dao.entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Session {
	protected SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
