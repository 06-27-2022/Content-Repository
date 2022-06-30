package com.revature.dsa;

public class UsingArrays {
	
	/*
	 * Can you remember what the default values are for these primitives?
	 */
	float myFloat;
	double myDouble;
	char myChar;
	boolean myBoolean;
	byte myByte;
	short myShort;
	int myInt;
	long myLong;
	
	public static void main(String[] args) {
		/*
		 * This is called an "array". An array is a data structure.
		 * An array acts as a container for multiple values. This gives
		 * us the benefit of accessing multiple values via one reference.
		 * It also gives us the benefit of being able to access those values
		 * quickly.
		 * 
		 * This is a basic syntax for creating an array, but there are
		 * also other syntaxes for creating an array. The guiding
		 * principle here is that Java must always know how much space
		 * it should allocate for the array. That is to say, it needs to
		 * know how many elements should be in that array.
		 * 
		 * Please note that you CANNOT change an array's capacity.
		 */
		int[] arr = {3, 22, 98, 12};
		int[] arr2 = new int[10];
		int[] arr3 = new int[]{3, 2, 12, 3, 5};

		/*To access a single element in an array, you can use the following
		 *syntax. Please note that you use indexes when accessing elements
		 *in an array. These indexes start from 0 - NOT 1. This also
		 *means that the largest index for an array is the array's length - 1.
		 */
		System.out.print(arr[3] + " ");
		arr[3] = 50;
		System.out.println(arr[3]);
		
		//Arrays are iterable, which means that you can iterate over them:
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		// This is here just to print a line.
		System.out.println();
		
		/*
		 * What about our array that has "nothing" in it? Let's find out.
		 * 
		 * Notice that when you run this code, the array doesn't have "nothing"
		 * in it; it has been initialized with 10 0s.
		 * 
		 * Why? Because all primitive data types have default values. These
		 * default values are the simplest values that they could be.
		 */
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		
		// This is here just to print a line.
		System.out.println();
		
		//Let's look at the default for these primitives (which as defined
		//instance variables in this class):
		
		UsingArrays usingArrays = new UsingArrays();
		
		System.out.println(usingArrays.myBoolean);
		System.out.println(usingArrays.myFloat);
		//The default value for char is the null character (\u0000).
		System.out.println(usingArrays.myChar);
		
	}
}
