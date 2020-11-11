<html>
<head>
<title>Employee View</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>Product List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Image Path</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.productDescription}</td>
				<td>$${product.productPrice}</td>
				<td>${product.productImagePath}</td>
				<td><a href="editproduct/${product.id}">Edit</a></td>
				<td><a href="deleteproduct/${product.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addproduct">Add New Product</a>
</body>
</html>