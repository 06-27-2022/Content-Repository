package com.revature.strings;

public class BuilderAndBuffer {

	public static void main(String[] args) {
		
		/*
		 * Recall that a String is used to represent sequences of characters. Also
		 * recall that String is a final class, Strings are stored in a special place
		 * in memory called the String Pool, and that Strings are immutable.
		 */
		
		String christina = "Christina";
		christina.concat(" Russ"); // this returns an entirely new String
		
		System.out.println(christina); // this prints "Christina"
		
		/*
		 * What if I wanted to use a type that feels a lot more like a "mutable String".
		 * That is to say, what if when I called a method like "concat" on the object,
		 * it actually concatenated the new text to the end of my name and actually
		 * allowed me to use the same object?
		 * 
		 * This is possible, but not with the String type. You instead need to use
		 * one of two wrapper classes: StringBuilder or StringBuffer.
		 */
		
		StringBuilder builder = new StringBuilder("Christina");
		builder.append(" Russ");
		
		System.out.println(builder);
		
		
		/*
		 * Although StringBuffer can be used just like StringBuilder, you should not use
		 * StringBuffer. It is ultimately slower than using StringBuilder because it
		 * is what we refer to as "thread-safe", meaning that it is safe for use in
		 * multi-threaded environments. Unless you're using multiple threads, you should
		 * NOT be using StringBuffer.
		 * 
		 * In fact, StringBuffer was the original StringBuilder.
		 */
		StringBuffer buffer = new StringBuffer("Christina");
		buffer.append(" Russ");
		
		System.out.println(buffer);
		
	}
}
