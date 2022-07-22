package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InvalidateCookies
 */
public class InvalidateCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvalidateCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Once a client's session is "over", you will need some way to remove their cookies
		 * that allow them access to resources. Here is how you do so:
		 * 
		 * Recall that whenever the client makes a request, their cookies come with the
		 * request. This means that you can actually check their existing cookies:
		 */
		
		Cookie[] cookieJar = request.getCookies();
		
		/*
		 * Now that we have the array of cookies, we can iterate over the array to find
		 * the specific cookie that we're looking for.
		 */
		
		for(Cookie cookie : cookieJar) {
			if(cookie.getName().equals("authenticated")) {
				cookie.setMaxAge(0); //Setting the max age to 0 deletes a cookie
			}
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
