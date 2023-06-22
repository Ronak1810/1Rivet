<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.curd.EmpDao"%>
<%@ page import="com.curd.Emp"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align="center">


	<h2>All User Details</h2>
	<table border=1>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>

		<%
		

		List<Emp> list = EmpDao.getAllUsers();

		for (Emp e : list)
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getEmail() + "</td><td>"
			+ e.getPassword() + "</td></tr>");
		%>

	</table>
	<br>
	<br>
</body>
</html>