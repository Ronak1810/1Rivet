<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="JSPCurd.EmpDao" %>
    <%@ page import="JSPCurd.Emp" %>
    <%@ page import="java.util.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String sid =request.getParameter("Id");
int id = Integer.parseInt(sid);
List<Emp> list=EmpDao.GetDetails(id); 
%>
<h3 align = center>Get All User Details </h3>
<table border = 1 width = 50% align = center>
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Password</th></tr>

<%
Emp e1 = new Emp();
 for(Emp e : list) 
    out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td></tr>"); 
    out.print("</table>");
    
%>
</body>
</html>