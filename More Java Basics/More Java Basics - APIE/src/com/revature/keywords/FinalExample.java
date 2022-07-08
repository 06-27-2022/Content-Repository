package com.revature.keywords;

import java.util.ArrayList;
import java.util.List;

/*
 * There are many reserved keywords in Java; generally your IDE highlights these for
 * you, but of course you should know them regardless of the highlighting. Let's take
 * a look a very commonly used keyword called "final".
 * 
 * The "final" keyword has 3 different uses in Java. It can be used:
 * 
 * 1) with classes: prevents a class from being subclassed; it can't have child classes; you cannot extend a final class
 * 2) with methods: prevents a method from ever being overridden
 * 3) with variables: prevents us from using the assignment operator with a variable more than once
 */
public final class FinalExample {
	
	/*
	 * If you have a final variable, be careful and make sure that you intialize the
	 * variable pretty early as you are required to do so. You can do so immediately
	 * after the declaration, in the constructor, or inside of an instance initializer
	 * block.
	 * 
	 * Note: By convention, final variables are typically named in all caps!
	 */
	private final int FINAL_INT = 90;
	
	public FinalExample() {
		
	}
	
	

	public static void main(String[] args) {
		
		/*
		 * What if it was important to you that a variable only ever pointed to the
		 * same object or value? Using the final keyword can ensure this.
		 * 
		 * BUT please understand that this does not mean that the underlying object in
		 * change.
		 */
		final String MY_NAME = "Christina Russ";
		final int NUMBER_OF_CARDS = 52;
		/*
		 * What if you had a list of names? Understand that the object a final variable
		 * points to can be modified (unless it's an immutable type like String).
		 */
		final List<String> names = new ArrayList<>();
		names.add("Christina");
		names.add("Mom");
		names.add("Canisha");
		names.add("Dashawn");
	}
	
	/*
	 * Let's make a final method. Note that when you use a "non-access modifier" like
	 * final, you cannot put it after the return type. Please note that you can put it
	 * before your access modifiers (e.g. public), but that you typically don't see it
	 * that way.
	 * 
	 * This method can never be overridden because it is final.
	 */
	
	public final void printMessage() {
		System.out.println("You can't change me!");
	}
}

/*
 * I've commented the "extends FinalExample" because the code doesn't compile otherwise
 * since FinalExample is a final class that cannot be extended.
 */
class FinalExampleChild /*extends FinalExample*/{
	
	/*
	 * Final methods are NOT allowed to be overridden. This means that our child class
	 * cannot override printMessage.
	 */
//	@Override
//	public final void printMessage() {
//		
//	}
	
}
