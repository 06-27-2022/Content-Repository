package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InvalidateSession
 */
public class InvalidateSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidateSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * If the client has an open session, you still need to check for it in order to
		 * determine whether or not they have permission to access resources.
		 * 
		 * If you want to check for the existence of a session, you should pass "false"
		 * into the getSession method as the method will return null if the client does
		 * not have a session.
		 */
		
		HttpSession session = request.getSession(false);
		
		/*
		 * How do you invalidate a session once you have the existing session object?
		 * You simply call the "invalidate" method. That said, be sure to perform a null
		 * check on the session because there is a chance that the session is null 
		 * after all.
		 */
		
		if(session != null) session.invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
