<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage groups</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Manage groups</div>
			<a href="./addgroup" class="add">Add new group</a>
			<table class="manage">
				<tr>
					<th></th>
					<th></th>
					<th>id</th>
					<th>name</th>
				</tr>

				<c:forEach items="${allGroupsToManage}" var="group">
					<tr>
						<td><a href="editgroup?id=${group.id}"><span class="edit">edit</span></a></td>
						<td><a href="deletegroup?id=${group.id}"><span class="delete">delete</span></a></td>
						<td>${group.id}</td>
						<td>${group.name}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>