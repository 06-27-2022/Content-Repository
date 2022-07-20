package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Remember: A servlet intercepts an incoming HTTP Request when it reaches the server.
 * Intercepting this HTTP request allows our application to access the HTTP Request and
 * wrap it as a Java object. We can then (within our application) interact with this object
 * to make decisions. We can also populate the HTTP Response body before the server ships
 * the HTTP Response back off the client.
 * 
 * A servlet is just a class, meaning that if you want to create a servlet, you are going
 * to create a Java class. That Java class should extend the HttpServlet class.
 * 
 * @author 17084
 *
 */
public class HelloWorldServlet extends HttpServlet {

	/*
	 * You do not have to know about Serialization. I've only added the serialVersionUID
	 * to remove a compiler warning.
	 */
	private static final long serialVersionUID = 8436535011137580232L;
	
	/*
	 * Let's say that we want our servlet to be able to handle GET requests. In order
	 * to do this, we need to override a method that is inherited from the HttpServlet.
	 * In this case, we specially want to override the "doGet" method.
	 * 
	 * The HttpServletRequest is an object representation of an HTTP request. It gives you
	 * access to the HTTP request's head and body.
	 * 
	 * The HttpServletResponse is an object representation of an HTTP response. It allows you
	 * to populate the response's body and head (e.g. the status code).
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * Let's send a "hello world!" message back to the client as a response!
		 * In order to write to the response body, we should use the HttpServletResponse
		 * object.
		 */
		PrintWriter writer = response.getWriter();
		writer.write("Hello world!");
		
	}

}
