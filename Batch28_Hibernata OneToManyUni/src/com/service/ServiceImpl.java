package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.connection.HibernateUtil;
import com.model.Driver;
import com.model.Vehicle;

public class ServiceImpl implements Services {
	
	SessionFactory sf=HibernateUtil.getSessionFactory();
	Scanner sc=new Scanner(System.in);
	

	@Override
	public void addDriverWithMultipleVehicle() {
		
		Session session=sf.openSession();
		Driver d=new Driver();
		
		System.out.println("Enter Driver name: ");
		d.setDname(sc.next());
		
		List<Vehicle> vlist=new ArrayList<Vehicle>();
		
		System.out.println("How many vehicle you want to add : ");
		int n=sc.nextInt();
		
		for (int i = 1; i <=n; i++) {
			
			Vehicle v=new Vehicle();
			System.out.println("Enter vehicle name: ");
			v.setVname(sc.next());
			
			vlist.add(v);
			
		}
		d.setVlist(vlist);
		session.save(d);
		session.beginTransaction().commit();
		
		
	}

	@Override
	public void showAllDriverWithVehicle() {
		Session session=sf.openSession();
		Query<Driver> query=session.createQuery("from Driver");
		List<Driver>list=query.getResultList();
		System.out.println(list);
		
		
	}

	@Override
	public void showSingleDriverWithVehicle() {
		Session session=sf.openSession();
		System.out.println("Enter Driver id: ");
		int id=sc.nextInt();
		Driver d=session.get(Driver.class, id);
		System.out.println(d);
		
	}

	@Override
	public void updateDriver() {
		Session session=sf.openSession();
		System.out.println("Enter id: ");
		int id=sc.nextInt();
		Driver d=session.get(Driver.class, id);
		System.out.println("Enter name: ");
		d.setDname(sc.next());
		
		session.update(d);
		session.beginTransaction().commit();
		
		
		
	}

	@Override
	public void updateVehicleUsingDriverID() {
		Session session=sf.openSession();
		System.out.println("Enter Driver id: ");
		int id=sc.nextInt();
		Driver d=session.get(Driver.class, sc.nextInt());
		
		if (d !=null) {
  		List<Vehicle>vlist=d.getVlist();
		System.out.println("Enter vehicle id: ");
		int vid=sc.nextInt();
		for(Vehicle v:vlist) {
			if(v.getVid()==vid) {
				System.out.println("Enter vehicle name: ");
				v.setVname(sc.next());
				
				session.update(v);
				session.beginTransaction().commit();
				System.out.println("updated");
			}
		}
		   
		
		}else {
			System.out.println("Invalid Driver Id!!");
		}
		
		
		
	}

	@Override
	public void deleteDriver() {
		Session session=sf.openSession();
		System.out.println("Enter did: ");
		int id=sc.nextInt();
		Driver d=session.get(Driver.class, id);
		
		session.delete(d);
		session.beginTransaction().commit();
		
	}

	@Override
	public void deleteParticularVehicleUsingDriver() {
		Session session=sf.openSession();
		System.out.println("Enter did: ");
		Driver d=session.get(Driver.class, sc.nextInt());
		
		if (d!=null) {
			List<Vehicle>vlist=d.getVlist();
			System.out.println("Enter vid :");
			int vid=sc.nextInt();
			
		  for(Vehicle v:vlist) {
			  if (v.getVid()==vid) {
				  vlist.remove(v);
				  session.update(d);
				  session.delete(v);
				  session.beginTransaction().commit();
				  break;
				
			}
		  }
			
		}
		
	}
	
	@Override
	public void addVehicleToExistingDriver() {
		
		Session session=sf.openSession();
		System.out.println("Enter did: ");
		Driver d=session.get(Driver.class, sc.nextInt());
		
		Vehicle v=new Vehicle();
		System.out.println("Enter vehicle name:");
		v.setVname(sc.next());
		
		if (d!=null) {
			d.getVlist().add(v);
			session.update(d);
			
			session.beginTransaction().commit();
		}else {
			System.out.println("Invalid id!!!!");
			
		}
		
		
	}
	
	
	
	

}
