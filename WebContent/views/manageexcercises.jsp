<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage excercises</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Manage excercises</div>
			<a href="./addexcercise" class="add">Add new excercise</a>
			<table class="manage">
				<tr>
					<th></th>
					<th></th>
					<th>id</th>
					<th>title</th>
					<th>description</th>
				</tr>

				<c:forEach items="${allExcercisesToManage}" var="excercise">
					<tr>
						<td><a href="editexcercise?id=${excercise.id}"><span class="edit">edit</span></a></td>
						<td><a href="deleteexcercise?id=${excercise.id}"><span class="delete">delete</span></a></td>
						<td>${excercise.id}</td>
						<td>${excercise.title}</td>
						<td>${excercise.description}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>