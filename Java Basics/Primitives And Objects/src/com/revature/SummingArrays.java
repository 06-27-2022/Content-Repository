package com.revature;

public class SummingArrays {

	/*
	 * A programming language is just a tool that helps us verbalize
	 * a solution that we already know. This means that you have to
	 * know how to solve a problem before you write the solution.
	 * 
	 * As a result, it is a good idea to think about how you would
	 * solve the problem even if you didn't have to code it. Given
	 * the array:
	 * 
	 * {4, 2, 5, 7, 9}
	 * 
	 * Adding all of these numbers together requires that I:
	 * 
	 * 1) I have to look at each number in the array.
	 * 2) I will need to add the first 2 numbers together and then
	 * add this result to the next (3rd) number.
	 * {6, 5, 7, 9}
	 * {11, 7, 9}
	 * {18, 9}
	 * {27}
	 * 
	 * Now you need to match these ideas up with programming concepts.
	 * 
	 * For instance, I said that I had to look at each number and
	 * add it to my existing sum. Well, is there is something in Java
	 * that would allow me to move through all of these numbers? Yes:
	 *  a for loop. I also know that when I add 2 numbers together, I
	 *  need to store the sum of adding two numbers together. Can I 
	 *  do this? Yes; I need to create a variable that stores this
	 *  information.
	 */
	
	/*
	 * Recall that a method will have a return type and a name as well
	 * as optional parameters at the very least.
	 * 
	 * If my answer should support finding the sum of the ints in ANY 
	 * array, this suggests that I won't know what the values in that
	 * array are until the program runs. It sounds like I need a placeholder.
	 * And remember: Parameters are placeholders.
	 */
	 int sum(int[] arrayThatWillBePassedIn) {
		
		int sum = 0;
		//We need to iterate over the array:
		for(int i : arrayThatWillBePassedIn) {
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		SummingArrays summing = new SummingArrays();
		System.out.println(summing.sum(new int[] {3, 4, 60, 23}));
	}
}
