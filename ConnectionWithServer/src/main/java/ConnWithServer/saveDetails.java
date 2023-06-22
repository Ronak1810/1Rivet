package ConnWithServer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveDetails")
public class saveDetails extends HttpServlet {

	//private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		// TODO Auto-generated method stub
				//super.doGet(req, resp);
				 res.setContentType("text/html");  
			     PrintWriter out=res.getWriter(); 
			     
			     String name=req.getParameter("name");  
			     String email=req.getParameter("email");  
			     String password=req.getParameter("password");  
			    
			     users e=new users();  
			     e.setName(name);  
			     e.setEmail(email);
			     e.setPassword(password); 
			     System.out.println(name);
			     System.out.println(email);
			     System.out.println(password);
			       
			     
			    
			     int status=cusDao.save(e);  
			     
//			     out.print("<h1>hello world</h1>");
			     if(status>0){  
			     out.print("<p>Record saved successfully!</p>");  
			            //req.getRequestDispatcher("index.html").include(req, res);  
			     }else{  
			         out.println("Not save your record. please try again.");  
			     }  
			          
			     out.close();  
			       
		
	}
	
}
