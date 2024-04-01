package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session=sf.openSession();
//		System.out.println(session.hashCode());

//		Session session2=sf.openSession();
//		System.out.println(session2.hashCode());

//		Session session = sf.getCurrentSession();
//		System.out.println(session.hashCode());

//		session.close();

//		Session session2 = sf.getCurrentSession();
//		System.out.println(session2.hashCode());
		
		

//		int i=(int)session.save(s);//persist
//		session.persist(s); //void
//		session.beginTransaction().commit();
		
//		System.out.println(i);

//		session.update(s);
//		session.saveOrUpdate(s);
//		session.beginTransaction().commit();
		
		Student s = new Student();
//		s.setSid(1);
		s.setSname("akshya");
//
		College c = new College();
		c.setCname("Pccoe");

		int id = (int) session.save(s);
//		int id1=(int)session.save(c);
		session.beginTransaction().commit();

		System.out.println(id);
//		System.out.println(id1);
	}

}
