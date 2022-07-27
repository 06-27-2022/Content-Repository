package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.comparing.StudentFirstNameComparator;
import com.revature.model.Student;

public class Driver {
	
	/*
	 * A main method to run examples later.
	 */
	public static void main(String[] args) {
		
		Student christina = new Student(1, "Christina", "Russ", 26, 'B');
		Student canisha = new Student(2, "Canisha", "Russ", 26, 'A');
		Student john = new Student(3, "John", "Johnson", 89, 'C');
		Student carly = new Student(4, "I", "Carly", 25, 'D');
		Student beary = new Student(5, "Beary", "Allen", 34, 'F');
		
		
		/*
		 * You cannot use the < or > symbols with your own custom types (with object types
		 * in general). Not only that, but there is no built-in way to compare instances of
		 * your custom "Student" type, so Java does not know how to compare the instances
		 * anyway.
		 */
		
		if(christina.compareTo(canisha) < 0) {
			System.out.println("Christina is younger than Canisha.");
		}
		else if(christina.compareTo(canisha) > 0) {
			System.out.println("Christina is older than Canisha.");
		}
		else System.out.println("They're the same age.");
		
		/*
		 * The Student class implements Comparable, and that is a major benefit to us
		 * when we're using types such as List. Let's say I wanted a List of students:
		 */
		
		List<Student> students = new ArrayList<>();
		students.add(christina);
		students.add(canisha);
		students.add(john);
		students.add(carly);
		students.add(beary);
		
		/*
		 * Ordering the students by age is as simple as using the "Collections" utility
		 * class and calling "sort". Note that the Collection utility class contains
		 * several static methods which makes working with List and other types of 
		 * Collections easier.
		 */
		
		Collections.sort(students);
		
		System.out.println(students);
		
		/*
		 * But what if I want another way of comparing students? Currently, I only have
		 * one way of doing so (by age). But now I want to put them in alphabetical order.
		 * Is there some way to do this? Yes, and we do so by using the Comparator interface.
		 */
		
		/*
		 * If you know lambda expressions, do the following:
		 */
//		Collections.sort(students, (student1, student2) -> 
//		student1.getFirstName().compareToIgnoreCase(student2.getFirstName()));
		
		/*
		 * If you don't know Lambda expressions, you need to make a separate class that
		 * implements Comparator and then override the "compare" method.
		 */
		
		StudentFirstNameComparator comparator = new StudentFirstNameComparator();
		System.out.println(comparator.compare(christina, john));
		
		Collections.sort(students, comparator);
		
		System.out.println(students);
	}
		
}
