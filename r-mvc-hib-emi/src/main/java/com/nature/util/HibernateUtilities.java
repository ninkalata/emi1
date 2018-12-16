package com.nature.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.entity.Customer;


public class HibernateUtilities {
	private static ServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	static {
		try {
			Configuration configuration = new Configuration().configure().addAnnotatedClass(Customer.class);
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.getBootstrapServiceRegistry();
			sessionFactory = configuration.buildSessionFactory();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (HibernateException exception) {
			System.out.println("ERROR : Creating Session Factory!");
			System.out.println(exception);
		}
	}
}
