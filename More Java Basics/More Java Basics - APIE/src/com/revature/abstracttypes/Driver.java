package com.revature.abstracttypes;

public class Driver {

	public static void main(String[] args) {
		
		Human human = new Human();
		Cat cat = new Cat();
		/*
		 * Abstract types cannot be instantiated! This makes sense as abstract types
		 * aren't guaranteed to have concrete methods.
		 */
//		Animal animal = new Animal(); //does not compile
//		Mammal mammal = new Mammal(); //does not compile
	}
}
