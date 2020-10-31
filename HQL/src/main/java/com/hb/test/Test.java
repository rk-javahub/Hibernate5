package com.hb.test;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.entity.Delivery;
import com.hb.entity.Restaurant;
import com.hb.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		

		Restaurant restaurant = session.get(Restaurant.class, 52);
		System.out.println(restaurant.getRestaurantName());
		System.out.println(restaurant.getAddress());

	}
}
