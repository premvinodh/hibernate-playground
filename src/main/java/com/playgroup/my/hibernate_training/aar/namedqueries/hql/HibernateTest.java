package com.playgroup.my.hibernate_training.aar.namedqueries.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateTest {

	public static void main(String[] args) {
		SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// Persistent Object once session.save is called.
		CustomerDetail customer1 = getCustomer("Pluto", "Doggie", "pluto.doggie@gmail.com");
		CustomerDetail customer2 = getCustomer("Launch", "Pad", "launch.pad@gmail.com");
		
		session.save(customer1);
		session.save(customer2);

		session.getTransaction().commit();
		session.close();
		
		// ***********************************************
		session = factory.openSession();
		session.beginTransaction();

		Query query = session.getNamedQuery("Customer.byId");
		query.setInteger(0, 1); // hardcoding the value for simplicity
		
		List<CustomerDetail> customers = (List<CustomerDetail>) query.list();

		session.getTransaction().commit();
		session.close();

		for (CustomerDetail cust : customers) {
			System.out.println(cust);
		}
	}

	private static CustomerDetail getCustomer(String firstName, String lastName, String email) {
		CustomerDetail customer = new CustomerDetail();
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		return customer;
	}
}
