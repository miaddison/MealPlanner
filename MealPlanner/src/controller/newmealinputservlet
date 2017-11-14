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
 * Servlet implementation class newmealinputservlet
 */
@WebServlet("/newmealinputservlet")
public class newmealinputservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newmealinputservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String mealName = request.getParameter("mealName");
		ArrayList<String> ingredients = new ArrayList<>();
		ArrayList<String> directions = new ArrayList<>();
		String[] ing = request.getParameterValues("ing");
		String[] dir = request.getParameterValues("dir");
		
		//System.out.println("newmealinput: " + mealName);
		
		for(int i = 0; i < ing.length; i++){
			ingredients.add(ing[i]);
			//System.out.println(ing[i]);
		}
		
		for(int i = 0; i < dir.length; i++){
			directions.add(dir[i]);
			//System.out.println(dir[i]);
		}
		
		Meal meal = new Meal(mealName, ingredients, directions);
		request.setAttribute("meal", meal);
		getServletContext().getRequestDispatcher("/mealconfirmation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
