package com.curd;

import org.hibernate.Transaction;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmpDao {

	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Emp.class);
	private static SessionFactory sf = cfg.buildSessionFactory();

	public static int save(Emp e) {

		int status = 0;

		Session s = sf.openSession();

		Transaction tf = s.beginTransaction();
		s.save(e);
		tf.commit();
		return status;
	}

	public static List<Emp> getAllUsers() throws SQLException {

		Session s = sf.openSession();
		Transaction tf = s.beginTransaction();

		List<Emp> list = s.createQuery("FROM Emp").getResultList();
		for (Emp e : list) {
			System.out.println(+e.getId() + " " + e.getName() + " " + e.getEmail() + " " + e.getPassword());
		}

		tf.commit();
		s.close();

		return list;
	}

	public static void delete(Emp e) {

		Session s = sf.openSession();
		Transaction tf = s.beginTransaction();

		s.delete(e);
		tf.commit();
		s.close();

	}

	public static Emp getEmpById(int id) {

		Session s = sf.openSession();
		Transaction tf = s.beginTransaction();

		Emp e = s.get(Emp.class, id);
		tf.commit();
		s.close();

		return e;
	}

	public static void update(Emp e) {

		Session s = sf.openSession();
		Transaction tf = s.beginTransaction();

		s.update(e);
		tf.commit();
		s.close();

	}

	public static Emp getUserById(int id) {

		Session s = sf.openSession();
		Transaction tf = s.beginTransaction();

		Emp e = s.get(Emp.class, id);

		tf.commit();
		s.close();
		return e;

	}

}
