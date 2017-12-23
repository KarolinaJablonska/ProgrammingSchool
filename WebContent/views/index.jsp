<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProgrammingSchool Homepage</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<a href="userpanel" class="userpanellink">User panel</a>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">		
		<div class="headerMini">5  recent  solutions</div>
			<table class="view">
				<tr>
					<th>id</th>
					<th>created</th>
					<th>updated</th>
					<th>description</th>
					<th>go to details</th>
					<!-- <th>excercise_id</th> -->
					<!-- <th>users_id</th> -->
				</tr>

				<c:forEach items="${newestSolutions}" var="solution">
					
					<tr>
						<td>${solution.id}</td>
						<td>${solution.created}</td>
						<td>${solution.updated}</td>
						<td>${solution.description}</td>
						<td><a href="solutiondetails?id=${solution.id}"
							style="text-decoration: none; font-size: 20px;"><span class="details">details</span></a></td>
						<!-- <td>${solution.excercise_id}</td> -->
						<!-- <td>${solution.users_id}</td> -->
					</tr>
				</c:forEach>

			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>