package com.hb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.entity.Address;
import com.hb.entity.User;
import com.hb.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Address address = new Address();
		address.setStreet("Vijapur road");
		address.setCity("Solapur");
		address.setState("MAharashtra");
		address.setPincode(413004);

		User user = new User();
		user.setFirstName("Rohit");
		user.setLastName("Kumbhar");
		user.setAddress(address);

		session.save(user);
		transaction.commit();
	}
}
