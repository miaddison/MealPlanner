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
 * Servlet implementation class mealservlet
 */
@WebServlet("/mealservlet")
public class mealservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mealservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		MealDaoImpl mealDao = new MealDaoImpl();
		String[] mealId  = request.getParameterValues("id");
		int[] ID = new int[mealId.length];
	
		for(int i = 0; i < mealId.length; i++){
				try{
					ID[i] = Integer.parseInt(mealId[i]);
				}catch (NumberFormatException nfe){
					System.out.println(nfe);
				}
		}
		
		request.setAttribute("selectedMeals", mealDao.createMealListByIds(ID));
		getServletContext().getRequestDispatcher("/printrecipes.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
