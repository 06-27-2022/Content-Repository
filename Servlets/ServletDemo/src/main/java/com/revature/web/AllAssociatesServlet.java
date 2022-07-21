package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Associate;
import com.revature.repository.AssociateRepository;
import com.revature.repository.AssociateRepositoryImpl;

public class AllAssociatesServlet extends HttpServlet{

	private static final long serialVersionUID = -158339544377432047L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		/*
		 * We know that we want our /associates/all endpoint to return all of the associates'
		 * information to the client as JSON.
		 * 
		 * This requires that we:
		 * 
		 * 1) Get all of the associates' information from the DB. This requires that
		 * we make an instance of the AssociateRepositoryImpl class and call the
		 * findAllAssociates method.
		 * 
		 * 2) Transform our Java object (a list of Associates) into a JSON string.
		 * We will need our Jackson ObjectMapper.
		 * 
		 * 3) Now that we converted this into object into a JSON string, we can write
		 * it to the response body.
		 */
		
		//Step 1
		AssociateRepository associateRepository = new AssociateRepositoryImpl();
		List<Associate> associates = associateRepository.findAllAssociates();
		
		//Step 2
		ObjectMapper imTheMap = new ObjectMapper();
		String json = imTheMap.writeValueAsString(associates);
		
		//Step 3
		response.setContentType("application/json"); //you should be setting the content type
		PrintWriter writer = response.getWriter();
		writer.write(json);
	}

}
