<html>
<head>
<title>User View</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>User List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Username</th>
			<th>Password</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Role</th>
			<th>Address ID</th>
			<th>Address Street</th>
			<th>Address City</th>
			<th>Address State</th>
			<th>Address Zip Code</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="user" items="${list}">
			<tr>
				<td>${user.id}</td>
				<td>${user.username}</td>
				<td>${user.userPass}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.userEmail}</td>
				<td>${user.phone}</td>
				<td>${user.userRole}</td>
				<td>${user.billingAddress.id}</td>
				<td>${user.billingAddress.street}</td>
				<td>${user.billingAddress.city}</td>
				<td>${user.billingAddress.state}</td>
				<td>${user.billingAddress.zipCode}</td>
				<td><a href="edituser/${user.id}">Edit</a></td>
				<td><a href="deleteuser/${user.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="adduser">Add New User</a>
</body>
</html>