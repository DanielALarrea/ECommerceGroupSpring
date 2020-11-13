<html>
<head>
<title>User Form</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Add New User</h1>
	<form:form method="post" action="adduser">
		<table>
			<tr>
				<td>First Name :</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Phone Number :</td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="userEmail" /></td>
			</tr>
			<tr>
				<td>Username :</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="userPass" /></td>
			</tr>
			
			<tr>
				<td>Address</td>
			</tr>
			<tr>
				<td>Street :</td>
				<td><form:input path="billingAddress.street" /></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><form:input path="billingAddress.city" /></td>
			</tr>
			<tr>
				<td>State :</td>
				<td><form:input path="billingAddress.state" /></td>
			</tr>
			<tr>
				<td>ZIP Code :</td>
				<td><form:input path="billingAddress.zipCode" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add User" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>