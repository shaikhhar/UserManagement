<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/app.css">
</head>
<body>
<a href="./Index.jsp" style="position:absolute; top:20px; left:20px">Home</a>
<a href="./Login.jsp" style="position:absolute; top:20px; right:20px">Logout</a>
<br><br>
<h1>Home Page</h1>
<p> Welcome: ${user}</p>
<br>
<a href="ListUserServlet">User List</a>


</body>
</html>