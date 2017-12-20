<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Excercise details</title>
<%@ include file="headInclude.jsp" %>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Excercise details</div>
			<div class="beforeEdit">
				<b>Excercise id: </b> ${excerciseInDetail.id}</br> 
				<b>Excercise title: <br/></b>${excerciseInDetail.title}</br>
				<b>Excercise description: <br/></b>${excerciseInDetail.description}</br> 
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>