package ConnWithServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		

		res.setContentType("text/html"); 
		PrintWriter out=res.getWriter();
		
		
		out.println("<h3>Delete User</h3>"); 		   	
		out.println("<form action =deleteUser method = post>");
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
	    List<users> list=cusDao.deleteUser(id); 
	    
	    out.println("<h3>Succsessfully Delete User</h3>"); 		
	}

}
