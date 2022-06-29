public class ControlFlowStatements  {
	
	public static void main (String[] args) {
		/*
		 * decision statements
		 * : if statements, else if, switch
		 * 
		 * looping statement
		 * : for, while, do while, enhanced for loop
		 * 
		 * */
		
		//decision statements: 
		//if statement: 
		//can also have else if and/or else statements
		//if there are multiple blocks (more than just an if block), only ONE block will run. 
		System.out.println("This is an if statement example: ");
		String day = "Wednesday";
		
		//if statement using strings
		if (day != "Tuesday") {
			//will only run if the condition is met
			System.out.println(day);
		}
		else if (day == "Wednesday") {
			//can have as many else if statements as desired
			//will only run if condition is met
			System.out.println(day);
		}
		else if (day == "Thursday") {
			System.out.println(day);
		}
		else if (day == "Friday") {
			System.out.println(day);
		}
		else {
			//will run if no other condition is met
			System.out.println("It's another day");
		}
		
		System.out.println("\n");

		
		int test1 = 10;
		int test2 = 35;
		char char1 = 'a';
		char char2 = 'b';
		
		//if statement with multiple conditions
		//logical operators: 
		//&& - logical AND => both conditions must be met
		//|| - logical OR => either condition must be met
		System.out.println("If statements with multiple conditions: ");
		if (test1 >= 5) {
			System.out.println("The number is greater than or equal to 5");
		}
		if (test2 > 30 && test2 < 40 && test1 > 5) {
			// && AND operator - both conditions need to be true
			//you can have multiple && operators in the same condition
			System.out.println("The number is between 30 and 40");
		}
		if (test2 > 30 || test2 < 40) {
			// && AND operator - both conditions need to be true
			//you can have multiple && operators in the same condition
			System.out.println("The number is greater than 30 OR less than 40");
		}
		if ((test2 > 20 && test2 < 30) || test2 == 35) {
			// && AND operator - both conditions need to be true
			//you can have multiple && operators in the same condition
			System.out.println("The number is between 20 and 30, or equal to 35");
		}
		if (test2 > 50 || test1 < 40 || char2 == 'c') {
			//you can have more than 2 conditions
			//for the || (or) operator, only one condition needs to be true
			System.out.println("Test2 is greater than 50 or test1 is less than 40 or char2 is equal to c");
		}
		if (test2 > 50 && test1 < 40 && char2 == 'c') {
			//you can have more than 2 conditions
			//for the || (or) operator, only one condition needs to be true
			System.out.println("Test2 is greater than 50 AND test1 is less than 40 AND char2 is equal to c");
		}
		if (test1 == 20 || char1 == 'a') {
			System.out.println("This statement prints if the number is less than 20 OR if the letter is equal to a");
		}
		//you can also perform operations in the condition
		if (test1 + test2 < 100) {
			System.out.println("This statement prints if the result of the addition is less than 100");
		}
		
		
		
		System.out.println("\n");


		//switch statement: 
		int num1 = 1;
		
		//int[] numberArray = {1, 2, 3};
		System.out.println("This is a switch statement example: ");
		switch(num1) {
		case 1:
			//if num1 == 1
			System.out.println("Inside case 1: ");
			System.out.println(num1);
			break;
			//the break statement terminates the enclosing switch statement
			//if you don't have the break statement
			//the statements in the switch block will "fall through"
		case 2:
			//if num == 2
			System.out.println("Inside case 2: ");
			System.out.println(num1);
			break;
		case 3:
			//if num == 3
			System.out.println("Inside case 3: ");
			System.out.println(num1);
			break;
		default: 
			//optional statement
			//default statement does not need a break statement
			//will run if no other case conditions are met or if we don't have a break statememnt to prevent fall through
			System.out.println("Inside my default: ");
			System.out.println(num1);
		}
		
		
		//looping statements: 
		//for, while, do while, for each (enhanced for loop)
		
		//we want the print statement to execute 17 times
		int numOfTimes = 11;
		System.out.println("\n");
		System.out.println("This is a for loop example");

		for (int i = 0; i < numOfTimes; i++) {
			System.out.println(i);
		}
		

		//while loop: 
		//while the condition is true, execute the code in the block
		boolean keepGoing = true;

		int whileExample = 0;
		System.out.println("\n");
		System.out.println("This is a while loop example");
		while(keepGoing) {
			System.out.println("hello!!");
			whileExample++;
			
			if (whileExample == 10) {
				keepGoing = false;
				//break;
			}
			System.out.println("End of while block");
		}
		
		
		//do while
		System.out.println("\n");
		System.out.println("This is a do while example");
		
		boolean doKeepGoing = true;
		do {
			System.out.println("Hello do while!");
			
		} while (!doKeepGoing);
		
		
		//enhanced for loop (for each)
		//use this loop to iterate/traverse through data structures
		//like arrays or collections
		System.out.println("\n");
		System.out.println("This is an enhanced for loop example");
		int[] numberArray = {1, 2, 3, 4, 10, 35, 16};
		char[] charArray = {'a', 'b'};
		
		//in an enhanced for loop, we don't need to update the loop variable
		for (int number: numberArray) {
			System.out.println(number);
		}
		
		System.out.println("\n");
		System.out.println("Iterating through an array");

		//iterating through an array: 
		int[] basicArray = {1, 2, 3, 4, 5};
		
		//System.out.println(basicArray[0]);
		
		for (int i = 0; i < basicArray.length; i++) {
			System.out.println(basicArray[i]);
		}
		
		
		
		
		
		
	}
	
	
}