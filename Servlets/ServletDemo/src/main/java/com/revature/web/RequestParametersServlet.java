package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestParametersServlet extends HttpServlet{

	private static final long serialVersionUID = -6854657543069316481L;
	
	/*
	 * This servlet will handle/accept GET requests. That said, we'll override doGet.
	 * 
	 * MODIFICATION: This servlet now only accepts POST requests as if you are sending
	 * sensitive data (e.g. passwords and usernames), you should NOT use a GET request
	 * as it exposes the credentials via the URL.
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * Yesterday we observed that the client can send data to the server by adding data
		 * to the request body. To be exact, we ended up sending plain text and JSON to
		 * the server.
		 * 
		 * That said, this is not the only option you have for sending data from client
		 * to server. You can also use request parameters. These parameters are appended
		 * to the request URL.
		 * 
		 * The first thing we want to do is determine which request parameters we're willing
		 * to accept on the server side.
		 */
		
		System.out.println(request.getRequestURI()); //printing the request URI
		System.out.println(request.getQueryString()); //printing the query string
		
		/*
		 * Once the client has made the request and the server has received it, you
		 * will have access to the query string as you can see above. You can choose
		 * to manually parse the query string, but you don't have to as there is a method
		 * that allows you to extract specific parameters from the query string.
		 */
		
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
	}

}
