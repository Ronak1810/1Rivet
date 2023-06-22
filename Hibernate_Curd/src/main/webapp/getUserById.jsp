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
<body align = "center">
<h2> Employee Details</h2>
	<%
	Emp e = (Emp)request.getAttribute("Emp");
	%>

	<table border=1 align="center" width="40%">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		
	
		<tr>
			<td><%=e.getId()%></td>
			<td><%=e.getName()%></td>
			<td><%=e.getEmail()%></td>
		</tr>
	</table>
</body>
</html>