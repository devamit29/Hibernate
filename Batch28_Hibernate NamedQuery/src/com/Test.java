package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

//	Student s=new Student();
//	s.setSname("Laxmi");
//	session.save(s);
//	session.beginTransaction().commit();
//	 
//	
//	session.createQuery("from Student");
//		Query<Student> query = session.createNamedQuery("allStudent");
//		List<Student> slist = query.getResultList();
//		System.out.println(slist);
//
//		System.out.println("------------------------");
//
//		Query<Student> query1 = session.createNamedQuery("getStudentId");
//		query1.setParameter("id", 5);
//		Student s = query1.getSingleResult();
//		System.out.println(s);

//		Person p = new Person();
//		p.setPname("Azaz Sir");
//		session.save(p);
//		session.beginTransaction().commit();
		
		Query<Person>query=session.getNamedNativeQuery("allPerson");
		List<Person>plist=query.getResultList();
		System.out.println(plist);
		
		Query<Person>query1=session.getNamedNativeQuery("getPersonUsingName");
		query1.setParameter(1, "Nilesh Sir");
		List<Person>plist1=query1.getResultList();
		System.out.println(plist1);

	}

}
