<table class="view">
	<tr>
		<th>id</th>
		<th>name</th>
		<th></th>
	</tr>

	<c:forEach items="${allGroups}" var="group">
		<tr>
			<td>${group.id}</td>
			<td>${group.name}</td>
			<td><a href="groupmembers?id=${group.id}"
				style="text-decoration: none;"><span class="details">members</span></a></td>
		</tr>
	</c:forEach>
</table>