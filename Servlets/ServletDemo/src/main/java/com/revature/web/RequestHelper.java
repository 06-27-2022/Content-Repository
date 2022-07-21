package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.AssociateController;
import com.revature.model.Associate;
import com.revature.repository.AssociateRepository;
import com.revature.repository.AssociateRepositoryImpl;

/**
 * This helper class is designed to be used in conjunction with the
 * DispatcherServlet. At this stage, we will simply check the URI here and
 * delegate to an appropriate controller.
 */
public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resource = request.getRequestURI();

		// Let's print the URI (for your reference)
		System.out.println(resource);

		// It would likely help us to parse the URI (remove the fluff at the beginning)
		String isolatedResource = resource.replace("/ServletDemo/api", "");

		switch (isolatedResource) {
		case "/associates":
			// do stuff that writes all of the associates to the response body as JSON
			response.setContentType("application/json");
			return AssociateController.findAll(request, response);
		default:
			// if we get here, the resource must not exist, so we send a 404 back to the
			// client.
			response.setStatus(404);
			break;
		}

		return null;
	}

	public static void processPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String resource = request.getRequestURI().replace("/ServletDemo/api", "");

		switch (resource) {
		case "/associate":
			AssociateController.save(request, response);
			break;
		default:
			response.setStatus(404);
			break;
		}

	}
}
