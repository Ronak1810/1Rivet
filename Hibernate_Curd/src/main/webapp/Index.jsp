<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.curd.EmpDao"%>
<%@ page import="com.curd.Emp"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body align="center">
	<a href="AddEmp.jsp"><button type=submit>Add Employee</button></a>
	<h2>All User Details</h2>
	<table border=1 align="center" width="50%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<%
		List<Emp> list = EmpDao.getAllUsers();
		//System.out.println()
		for (Emp e : list) {
		%>
		<tr>
			<td><a href="UserServlet?a=getUserById&id=<%=e.getId()%>"><%=e.getId() %></a></td>			
			<td><%=e.getName()%></td>
			<td><%=e.getEmail()%></td>
			<td><%=e.getPassword()%></td>
			<td><a href="UserServlet?a=delete&id=<%=e.getId()%>">Delete</a></td>
			<td><a href="update.jsp?id=<%=e.getId()%>">Update</a></td>
		</tr>

		<%
		}
		%>

	</table>
	<br>
	<br>

	<br>
	<br>





</body>
</html>