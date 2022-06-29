/*
 * You do not do anything outside of a the context of a class in Java.
 * We often use classes to model real-world concepts by assigning "state"
 * and "behavior" to the instances of the class.
 */
public class Objects{
	
	public static void main(String[] args) {
		
		/*
		 * An object is:
		 * 
		 * 1) An instance of a class. 
		 * 2) A representation for some data that is stored somewhere in memory.
		 * 
		 * In order to create an object (which will force Java to allocate memory),
		 * you need a class and you need to use that class's constructor:
		 */
		
		/*
		 * Please note that objects and primitives have major differences,
		 * one big one being that primitives don't have methods/behaviors
		 * associated with them. In order to create an object, you must
		 * use a constructor in conjunction with the "new".
		 */
		int myPrimitive = 8;
		Object myObject = new Object();
		
	}
}
