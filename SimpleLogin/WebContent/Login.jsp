<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/app.css">
</head>
<body>
<h3>Login</h3>
<br>
<form action="LoginServlet" method="post">
Username: <input type="text" name="username"><br>
password: <input type="password" name="password">
<input type="submit" name="Login">
</form>
<p style="color:red">${ErrorMsg}</p>
<br><br>
<p>Don't have an account? <a href="SignupServlet">&nbsp Signup</a></p>

</body>
</html>