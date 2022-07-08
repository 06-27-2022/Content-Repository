package com.revature.wrappers;

import java.util.ArrayList;
import java.util.List;

public class WrapperClasses {

	public static void main(String[] args) {
		
		/*
		 * As you recall, Java has 8 primitive data types. Remember that these are
		 * not Object types; you can't, for instance, call any methods on these values.
		 */
		
		int num = 8;
		
		/*
		 * There are Object representations for all of the primitives in Java. These 
		 * are referred to as "Wrapper Classes".
		 * 
		 * The wrapper classes are as follows.
		 */
		
		Integer myInt = 0;
		Long myLong = 18L;
		Short myShort = 8;
		Byte myByte = 5;
		Double myDouble = 78D;
		Float myFloat = 56f;
		Boolean myBoolean = false;
		Character myCharacter = 'e';
		
		/*
		 * Note that you should NOT use the constructors as they're deprecated. Java is
		 * capable of taking a primitive value and "autoboxing" it into an object type.
		 * 
		 * Also note that these wrapper classes are really useful as utilities for
		 * converting between different types. For instance, the "parse" method is really
		 * useful for moving between a String value and a primitive value.
		 */
		
		String oneTwoThree = "123";
		int actualNumber = Integer.parseInt(oneTwoThree);
		
		/*
		 * Wrapper classes are very useful because we can't use primitives for everything
		 * in Java. For instance, if you wish to use Java collections with generics, you
		 * must wrapper classes.
		 */
		
		/*Note that an ArrayList is used as a resizable array.
		 * 
		 * Generally, when you use a List, it is recommended that you use generics.
		 * Generics impose a type on a List. This means that you will only be able
		 * to add a certain type of Object to the list. You are NOT allowed to use
		 * primitives with generics. In this case, you would be forced to use 
		 * wrapper classes.
		 */
		List<Integer> myList = new ArrayList<>();
		
		myList.add(8);
		myList.add(900);
		myList.add(34);
		myList.add(12);
		
		//This removes an element by its index (so this removes 8 from the list).
		myList.remove(0);
		
		System.out.println(myList);
	}
	
}
