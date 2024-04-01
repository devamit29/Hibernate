package com;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class App {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);

	public void saveEmp() {
		Session session=sf.openSession();//session instance create
		Employee e=new Employee();
		
		System.out.println("Enter emp Id:");
		e.setEid(sc.nextInt());
		
		System.out.println("Enter emp Name:");
		e.setEname(sc.next());
		
		session.save(e);
		session.beginTransaction().commit();
		System.out.println("Inserted");

	}
	public void getSingleEmp() {
		Session session=sf.openSession();
		System.out.println("Enter Emp Id:");
		int id=sc.nextInt();
		
		Employee emp=session.get(Employee.class, id);
		System.out.println(emp);
		
		
	}
	public void getAllEmp() {
		Session session=sf.openSession();
         Query<Employee>query=session.createQuery("from Employee");
            List<Employee>elist=query.getResultList();
            
            System.out.println(elist);
         
		
	}
	
	public void updateEmpData() {
		Session session=sf.openSession();
		System.out.println("Update eid:");
		int id=sc.nextInt();
		Employee e=session.get(Employee.class, id);
		if(e!=null) {
		System.out.println("Enter updated name:");
		e.setEname(sc.next());
		session.beginTransaction().commit();
		System.out.println("Updated");
		
		
		session.update(e);
		}
		else {
			System.out.println("enter valid id");
		}
		
		
	}
	public void deleteEmp() {
		Session session=sf.openSession();
		System.out.println("Enter Emp Id:");
		int id=sc.nextInt();
		Employee e=session.get(Employee.class, id);
		
		if (e!=null) {
			session.delete(e);
			session.beginTransaction().commit();
			System.out.println("Deleted");
			
		}else {
			System.out.println("Invalid id");
		}
		
	}

	public static void main(String[] args) {

		
		boolean flag = true;
		App a = new App();
		Scanner sc = new Scanner(System.in);

		while (flag) {
			System.out.println("Welcome into app");
			System.out.println("1.To insert data");
			System.out.println("2.Get Single Emp");
			System.out.println("3.Get All Emp");
			System.out.println("4.Update Emp data");
			System.out.println("5.Delete Emp data");
			System.out.println("8.exit");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				a.saveEmp();

				break;
				
			case 2:
			    a.getSingleEmp();
			    break;
			case 3:
				a.getAllEmp();
				break;
			case 4:
				a.updateEmpData();
				break;
			case 5:
				a.deleteEmp();
				break;
				
			case 8:
				System.out.println("Thank you");
				flag=false;
				break;
				
			
				

			default:
				System.out.println("Invalid input");
				break;
			}

		}
	}

}
