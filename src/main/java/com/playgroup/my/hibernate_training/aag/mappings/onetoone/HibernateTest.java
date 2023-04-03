package com.playgroup.my.hibernate_training.aag.mappings.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Address addresss = getAddress("Street 1", "City 1", "State 1", "530001");
		Customer customer = getCustomer();
		customer.setAddress(addresss);

		session.save(customer);
//		session.save(addresss);

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
		customer.setFirstName("Mickeyyyy");
		customer.setLastName("Mouse");
		customer.setEmail("mickey.mouse@gmail.com");
		return customer;
	}
}
