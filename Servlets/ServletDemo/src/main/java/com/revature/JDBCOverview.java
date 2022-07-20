package com.revature;

import java.util.List;

import com.revature.model.Associate;
import com.revature.repository.AssociateRepository;
import com.revature.repository.AssociateRepositoryImpl;

/*
 * JDBC stands for "Java Database Connectivity". JDBC provides a standard interface for
 * allowing developers to connect their Java applications to databases - regardless of
 * which variant/dialect of SQL they are using.
 * 
 * At its core, JDBC consists of several key classes and interfaces. These include:
 * 
 * DriverManager (class): A utility class that allows us to utilize the Postres Driver
 * 						  to establish a connection to our DB and modify options for
 * 						  connection timeouts, etc.
 * Connection (interface): Represents a connection to your DB.
 * Statement (interface): Represents a SQL statement that you wish to run against your DB.
 * ResultSet (interface): Represents the records that are returned after executing a query.
 * SQLException (class): A checked exception that is thrown when something goes awry when using
 * 						 JDBC
 * 
 * Note that these are in fact interfaces; this means that they're abstract. As interfaces
 * have no implementations for their methods, we are required to provide the implementation
 * for the key interfaces. Fortunately, there is a standard Postgres JDBC library that we
 * can add to the classpath.
 */
public class JDBCOverview {

	/*
	 * Let's attempt to connect to our DB from within our Java application. In order
	 * to do so, we will need our DriverManager class and our Connection interface:
	 */
	public static void main(String[] args) {
		
		AssociateRepository associateRepository = new AssociateRepositoryImpl();
		/*
		 * The below phenomenon is called "SQL injection". SQL injection occurs when
		 * an end user of your application inputs valid SQL in an attempt to steal
		 * data or alter data or even just delete it. Fortunately, there is a way to
		 * prevent SQL in JDBC!
		 */
		Associate newAssociate = new Associate(0, "Christina", "Illinois", 
				"lifting', 2); drop table batches; --the rest is a comment", 2);
//		associateRepository.save(newAssociate);
		
		/*
		 * I need to pass an Associate object to the "update" method that I have
		 * written.
		 */
		Associate associateToUpdate = new Associate(11, "Christina", "Texas", 
				"doesn't matter", 4);
		
//		associateRepository.update(associateToUpdate);
		
		//Printing all associates
		List<Associate> associates = associateRepository.findAllAssociates();
//		for(Associate individual : associates) {
//			System.out.println(individual);
//		}
		
		Associate retrievedAssociate = associateRepository.findById(100);
		System.out.println(retrievedAssociate);
	}
	
}
