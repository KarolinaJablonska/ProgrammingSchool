<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User panel</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<c:if test="${not empty loggedIn}"><%@ include file="userbox.jsp"%></c:if>
	<div class="wrapper">
		<%@ include file="headeruser.jsp"%>
		<div class="content">

			<div class="headerMini">Your unsolved Excercises</div>
			<table class="view">
				<tr>
					<th>id</th>
					<th>title</th>
					<th>description</th>
					<th></th>
				</tr>

				<c:forEach items="${allUnsolvedExcercises}" var="excercise">
					<tr>
						<td>${excercise.id}</td>
						<td>${excercise.title}</td>
						<td>${excercise.description}</td>
						<td><a
							href="addsolution?user_id=${userId}&ex_id=${excercise.id}"><span
								class="addsolution">add solution</span></a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="headerMini">Your solved Excercises</div>
			<table class="view">
				<tr>
					<th>id</th>
					<th>title</th>
					<th>description</th>
					<th></th>
				</tr>

				<c:forEach items="${allSolvedExcercises}" var="excercise">
					<tr>
						<td>${excercise.id}</td>
						<td>${excercise.title}</td>
						<td>${excercise.description}</td>
						<td><a href="editsolution?ex_id=${excercise.id}"><span
								class="edit">edit</span></a></td>
					</tr>
				</c:forEach>
			</table>

			<div class="headerMini">All your solutions</div>
			<table class="view">
				<tr>
					<th>id</th>
					<th>created</th>
					<th>updated</th>
					<th>description</th>
					<th>excercise_id</th>
					<th></th>
				</tr>

				<c:forEach items="${allUserSolutions}" var="solution">
					<tr>
						<td>${solution.id}</td>
						<td>${solution.created}</td>
						<td>${solution.updated}</td>
						<td>${solution.description}</td>
						<td>${solution.excercise_id}</td>
						<td><a href="solutiondetails?id=${solution.id}"><span
								class="details">details</span></a></td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>