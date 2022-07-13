package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
 * SQLException (class)
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
		
		try {
			//The first step is to get a connection.
			Connection conn = DriverManager.getConnection(
					System.getenv("db_url"), 
					System.getenv("db_username"), 
					System.getenv("db_password")
					);
			
			/*
			 * After we have established a connection, we can execute SQL statements
			 * against our DB. We will need the Statement interface. We can use our
			 * connection to create a statement.
			 */
			Statement stmt = conn.createStatement();
			
			/*
			 * The ResultSet will store the results of a running a query (e.g. the
			 * records that are returned after executing that query).
			 */
			ResultSet set = stmt.executeQuery("select * from associates");
			
			/*
			 * You have to extra the results from a ResultSet one by one once you have
			 * the records local to your application.
			 */
			
			while(set.next()) {
				/* 
				 * While there is another record in the result set, let's print the
				 * the contents of the table rows here.
				 */
				int id = set.getInt(1);
				String associateName = set.getString(2);
				String associateLocale = set.getString(3);
				String associateHobby = set.getString(4);
				int trainerId = set.getInt(5);
				
				System.out.println(id + ", " + associateName + ", " + associateLocale
						+ ", " + associateHobby + ", " + trainerId);
				 
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
