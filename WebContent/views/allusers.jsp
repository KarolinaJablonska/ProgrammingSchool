<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All users</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">All users list</div>
			<table class="view">
				<tr>
					<th>id</th>
					<th>email</th>
					<th>username</th>
					<th>group id</th>
					<th></th>
				</tr>

				<c:forEach items="${allUsers}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.email}</td>
						<td>${user.username}</td>
						<td>${user.person_group_id}</td>
						<td><a href="userdetails?id=${user.id}"
							style="text-decoration: none;"><span class="details">details</span></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>