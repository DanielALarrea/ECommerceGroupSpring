<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>e-commerce-home</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
	
<style>
/* <c:url value="imagepath" var = "name" /> */

</style>

</head>

<body >
	
	<div class="header" >
	
		<h4 style="text-align: left;color: black;padding-top:5px;padding-bottom: 5px;margin-left:1vw">Something Hub 
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="/ECommerceGroupSpring" >Home</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="products" >Products</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >About Us</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >Contact Us</a>
			<a class="flex" style="color: black;" href="admin" >Admin</a>
			<a class="flex" style="color: black;" href="/logout" >Logout</a>
			<a class="flex-no-hover">Welcome: </a>
			
			
		</h4>
		
	</div >
	

	<div class="admin-home">
        <h1>Administrator Page</h1>
        <h4>This is the Admin page!</h4>
        <br>
        <hr>
        <br>
        <h2>Welcome: ${cust.userName} | <a href="logout">Logout</a></h2>
        <h3><a href="admin-products">Product Inventory</a></h3>
        <p>Here you can view and modify product listings.</p>
        <br><br>
        <h3><a href="managecustomers">Customer Management</a></h3>
        <p>Here you can view registered customer information.</p>
    </div>
    

	
</body>

</html>