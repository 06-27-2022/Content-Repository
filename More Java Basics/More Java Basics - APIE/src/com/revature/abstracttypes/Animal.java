package com.revature.abstracttypes;

/*
 * It seems that the point of making the Animal class was for subtypes to just
 * override all of the methods present here. If that is the case, then our current
 * approach is tedious because we must continue to refer to this class in order to
 * flesh out our subtypes.
 * 
 * What if it were possible to tell Java to force our subtypes to override certain
 * methods so that it would not be possible for the developer to forget to override
 * certain methods? This is possible. We can do this by using what we call "Abstract
 * Classes".
 * 
 * An abstract class is a class that is marked with the "abstract" modifier and is
 * therefore allowed to contain abstract methods.
 * 
 * An abstract method is a method that does not have an implementation (e.g. it does
 * not have curly braces or anything that would be contained within curly braces).
 * 
 * Fun Fact: You don't have to have any abstract methods on an abstract class. It still
 * compiles.
 * 
 */
public abstract class Animal {

	protected int age;
	protected int numberOfOrgans;
	protected String habitat;
	
	public Animal() {
		
	}
	
	public Animal(int age, int numberOfOrgans, String habitat) {
		this.age = age;
		this.numberOfOrgans = numberOfOrgans;
		this.habitat = habitat;
	}
	/*
	 * Using abstract modifier on a method. Please note that an abstract cannot be
	 * "final". It also cannot be "static".
	 */
	public abstract void makeASound();
	
	public void eat() {
		System.out.println("Eating organic matter!");
	}
	
	public void sleep() {
		System.out.println("Zzzzzzzz...");
	}
}
