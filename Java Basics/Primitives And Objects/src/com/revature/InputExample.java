package com.revature;

import java.util.Scanner;

/*
 * If you want to use a class that exists in a different Java package,
 * you must import it. In order to import a type, you must specify
 * the fully qualified class name (which is the package AND the class
 * name).
 */


public class InputExample {

	/*
	 * Thus far, we've seen a lot of "output". This output has been written
	 * to the console because the console where our "standard output" is
	 * directed.
	 */
	public static void main(String[] args) {
		
		/*
		 * The "out" here is our standard output stream; it is where things
		 * are written by default.
		 */
		System.out.println("output");
		
		/*
		 * If there is a standard output stream that directs output from
		 * our application to our console, you might imagine that there is
		 * a standard input stream that directs input that is taken in the
		 * console to our application. There is: System.in. That said, we
		 * usually don't use System.in alone. We use it in conjunction
		 * with a class called Scanner. The Scanner class is a utility class
		 * that we use to parse streams of data. We wrap an instance of the
		 * Scanner class around our input stream so that it can parse the
		 * input.
		 */
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("What is your name: ");
		String username = scan.nextLine();
		
		//A trick people use to clear out the stream:
		scan.nextLine();
		
		System.out.print("What is your age: ");
		String age = scan.nextLine();
		
		//For those of you who want to convert a String to an Integer.
		int numericAge = Integer.parseInt(age);
		numericAge++;
		
		System.out.println("Hello, " + username + "! You are " 
				+ age + " years old!");
		
		/*One more thing about Scanner: It's typical to close resources
		 *when we're done with them. That said, you better be sure that
		 *you are done with your stream before closing the Scanner because
		 *once you close it, you're not opening it again.
		 */
		scan.close();
		
		int[] arr = {};
	}
}
