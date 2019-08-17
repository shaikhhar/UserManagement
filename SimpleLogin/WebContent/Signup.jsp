<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<link rel="stylesheet" href="css/app.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<h3>Registration</h3>
<br>
<form action="SignupServlet" method="post">
FirstName: <input type="text" name="FirstName"><br>
LastName: <input type="text" name="LastName"><br>
Email: <input type="text" name="email"><br>
Username: <input type="text" name="username"><br>
password: <input type="password" name="password"><br>
<input type="submit" name="Sign up">
<p style="color:red"> ${ErrMsg} </p>
</form>

</body>
</html>