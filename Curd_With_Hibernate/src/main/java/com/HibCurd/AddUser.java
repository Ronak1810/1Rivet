package com.HibCurd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Emp e = new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(password);
		System.out.println(name);
		System.out.println(email);
		System.out.println(password);

		Configuration con = new Configuration().configure("hibernate.cfg.xml");

		SessionFactory sf = con.buildSessionFactory();

		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(e);

		tx.commit();
		
		s.close();
	}

}
