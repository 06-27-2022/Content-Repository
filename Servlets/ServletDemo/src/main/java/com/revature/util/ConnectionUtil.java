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
		
		/*
		 * For anyone who is interested in turning off autocommit mode and manually
		 * committing, you can configure the automcommit using the returned Connection
		 * object.
		 */
		
		/*
		 * If you are running into an issue with your Driver class not being found
		 * on the classpath, you can explicitly tell Java to load the class. Also note
		 * that you will have to handle the checked ClassNotFoundException that could
		 * be thrown as a result of telling Java to load a specific class.
		 */
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = DriverManager.getConnection(
				System.getenv("db_url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
			);
		
//		conn.setAutoCommit(false); //optional
		
		return conn;
	}
}
