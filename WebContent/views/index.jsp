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
					<th>created</th>
					<th>updated</th>
					<th>description</th>
				</tr>

				<c:forEach items="${newestSolutions}" var="solution">
					
					<tr>
						<td>${solution.created}</td>
						<td>${solution.updated}</td>
						<td>${solution.description}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>