package com.curd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Emp e = new Emp();
		String a = req.getParameter("a");

		switch (a) {

		case "save":
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			e.setName(name);
			e.setEmail(email);
			e.setPassword(password);

			System.out.println(name);
			System.out.println(email);
			System.out.println(password);

			EmpDao.save(e);
			res.sendRedirect("Index.jsp");

			break;

		case "delete":

			String id = req.getParameter("id");
			int sid = Integer.parseInt(id);
			e = EmpDao.getEmpById(sid);
			EmpDao.delete(e);
			res.sendRedirect("Index.jsp");
			break;

		case "update":
			id = req.getParameter("id");
			sid = Integer.parseInt(id);
			e.setId(sid);
			e.setName(req.getParameter("name"));
			e.setEmail(req.getParameter("email"));
			e.setPassword(req.getParameter("password"));
			// System.out.println(id);
			EmpDao.update(e);
			res.sendRedirect("Index.jsp");
			break;
			
		case "getUserById":
			id = req.getParameter("id");
			sid = Integer.parseInt(id);
			e.setId(sid);
			e.setName(req.getParameter("name"));
			e.setEmail(req.getParameter("email"));
			e.setPassword(req.getParameter("password"));
			e=EmpDao.getUserById(sid);
			req.setAttribute("Emp", e);
			req.getRequestDispatcher("getUserById.jsp").forward(req, res);
			break;
				
		case "Default":
			System.exit(0);

		}

	}

}
