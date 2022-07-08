package com.revature.keywords;

public class StaticExample {
	
	//Let's create some instance variables!
	private int instanceInt;
	private String instanceString;
	/*
	 * Let's create a static variable. Unlike our instance variables, there is only
	 * ever ONE COPY of a static variable. That one copy belongs to the entire class
	 * and is shared across all instances.
	 * 
	 */
	private static int staticInt = 0;
	
	
	public StaticExample() {
		
	}
	
	public StaticExample(int instanceInt, String instanceString) {
		this.instanceInt = instanceInt;
		this.instanceString = instanceString;
		//Let's increment the staticInt every time we call the constructor:
		staticInt++;
	}

	/*
	 * We've seen the "static" keyword several times at this point. What is it's
	 * purpose? And where do we use it?
	 * 
	 * The static keyword can be applied to methods and even fields.
	 */
	public static void main(String[] args) {
		
		StaticExample staticExample1 = new StaticExample(1, "one");
		StaticExample staticExample2 = new StaticExample(2, "two");
		StaticExample staticExample3 = new StaticExample(3, "three");
		System.out.println(staticExample1);
		System.out.println(staticExample2);
		System.out.println(staticExample3);
		
		/*
		 * When accessing a static variable or method, you should not (though you can)
		 * use a reference to an instance of the class. You should instead use the
		 * class name.
		 */
		System.out.println(StaticExample.staticInt);
		staticExample1.printMessage(); //calling an instance method
		
		/*
		 * Calling a static method does NOT require that you create an instance of
		 * the StaticExample class. You can simply use the class's name to call the
		 * method. When a method or a field is marked as "static", it belongs to the
		 * entire class itself - NOT just an instance of the class.
		 */
		StaticExample.printStaticMessage(); //calling a static method
	}
	
	public void printMessage() {
		System.out.println("I'm an instance method!");
	}
	
	public static void printStaticMessage() {
		/*
		 * This method call is not legal in Java because you cannot access non-static (instance)
		 * methods and variables inside of a static block or method. That is because
		 * a static member of a class actually exists before you ever create an instance
		 * of the class. It essentially exists the minute the application starts running.
		 * This is NOT true for instance variables or methods, which means that they
		 * do not truly exist until you create instances of the classes inside which
		 * they are declared.
		 */
//		printMessage();
		System.out.println("I'm a static method!");
	}

	@Override
	public String toString() {
		return "StaticExample [instanceInt=" + instanceInt + ", instanceString=" + instanceString + "]";
	}
}
