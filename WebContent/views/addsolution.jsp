<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add solution</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="headeruser.jsp"%>
		<div class="content">
			<div class="headerMini">Add solution</div>
			<div class="beforeEdit">
				<b>Excercise id: </b> ${solution.id}</br>
				<b>Created: </b>${solution.created}</br>
				<b>Last updated: </b>${solution.updated}</br>
				<b>Description: </br></b>${solution.description}</br>
				<b>Excercise title: </br></b>${excercise.title}</br>
				<b>Excercise description: </b>${excercise.description}</br>
			</div>
			<div class="formdiv">
				<form method="POST" action='./addsolution'>
					<input name="description" type="TEXT" value="" placeholder="new solution"
						onfocus="this.placeholder=''; this.value='${solution.description}'"
						onblur="this.placeholder='new solution'" /></br>			
						<input type="SUBMIT" value="Add" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>