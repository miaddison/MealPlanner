<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href= "files/style.css" rel= "stylesheet" type= "text/css"/>
<title>Menu Planner - Admin Login</title>

</head>
<body>
<div id = "container">
<div id = "login">
	<a href = "login.jsp">Login</a>
</div>
<header>
	<a href = "index.html">
		<h1>Welcome to the meal planner</h1>
	</a>
</header>
<nav>
	<ul>
		<li><a href = "index.html">Home</a></li>
		<li><a href = "mealpick.jsp">Meal Planner</a>
		<li><a href = "allmeals.jsp">See all Meals</a></li>
	</ul>
</nav>
<main>
<br/> 
<form action = "loginservlet" method = "post">
	<h3>Please login below to add recipes</h3>
	<br>
	<% String error = (String)request.getAttribute("error");
		if(error != null && !error.isEmpty()){%>
			<h6><%=error %></h6>
		<%}%>
	
	<div id = "input">
		<label for = "name">Name: </label>
		<input type = "text" name = "name" size = "30" />
		<br/>
		<label for = "password">Password:* </label>
		<input type = "password" name = "password" size = "30" require/>
	</div><!-- end input -->
	<br/><br/>
	<div id="buttons">
		<input type = "reset" value = "Try again" />
		<input type="submit" value = "Submit" />
	</div><!-- end buttons -->
</form>
<br/>
</main>
<footer>
	<p>&copy; 2017 Merna Addison and Sally Coil</p>
</footer>
</div><!--end container-->

</body>
</html>