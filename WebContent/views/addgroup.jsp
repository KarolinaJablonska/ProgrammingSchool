<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add group</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Add new group</div>
			<div class="formdiv">
				<form method="POST" action='./addgroup'>
					<input name="name" type="TEXT" placeholder="name"
						onfocus="this.placeholder=''" onblur="this.placeholder='name'" />
					</br> <input type="SUBMIT" value="Add"/>
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>