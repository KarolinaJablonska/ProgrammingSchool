<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Panel</title>
<%@ include file="headInclude.jsp"%>
</head>
<body style="text-align: center;">
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
		
		<div class="headerMini">Panel</div>
		<a href="allexcercises">
		<div class="panelMenu">List of excercises</div>
		</a>
		<a href="allgroups">
		<div class="panelMenu">List	of groups</div>
		</a>
		<a href="allusers">
		<div class="panelMenu">List of</br> users</div>
		</a>
		<div style="clear:both"></div>
		<a href="manageexcercises">
		<div class="panelMenu">Manage excercises</div>
		</a>
		<a href="managegroups">
		<div class="panelMenu">Manage groups</div>
		</a>
		<a href="manageusers">
		<div class="panelMenu">Manage users</div>
		</a>
		<div style="clear:both"></div>

		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>