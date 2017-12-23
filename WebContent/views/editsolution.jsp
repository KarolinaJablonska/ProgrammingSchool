<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit solution</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<c:if test="${not empty loggedIn}"><%@ include
			file="userbox.jsp"%></c:if>
	<div class="wrapper">
		<c:if test="${empty loggedIn}"><%@ include file="header.jsp"%></c:if>
		<c:if test="${not empty loggedIn}"><%@ include
				file="headeruser.jsp"%></c:if>
		<div class="content">
			<div class="headerMini">Edit solution</div>
			<div class="beforeEdit">
				<b>Excercise id: </b> ${solution.id}</br> <b>Created: </b>${solution.created}</br>
				<b>Last updated: </b>${solution.updated}</br> <b>Description: </br></b>${solution.description}</br>
				<b>Refers to excercise no. </b>${solution.excercise_id}</br> <b>Assigned
					to user no. </b>${solution.users_id}</br>
			</div>
			<div class="formdiv">
				<form method="POST" action='./editsolution'>
					<input name="description" type="TEXT" value=""
						placeholder="new description"
						onfocus="this.placeholder=''; this.value='${solution.description}'"
						onblur="this.placeholder='new description'" /></br> <input
						type="SUBMIT" value="Edit" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>