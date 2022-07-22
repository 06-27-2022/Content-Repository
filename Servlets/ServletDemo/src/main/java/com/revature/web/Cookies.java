package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * After you've determined that a user is a valid (registered) user and they've logged in,
 * you'll need some way of tracking is (e.g. how do you know someone has logged in already).
 * 
 * You have a couple of options when working with the Servlet API when it comes to
 * session management. Session management entails tracking a client's interactions with
 * your application.
 * 
 * The first option we'll talk about is cookies.
 * 
 * A cookie is a key-value pair. It is stored on the client machine as a text file (this
 * is why it is common for sites to ask for your permission to store them).
 * 
 * @author 17084
 *
 */
public class Cookies extends HttpServlet{

	private static final long serialVersionUID = -584985904574226172L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		/*
		 * The first thing I'll do is check for request parameters, meaning that I'm going to allow
		 * the client to pass parameters to the server.
		 * 
		 * The parameters that I will check for are "username" and "password".
		 * 
		 * Recall that we can use some variation of the getParameter method.
		 */
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		/*
		 * Let's imagine that the username and password needs to be "Christina" and
		 * "christinapass" before I'm willing to grant a session to the client.
		 */
		
		if(username.equals("Christina") && password.equals("christinapass")) {
			//Send a cookie to the client machine
			Cookie myCookie = new Cookie("authenticated", "true");
			Cookie badCookie = new Cookie("password", password);
			//Add the cookie to the response. Note that it will be your responsibility
			//to check for these cookies with every request the client sends to the server.
			response.addCookie(myCookie);
			response.addCookie(badCookie);
		}else {
			response.setStatus(401);
		}
		
		
	}

	
}
