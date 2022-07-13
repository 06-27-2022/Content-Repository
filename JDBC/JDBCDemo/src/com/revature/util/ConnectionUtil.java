package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author 17084
 *
 *This utility class is designed to quickly grab a fresh connection to our DB. It is
 *not required, but it is useful for reducing the amount of code that we will write
 *throughout this application.
 */
public class ConnectionUtil {

	/**
	 * 
	 * @return a new connection to a database
	 * @throws SQLException
	 */
	public static Connection getNewConnection() throws SQLException {
		
		//The first step is to get a connection.
		return DriverManager.getConnection(
				System.getenv("db_url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
			);
	}
}
