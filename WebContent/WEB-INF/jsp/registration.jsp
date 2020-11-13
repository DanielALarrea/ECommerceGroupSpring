<html>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<head>
<title>e-commerce-login</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="styles.css">
<style>
/* <c:url value="imagepath" var = "name" /> */

</style>

</head>
<body >

	<div class="header" >
	
		<h4 style="text-align: left;color: black;padding-top:5px;padding-bottom: 5px;margin-left:1vw">Something Hub 
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="/ECommerceGroupSpring" >Home</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >Products</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >About Us</a>
			<a class="boxt" style="font-size: 17px;margin-left:1vw;color: black" href="" >Contact Us</a>
			<a class="flex" style="color: black;" href="" >Admin</a>
			<a class="flex" style="color: black;" href="" >Login</a>
			<a class="flex" style="color: black;" href="" >Register</a>
		</h4>
		
	</div >
<h1 class="page" style="margin-top:2vw;text-align: center;">Register Customer</h1>
<h3 style="text-align: center;">Please fill in your information below.</h3>
	<div class="register">
		<form:form method="post" modelAttribute="user"
			style="padding: 20px; text-align:center; margin-left:0">
			<h5 class="info">Basic Info:</h5>
			
			
			<h6 style="margin-left: -150px; color: black">
				<u>Name</u> :
			</h6>
			<form:input path="userId" type="text" placeholder="Enter Name"
				style="margin-left: 10px" required="required"/>



			<h6 style="margin-left: -150px; color: black">
				<u>Email</u> :
			</h6>
			<form:input path="userId" type="text" placeholder="Enter Email"
				style="margin-left: 10px" required="required"/>
				
				
			<h6 style="margin-left: -150px; color: black">
				<u>Phone</u> :
			</h6>
			<form:input path="contactNumber" id="mobile" type="tel"
				pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
				placeholder="222-222-2222" style="margin-left: 10px" />
				
				
				
			<h6 style="margin-left: -150px; color: black">
				<u>Username</u> :
			</h6>
			<form:input path="userId" type="text" placeholder="Enter Username"
				style="margin-left: 10px" required="required"/>
				
				
				
			<h6 style="margin-left: -150px; color: black">
				<u>Password</u> :
			</h6>
			<form:input path="password" type="text" placeholder="Enter Password"
				style="margin-left: 10px" pattern="(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
				required="required"/>
				
				
				
				<br>
				<br>
				<br>
				
			<h5 class="info">Billing Address:</h5>
			
			<h6 style="margin-left: -150px; color: black">
				<u>Street Name</u> :
			</h6>
			<form:input path="custName" type="text"
				placeholder="Enter Street Name" style="margin-left: 10px" required="required"/>
				
				
			<h6 style="margin-left: -150px; color: black">
				<u>Apartment Number</u> :
			</h6>
			<form:input path="custAddress" type="text"
				placeholder="Enter Apartment #" style="margin-left: 10px" />
				
				
			<h6 style="margin-left: -150px; color: black">
				<u>City</u> :
			</h6>
			<form:input path="contactNumber" id="mobile" type="tel"
				pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}"
				placeholder="222-222-2222" style="margin-left: 10px" />
				
				
			<h6 style="margin-left: -150px; color: black">
				<u>State</u> :
			</h6>
			<form:input path="balance" type="text" placeholder="Enter State" style="margin-left: 10px" required="required"/>


			<br>
			<br>
			<input type="submit" class="btn btn-info box" style="margin-left: -10px" />

			<br>
			<br>
			<a style="margin-left: 0px; color: black">Already have an
				account?</a>
			<a href="login.html" style="margin-left: 10px; color: blue">Login Here</a><br>
			
		</form:form>
	</div>
	<!-- <%
		Object param = request.getAttribute("errorMessage");
	if (param == null)
	{
	%>
	<%
		} else
	{
	%>
	<font color="red">[${errorMessage}]</font>
	<%
		}
	%> -->
	
</body>
</html>