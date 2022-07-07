package com.revature.exceptions;

import java.util.Scanner;

/*
 * One of the features of Java is its built-in exception handling. This means that
 * when something goes "wrong", Java has a built-in mechanism the developer can
 * take advantage of to correct it.
 * 
 * Simply put, an Exception is an unexpected event that disrupts the normal flow of
 * your application. Exceptions can be reasonably handled.
 * 
 * "Exception" is just a class. It actually inherits from a class called "Throwable".
 * Exception also has a sibling class called "Error".
 * 
 * What is the difference between these two classes? Errors cannot be reasonably recovered
 * from.
 */
public class ExceptionExamples {

	/*
	 * When called, this method will throw a StackOverflowError.
	 */
	public void overflow() {
		overflow();
	}
	
	public static void main(String[] args) {
		
		//Let's take input from a user to allow them to pick a number from this array and print it.
		Scanner scan = new Scanner(System.in);
		System.out.print("Which index would you like to see: ");
		int userSelection = scan.nextInt();
		
		
		//An example of an Error for your reference:
		ExceptionExamples exceptionExamples = new ExceptionExamples();
		exceptionExamples.overflow(); //This line throws a StackOverflowError
		
		int[] myNums = {2, 5, 5, 2, 122, 90};
//		myNums[2] = 8; //This line throws an ArrayIndexOutOfBoundsException
		
		String myString = "A String";
//		myString.charAt(20); //This line throws a StringIndexOutOfBoundsException
		
//		LocalDate myDate = LocalDate.of(2022, 20, 21); //This line throws a DateTimeException
		
		//Let's print the user's number selection:
		/*
		 * Because we know that there is the potential for an Exception to be thrown,
		 * especially in this case because we're taking user input and using it to 
		 * access an element in our array. If an Exception is thrown, our goodbye
		 * message is never printed. We ideally want to be able to move past the
		 * Exception even if it is thrown.
		 * 
		 * In order to do this, I will do what we call "handling the exception". We
		 * handle exceptions by using try-catch blocks.
		 * 
		 * We put our "risky" code (code that could lead an exception being thrown)
		 * inside of our try block. There should only be one try block! Please not
		 * that a try block cannot be used alone. It must be followed by either a catch
		 * block or a finally block.
		 * 
		 * If an exception is thrown, we course correct our application inside of a
		 * catch block after our try block. When using a catch block, you must specify
		 * the exception that you're expecting to be thrown.
		 * 
		 * You are allowed to have multiple catch blocks, BUT the exceptions those blocks
		 * handle should be listed from most to least specific.
		 * 
		 * You can also optionally have another block at the end called a "finally block".
		 * In fact, you can just have try-finally. The finally block always runs; there are
		 * some exceptions to the rule. For instance, if there is some unrecoverable error
		 * in your program, the finally block won't run.
		 * 
		 * Why would you want a block that always run? Sometimes there are things we
		 * need to do regardless of whether or not an exception is thrown. For example,
		 * you always want to close an open connection to a database or close an open
		 * FileInputStream.
		 */
		try{
			System.out.println(myNums[userSelection]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("That is not a valid index!");
		}catch(Exception e) {
			e.printStackTrace();
		} finally{
			System.out.println("I always run.");
		}
		
		System.out.println("Thanks for playing!");
		
		
		scan.close();
	}
}
