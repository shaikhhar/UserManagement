<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>D</title>
<link rel="stylesheet" href="css/app.css">
</head>
<body>
<p style="font-weight: bold">Update <span style="font-style: italic"> ${username} </span> </p>
<form action="AdminServlet" method="post">
<input type="hidden" name="usernameO" value="${username}">
FirstName: <input type="text" name="FirstName" value="${FirstName}" placeholder="${FirstName}"><br>
LastName: <input type="text" name="LastName" value="${LastName}" placeholder="${LastName}"><br>
Email: <input type="text" name="email" value="${email}" placeholder="${email}"><br>
password: <input type="password" name="password" value="${password}" placeholder="${password}"><br>
<input type="submit" value="Update">
<p style="color:red"> ${ErrMsg} </p>
</form>

</body>
</html>