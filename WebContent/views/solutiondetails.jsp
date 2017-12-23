<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solution details</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Solution details</div>
			<div class="beforeEdit">
				<b>Solution id: </b> ${solutionInDetail.id}</br> 
				<b>Created: </b>${solutionInDetail.created}</br>
				<b>Last updated: </b>${solutionInDetail.updated}</br> 
				<b>Description: </br></b>${solutionInDetail.description}</br> 
				<b>Refers to excercise no.</b>${solutionInDetail.excercise_id}</br> 
				<b>Assigned to user no. </b>${solutionInDetail.users_id}
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>