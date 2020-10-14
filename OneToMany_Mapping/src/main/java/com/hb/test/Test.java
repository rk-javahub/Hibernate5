package com.hb.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hb.entity.BankAccount;
import com.hb.entity.User;
import com.hb.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		User user = new User();
		user.setFirstName("Rohit");
		user.setLastName("Kumbhar");

		BankAccount hdfcBankAccount = new BankAccount();
		hdfcBankAccount.setBankName("HDFC Bank");
		hdfcBankAccount.setAccountNumber(412365478);
		hdfcBankAccount.setBranch("Kharadi");
		hdfcBankAccount.setUser(user);

		BankAccount axisBankAccount = new BankAccount();
		axisBankAccount.setBankName("Axis Bank");
		axisBankAccount.setAccountNumber(742365478);
		axisBankAccount.setBranch("Chandan Nagar");
		axisBankAccount.setUser(user);

		BankAccount sbiBankAccount = new BankAccount();
		sbiBankAccount.setBankName("SBI Bank");
		sbiBankAccount.setAccountNumber(12565478);
		sbiBankAccount.setBranch("Solapur");
		sbiBankAccount.setUser(user);

		Set<BankAccount> setaccount = new HashSet<BankAccount>();
		setaccount.add(hdfcBankAccount);
		setaccount.add(axisBankAccount);
		setaccount.add(sbiBankAccount);

		user.setBankAccount(setaccount);

		session.save(user);
		transaction.commit();
	}
}
