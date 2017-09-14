<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page import = "java.util.ArrayList, model.Meal" %>
<link href= "files/style.css" rel= "stylesheet" type= "text/css"/>
<title>Menu Planner - Selected Menu Items</title>
</head>
<body style = "text-align: center">
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
	<h3>Please select the meals below that you would like to print out to use</h3>
<% 
ArrayList<Meal> meals = (ArrayList<Meal>)request.getAttribute("meals"); 
%>
<form action = "mealservlet" method = "post" style = "margin: 0 auto">
<br/>
<table style = "margin: 0 auto">
	<tr>
		<th>Select</th>
		<th>Meal</th>
	</tr>
<% //System.out.println("About to add items to page");
//System.out.println(meals.toString());
for (int i = 0; i < meals.size(); i++){
	%>
	<tr>
		<td><input type = "checkbox" name = "id" checked = "checked" value = "<%=meals.get(i).getId()%>"></td>
		<td><%=meals.get(i).getMealname() %></td>
	</tr>
	<% 
}
%>
</table>
<br/>
<button formaction="mealpick.jsp" type="submit">Try again</button>
<input type = "submit" name = "printMeals" value = "Submit">
</form>
<br/>
</main>
<footer>
	<p>&copy; 2017 Merna Addison and Sally Coil</p>
</footer>
</div><!--end container-->

</body>
</html>