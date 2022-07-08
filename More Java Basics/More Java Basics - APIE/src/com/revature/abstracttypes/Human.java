package com.revature.abstracttypes;

/*
 * I cannot extend multiple classes, BUT I can implement as many interfaces as I want.
 * Note that interfaces are implemented while classes are extended.
 */
public class Human extends Animal implements Mammal{

	public Human() {
		
	}
	
	public Human(int age, int numberOfOrgans, String habitat) {
		super(age, numberOfOrgans, habitat);
	}

	/*
	 * If a child class inherits an abstract method from a parent class, it MUST
	 * implement it.
	 */
	@Override
	public void makeASound() {
		System.out.println("I hate work meetings!");
		
	}

	@Override
	public void beWarmBlooded() {
		System.out.println("Blood temp in the high nineties!");
		
	}
	
	
}
