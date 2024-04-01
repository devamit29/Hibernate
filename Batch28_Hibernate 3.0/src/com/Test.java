package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		
		Student s=new Student();
		s.setSid(105);
		s.setSname("Vishal");
		s.setAddress("Pune");
		
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Inserted");
		
		
	}

}
