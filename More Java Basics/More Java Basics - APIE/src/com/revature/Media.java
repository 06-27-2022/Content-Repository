package com.revature;

import java.time.LocalDate;

/**
 * 
 * @author 17084
 * 
 * Media refers to a type of consumable digital content such as music or TV show.
 *
 */
public class Media {

	/*
	 * Typically, we include access modifiers when creating classes, fields, and methods.
	 * Even when we don't type an access modifier, one exists for our class members; the
	 * default access is "default".
	 * 
	 * But what is an "access modifier"? An access modifier determines where we can 
	 * directly access a field or a class or method in our program.
	 * 
	 * There are 4 access levels in Java, though only 3 require a special keyword:
	 * 
	 * public: any public member is directly accessible EVERYWHERE in the application
	 * protected: any protected member is directly accessible within the same package
	 * 			AND within child classes (even if those child classes are in different
	 * 			packages)
	 * default (you DO NOT type this to get default access): any default member is
	 * 			directly accessible only within the same package (it is also called 
	 * 			package private as a result).
	 * private: any private member is directly accessible only within the same class that
	 * 			it is declared. MOST RESTRICTIVE ACCESS MODIFIER. Also most commonly used
	 * 			modifier.
	 */
	
	public String title;
	/**
	 * LocalDate is currently the standard for tracking dates in Java.
	 */
	protected LocalDate dateReleased;
	private String intendedAudience;
	
	public Media() {
		
	}
	
	/*
	 * Typically, constructors are public. If they aren't public, you won't be able
	 * to use them to create objects everywhere in the application.
	 */
	public Media(String title, LocalDate dateReleased, String intendedAudience) {
		this.title = title;
		this.dateReleased = dateReleased;
		this.intendedAudience = intendedAudience;
	}
}
