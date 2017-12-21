<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign excercise to user</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Assign excercise to user</div>
			<div class="formdiv">
				<form method="POST" action='./assignextouser'>
					<input name="user_id" type="TEXT" placeholder="user id"
						onfocus="this.placeholder=''" onblur="this.placeholder='user id'" /></br>
					<input name="ex_id" type="TEXT" placeholder="excercise_id"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='excercise id'" /></br> <input type="SUBMIT"
						value="Assign" />
				</form>
			</div>
			<div class="headerMini">All users list</div>
			<%@ include file="tableviewusers.jsp"%>
			<div class="headerMini">All excercises list</div>
			<%@ include file="tableviewexcercises.jsp"%>
			<div class="headerMini">All solutions list</div>
			<%@ include file="tableviewsolutions.jsp"%>
		</div>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>