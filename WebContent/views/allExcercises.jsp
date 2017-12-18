<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All excercises</title>
</head>
<body>
	<table style="width: 100%" border="1">
		<tr>
			<th>id</th>
			<th>Title</th>
			<th>Description</th>
		</tr>

		<c:forEach items="${allExcercises}" var="excercise">
			<tr>
				<td>${excercise.id}</td>
				<td>${excercise.title}</td>
				<td>${excercise.description}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
