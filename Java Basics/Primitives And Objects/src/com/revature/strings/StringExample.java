package com.revature.strings;

public class StringExample {

	public static void main(String[] args) {
		/*
		 * We've used the String class already in several examples.
		 * This is class is VERY often used in Java. The String class is
		 * used to represent what we think of as text: words, sentences.
		 * In general, a String represents a sequence of characters. 
		 * 
		 * Of course, we can already represent this without using the String
		 * type:
		 */
		
		char[] myName = {'C', 'h', 'r', 'i', 's', 't', 'i', 'n', 'a'};
		
		/*
		 * Printing my name:
		 */
		
		System.out.println(myName); //this will work
		for(char c : myName) {
			System.out.print(c);
		}
		
		//This is only here to add a new line!
		System.out.println();
		
		/*Adding my last name to my first name. This means that I have to
		 *make a new array because the size of an array can't be changed.
		 *The new array will need 5 extra spaces for a space and the four
		 *letters of my last name, so the length will be 14.
		 *
		 *After I make the new array, I need to take all of the characters 
		 *from the first array so that I can my first name.
		 */
		
		char[] myFullName = new char[14];
		
		//Takes all of the chars from the first array and puts them in the new array
		for(int i = 0; i < myName.length; i++) {
			myFullName[i] = myName[i];
		}
		
		//Then I have to put my last name in the array.
		
		myFullName[10] = 'R';
		myFullName[11] = 'u';
		myFullName[12] = 's';
		myFullName[13] = 's';
		
		System.out.println(myFullName);
		
		/*
		 * All of the things that we did above are tedious. We do NOT have
		 * to do all of this just to work with characters in Java. That's where
		 * the String class comes in. Understand that is just a char[].
		 * 
		 * Note that String is a class we DON'T want to use a constructor
		 * for when creating an instance of the class. We instead want to
		 * use a String literal.
		 * 
		 * Why don't use the String constructor to create String objects?
		 * Strings that are created using the String constructor are
		 * guaranteed to create new objects. If you use a String literal,
		 * however, Java might not create a new object. Instead, it will
		 * reuse an existing String in memory if it can. These Strings are
		 * stored in a special place in memory called the "String Pool".
		 */
		
		String myBetterName = "Christina";
		/*
		 * This is bad practice because it forces the creation of another
		 * String object with the exact same contents as the first. That
		 * means this is memory inefficient.
		 */
		String badPracticeName = new String("Christina");
		/*And let's say I wanted to add a space and my last name.
		 * 
		 * Please note that you can't actually "change" a String. Strings
		 * are "immutable". Because Strings are immutable, most String
		 * methods return an entirely new String.
		 */
		myBetterName = myBetterName.concat(" Russ");
		myBetterName = myBetterName.toUpperCase();
		myBetterName = myBetterName.replace('A', 'E');
		System.out.println(myBetterName);
	}
}
