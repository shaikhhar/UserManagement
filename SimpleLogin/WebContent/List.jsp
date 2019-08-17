<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<link rel="stylesheet" href="css/app.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<a href="./Index.jsp" style="position:absolute; top:20px; left:20px">Home</a>
<a href="./Login.jsp" style="position:absolute; top:20px; right:20px">Logout</a>
<br><br>
<p style="color: red"> ${msg} </p>
<table border="1px solid black">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Email</th>
<th>UserName</th>
<th>Password</th>
<th colspan="2">Action</th>
<c:forEach var="user" items="${UserList}">
<tr>
<td>${user.getFirstName()}</td>
<td>${user.getLastName()}</td>
<td>${user.getEmail()}</td>
<td>${user.getUsername()}</td>
<td>${user.getPassword()}</td>
<td style="color: red; border-spacing:3px"><a href="AdminServlet?param1=edit&param2=${user.getUsername()}">Edit</a></td>
<td style="color: red; border-spacing:3px"><a href="AdminServlet?param1=delete&param2=${user.getUsername()}">Delete</a></td>
<td></td>
</c:forEach>

</tr>





</table>

</body>
</html>