<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form:form action="loginEmployee" modelAttribute="employee">
		<form:label path="email">Email:</form:label>
		<form:input path="email" />
		<form:label path="password">Password:</form:label>
		<form:input path="password" />
		<input type="submit" value="login">
	</form:form>
</body>
</html>