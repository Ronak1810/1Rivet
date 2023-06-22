<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body align ="center">
	<form action = "UserServlet?a=update" method = "post">
		
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