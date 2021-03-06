package com.hb.test;

import org.hibernate.Transaction;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.hb.entity.User;
import com.hb.util.HibernateUtil;

public class Test {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Transaction transaction = session.beginTransaction();

	public static void main(String[] args) {
		Test t = new Test();
		t.userOperations();
	}

	void userOperations() {
		System.out.println("Select your choice");
		System.out.println("1:Add User 2:Delete User 3:Update User 4:View User 5:View All Users");
		Scanner sc = new Scanner(System.in);
		Test t = new Test();
		int i = sc.nextInt();
		switch (i) {
		case 1:
			t.addUser();
			System.out.println("User added successfully...");
			break;
		case 2:
			t.delateuser();
			System.out.println("User deleted successfully...");
			break;
		case 3:
			t.updateUser();
			System.out.println("User updated successfully...");
			break;
		case 4:
			t.viewUser();
			break;
		case 5:
			t.viewAllUsers();
			break;
		default:
			System.out.println("Wrong choice");
		}
		sc.close();
	}

	/* Add User */
	void addUser() {
		User user = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user details:");
		System.out.println("Enter id:");
		user.setId(sc.nextInt());
		System.out.println("Enter First Name:");
		user.setFirstName(sc.next());
		System.out.println("Enter Last Name:");
		user.setLastName(sc.next());
		session.save(user);
		transaction.commit();
		session.close();
		sc.close();
	}

	/* View all users */
	private void viewAllUsers() {

		// Using native query
		/*
		 * @SuppressWarnings("unchecked") List<Object[]> users =
		 * session.createNativeQuery("select * from User").list(); for (Object[] user :
		 * users) { System.out.println(user[0] + " " + user[1] + " " + user[2]); }
		 */

		// Using HQL
		List<User> users = session.createQuery("from User", User.class).list();
		for (User user : users) {
			System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName());
		}
	}

	/* View User */
	private void viewUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter userid");
		User user = session.get(User.class, sc.nextInt());
		System.out.println("User id=" + user.getId());
		System.out.println("User First Name=" + user.getFirstName());
		System.out.println("User Last Name=" + user.getLastName());
		sc.close();
	}

	/* Update User */
	private void updateUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter userid of user to be upadated.");
		User user = session.get(User.class, sc.nextInt());
		System.out.println("Enter firstname of user to be upadated.");
		String fname = sc.next();
		user.setFirstName(fname);
		System.out.println("Enter lastname of user to be upadated.");
		String lname = sc.next();
		user.setLastName(lname);
		session.saveOrUpdate(user);
		transaction.commit();
		sc.close();

	}

	/* Delete User */
	private void delateuser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter userid of user to be deleted.");
		int id = sc.nextInt();
		session.delete(session.get(User.class, id));
		sc.close();
	}
}
