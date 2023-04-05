package com.playgroup.my.hibernate_training.aaj.mappings.manytoone.relationtable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Address addresss1 = getAddress("Street 1", "City 1", "State 1", "530001");
		Address addresss2 = getAddress("Street 2", "City 2", "State 2", "530002");
		
		Customer customer = getCustomer();
		customer.getAddresses().add(addresss1);
		customer.getAddresses().add(addresss2);

		session.save(customer);
		session.save(addresss1);
		session.save(addresss2);

		session.getTransaction().commit();
		session.close();
	}

	private static Address getAddress(String street, String city, String state, String zipCode) {
		Address addr1 = new Address();
		addr1.setStreet(street);
		addr1.setCity(city);
		addr1.setState(state);
		addr1.setPincode(zipCode);
		return addr1;
	}

	private static Customer getCustomer() {
		Customer customer = new Customer();
		customer.setFirstName("Huey");
		customer.setLastName("Duck");
		customer.setEmail("huey.duck@gmail.com");
		return customer;
	}
}
