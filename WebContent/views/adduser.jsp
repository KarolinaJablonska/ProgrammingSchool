<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new user</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Add new user</div>
			<div class="formdiv">
				<form method="POST" action='./adduser'>
					<input name="email" type="TEXT" placeholder="email"
						onfocus="this.placeholder=''" onblur="this.placeholder='email'" /></br>
					<input name="username" type="TEXT" placeholder="username"
						onfocus="this.placeholder=''" onblur="this.placeholder='username'" /></br>
					<input name="password" type="PASSWORD" placeholder="password"
						onfocus="this.placeholder=''" onblur="this.placeholder='password'" /></br>
					<input name="person_group_id" type="TEXT" placeholder="group id"
						onfocus="this.placeholder=''" onblur="this.placeholder='group id'" /></br>
					<input type="SUBMIT" value="Add"/>
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>