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
	
	@Override
	void eat() {
		//super keyword: this keyword is used to refer to the super class' (parent class')
		// instance of a method or constructor
		//it can also be used to refer to the super class' instance
		
		super.eat(); //this calls the parent's overridden version of the eat method
		System.out.println("Eats very hungrily");
	}
	
	
	void fly() {
		System.out.println(super.name + " can fly so high");
	}
	
	
	public static void main(String[] args) {
		
		/*
		 * Please note that a Bird object has the properties of a Dinosaur object:
		 * name, habitat, and height.
		 */
		Bird bigBird = new Bird();
		
		/*
		 * Method overriding allows a child class to provide a specific implementation
		 * of a method
		 * 
		 * With method overriding you have the same method name and same
		 * method signature but different implementation
		 * 
		 * */
		
		
		bigBird.eat(); //this method calls the overridden eat method in my bird class
		//bigBird.eat(10); //this method calls the inherited method in my Dinosaur class
		
		bigBird.fly();
		
		
	}
}