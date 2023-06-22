package ConnWithServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/getAllCustomers")
public class getAllCustomers extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		List<users> list=cusDao.getAllCustomers();  
		
		resp.setContentType("text/html");  
	    PrintWriter out=resp.getWriter(); 
	    
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
