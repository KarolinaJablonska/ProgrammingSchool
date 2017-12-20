<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User details</title>
<%@ include file="headInclude.jsp" %>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">User details</div>
			<div class="beforeEdit">
				<b>User id: </b> ${userInDetail.id}</br> 
				<b>Email: </b>${userInDetail.email}</br>
				<b>Username: </b>${userInDetail.username}</br> 
				<b>Group: </b>${userInDetail.person_group_id}</br> 
			</div>
			
			<div class="headerMini">User's solutions</div>
				<table class="view">
		<tr>
			<th>id</th>
			<th>created</th>
			<th>updated</th>
			<th>description</th>
			<th></th>
		</tr>

		<c:forEach items="${userSolutions}" var="solution">
			<tr>
				<td>${solution.id}</td>
				<td>${solution.created}</td>
				<td>${solution.updated}</td>
				<td>${solution.description}</td>
				<td><a href="solutiondetails?id=${solution.id}"
					style="text-decoration: none;"><span class="details">details</span></a></td>
			</tr>
		</c:forEach>
	</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>