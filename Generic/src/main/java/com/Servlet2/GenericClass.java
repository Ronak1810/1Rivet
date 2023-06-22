package com.Servlet2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/app2")
public class GenericClass extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String n1 = req.getParameter("name");
		System.out.println(n1);
		String n2 = req.getParameter("email");
		System.out.println(n2);
		String n3 = req.getParameter("password");
		System.out.println(n3);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("Welcome to Generic servlet");
		
	}

}
