<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
</head>
<body>
	<h3>HI ${name}</h3>
	<table border="2px">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${elist}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.email}</td>
				<td>${employee.password}</td>
				<td><a href="delete?id=${employee.id}">delete</a></td>
				<td><a href="edit?id=${employee.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>