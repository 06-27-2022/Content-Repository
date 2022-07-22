package com.revature.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Associate;
import com.revature.repository.AssociateRepository;
import com.revature.repository.AssociateRepositoryImpl;

public class AssociateController { 

	private AssociateRepository associateRepository;
	public ObjectMapper objectMapper;
	
	public AssociateController() {
		associateRepository = new AssociateRepositoryImpl();
		objectMapper = new ObjectMapper();
	}
	
	/*
	 * This is a helper method that we can delegate to within our DispatcherServlet.
	 * We'll make it static because I don't particularly need to create an instance
	 * of this class just to call the one helper method.
	 * 
	 * Notice that we are passing our HttpServletRequest and HttpServletResponse objects
	 * into this methods. This is perfectly acceptable as there is no rule that states
	 * that you can only these objects within a servlet class.
	 */
	
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String json = objectMapper.writeValueAsString(associateRepository.findAllAssociates());
		return json;
	}
	
	public void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Check the request body for JSON
		String jsonBody = new String(request.getInputStream().readAllBytes());
		Associate newAssociate = objectMapper.readValue(jsonBody, Associate.class);
		associateRepository.save(newAssociate);
	}
}
