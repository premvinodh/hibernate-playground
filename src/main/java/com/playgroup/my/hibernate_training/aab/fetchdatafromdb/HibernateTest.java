package com.playgroup.my.hibernate_training.aab.fetchdatafromdb;

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

		session = factory.openSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("Customer retrieved is " + customer);
		session.getTransaction().commit();
		session.close();
	}

	private static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setId(1);
		customer.setFirstName("Mickey");
		customer.setLastName("Mouse");
		customer.setEmail("mickey.mouse@gmail.com");
		return customer;
	}

}
