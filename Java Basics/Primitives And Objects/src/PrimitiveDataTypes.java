public class PrimitiveDataTypes{
	
	public static void main(String[] args) {
		
		/*
		 * Programming languages allow us to represent real-world data
		 * quite easily. We can represent the simplest types right out
		 * of the box by using built-in primitive data types. There are
		 * 8 primitive data types in Java:
		 * 
		 * boolean (has a negligible bit value) - represents a value of either "true" or "false"
		 * byte (8 bit values) - represents a whole number between -128 and 127
		 * char (16 bit values) - represents a single character
		 * short (16 bit values) - represents a whole number
		 * int (32 bits values) - represents a whole number
		 * float (32 bit values) - represents a floating point value
		 * long (64 bit values) - represents a whole number
		 * double (64 bit values) - represents a floating point value
		 * 
		 * These primitive data types are often used as building blocks
		 * for more complex types (e.g. classes). Please note that your 
		 * primitive data types have upper limits on the amount of data
		 * they can store.
		 */
		
		/*
		 * These are variable declarations and assignments. A variable
		 * declaration consists of a type and a variable name. The
		 * actual assignment entails using "=" operator to assign a value
		 * to the variable.
		 */
		boolean isTrue = false;
		char aChar = 'a';
		byte aByte = 120;
		short aShort = 1280;
		int anInt = 899922242;
		float aFloat = 8.7888f; //note that the "f" must be present for the float
		long aLong = 875497593759745973L; //note that the "L" must be present for longs
		double aDouble = 832424.33;
		
		//Operators
		
		//Assignment Operator
		int myNum = 89; //myNum has been assigned a value of 89
		
		//Equality Operator: This is used to compare values
		System.out.println(myNum == 90);
		
		//Basic math (+, -, *, /, %)
		
		int a = 8;
		float b = 5;
		float answer = a * b;
		System.out.println(answer);
		
		//Also watch out for primitive promotion when doing math!
		short c = 8;
		short d = 9;
		int e = c + d;
		
		//Greater than or less than
		System.out.println(4 >= 5);
		
		//Ternary Operator: This operator allows you to make conditional
		//assignments based on whether or not a bolean expression evaluates
		//to true or false.
		
		int dependency = 9;
		int conditionalVar = (dependency > 5) ? 10 : 20;
		System.out.println(conditionalVar);
	}
}