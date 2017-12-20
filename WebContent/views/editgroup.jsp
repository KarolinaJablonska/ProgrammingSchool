<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit group</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Edit group</div>
			<div class="beforeEdit">
				<b>Group id: </b> ${group.id}</br> <b>Name: </b>${group.name}
			</div>
			<div class="formdiv">
				<form method="POST" action='./editgroup'>
					<input name="name" type="TEXT" value="" placeholder="new name"
						onfocus="this.placeholder=''; this.value='${group.name}'"
						onblur="this.placeholder='new name'" /></br> <input type="SUBMIT" value="Edit" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>