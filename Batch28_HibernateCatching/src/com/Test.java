package com;

import javax.persistence.Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		
//		Student s=new Student();
//		s.setSid(12);
//		s.setSname("Vivek");
//		
//		session.save(s);
//		session.beginTransaction().commit();
//		
//		Student s=session.get(Student.class, 2);
//		System.out.println(s);
		
//		Employee e1=session.get(Employee.class, 3);
//		System.out.println(e1);
//		session.clear();
		
//		session.evict(s);
		
//		System.out.println("____________________");
		
//		Student s2=session.get(Student.class, 2);
//		System.out.println(s2);
		
//		Student s3=session.get(Student.class, 2);
//		System.out.println(s3);
		
//		Student s4=session.get(Student.class, 4);
//		System.out.println(s4); 
//		
//		Employee e2=session.get(Employee.class, 3);
//		System.out.println(e2);
//		
//		Employee e=new Employee();
//		e.setId(35);
//		e.setName("Anthony");
//		
//		session.save(e);
//		session.beginTransaction().commit();
		
		Student s=session.get(Student.class, 1);
		System.out.println(s);
		
		Cache cache=sf.getCache();
		cache.evictAll();
		
		Session session2=sf.openSession();
		
		Student s1=session2.get(Student.class,2);
		System.out.println(s1);
		
		
	}

}
