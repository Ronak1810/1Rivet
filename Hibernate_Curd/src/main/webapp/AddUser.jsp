<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserServlet" method="post">

		<label>Enter your Name:</label><br> <input type="text"
			name="name"><br> <label>Enter your Email :</label><br>
		<input type="text" name="email"><br>

		<lable>Enter password : </lable>
		<br> <input type="password" name="password"><br>
		<br> <a href="app3"></a><input type="submit" value="Submit"></a>

	</form>
	<br>


	<a href="getUserById"><button type="submit">Get user</button></a>
	<a href="deleteUser"><button type="submit">Delete user</button></a>
	<a href="getAllCustomers"><button type="submit">Click here
			for all user details</button></a>
</body>
</html>