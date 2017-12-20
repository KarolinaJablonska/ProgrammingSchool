<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage users</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Manage users</div>
			<a href="./adduser" class="add">Add new user</a>
			<table class="manage">
				<tr>
					<th></th>
					<th></th>
					<th>id</th>
					<th>email</th>
					<th>username</th>
					<th>group id</th>
				</tr>

				<c:forEach items="${allUsersToManage}" var="user">
					<tr>
						<td><a href="edituser?id=${user.id}"><span class="edit">edit</span></a></td>
						<td><a href="deleteuser?id=${user.id}"><span class="delete">delete</span></a></td>
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.username}</td>
						<td>${user.person_group_id}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>