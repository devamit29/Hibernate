package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Student student=new Student();
		student.setSid(101);
		student.setSname("Amit");
		
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Inserted");
	}

}
