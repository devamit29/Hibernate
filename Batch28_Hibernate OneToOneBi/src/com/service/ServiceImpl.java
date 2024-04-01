package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.connection.HibernateUtil;
import com.entity.AdharCard;
import com.entity.Person;

public class ServiceImpl implements Services {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addPersonWithAdharCard() {
		Session session = sf.openSession();
		Person p = new Person();
		System.out.println("Enter pname: ");
		p.setPname(sc.next());

		AdharCard a = new AdharCard();
		System.out.println("Enter aname: ");
		a.setAname(sc.next());

		p.setAdharCard(a);
		a.setPerson(p);

		session.save(p);
		session.beginTransaction().commit();

	}

	@Override
	public void addAdharCardWithPerson() {
		Session session = sf.openSession();
		Person p = new Person();
		System.out.println("Enter pname: ");
		p.setPname(sc.next());

		AdharCard a = new AdharCard();
		System.out.println("Enter anme: ");
		a.setAname(sc.next());

		p.setAdharCard(a);
		a.setPerson(p);

		session.save(a);
		session.beginTransaction().commit();

	}

	@Override
	public void getAllDataFromPerson() {
		Session session = sf.openSession();
		Query<Person> query = session.createQuery("from Person");
		List<Person> plist = query.getResultList();
		System.out.println(plist);

	}

	@Override
	public void getAllDataFromAdharCard() {
		Session session = sf.openSession();
		Query<AdharCard> query = session.createQuery("from AdharCard");
		List<AdharCard> alist = query.getResultList();
		System.out.println(alist);

	}

	@Override
	public void getSinglePersonDataWithAdharCard() {
		Session session = sf.openSession();
		System.out.println("Enter pid: ");
		int id = sc.nextInt();

		Person person = session.get(Person.class, id);
		System.out.println(person);

	}

	@Override
	public void getSingleAdharcardWithPerson() {
		Session session = sf.openSession();
		System.out.println("Enter aid: ");
		int id = sc.nextInt();

		AdharCard a = session.get(AdharCard.class, id);
		System.out.println(a);

	}

	@Override
	public void updateAdharCardWithPersonId() {
		Session session = sf.openSession();
		System.out.println("Enter pid: ");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);
		AdharCard a = person.getAdharCard();
		System.out.println("Enter aname: ");
		a.setAname(sc.next());

		session.update(person);
		session.beginTransaction().commit();

	}

	@Override
	public void updatePersonWithAdharCardId() {
		Session session = sf.openSession();
		System.out.println("Enter aid: ");
		int id = sc.nextInt();
		AdharCard a = session.get(AdharCard.class, id);
		Person person = a.getPerson();
		System.out.println("Enter pname: ");
		person.setPname(sc.next());

		session.update(a);
		session.beginTransaction().commit();

	}

	@Override
	public void deletePersonWithAdharCardId() {
		Session session = sf.openSession();
		System.out.println("Enter pid: ");
		int id = sc.nextInt();
		Person person = session.get(Person.class, id);

		session.delete(person);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteAdharCardWithPersonId() {
		Session session = sf.openSession();
		System.out.println("Enter aid: ");
		int id = sc.nextInt();
		AdharCard a = session.get(AdharCard.class, id);

		session.delete(a);
		session.beginTransaction().commit();

	}

	@Override
	public void deleteAdharCardOnly() {
		Session session = sf.openSession();
		System.out.println("Enter aid: ");
		int id = sc.nextInt();
		AdharCard a = session.get(AdharCard.class, id);

		Person p = a.getPerson();

		p.setAdharCard(null);
		a.setPerson(null);
		session.update(a);
		session.delete(a);
		session.beginTransaction().commit();

	}

	@Override
	public void deletePersonOnly() {
		Session session = sf.openSession();
		System.out.println("Enter pid: ");
		int id = sc.nextInt();
		Person p = session.get(Person.class, id);
		AdharCard a = p.getAdharCard();

		a.setPerson(null);
		p.setAdharCard(null);

		session.update(p);
		session.delete(p);
		session.beginTransaction().commit();

	}

}
