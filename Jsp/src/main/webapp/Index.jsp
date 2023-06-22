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


 <a href = "AddUser.html"><button type = submit> Add Employee </button></a><br><br>

 
 <h2> All User Details </h2>
<table border = 1>
<tr>
<th> Id </th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Delete</th>
<th>Update</th>
</tr>

<%

List<Emp> list=EmpDao.getAllUsers();  

for(Emp e : list)
    out.print("<tr><td><a href =GetUserDetails.jsp?id="+e.getId()+">"+e.getId()+
    "</td><td><a href =GetUserDetails.jsp?Name="+e.getName()+">"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+
    		"</td><td><a href = Delete.jsp?id="+e.getId()+">Delete</a></td><td><a href = UpdateUser.jsp?id="+e.getId()+">Update</a></td></tr>"); 
    


%>

</table>
<br>
 <a href = "Delete.jsp"><button type = submit> Delete User </button></a><br><br>


</body>
</html>