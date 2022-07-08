package com.revature.abstracttypes;

/*
 * Java does NOT support multiple inheritance! This means that it's not possible for a
 * class to extend multiple classes.
 * 
 * The solution to this problem in Java is "interfaces". Instead of using a class, we
 * use an interface.
 * 
 * Note that an interface is similar to an abstract class, but there are a few key
 * differences to note:
 * 
 * 1) It is implicitly abstract; this means that you don't have to type "abstract"
 * in front of it.
 * 
 * 2) All of its methods are assumed to be abstract; this means that you don't have
 * to type "abstract" in front of the methods.
 * 
 * 3) All of its methods are also assumed to be public; this means that you don't have
 * to type "public" in front of the methods.
 */
interface Mammal {
	
	/*
	 * It is also possible for interfaces to have fields. They must be public, static,
	 * and final.
	 */
	public static final int BRAIN_COMPLEXITY = 9001;

	void beWarmBlooded();
	
	/*
	 * What if you want a method to have a default implementation? That is possible
	 * as well on interfaces. You have two options:
	 * 
	 * 1) To make the method static: Static methods must have implementations.
	 * 2) To use the "default" keyword. Default methods must have implementations.
	 */
	
	static void drinkMilk() {
		System.out.println("Baby mammals drink milk.");
	}
	
	default void beBornAlive() {
		System.out.println("Mammals don't lay eggs.");
	}
}

/*
 * Interfaces can extend other interfaces. Note that they will NOT be forced to implement
 * the abstract methods they inherit because abstract types are not forced to implement
 * methods.
 */
interface Marsupial extends Mammal{
	
	
}