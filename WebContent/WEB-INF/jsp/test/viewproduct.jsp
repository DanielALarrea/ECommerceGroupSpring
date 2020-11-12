<html>
<head>
<title>Employee View</title>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<% 
		String localDir = "D:/GitHub Repos/ECommerceGroupSpring";
		String imageDir = localDir + "/WebContent/resources/theme1/assets/productpics/";
	%>

	<h1>Product List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Image Path</th>
			<th>Stock</th>
			<th>In Stock</th>
			<th>Edit</th>
			<th>Delete</th>
			<th>Top Image</th>
		</tr>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>$${product.price}</td>
				<td>${product.imagePath}</td>
				<td>${product.stock}</td>
				<td>${product.inStock}</td>
				<td><a href="editproduct/${product.id}">Edit</a></td>
				<td><a href="deleteproduct/${product.id}">Delete</a></td>
				<td><img src="${product.imagePath}" style="max-width: 400px" /></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addproduct">Add New Product</a>
</body>
</html>