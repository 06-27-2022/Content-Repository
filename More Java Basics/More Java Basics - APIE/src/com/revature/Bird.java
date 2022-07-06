package com.revature;

/*
 * When we talk about inheritance, we are talking about the ability for one class to
 * inherit properties and behaviors from another class. The class from which a class
 * inherits is called its parent class or "super" class.
 * 
 * In order to make a child class, you must use the "extends" keyword.
 * 
 * Please note that Java does not support multiple inheritance, so you are only
 * allowed to extend one class.
 */
public class Bird extends Dinosaur{

	public static void main(String[] args) {
		
		/*
		 * Please note that a Bird object has the properties of a Dinosaur object:
		 * name, habitat, and height.
		 */
		Bird bigBird = new Bird();
		
	}
}
