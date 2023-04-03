package com.playgroup.my.hibernate_training.aae.collections;

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
		Address addr1 = new Address();
		addr1.setStreet(street);
		addr1.setCity(city);
		addr1.setState(state);
		addr1.setPincode(zipCode);
		
		Address addr2 = new Address();
		addr2.setStreet("Off"+street);
		addr2.setCity("Off"+city);
		addr2.setState("Off"+state);
		addr2.setPincode("Off"+zipCode);
		
		Customer customer = new Customer();
		customer.setFirstName("Donald");
		customer.setLastName("");
		customer.setEmail("donald.duck@gmail.com");
		customer.getListOfAddresses().add(addr1);
		customer.getListOfAddresses().add(addr2);
		return customer;
	}

}
