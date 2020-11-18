<html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>e-commerce-home</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" >
<c:url value="${pageContext.request.contextPath}../assets/thumbnail.PNG" var = "thumbnail" />
<style>


</style>
<script>
	var userName = "";
</script>
</head>

<body >
	
	<div class="header" >
	
		<h4 style="text-align: left;color: black;padding-top:5px;padding-bottom: 5px;margin-left:1vw">Something Hub 
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="/ECommerceGroupSpring" >Home</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="products" >Products</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >About Us</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >Contact Us</a>
			<a class="flex" style="color: black;" href="admin" >Admin</a>
			<a id="login"></a>
			<script>
				if(userName === "")
				{
					var display = '<a class="flex" style="color: black;" href="login" >Login</a> ';
				}
				else
				{
					var display = '<a class="flex" style="color: black;" href="" >Logout</a><a class="flex-no-hover">Welcome: </a>';

				}
				document.getElementById("login").innerHTML = display;
			</script>
			
		</h4>
		
	</div >
	

	
	<h1 style="margin-top:2vw;text-align: center;">Home</h1>
	<img class="home-image" alt="" src="${pageContext.request.contextPath}/resources/assets/menu.jpg">
<!-- Insert some sort of picture slides -->
	
</body>

</html>