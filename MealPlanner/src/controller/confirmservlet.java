package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Meal;

/**
 * Servlet implementation class confirmservlet
 */
@WebServlet("/confirmservlet")
public class confirmservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Meal meal = (Meal)request.getSession().getAttribute("meal");
		String mealName = meal.getMealname();
		ArrayList<String> ingredients = meal.getIngredients();
		ArrayList<String> directions = meal.getDirections();
		MealDaoImpl mealDao = new MealDaoImpl();
		
		//System.out.println("confirm: " + mealName);
		
		mealDao.enterMealInDatabase(mealName, ingredients, directions);
		getServletContext().getRequestDispatcher("/successfulentry.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
