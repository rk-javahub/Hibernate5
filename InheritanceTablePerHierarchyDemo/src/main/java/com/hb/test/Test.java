package com.hb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.entity.ContractEmployee;
import com.hb.entity.Employee;
import com.hb.entity.RegularEmployee;
import com.hb.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp = new Employee();
		emp.setName("Sachin");

		RegularEmployee remp = new RegularEmployee();
		remp.setName("Ranjit");
		remp.setSalary(45000.00F);
		remp.setBonus(7000);
		
		ContractEmployee cemp = new ContractEmployee();
		cemp.setName("Yogesh");
		cemp.setContract_duration("3 year");
		cemp.setPay_per_hour(400);
		
		session.save(emp);
		session.save(remp);
		session.save(cemp);
		transaction.commit();
	}
}
