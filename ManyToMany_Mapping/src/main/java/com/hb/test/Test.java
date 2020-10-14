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
		Transaction transaction = session.beginTransaction();
		Set<Restaurant> restaurantList = new HashSet<Restaurant>();
		Set<Delivery> deliveries = new HashSet<Delivery>();

		Restaurant restaurant1 = new Restaurant();
		restaurant1.setRestaurantName("Taj");
		restaurant1.setAddress("Mumbai");

		Restaurant restaurant2 = new Restaurant();
		restaurant2.setRestaurantName("Kamat");
		restaurant2.setAddress("Pune");

		Restaurant restaurant3 = new Restaurant();
		restaurant3.setRestaurantName("CCD");
		restaurant3.setAddress("Solapur");

		Delivery delivery1 = new Delivery();
		delivery1.setPartnerName("Zomato");
		delivery1.setCharges(50d);
		delivery1.setRestaurantList(restaurantList);

		Delivery delivery2 = new Delivery();
		delivery2.setPartnerName("Swiggy");
		delivery2.setCharges(40d);
		delivery2.setRestaurantList(restaurantList);

		Delivery delivery3 = new Delivery();
		delivery3.setPartnerName("Uber Eat");
		delivery3.setCharges(55d);
		delivery3.setRestaurantList(restaurantList);

		restaurant1.setDelivery(deliveries);
		restaurant2.setDelivery(deliveries);
		restaurant3.setDelivery(deliveries);

		session.save(restaurant1);
		transaction.commit();
	}
}
