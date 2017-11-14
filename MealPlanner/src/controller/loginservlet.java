/*
 * This page validates that the user has the correct password and then sends the information to admin.jsp.
 * This was a very basic start to be able to a login page. In the future I would like to add a user
 * table and be able to validate the user login information through the database.
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
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");   
		
	    String password=request.getParameter("password"); 
	    String name = request.getParameter("name");
	    String error = null;
	         
	    if(password.equals("Password")){  // checks that correct password is entered
	    	request.setAttribute("name", name); // sends user name to admin.jsp
	    	
	    	getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	    }  
	    else{  
	    	error = "Your password was incorrect, please try again.";
	    	request.setAttribute("error", error);
	        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
