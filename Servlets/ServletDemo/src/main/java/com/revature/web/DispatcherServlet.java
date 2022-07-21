package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Thus far, we've made a new servlet for every new resource we wanted to expose to
 * the client. This doesn't scale well. If, for example, we had 100 endpoints planned
 * out for our application, we would have to make 100 servlets if we continued on like
 * this.
 * 
 * For this reason, it is common to only create one servlet. If you create just one
 * servlet, you typically are following the "Front Controller" design pattern. The
 * Front Controller accepts all incoming requests and dispatches the requests
 * to various helper classes.
 * 
 * @author 17084
 *
 */
public class DispatcherServlet extends HttpServlet{

	private static final long serialVersionUID = -4122841785692138080L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * I want to remake my previous endpoints for associates: /associates/all and /associate.
		 * In order to do this, I have to redirect the incoming HTTP request and HTTP response objects
		 * to the right places.
		 * 
		 * Since I am using the doGet method to handle all of this servlet's logic (even
		 * the logic for doPost), I might want to check the HTTP verb first.
		 * 
		 * I might also need to check the URI.
		 */
		
		String httpVerb = request.getMethod(); //isolating the verb
		
		//Let's print the URI
		System.out.println(request.getRequestURI());
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request, response); //deferring to the logic for doGet
	}

}
