/*
 * This page receives recipe information from admin.jsp on recipe name, number of ingredients, and number of 
 * steps. If the information is valid it is sent to mealentry.jsp or the user is redirected back to admin.jsp
 * to try again.
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Meal;
/**
 * Servlet implementation class NewMealServlet
 */
@WebServlet("/newmealservlet")
public class newmealservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newmealservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String mealName = request.getParameter("name");
		String numIng = request.getParameter("numing");
		String numDir = request.getParameter("numdir");
		
		try{
			int numIngredients = Integer.parseInt(numIng);
			int numDirections = Integer.parseInt(numDir);
			request.setAttribute("mealName",mealName);
			request.setAttribute("numIngredients", numIngredients);
			request.setAttribute("numDirections", numDirections);
			getServletContext().getRequestDispatcher("/mealentry.jsp").forward(request, response);
			
		}catch (Exception e){ 
			String error = "Please enter a whole number for both number of ingredients and number of directions.";
		    request.setAttribute("error", error);
		    getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
