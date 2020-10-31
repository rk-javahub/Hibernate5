package com.hb.test;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.hb.entity.Delivery;
import com.hb.entity.Restaurant;
import com.hb.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		// Retrieve record by using sessions get()
		/*
		 * Restaurant restaurant = session.get(Restaurant.class, 2);
		 * System.out.println(restaurant.getRestaurantName());
		 * System.out.println(restaurant.getAddress()); Set<Delivery> deliverys =
		 * restaurant.getDelivery(); deliverys.stream() .forEach(delivery ->
		 * System.out.println(delivery.getPartnerName() + " " + delivery.getCharges()));
		 */

		// Retrieve record by using HQL
		@SuppressWarnings("unchecked")
		Query<Restaurant> query = session.createQuery("from Restaurant");
		List<Restaurant> list = query.list();
		list.forEach(restaurant -> {
			System.out.println("****Hotel Details**** \n" + restaurant.getRestaurantName() + " "
					+ restaurant.getAddress() + "\n****Delivery Details****");
			restaurant.getDelivery().forEach(delivery -> {
				System.out.println(delivery.getPartnerName());
				;
			});
		});

	}
}
