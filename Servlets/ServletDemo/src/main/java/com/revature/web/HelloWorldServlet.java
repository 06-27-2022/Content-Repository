package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Associate;

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
		 * Remember that your HttpServletResponse is an object representation of an
		 * HTTP response. That said, we can use it to modify our response head and body.
		 * 
		 * For instance, we can modify the status code:
		 */
		response.setStatus(200);
		
		/*
		 * You can also modify the content type. By default, we send plain text back
		 * to the client. That said, sometimes (most of the time) you want an alternative
		 * content type. For example:
		 */
		response.setContentType("text/html");
		
		/*
		 * You can also set your custom Response headers as well:
		 */
		
		response.addHeader("Custom Header", "custom value");
		
		/*
		 * Let's send a "hello world!" message back to the client as a response!
		 * In order to write to the response body, we should use the HttpServletResponse
		 * object.
		 */
		PrintWriter writer = response.getWriter();
		writer.write("Hello world!"); //Writing text/plain (plain text) to the response body
//		writer.write("<h1>Welcome to my app!</h1><p>This looks pretty gross. Sorry.</p>"); //Writing text/html to the response body.
		
	}
	
	/*
	 * We also want this servlet to accept POST requests now. Let's implement doPost:
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		/*
		 * Remember that the intention behind sending a POST request if you're the client
		 * is to send data to the server. Since that is the case, I should expect the 
		 * HTTP request body to contain something at this point.
		 * 
		 * Our HttpServletRequest is an object representation of our HTTP request, and it
		 * gives us access to the request head and body. That said, let's take a look at
		 * our request body.
		 * 
		 * When we extract the request body like this, note that simply accessing the
		 * input stream itself will not be enough. You will need to extract data from the
		 * input stream.
		 */
		
		String requestBodyText = new String(request.getInputStream().readAllBytes());
		
		/*
		 * Extracting the request body's data yields a String. We want to be able to
		 * store this particular data (a JSON object representing an associate) as
		 * a Java object, preferably using our Java model (Associate).
		 * 
		 * In order to avoid manually parsing the String, we will use a popular library
		 * called "Jackson". We can easily bring this 3rd party library into our application
		 * by getting it from the Maven repository.
		 * 
		 * Now that we've added Jackson as a dependency, we have access to the "ObjectMapper"
		 * type. The ObjectMapper allows us to serialize and deserialize Java Objects/JSON.
		 * We can serialize Java objects as JSON, which simply means that we can write a 
		 * Java object's state (properties) as a JSON string.
		 */
		
		ObjectMapper objectMapper = new ObjectMapper();
		Associate associateFromRequestBody = objectMapper.readValue(requestBodyText, Associate.class);
				
		System.out.println(associateFromRequestBody);
	}

}
