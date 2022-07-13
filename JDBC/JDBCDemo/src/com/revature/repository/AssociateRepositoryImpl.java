package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Associate;
import com.revature.util.ConnectionUtil;

/*
 * It is very common to have specific classes that handle the logic for methods that
 * will interact with your data source (DB). We call this classes repositories. They
 * follow a design pattern called the Data Access Object (DAO) design pattern.
 */
public class AssociateRepositoryImpl implements AssociateRepository{

	/**
	 * I want a method that I can use to get all of the associates' information
	 * from the DB. I don't just want this method to print this associates; I want it
	 * to return a List of associates to the caller.
	 */
	public List<Associate> findAllAssociates() {
		
		/*
		 * I've moved my Connection declaration up so that it will be in scope
		 * for both the "try" and "finally" blocks.
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		//Declaring the list and initalizing the List we will return at the end of this method.
		List<Associate> associates = new ArrayList<>();
		
		//Declare my SQL query string ahead of time:
		final String SQL = "select * from associates";
		
		try {
			//The first step is to get a connection.
			conn = ConnectionUtil.getNewConnection();
			
			/*
			 * After we have established a connection, we can execute SQL statements
			 * against our DB. We will need the Statement interface. We can use our
			 * connection to create a statement.
			 */
			stmt = conn.createStatement();
			
			/*
			 * The ResultSet will store the results of a running a query (e.g. the
			 * records that are returned after executing that query).
			 */
			set = stmt.executeQuery(SQL);
			
			/*
			 * You have to extra the results from a ResultSet one by one once you have
			 * the records local to your application.
			 */
			
			while(set.next()) {
				/* 
				 * While there is another record in the result set, let's print the
				 * the contents of the table rows here.
				 */
				
				Associate associate = new Associate(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getInt(5));
				
				/*
				 * Let's add Associate objects to our List<Associate> (list of associates)
				 * on each iteration.
				 */
	
				associates.add(associate);
				 
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			/*
			 * Remember that a finally always executes. This makes it a good place
			 * to close your connection to your DB. Yes, you can have a try-catch
			 * block inside of a try-catch block.
			 */
			try {
			conn.close();
			stmt.close();
			set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return associates;
	}

	@Override
	public void save(Associate associate) {
		/*
		 * The standard JDBC workflow includes a Connection. We will also want
		 * a Statement so that we can execute it against our DB. We don't necessarily
		 * need a ResultSet if we're not planning on getting records back.
		 */
		
		Connection conn = null;
		/*
		 * If you're ever going to be inserting user input into a DB, you should use a
		 * special kind of Statement called a PreparedStatement. A PreparedStatement 
		 * protects against SQL injection by precompiling a SQL query with placeholders
		 * and then later substituting in the necessary values. 
		 */
		PreparedStatement stmt = null;
		/*
		 * We will alter our SQL String to a parameterized SQL String (the
		 * question marks being parameters).
		 */
		final String SQL = "insert into associates values(default, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);
			/*
			 * Before you execute a PreparedStatement, you need to specify what the
			 * values of each parameter( each ?) should be.
			 */
			stmt.setString(1, associate.getAssociateName());
			stmt.setString(2, associate.getAssociateLocale());
			stmt.setString(3, associate.getAssociateHobby());
			stmt.setInt(4, associate.getTrainerId());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			conn.close();
			stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void update(Associate associate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Associate findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
