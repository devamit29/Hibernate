package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test2 {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		
		Student s=new Student();
		s.setSname("Ram");
		session.save(s);
		session.beginTransaction().commit();
		 
		
		session.createQuery("from Student");
	}

}
