package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.connection.HibernateUtil;
import com.entity.Company;
import com.entity.Product;

public class ServiceImpl implements Services {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	@Override
	public void addCompanyWithProducts() {

		Session session = sf.openSession();

		Company c = new Company();
		System.out.println("Enter Cname:");
		c.setCname(sc.next());

		List<Product> plist = new ArrayList<Product>();
		System.out.println("How many products you want to add:");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			Product p = new Product();
			System.out.println("Enter pname:");
			p.setPname(sc.next());

			p.setCompany(c);
			plist.add(p);

		}
		c.setPlist(plist);
		session.save(c);
		session.beginTransaction().commit();

	}

	@Override
	public void showAllCompanyWithProducts() {
		Session session = sf.openSession();
		Query<Company> query = session.createQuery("from Company");
		List<Company> clist = query.getResultList();
		System.out.println(clist);

	}

	@Override
	public void getSingleCompanyWithMultipleProducts() {
		Session session = sf.openSession();

		System.out.println("Enter cid:");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {
			System.out.println(c);

		} else {
			System.out.println("Invalid id");

		}

	}

	@Override
	public void updateComapnyUsingCid() {
		Session session=sf.openSession();
		System.out.println("Enter cid: ");
		int id=sc.nextInt();
		Company c=session.get(Company.class, id);
		System.out.println("Enter cname:");
		c.setCname(sc.next());
		
		session.update(c);
		session.beginTransaction().commit();
		

	}

	@Override
	public void updateProductUsingCid() {
		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {
			List<Product> plist = c.getPlist();
			System.out.println("Enter pid:");
			int pid = sc.nextInt();
			for (Product p : plist) {
				if (pid == p.getPid()) {
					System.out.println("Enter pname:");
					p.setPname(sc.next());
					session.update(p);
					session.beginTransaction().commit();
				}
			}

		} else {
			System.out.println("Invalid id");

		}

	}

	@Override
	public void updateCompanyUsingPid() {
		
		
	}

	@Override
	public void deleteCompanyUsingCid() {
		Session session=sf.openSession();
		System.out.println("Enter cid:");
		int id=sc.nextInt();
		Company c=session.get(Company.class, id);
		
		if (c!=null) {
			session.delete(c);
			session.beginTransaction().commit();
			System.out.println("Deleted");
			
		}else {
			System.out.println("Invalid id");
		}

	}

	@Override
	public void deleteProductUsingCid() {
		Session session = sf.openSession();
		System.out.println("Enter cid:");
		Company c = session.get(Company.class, sc.nextInt());

		if (c != null) {
			List<Product> plist = c.getPlist();
			System.out.println("Enter pid:");
			int pid = sc.nextInt();
			for (Product p : plist) {
				if (pid == p.getPid()) {
					p.setCompany(null);
					plist.remove(p);
					session.update(c);
					session.delete(p);
					session.beginTransaction().commit();
					break;

				}

			}

		} else {
			System.out.println("Invalid id!!!!");

		}

	}

	@Override
	public void deleteCompanyUsingPid() {
		Session session = sf.openSession();
		System.out.println("Enter pid:");

		Product p = session.get(Product.class, sc.nextInt());

		if (p != null) {
			Company c = p.getCompany();
			List<Product> plist = c.getPlist();

			for (Product p1 : plist) {
				p1.setCompany(null);

			}
			c.setPlist(null);

			session.update(c);
			session.delete(c);
			session.beginTransaction().commit();

		} else {
			System.out.println("Invalid id");

		}

	}

	@Override
	public void addProductToExistingCompany() {

	}

	@Override
	public void addCompanyToExistingProduct() {
		Session session = sf.openSession();

		Company c = new Company();
		System.out.println("Enter cname:");
		c.setCname(sc.next());

		System.out.println("Enter pid:");
		Product p = session.get(Product.class, sc.nextInt());
		if (p != null) {
			List<Product> plist = new ArrayList<>();
			p.setCompany(c);
			plist.add(p);
			c.setPlist(plist);

			session.save(c);
			session.beginTransaction().commit();
		} else {
			System.out.println("invalid id!!!");

		}

	}

}
