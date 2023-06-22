package httpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app3")
public class HttpClass extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, res);
		String n1 = req.getParameter("name");
		System.out.println(n1);
		String n2 = req.getParameter("email");
		System.out.println(n2);
		String n3 = req.getParameter("password");
		System.out.println(n3);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("Welcome to http servlet");
	}

}
