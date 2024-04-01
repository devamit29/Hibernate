package com.connection;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Environment;

import com.entity.Company;
import com.entity.Product;
import com.mysql.jdbc.Driver;

public class HibernateUtil {

	public static StandardServiceRegistry registry;

	public static SessionFactory sf;

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/batch28hbmonetomanybi");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.HBM2DDL_AUTO, "update");

			registry = new org.hibernate.boot.registry.StandardServiceRegistryBuilder().applySettings(map).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Company.class)
					.addAnnotatedClass(Product.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.buildSessionFactory();
			return sf;
		}
		return sf;

	}

}
