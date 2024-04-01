package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();

		//Session session = sf.openSession();
		//System.out.println(session.hashCode());
		
		//Session session2=sf.openSession();
		//System.out.println(session2.hashCode());
		
		Session session=sf.getCurrentSession();
		System.out.println(session.hashCode());
		
		Session session2=sf.getCurrentSession();
		System.out.println(session2.hashCode());
		
		
	}

}
