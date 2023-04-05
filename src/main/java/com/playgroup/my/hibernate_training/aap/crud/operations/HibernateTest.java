package com.playgroup.my.hibernate_training.aap.crud.operations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Customer customer = getCustomer("Uncle", "Scrooge", "uncle.scrooge@gmail.com");
		session.save(customer);

		Customer fetchedCustomer = (Customer) session.get(Customer.class, 1);
		System.out.println("Customer fetched from db:" + fetchedCustomer);

		fetchedCustomer.setFirstName("Scrooge");
		fetchedCustomer.setFirstName("Duck");
		session.update(fetchedCustomer);

		Customer fetchedCustomerAgain = (Customer) session.get(Customer.class, 1);
		System.out.println("Updated Customer fetched from db:" + fetchedCustomerAgain);

		session.delete(fetchedCustomerAgain);

		session.getTransaction().commit();
		session.close();
	}

	private static Customer getCustomer(String firstName, String lastName, String email) {
		Customer customer = new Customer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		return customer;
	}
}
