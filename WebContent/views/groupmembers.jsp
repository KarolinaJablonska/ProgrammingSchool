<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Group members</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Group members</div>
			<table class="view">
				<tr>
					<th>id</th>
					<th>email</th>
					<th>username</th>
					<th></th>
				</tr>

				<c:forEach items="${groupMembers}" var="member">
					<tr>
						<td>${member.id}</td>
						<td>${member.email}</td>
						<td>${member.username}</td>
						<td><a href="userdetails?id=${member.id}"
							style="text-decoration: none;"><span class="details">details</span></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>