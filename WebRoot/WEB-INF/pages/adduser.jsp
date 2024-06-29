<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>Add user</title>
	</head>
	<body>
		<form:form method="post" commandName="addUser">
			<table>
				<tr>
					<th>
						First Name
					</th>
					<td>
						<form:input path="firstName" />

					</td>
				</tr>
				<tr>
					<th>
						Last Name
					</th>
					<td>
						<form:input path="firstName" />

					</td>
				<tr>
					<th>
						Email ID
					</th>
					<td>
						<form:input path="firstName" />

					</td>
				<tr>
					<th>
						Mobile Number
					</th>
					<td>
						<form:input path="firstName" />

					</td>
				<tr>
					<th>
						Password
					</th>
					<td>
						<form:input path="firstName" />
					<td colspan=2>
						<input type="submit" value="adduser" />

					</td>
			</table>
		</form:form>
	</body>
</html>