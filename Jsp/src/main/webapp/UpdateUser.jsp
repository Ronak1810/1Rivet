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
String id = request.getParameter("id");
%>
 

<h2> Update Details </h2>
<form action = "UpdateForm.jsp" method = "post">

			<label >Enter Id :</label><br>
  			<input type="text" name="id"><br>
  			
			<label >Enter your Name:</label><br>
  			<input type="text" name="name"><br>
  			
  			<label >Enter your Email :</label><br>
  			<input type="text" name="email"><br>
  			
  			<label >Enter password : </lable><br>
  			<input type="password" name="password"><br><br>
  			
  			<input type="submit" value="Submit">
  		
  		</form><br>
 

</body>
</html>