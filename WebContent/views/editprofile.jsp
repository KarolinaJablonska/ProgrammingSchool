<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit profile</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<c:if test="${not empty loggedIn}"><%@ include file="userbox.jsp"%></c:if>
	<div class="wrapper">
		<%@ include file="headeruser.jsp"%>
		<div class="content">
			<div class="headerMini">Edit profile</div>
			<div class="beforeEdit">
				<b>User id: </b> ${user.id}</br> <b>Email: </b>${user.email}</br> <b>Username:
				</b>${user.username}</br> <b>Group: </b>${user.person_group_id}
			</div>
			<div class="formdiv">
				<form method="POST" action='./editprofile'>
					<input name="email" type="TEXT" value="" placeholder="new email"
						onfocus="this.placeholder=''; this.value='${user.email}'"
						onblur="this.placeholder='new email'" /></br> <input name="password"
						type="PASSWORD" placeholder="new password"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='new password'" /></br> <input type="SUBMIT"
						value="Edit" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>