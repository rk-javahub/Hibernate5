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

	@SuppressWarnings("deprecation")
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
		/*
		 * @SuppressWarnings("unchecked") Query<Restaurant> query =
		 * session.createQuery("from Restaurant"); List<Restaurant> list = query.list();
		 * list.forEach(restaurant -> { System.out.println("****Hotel Details**** \n" +
		 * restaurant.getRestaurantName() + " " + restaurant.getAddress() +
		 * "\n****Delivery Details****"); restaurant.getDelivery().forEach(delivery -> {
		 * System.out.println(delivery.getPartnerName()); ; }); });
		 */

		// Retrieve single record by using HQL
		/*
		 * @SuppressWarnings("unchecked") Query<Restaurant> query =
		 * session.createQuery("from Restaurant where restaurantId= :id");
		 * query.setInteger("id", 2); Restaurant restaurant = query.uniqueResult();
		 * System.out.println(restaurant.getRestaurantName() + " " +
		 * restaurant.getAddress());
		 */

		// Update Query
		/*
		 * @SuppressWarnings("unchecked") Query<Restaurant> query = session
		 * .createQuery("update Restaurant set restaurantName= :name where restaurantId= :id"
		 * ); query.setParameter("name", "Oasis"); query.setInteger("id", 2);
		 * session.beginTransaction(); int i = query.executeUpdate();
		 * System.out.println(i);
		 */

		@SuppressWarnings("unchecked")
		Query<Double> sum_of_charges = session.createQuery("select sum(charges) from Delivery");
		double charges = sum_of_charges.uniqueResult();
		System.out.println(charges);

	}
}
