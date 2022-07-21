package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * I'm not going to map this servlet as I am not going to use to expose a resource
 * to my client.
 * 
 * In any case, recall that our server (Tomcat in our case) is responsible for providing
 * the proper runtime environment for hosting a web application. But what is this runtime
 * environment doing for us? The answer to this question can be explored by observing the
 * "Servlet Lifecycle". This describes a servlet's lifecycle from its instantiation to its
 * destruction.
 * 
 * A servlet's lifecycle can be described in 3 phases:
 * 
 * 1) init
 * 2) service
 * 3) destroy
 * 
 * @author 17084
 *
 */
public class ServletLifecycle extends HttpServlet{

	private static final long serialVersionUID = -7849263190245621155L;
	
	/**
	 * The init method is called once when an instance of a servlet class is created.
	 * Your servlet container (also called a web container or less formally your "server")
	 * is responsible for creating instances of servlets for you.
	 * 
	 * Your server consults the deployment descriptor (the web.xml) to determine when
	 * a servlet instance needs to be created. For instance, if a servlet is
	 * mapped to a specific url pattern and the client's HTTP request uses that pattern,
	 * the server creates an instance of that servlet.
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	/**
	 * During the service phase of the lifecycle, methds such as doGet, doPost, doDelete, etc.
	 * are called.
	 * 
	 * Note that the service method can be called many times for a single instance of a
	 * servlet because the web container does not immediately destroy a servlet instance
	 * if it doesn't have to.
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
	}

	/**
	 * The destroy method is called once at the end of a servlet's lifecycle. Your web
	 * container may decided to destroy an instance of a servlet if, for example, the
	 * web container has been idle for a while.
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
	
}
