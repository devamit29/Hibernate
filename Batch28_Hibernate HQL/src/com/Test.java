package com;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test {
	public static void getAllData(SessionFactory sf) {
		// select *from student_details >>
		Session session = sf.openSession();

		Query<Student> query = session.createQuery("from Student");// class name
		List<Student> slist = query.getResultList();
		System.out.println(slist);
	}

	public static void getSingleData(SessionFactory sf) {
		// select *from student id= ?

		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student where sid=:id");
		query.setParameter("id", 4);
		Student s = query.getSingleResult();
		System.out.println(s);
	}

	public static void getSingleDataUsingName(SessionFactory sf) {
		// select *from student name= ?

		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student where sname=:id");
		query.setParameter("id", "Akshya");
		Student s = query.getSingleResult();
		System.out.println(s);
	}

	public static void getAllName(SessionFactory sf) {

		// select sname from student

		Session session = sf.openSession();
		Query<String> query = session.createQuery("select sname from Student");
		List<String> slist = query.getResultList();

		System.out.println(slist);
	}

	public static void getAllNameAndMarks(SessionFactory sf) {

		// select sname,marks from student

		Session session = sf.openSession();
		Query<Object[]> query = session.createQuery("select sname,marks from Student");
		List<Object[]> sarr = query.getResultList();

//		System.out.println(sarr);

		for (Object[] obj : sarr) {
			System.out.println(Arrays.toString(obj));
		}
	}

	public static void maxMarks(SessionFactory sf) {

		// select max(marks) from student

		Session session = sf.openSession();
		Query<Double> query = session.createQuery("select max(marks) from Student");
		Double max_marks = query.getSingleResult();
		System.out.println(max_marks);

	}

	public static void countName(SessionFactory sf) {

		// select count(name) from student

		Session session = sf.openSession();

		Query<Long> query = session.createQuery("select count(sname) from Student");
		Long i = query.getSingleResult();
		System.out.println(i);

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

//		Session session=sf.openSession();
//		
//		Student s=new Student();
//		s.setSname("Akshya");
//		s.setMarks(87.48);
//		
//		
//		session.save(s);
//		session.beginTransaction().commit();

//		getAllData(sf);
//		getSingleData(sf);
//	getSingleDataUsingName(sf);
//		getAllName(sf);
//		getAllNameAndMarks(sf);
//		maxMarks(sf);
		countName(sf);
	}

}
