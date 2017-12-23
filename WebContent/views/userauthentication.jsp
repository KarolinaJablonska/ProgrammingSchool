<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User authentication</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>

	<div class="wrapper">
			<%@ include file="headeruser.jsp"%>
		<div class="content">
			<div class="headerMini">Log in</div>
			<div class="formdiv">
				<form method="POST" action='./userauthentication'>
					<input name="email" type="TEXT" placeholder="email"
						onfocus="this.placeholder=''" onblur="this.placeholder='email'" />
					<input name="password" type="password" placeholder="password"
						onfocus="this.placeholder=''" onblur="this.placeholder='password'" />
					</br> <input type="SUBMIT" value="Log in"/>
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>