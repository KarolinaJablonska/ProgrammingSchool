<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit user</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Edit user</div>
			<div class="beforeEdit">
				<b>User id: </b> ${user.id}</br> <b>Email: </b>${user.email}</br> <b>Username: </b>${user.username}</br>
				<b>Group: </b>${user.person_group_id}
			</div>
			<div class="formdiv">
				<form method="POST" action='./edituser'>
					<input name="email" type="TEXT" value="" placeholder="new email"
						onfocus="this.placeholder=''; this.value='${user.email}'"
						onblur="this.placeholder='new email'" /></br> <input name="username"
						type="TEXT" placeholder="new username"
						onfocus="this.placeholder=''; this.value='${user.username}'"
						onblur="this.placeholder='new username'" /></br> <input
						name="password" type="PASSWORD" placeholder="new password"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='new password'" /></br> <input
						name="person_group_id" type="TEXT" placeholder="new group id"
						onfocus="this.placeholder=''; this.value='${user.person_group_id}'"
						onblur="this.placeholder='new group id'" /></br><input type="SUBMIT" value="Edit" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>