package com.playgroup.my.hibernate_training.aaa.firstentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(getCustomer());
		session.getTransaction().commit();
	}

	private static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Siva");
		customer.setLastName("Kumar");
		customer.setEmail("siva.kumar@gmail.com");
		return customer;
	}

}
