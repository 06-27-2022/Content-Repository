package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Polkaman;
import com.revature.service.PolkamanService;

/*
 * @Controller is a Spring stereotype that denotes that the annotated class belongs to a web
 * layer and will expose resources to the client. And of course, as a stereotype, this adds a bean
 * of this type to the IoC container.
 */

/*
 * A RestController (@Controller + @ResponseBody) is a specialized Controller class. All methods
 * within this class write the response body.
 * 
 * Recall that Spring has a built-in Servlet called the DispatcherServlet. But how does Spring
 * decided which controller should be used and which endpoints actually exist in the project?
 * 
 * The Spring framework uses an Interface called the HandlerMapping interface. This interface is
 * responsible for helping the DispatcherServlet figure out which controller should be used to
 * handle an incoming HTTP request. Since your controller is already registered as a bean in
 * the Spring container (ApplicationContext), the DispatcherServlet knows which controller should
 * be used after consulting with HandlerMapping interface.
 */
@RestController("polkamanController")
/*
 * The RequestMapping annotation specifies a portion of a URL that this entire controller will be
 * mapped to. That is to say, if a client wants access to resources exposed by this controller,
 * they should use the following URL: /api/polkaman/*
 */
@RequestMapping(path = "/polkaman")
public class PolkamanController {
	
	@Autowired
	private PolkamanService polkamanService;
	
	/*
	 * Let's start by adding a simple endpoint ("/all") that will allow the client to retrieve
	 * all Polkamans.
	 */
//	@RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	/*
	 * If you want a method's return value written to the HTTP response body, use the @Responsebody
	 * annotation.
	 */
//	@ResponseBody
	/*
	 * This annotation is a shortcut for @RequestMapping(method=RequestMethod.GET)
	 */
	@GetMapping(path = "/all")
	public List<Polkaman> findAll(){
		return this.polkamanService.sortPolkamansByName();
	}
	
	/*
	 * Let's create an endpoint that allows us to find a Polkaman by its id.
	 * 
	 * Using a PathVariable, we can tell Spring to parse the request URL for us, isolating
	 * the "id" parameter and passing it to our method for us.
	 * 
	 * Using a ResponseEntity allows you a bit more control over the Http Response status code.
	 */
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Polkaman> findById(@PathVariable int id) {
		return new ResponseEntity<Polkaman>(this.polkamanService.findById(id), HttpStatus.OK);
	}
	
	/*
	 * For those of you who like allowing the client to send request parameters (e.g. the people
	 * who liked using request.getParameter with Servlets), you might enjoy using the @RequestParam
	 * annotation.
	 */
	@GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public Polkaman findByIdRequestParam(@RequestParam int id) {
		return this.polkamanService.findById(id);
	}
	
	
	/*
	 * Let's create an endpoint that allows us to add a new Polkaman to our existing group of
	 * Polkamans.
	 * 
	 * The @RequestBody annotation reads data from the Http request body and marshalls it as
	 * a Java object of the parameter type.
	 */
	@PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Polkaman polkaman) {
		this.polkamanService.save(polkaman);
	}
	

}
