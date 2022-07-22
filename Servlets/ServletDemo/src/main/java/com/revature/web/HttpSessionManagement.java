package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionManagement
 */
public class HttpSessionManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpSessionManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * I'm once again checking for credentials by taking them from request parameters.
		 */
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("Christina") && password.equals("christinapass")) {
			/*
			 * Instead of using cookies, we're using something called an HttpSession.
			 * In order to create an HttpSession, we need to use the request object.
			 * 
			 * Note than an HttpSession stores some information about the session on
			 * the server side. Of course, you still have to check elsewhere for the
			 * existence of a session.
			 */
			
			HttpSession session = request.getSession();
			
		}else {
			response.setStatus(401);
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
