<html>
<head>
<title>Employee Edit Form</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Edit Product</h1>
	<form:form method="POST" action="/ECommerceGroupSpring/editproduct">
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="productName" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input path="productDescription" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><form:input path="productPrice" /></td>
			</tr>
			<tr>
				<td>Image Path :</td>
				<td><form:input path="productImagePath" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Edit Product" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>