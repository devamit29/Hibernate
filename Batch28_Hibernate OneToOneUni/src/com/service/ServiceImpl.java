package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.HibernateUtil;
import com.model.Address;
import com.model.Student;

public class ServiceImpl implements Services{
	SessionFactory sf=HibernateUtil.getSessionFactory();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addStudentWithAddress() {
		Session session=sf.openSession();
		Student s=new Student();
		System.out.println("Enter Sname: ");
		s.setSname(sc.next());
		
		Address a=new Address();
		System.out.println("Enter City: ");
		a.setCity(sc.next());
		
		s.setAddress(a);
		
		session.save(s);
		//session.save(a);
		session.beginTransaction().commit();
		System.out.println("Inserted");
		
	}
	
	@Override
	public void showStudentWithAddress() {
		Session session=sf.openSession();
		System.out.println("Enter student id: ");
		int id=sc.nextInt();
		
		Student s=session.get(Student.class, id);
		System.out.println(s);
		
	}
	
	@Override
	public void showAllStudentWithAddress() {
		Session session=sf.openSession();
		Query<Student>query=session.createQuery("from Student");
		List<Student>slist=query.getResultList();
		System.out.println(slist);
		
	}
	
	@Override
	public void updateStudentAndAddress() {
		Session session=sf.openSession();
		System.out.println("Enter sid : ");
		int id=sc.nextInt();
		
		Student s=session.get(Student.class, id);
		System.out.println("Enter name: ");
		s.setSname(sc.next());
		
		Address address=s.getAddress();
		System.out.println("Enter city: ");
		address.setCity(sc.next());
		
		session.update(s);
		session.beginTransaction().commit();
		
	}
	
	@Override
	public void deleteStudentWithAddress() {
		Session session=sf.openSession();
		System.out.println("Enter sid : ");
		int id=sc.nextInt();
		Student s=session.get(Student.class, id);
		
		session.delete(s);
		session.beginTransaction().commit();
		
		
	}
	@Override
	public void exist() {
		
		System.out.println("---Thank you for visiting---");
		
		
	}
	
 

}
