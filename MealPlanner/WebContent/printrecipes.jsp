<!-- 
	Receives request object from mealservlet.java and displays all the meals the user selected  
	so that they can print them off if desired. 
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href= "files/style.css" rel= "stylesheet" type= "text/css" media = "screen" />
<link href = "files/printstyle.css" rel = "stylesheet" type = "text/css" media = "print" />
<%@ page import = "java.util.ArrayList, model.Meal, controller.MealDaoImpl" %>
<title>Menu Planner - All Recipes</title>
<script language="javascript" type="text/javascript">
        function printDiv(divID) {
            //Get the HTML of div
            var divElements = document.getElementById(divID).innerHTML;
            //Get the HTML of whole page
            var oldPage = document.body.innerHTML;

            //Reset the page's HTML with div's HTML only
            document.body.innerHTML = 
              "<html><head><title></title></head><body>" + 
              divElements + "</body>";

            //Print Page
            window.print();

            //Restore orignal HTML
            document.body.innerHTML = oldPage;
        }
</script>
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
<% //get arraylist of selected meals from the request object
ArrayList<Meal> selectedMeals = (ArrayList<Meal>)request.getAttribute("selectedMeals"); 
%>
<nav>
	<ul>
		<li><a href = "index.html">Home</a></li>
		<li><a href = "mealpick.jsp">Meal Planner</a>
		<li><a href = "allmeals.jsp">See all Meals</a></li>
	</ul>
</nav>
<main>
<br/>
	<h3>Here are the directions you requested</h3> <!-- display all meal names in nav bar anchor using id -->
		<nav class = "sub">
		<%for(int i = 0; i < selectedMeals.size(); i++){
					Meal meal = new Meal();
					meal = selectedMeals.get(i);
					%>
					<li><a href = "#<%=meal.getId() %>"><%=meal.getMealname() %></a></li>
		<% } %>
		</nav>
		<%for(int i = 0; i < selectedMeals.size(); i++){
					Meal meal = new Meal();
					meal = selectedMeals.get(i);
					%>
					<div id = "<%=meal.getId() %>"> <!-- creates anchor for nav bar -->
					<h4><%=meal.getMealname() %></h4>
					
					<!-- button for printing each recipe, also has css formatting for printing -->
					<input style = "float: right; margin-right:15%" type="button" value="Print Recipe" onclick="javascript:printDiv('<%=meal.getId() %>')" />
					
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
					<p><a href="#top">Top of Page</a></p>			
		<%}%>
		
	
<!--h3>Click below if you would like to try again.</h3>
<form>
<button formaction="index.html" type="submit">Try again</button>
</form-->			

</main>
<footer>
	<p>&copy; 2017 Merna Addison and Sally Coil</p>
</footer>
</div><!--end container-->

</body>
</html>