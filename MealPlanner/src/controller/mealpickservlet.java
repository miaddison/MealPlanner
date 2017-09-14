package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MealServlet
 */
@WebServlet("/MealServlet")
public class mealpickservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mealpickservlet() {
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
		String numMeals = request.getParameter("mealnum");
	
		try{
			int mealnum = Integer.parseInt(numMeals);
			request.setAttribute("meals", mealDao.findSpecNumByRandm(mealnum));
			getServletContext().getRequestDispatcher("/meallist.jsp").forward(request, response);
			
		}catch (Exception e){
			String error = "Please enter a whole number.";
		    request.setAttribute("error", error);
		    getServletContext().getRequestDispatcher("/mealpick.jsp").forward(request, response);
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
