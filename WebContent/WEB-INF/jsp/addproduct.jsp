<html>
<head>
<title>Employee Form</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Add New Product</h1>
	<form:form method="post" action="addproduct">
		<table>
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
				<td><input type="submit" value="Add Product" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>