<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="JSPCurd.EmpDao" %>
    <%@ page import="JSPCurd.Emp" %>
    <%@ page import="java.util.*" %>
    
<% 
String id = request.getParameter("id");
int id1 = Integer.parseInt(id);
int status =EmpDao.delete(id1);  
if(status>0){
	out.print("Successfull");
}
response.sendRedirect("Index.jsp");  
%>  