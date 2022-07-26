package com.revature.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.revature.complexity.BigO;

/**
 * As a developer, it is not only your job to implement features in an application; it is
 * ALSO your job to unit test your own source code. In fact, you are expected to know how
 * to unit test your own code.
 * 
 * When I say "unit test", I am referring to testing the smallest unit of code possible. In
 * our case, this is usually a single method. As a result, unit testing is considered
 * simple. Generally, you will have more unit tests than any other type of test in an
 * application.
 * 
 * The point of testing an application is to identify defects (e.g. bugs and errors).
 * 
 * When writing tests, you typically compare the expected output to the actual output.
 * We can do this manually (by using sysouts, etc.), but that is not ideal as there are
 * already several frameworks that handle tests and reporting defects. One such framework
 * is JUnit.
 * 
 * JUnit is the most popular Java testing framework. It is considered easy to use as it
 * is annotation-based and it comes with simple "assertions", which compare our expected
 * output to our actual output.
 * 
 * In order to use JUnit, we will add the proper dependencies to our pom.xml. Keep in mind
 * that we will be using JUnit5, but that JUnit4 is also commonly used.
 * 
 * Understand that JUnit is what we call a "framework". Frameworks follow a design pattern
 * that we refer to as the "inversion of control" design pattern. This means that we pass
 * our source code to frameworks, at which point the frameworks take our source code and
 * use it to perform a task for us. For this reason, if we create a class that contains
 * JUnit tests (like the class below), JUnit will create an instance of our class for us
 * and call the methods present on that class for us.
 * 
 * @author 17084
 *
 */

/*
 * Be default, JUnit will call your @BeforeAll method and @AfterAll method without using
 * an instance of the class. This means that those methods have to be static. 
 * 
 * BUT if you're not a fan of making those methods static, you can use the @TestInstance
 * annotation above the class. This annotation will allow you to specify how many instances
 * of this test class are made to call the test methods as by default only one instance
 * is made.
 */
@TestInstance(Lifecycle.PER_CLASS)
public class SearchTest {
	
	/*
	 * We've declared this variable at the highest scope as we want to be able to use
	 * in multiple tests.
	 */
	
	int[] numbers;

	/*
	 * There are several JUnit annotations that you must know before using JUnit.
	 * Many of the annotations are method-level annotations, but some are also
	 * class-level annotations.
	 * 
	 * When declaring methods on a JUnit test class, they should have "void" as their
	 * return type.
	 */
	
	/**
	 * Any method that is annotated with @BeforeAll will be run ONCE. It will be run
	 * before all of the other methods present on this class. It is the very first
	 * method that JUnit will call for us. As a result, it is typically used to perform
	 * "setup" of a test suite (a suite is just a collection of tests). For instance,
	 * if you have a test DB that you must open a connection to, or if you have a file
	 * that you need to open a stream to, or even if you just need to create an instance
	 * of a class.
	 */
	@BeforeAll
	public void beforeAll() {
		System.out.println("before all");
		numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	}
	
	/**
	 * Any method that is annotated with @BeforeEach is called once PER test method (a
	 * test method is any method that is annotated with @Test). So if you have have
	 * 3 methods annotated with @Test, this method will be called once before each and
	 * every one of those methods (so 3 times). This method is typically used for more
	 * granular setup.
	 */
	@BeforeEach
	public void beforeEach() {
		System.out.println("before each");
	}
	
	/**
	 * @Test denotes that this method is a JUnit test. It runs once by default.
	 * 
	 * This test method will test our linear search method on our BigO class.
	 */
	@Test
	public void testLinearSearch() {
		/*
		 * Our linear search method takes a sorted array of type int and 
		 * returns the number of iterations that would be required to find a specific
		 * number. As such, we need to call that method in order to ascertain that it
		 * does in fact return what we expect it to.
		 * 
		 * As the method requires that we pass in an array and a number, we should go
		 * ahead and create that dummy data.
		 */
		
		int numToFind = 10;
		int answer = BigO.searchLinearly(numToFind, numbers);
		
		/*
		 * When we are writing tests, we do NOT do sysouts. We instead use the
		 * Assertions class. The Assertions provides static methods that allow us
		 * to compare expected output to actual output as well as provide custom
		 * error messages when our tests fail.
		 */
//		System.out.println(answer); //BAD
		Assertions.assertEquals(10, answer, "The linear search method failed with input 10 and an array of length 10");
	}
	
	/**
	 * If you wish to skip a test (which means it doesn't run), use the @Disabled
	 * annotation.
	 */
	@Test
	@Disabled
	public void test2() {
		// Blank because it is just here to show you the @Disabled annotation
	}
	
	/**
	 * Any method that is annotated with @AfterEach is called once PER test method (a
	 * test method is any method that is annotated with @Test). So if you have have
	 * 3 methods annotated with @Test, this method will be called once after each and
	 * every one of those methods (so 3 times). This method is typically used for more
	 * granular teardown.
	 */
	@AfterEach
	public void afterEach() {
		System.out.println("after each");
	}
	
	/**
	 * Any method that is annotated with @AfterAll will be run ONCE. It will be run
	 * after all of the other methods present on this class. It is the very last
	 * method that JUnit will call for us. As a result, it is typically used to perform
	 * "teardown" of a test suite (a suite is just a collection of tests). For instance,
	 * if you have a test DB open, close it. Or if you have a file stream open, close it.
	 */
	@AfterAll
	public void afterAll() {
		System.out.println("after all");
	}
	
	
}
