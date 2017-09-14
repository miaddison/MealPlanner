<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList, model.Meal" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href= "files/style.css" rel= "stylesheet" type= "text/css"/>
<title>Menu Planner - Admin Page</title>

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
<% 
	Meal meal = (Meal)request.getAttribute("meal");
%>
	<h3>Please confirm your recipe</h3> 
	<div id = "<%=meal.getId() %>">
		<h4><%=meal.getMealname() %></h4>		
					
		<!--begin bullet list of ingredients-->
		<ul style = "clear: both">
					
		<% for (int y = 0; y < meal.getIngredients().size(); y++){%>
			<li><%=meal.getIngredients().get(y) %></li>
		<% } %>
		</ul> 
					
		<!--begin numbered list of directions-->
		<ol>
		<% for(int x = 0; x < meal.getDirections().size(); x++){  %>
			<li><%=meal.getDirections().get(x) %></li>
		<% } %>
		</ol>
		</div><!-- end meal div -->
<form action = "confirmservlet" method = "post" style = "border: none; background: white">
	<div id = "input">
		<% request.getSession().setAttribute("meal", meal);%>
		
	</div>
	<div id="buttons">
		<button formaction="admin.jsp" type="submit">Try again</button>
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