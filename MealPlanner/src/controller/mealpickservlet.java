/*
 * receive mealnum from mealpick.jsp and sets the attribute "meal" 
 */


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
		
		// create instance of MealDaoImpl
		MealDaoImpl mealDao = new MealDaoImpl();
		String numMeals = request.getParameter("mealnum"); //retrieve mealnumb from request obj
	
		try{
			int mealnum = Integer.parseInt(numMeals); // unbox nummeals as integer
			request.setAttribute("meals", mealDao.findSpecNumByRandm(mealnum)); //meals to MealDaoImpl to create random meals then to meallist.hsp
			getServletContext().getRequestDispatcher("/meallist.jsp").forward(request, response); // send to meallist.jsp
			
		}catch (Exception e){ // validate user input
			String error = "Please enter a whole number.";
		    request.setAttribute("error", error); // from mealpick.jsp
		    getServletContext().getRequestDispatcher("/mealpick.jsp").forward(request, response); // send message back to user
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
