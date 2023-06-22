package ConnWithServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getUserById")
public class getUserById extends HttpServlet{

	
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		
		
		out.println("<h3>Get User Details By Id</h3>"); 		   	
		out.println("<form action =getUserById method = post>");
		out.println("<label>Enter Id : </label>");
		out.println("<input type = text name = Id><br>");
		out.println("<input type = submit value = submit>");
		out.println("<form>"); 	
		  
	
	}

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	
	
	resp.setContentType("text/html");  
    PrintWriter out=resp.getWriter(); 
  
    
    String sid =req.getParameter("Id");
    int id = Integer.parseInt(sid);
    List<users> list=cusDao.getUserById(id); 
    
    out.println("<h3 align = center>Get All User Details </h3>");    
     
    out.print("<table border = 1 width = 50% align = center>");
    out.print("<tr><th>Id</th>"
    		+ "<th>Name</th>"
    		+ "<th>Email</th>"
    		+ "<th>Password</th></tr>");  
    
    for(users e : list)
    out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td></tr>"); 
    out.print("</table>");
    
}
}
