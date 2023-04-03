package com.playgroup.my.hibernate_training.aad.valuetypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(getCustomer("Street 1", "City 1", "State 1", "530001"));
		session.getTransaction().commit();

		session = factory.openSession();
		session.beginTransaction();
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("Customer retrieved is " + customer);
		session.getTransaction().commit();
		session.close();
	}

	private static Customer getCustomer(String street, String city, String state, String zipCode) {
		Address addr = new Address();
		addr.setStreet(street);
		addr.setCity(city);
		addr.setState(state);
		addr.setPincode(zipCode);

		
		Customer customer = new Customer();
		customer.setFirstName("Mickeyyyy");
		customer.setLastName("Mouse");
		customer.setEmail("mickey.mouse@gmail.com");
		customer.setAddress(addr);
		return customer;
	}

}
