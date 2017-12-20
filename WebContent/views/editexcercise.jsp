<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit excercise</title>
<%@ include file="headInclude.jsp"%>
</head>
<body>
	<div class="wrapper">
		<%@ include file="header.jsp"%>
		<div class="content">
			<div class="headerMini">Edit excercise</div>
			<div class="beforeEdit">
				<b>Excercise id: </b> ${excercise.id}</br> <b>Title: <br /></b>
				${excercise.title}</br> <b>Description: <br /></b>
				${excercise.description}
			</div>
			<div class="formdiv">
				<form method="POST" action='./editexcercise'>
					<input name="title" type="TEXT" value="" placeholder="new title"
						onfocus="this.placeholder=''; this.value='${excercise.title}'"
						onblur="this.placeholder='new title'" /></br> <input
						name="description" type="TEXT" value="" placeholder="new description"
						onfocus="this.placeholder=''; this.value='${excercise.description}'"
						onblur="this.placeholder='new description'" /></br> <input
						type="SUBMIT" value="Edit" />
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>