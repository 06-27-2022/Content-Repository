package com.revature;

import com.revature.package2.Song;

/*
 * Remember that Java is statically typed. All variables are declared with a type and
 * those variables must point to the appropriate values or objects.
 * 
 * What happens, however, when you're working with data and you realize that you want
 * to the change the type of data you're working with? For instance, what if you start
 * with one data type and then realize you need a different or smaller/larger data type?
 * 
 * When this happens, you have the ability to cast one data type to another.
 */
public class CastingExample {

	public static void main(String[] args) {
		
		double someNumber = 89929342424.3424324D;
		
		/*Basic syntax for casting from one primitive type to another. Please
		 * note that you can lose date when you cast from a larger data type to 
		 * a smaller data type.
		 */
		
		int myCastedNum = (int) someNumber;
		
		System.out.println(myCastedNum);
		
		/*
		 * You can also Object types, BUT you need to be mindful about the instance (object)
		 * is.
		 * 
		 * Let's start with a lesson in "covariance". This terms simply refers to using a super
		 * type as your reference/variable type while the instance is a child type.
		 */
		
		Media myMovie = new Movie();
		Media myBook = new Book();
		Media mySong = new Song();
		Media myMedia = new Media();
		
		/*
		 * You can either "downcast" or "upcast" your types. Downcasting entails
		 * moving from a narrower type (super type) to a broader type (child type).
		 */
		
		Book castedBook = (Book) myBook;
		
		/*
		 * Downcasting is tricky. If you attempt to downcast to a type that the Object
		 * isn't (myMedia is NOT pointing to a Book object as we see above), the cast
		 * is going to fail. A ClassCastException will be thrown.
		 */
		Book anotherCastedBook = (Book) myMedia;
		
	}
}
