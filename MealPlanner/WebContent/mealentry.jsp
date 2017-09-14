<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href= "files/style.css" rel= "stylesheet" type= "text/css"/>
<title>Menu Planner</title>

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
<%String mealName = (String)request.getAttribute("mealName");
  int numIng = (int)request.getAttribute("numIngredients");
  int numDir = (int)request.getAttribute("numDirections");
%>
<main>
<br/>
<form action="newmealinputservlet" method="post">
	<h3>Please enter the number of meals you would like to plan below.</h3>
	
	<%String error = (String)request.getAttribute("error");
		if(error != null && !error.isEmpty()){%>
			<h6><%=error %></h6>
		<%}%>
	<br>
	<h3>Recipe Name: <%=mealName %></h3>
	<div id="input">
		<fieldset>
		<legend>Ingredients</legend>
		<%for(int i = 1; i <= numIng; i++) {%>
			<label for = "ing">Ingredient Number <%=i %>:</label>
			<input type = "text" name = "ing"  width = "50" required/>
			<br/><br/>
		<%}%>
		</fieldset>
		<fieldset>
		<legend>Directions</legend>
		<%for(int i = 1; i <= numDir; i++) {%>
			<label for = "dir">Step Number <%=i %>:</label>
			<input type = "textbox" name = "dir"  width = "50" required/>
			<br/><br/>
		<%}%>
		<input type = "hidden" name = "mealName" value = "<%=mealName %>" />
	</div>
	
	<div id="buttons">
		<button formaction="admin.jsp" type="submit">Try again</button>
		<input type="submit" value = "Submit" />
	</div>
</form>
<br/>
</main>
<footer>
	<p>&copy; 2017 Merna Addison and Sally Coil</p>
</footer>
</div><!--end container-->

</body>
</html>