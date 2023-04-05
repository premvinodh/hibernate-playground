package com.playgroup.my.hibernate_training.aan.inheritance.tableperclassstrategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		Customer customer = getCustomer("Huey", "Duck", "huey.duck@gmail.com");
		RegularCustomer regularCustomer = getRegularCustomer("Duey", "Duck", "duey.duck@gmail.com", 10);
		IrregularCustomer irregularCustomer = getIrregularCustomer("Luey", "Duck", "luey.duck@gmail.com", 2);

		session.save(customer);
		session.save(regularCustomer);
		session.save(irregularCustomer);

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

	private static RegularCustomer getRegularCustomer(String firstName, String lastName, String email, int discount) {
		RegularCustomer customer = new RegularCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setDiscountPricing(discount);
		return customer;
	}

	private static IrregularCustomer getIrregularCustomer(String firstName, String lastName, String email,
			int discount) {
		IrregularCustomer customer = new IrregularCustomer();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setDiscountPricing(discount);
		return customer;
	}
}
