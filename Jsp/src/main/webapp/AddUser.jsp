<%-- <%@page import="JSPCurd.Emp"%> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="JSPCurd.EmpDao"%>  
    <%@page import="JSPCurd.Emp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href = "ViewAll.jsp"> View All Employees</a>



  		<%
  		Emp e=new Emp();
  		e.setName(request.getParameter("name"));
  		e.setEmail(request.getParameter("email"));
  		e.setPassword(request.getParameter("password"));
  		int s=0;
  		s=EmpDao.AddUser(e);
  	
  		%>

</body>
</html>
