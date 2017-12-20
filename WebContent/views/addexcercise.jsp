<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add excercise</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Add new excercise</div>
			<div class="formdiv">
				<form method="POST" action='./addexcercise'>
					<input name="title" type="TEXT" placeholder="title"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='title'" /><br />
					<input name="description" type="TEXT" placeholder="description"
						onfocus="this.placeholder=''"
						onblur="this.placeholder='description'" /><br /> <input
						type="SUBMIT" value="Add" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>