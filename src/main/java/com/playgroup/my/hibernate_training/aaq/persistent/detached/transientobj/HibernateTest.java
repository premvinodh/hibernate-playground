package com.playgroup.my.hibernate_training.aaq.persistent.detached.transientobj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		// Transient object
		Customer customer = getCustomer("Uncle", "Scrooge", "uncle.scrooge@gmail.com");

		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// Persistent Object once session.save is called.
		session.save(customer);

		// Update but don't call the save/update
		customer.setFirstName("Scrooge");
		customer.setLastName("Duck");

		session.getTransaction().commit();
		session.close();

		// Detached object -- the changes are not tracked - after the session is closed.
		customer.setFirstName("ABC");
		customer.setFirstName("Duck");

	}

	private static Customer getCustomer(String firstName, String lastName, String email) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		return customer;
	}
}
