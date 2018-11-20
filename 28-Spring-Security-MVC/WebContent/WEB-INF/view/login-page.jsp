<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form:form action="loginProcess" method="POST">
		<p>
			username: <input type="text" name="username"> <br>
			<br> passowrd <input type="password" name="password"> <br>
			<br> <input type="submit" value="login">
		</p>
	</form:form>
</body>
</html>