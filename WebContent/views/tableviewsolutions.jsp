
<table class="view">
	<tr>
		<th>id</th>
		<th>created</th>
		<th>updated</th>
		<th>description</th>
		<th>users_id</th>
		<th>excercise_id</th>
		<th></th>
	</tr>

	<c:forEach items="${allSolutions}" var="solution">
		<tr>
			<td>${solution.id}</td>
			<td>${solution.created}</td>
			<td>${solution.updated}</td>
			<td>${solution.description}</td>
			<td>${solution.users_id}</td>
			<td>${solution.excercise_id}</td>
			<td><a href="solutiondetails?id=${solution.id}"><span
					class="details">details</span></a></td>
		</tr>
	</c:forEach>
</table>