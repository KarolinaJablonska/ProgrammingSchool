<table class="view">
	<tr>
		<th>id</th>
		<th>title</th>
		<th>description</th>
	</tr>

	<c:forEach items="${allExcercises}" var="excercise">
		<tr>
			<td>${excercise.id}</td>
			<td>${excercise.title}</td>
			<td>${excercise.description}</td>
		</tr>
	</c:forEach>
</table>