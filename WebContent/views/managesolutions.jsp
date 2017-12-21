<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage solutions</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Manage solutions</div>
			<table class="manage">
				<tr>
					<th></th>
					<th></th>
					<th>id</th>
					<th>created</th>
					<th>updated</th>
					<th>description</th>
					<th>users_id</th>
					<th>excercise_id</th>
				</tr>

				<c:forEach items="${allSolutionsToManage}" var="solution">
					<tr>
						<td><a href="editsolution?id=${solution.id}"><span class="edit">edit</span></a></td>
						<td><a href="deletesolution?id=${solution.id}"><span class="delete">delete</span></a></td>
						<td>${solution.id}</td>
						<td>${solution.created}</td>
						<td>${solution.updated}</td>
						<td>${solution.description}</td>
						<td>${solution.users_id}</td>
						<td>${solution.excercise_id}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>