/*
 * Everything in Java occurs within the context of a class. A public class in a file
 * should have a name that matches the name of the Java file itself (sans the .java
 * extension).
 */
public class HelloWorld {
	/*
	 * This is called the "main" method. Your Java application begins execution
	 * from this method.
	 */
	public static void main(String[] args){
		System.out.println("loading...");
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println("Hello world!");
	}
}
