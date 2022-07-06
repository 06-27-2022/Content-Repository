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
	
	/*
	 * When you declare properties on a child class, be sure that you do not accidentally
	 * "shadow" the parent class's properties. Shadowing occurs when you effective hide the
	 * parent class's properties by naming a child class's properties the exact same thing
	 * that you named the parent class's properties.
	 */
	String chirpSound;
	
	Bird(){
		/*
		 * The implementation (logic inside of the curly braces) for a constructor is never
		 * really empty. The very first line of any constructor is actually a call to the
		 * parent class's constructor.
		 * 
		 * This means that this happens implicitly: super();
		 * 
		 * Please understand that if you choose to type super() that it MUST be the very first
		 * line of constructor.
		 */
		
		super();
	}
	
	Bird(String name, String habitat){
		super(name, habitat);
	}
	
	Bird(String name, String habitat, int height){
		super(name, habitat, height);
	}
	
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
		Bird bigBird = new Bird("Toucan Sam", "Cereal Box");
		
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