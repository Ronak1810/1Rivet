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
String sid = request.getParameter("id");
int id1 = Integer.parseInt(sid);
String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");

Emp e = new Emp();
e.setId(id1);
e.setName(name);
e.setEmail(email);
e.setPassword(password);

int status = EmpDao.Update(e);  


if (status > 0){
	out.println("succsessfull");
}
else {
	out.println("unsuccsessfull");
}
response.sendRedirect("Index.jsp");
%> 
</body>
</html>