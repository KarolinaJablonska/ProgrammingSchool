<table class="view">
	<tr>
		<th>id</th>
		<th>email</th>
		<th>username</th>
		<th>group id</th>
	</tr>

	<c:forEach items="${allUsers}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.email}</td>
			<td>${user.username}</td>
			<td>${user.person_group_id}</td>
		</tr>
	</c:forEach>
</table>