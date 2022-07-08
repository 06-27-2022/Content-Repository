package com.revature.exceptions;

import java.util.Scanner;

/*
 * You can create custom exceptions in Java. You can do so by simply extending
 * the Exception class.
 * 
 * There are actually two types of Exceptions in Java. We categorize exceptions as either
 * unchecked (Runtime Exceptions) or checked exceptions. Unchecked exceptions do not
 * have to handled; this means that even I don't handle unchecked exceptions, the code
 * compiles. Checked exceptions, on the other hand, are required to be handled or the
 * code fails to compile.
 * 
 * Checked exceptions are exceptions that inherit from the Exception class but NOT from
 * the RuntimeException class. Unchecked exceptions inherit from the RuntimeException
 * class.
 * 
 *                                           Throwable
 *                                       /             \
 *                                   Exception			Error
 *                                  	|
 *                                  RuntimeException 
 *                                
 *                                */
public class ChristinaException extends Exception {

	/*
	 * This is only here to remove the warning related to not having a serial
	 * version UID for deserializtion of this type is you're using Java
	 * serialization. If you're curious, please look into an interface called
	 * "Serializable".
	 */
	private static final long serialVersionUID = 1L;

	public ChristinaException() {

	}

	/*
	 * This overload of the constructor prints a message to the console when the
	 * Exception is thrown.
	 */
	public ChristinaException(String message) {
		super(message);
	}

	public static void main(String[] args){

		ChristinaException christinaException = new ChristinaException();

		/*
		 * You can throw an exception whenever you want to:
		 */
		System.out.print("Type your name: ");
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();

		/*
		 * We moved this logic into a method to observe how we can propagate Exceptions
		 * up to the caller.
		 */
//		if(name.equals("Christina")) {
//			try {
//				throw new ChristinaException("User's name is Christina!");
//			}catch(ChristinaException e) {
//				System.out.println(e.getMessage());
//		}

		// We make a method call instead. Notice that we have now forced main
		//to handle the exception.
		try {
			christinaException.takeName(name);
		}catch(ChristinaException e) {
			System.out.println(e.getMessage());
		}

		scan.close();
	}

	public void takeName(String name) throws ChristinaException {

		if (name.equals("Christina")) {
			/*
			 * Sometimes, we don't want to handle an Exception where it is thrown.
			 * In those cases, we want to do the Exception handling somewhere else.
			 * We can force the caller to handle the exception instead. Remember that
			 * the "caller" is simply the method that calls this method. We can do
			 * so by using the "throws" keyword. The "throws" keyword is used on
			 * method signatures to denote that a methods will force its calling method
			 * to handle an exception.
			 */ 
			throw new ChristinaException("User's name is Christina!");
		}
	}

}
