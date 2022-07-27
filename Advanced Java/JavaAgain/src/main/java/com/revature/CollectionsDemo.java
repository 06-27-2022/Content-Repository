package com.revature;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;
import java.util.Vector;

import com.revature.comparing.StudentFirstNameComparator;
import com.revature.model.Student;

public class CollectionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Collections framework which we use to handle collections
		 * 
		 * Collection Heirarchy: 
		 * 
		 * 							Iterable Interface
		 * 								|
		 * 						Collection Interface
		 * 				/				|						\
		 * 		List Interface		Set Interface				Queue Interface --> Deque interface 
		 * 			|				|		|							|
		 * 		ArrayList		HashSet		SortedSet(interface)	PriorityQueue
		 * 		LinkedList						|
		 * 		Vector <-- Stack			TreeSet	
		 * 
		 *
		 * ============================================================================
		 * 
		 * List: 
		 * 
		 * A list is an interface that provides control over the position of where you
		 * can insert an element. You can access elements by their index and also search
		 * elements in the list
		 * 
		 * Key features: 
		 * - Allows you to have duplicate elements
		 * - Allows you to have null elements
		 * - Index starts from 0 like arrays
		 * - Supports Generics (which you should be using)
		 * - Not fixed in size
		 * - Good for data retrievals
		 * - Backed by arrays
		 * 
		 * 
		 * 
		 * */
		//Example of how you can use Generics with classes and methods
		TestClass<Integer> testObject = new TestClass<Integer>(15);
//		System.out.println(testObject.getObject());
		
		Student christina = new Student(1, "Christina", "Russ2", 26, 'B');
		Student canisha = new Student(2, "Canisha", "Russ", 27, 'A');
		Student john = new Student(3, "John", "Johnson", 89, 'C');
		Student carly = new Student(4, "I", "Carly", 25, 'D');
		Student beary = new Student(5, "Beary", "Allen", 34, 'F');
		Student terry = new Student(6, "Terry", "Pratchet", 44, 'F');
		
		
		List<Student> arrayList = new ArrayList<Student>();
		//Generics are parameterized types (basically a "type" parameter
		//With Generics you can use them in classes, methods, and interfaces
		
		arrayList.add(terry);
		arrayList.add(christina);
		arrayList.add(terry);
		
		//using the forEach method, you can perform some action on the elements
		//in a list - the variable name in the () can be whatever you want
		//arrayList.forEach((element) -> System.out.println(element));
//		arrayList.forEach(System.out::println);
		
		
		/*Linked list: 
		 * Similar to arraylist, can contain many object of the same type
		 * Implements both the List interface and also the Queue interface
		 * In Java, LinkedList is implemented as what is called a doubly linked list
		 * 
		 * element1(->)		(<-)element2(->)		(<-)element3(->)		(<-)element4(->) Null
		 * 
		 * 
		 * Differences between ArrayList and LinkedList: 
		 * One of the big differences that you see between these 2 lists, aside from how they are
		 * constructed, would be in their time complexity 
		 * 
		 * ArrayList - accessing an element takes constant time O(1), while adding elements takes O(n)
		 * LinkedList - inserting and accessing elements *without an iterator* takes O(n)
		 * it would seem like LinkedList is at a big disadvantage - but it has some methods that could make
		 * it useful depending on the type of program you want/if time complexity is an issue
		 * LinkedList does cost memory
		 * 
		 * if you use an iterator, then adding/removing an element takes O(1)
		 * LinkedList also has some methods like getFirst, getLast, addFirst, addLast that automatically insert
		 * the node at the beginning or end of the list, so it also performs these actions at O(1)
		 * 
		 * */
		List<Student> linkedList = new LinkedList<Student>();
		
		
		//Vector:
		/*Similar to the arraylist, vector implements a dynamic array, however it differs from ArrayList in that
		 * Vector is synchronized - this means that every operation is thread safe. Basically Vector is 
		 * the list you would want to use if your application implement multithreading 
		 * 
		 * If you were to use a Vector list outside of a multithreading program, then the Vector is actually a poor
		 * performer when it comes to adding, searching, deleting, updating elements
		 * 
		 * If you are dealing with a multi-threaded program, and multiple threads are accessing the same List, you 
		 * would want to make sure that the list is a Vector
		 * 
		 * */
		List<Student> vectorList = new Vector<Student>();
		//you can treat the vector like you would an arraylist 

		
		//Stack: Depreciated
		/*
		 * Stack is kind of similar to Queue - but where Queue is FIFO, Stack is LIFO - last in first out
		 * push(): "push" element on top of the stack (equivalent of adding to the list)
		 * pop(): removes and also returns the top element of the stack
		 * peek(): returns the element on top of the stack but does not remove it
		 * Rather than using the Stack - you would use what is called Deque (DoubleEnded Queue)
		 */
		
		//Use this instead of using Stack
		//Deque implements the Queue interface
		//You're able to implement this queue as either a FIFO implementation or a LIFO implementation 
		Deque<Student> dqStudent = new LinkedList<Student>();
		
		
		/*Set interface:
		 * 
		 * Set is an unordered collection of objects where duplicates cannot be stored
		 * Inherits from the Collection interface but adds feaatures that prevent you from 
		 * inserting duplicates
		 * 
		 * */
		
		//TreeSet: with the TreeSet, similar to the Set interface, there cannot be duplicates,
		//but the interesting thing about TreeSet is that the elements in this set are ordered
		//automatically - there is what is called a "natural sorting order" 
		//Another way we can set the order to our TreeSet is via the Comparable interface
		
		
		
		
		TreeSet<String> stringTree = new TreeSet<String>();
		stringTree.add("first");
		stringTree.add("second");
		stringTree.add("third");
		stringTree.add("fourth");
		
		//stringTree.forEach((element) -> System.out.println(element + " "));
		
		//System.out.println();
		
		TreeSet<Integer> numTree = new TreeSet<Integer>();
		numTree.add(100);
		numTree.add(59);
		numTree.add(235);

		//numTree.forEach((element) -> System.out.println(element + " "));
		
		
		TreeSet<Student> studentTree = new TreeSet<Student>();
		
		studentTree.add(terry);
		studentTree.add(canisha);
		studentTree.add(christina);
		studentTree.add(beary);
		studentTree.add(john);
		studentTree.add(carly);

		//studentTree.forEach((element) -> System.out.println(element + " "));
		
		TreeSet<Student> studentTree2 = new TreeSet<Student>(new StudentFirstNameComparator());
		
		//System.out.println();
		
		studentTree2.add(terry);
		studentTree2.add(canisha);
		studentTree2.add(christina);
		studentTree2.add(beary);
		studentTree2.add(john);
		studentTree2.add(carly);
		
		studentTree2.forEach((element) -> System.out.println(element + " "));
		
		//HashSet: 
		/*Implements the Set interface, but it's backed by what is called a HashTable*
		 * It allows you to have null elements, it also, because it implements the set interface, 
		 * does not allow duplicates; Like the TreeSet, it does not guarantee that the elements
		 * you insert into the HashSet will be ordered in that way - with HasheSet, the elements are
		 * inserted based on their hashcode
		 * 
		 * */
		
		HashSet<String> hashStringSet = new HashSet<String>();
		hashStringSet.add("One");
		hashStringSet.add("Two");
		hashStringSet.add("Three");
		hashStringSet.add("Four");
		
		//hashStringSet.forEach((element) -> System.out.println(element + " "));
		
		
		/*Queue Interface: this interface is used for holding elements before you process them 
		 * Basically, elements are stored in a "first in first out" basis (FIFO)
		 * 
		 * Queues provide addition insertion, extraction, and inspection operations (methods) aside 
		 * from those provided by the Collection interface. 
		 * 
		 * */
		
		//LinkedList implements Queue interface as well as List interface
		//If implement QUeue as a linkedlist, your list will be ordered according to the FIFO algorithm
		Queue<Student> linkedQueue = new LinkedList<Student>();
		
		
		Queue<Student> studentQueue = new PriorityQueue<Student>();
		//Correction - while Queues follow FIFO algorithm, 
		//PriorityQueue orders elements based on priority, 
		//which is determined by either natural ordering, or a provided Comparator
		studentQueue.add(christina);
		studentQueue.add(john);
		studentQueue.add(terry); 
		studentQueue.add(beary); 

		
		//studentQueue.forEach((element) -> System.out.println(element));
		
		studentQueue.poll(); //retreives and removes the head of the queue
		
		studentQueue.forEach((element) -> System.out.println(element));
		
		
		//Iterators: 
		/*
		 * Iterators are used, for lack of a better word, to iterate over a collection
		 * Using an iterator, you can both read and remove elements from a list
		 * You can also loop through a collection using an iterator
		 * You can think of this iterator as like a cursor or a pointer
		 * 
		 * */
		
		Iterator<Student> iterator = studentQueue.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		//Map: 
		/*Keep in mind, the Map interface is not technically part of the collections framework 
		 * because it does not implement the Collection interface
		 * So objects that implement map to not behave like other collections
		 * For one thing, maps contain key-value pairs: 
		 * 
		 * Maps would be good to use for dictionary applications (word - key; meaning - value) , 
		 * zip codes(key) and their cities (value), or managers (key) and a list of
		 * employees (values)
		 * 
		 * HashMap: 
		 * One thing to keep in mind is that it doesn't really allow for duplicates 
		 * If you try to insert a duplicate, it will replace the element with the corresponding key
		 * Allows one null key and multiple null values
		 * 
		 * HashTable: 
		 * Similar to HashMap, but synchronized (you can use this with multi-threaded applications 
		 * Has key-value pairs, and implements the Map interface
		 * 
		 * */
		
		Map<String, String> programLangs = new HashMap<String, String>();
		//to add elements to the hashmap: 
		
		programLangs.put("Java", "OOP lang");
		programLangs.put("Python", "an interpreted OOP lang");
		programLangs.put("JavaScript", "also interpreted but not strongly typed");
		
		//System.out.println("Java is a " + programLangs.get("Java"));
		//using the get method, we can retreive the value that is associated with a particular key
		
		System.out.println("JavaScript is " + programLangs.get("JavaScript"));
		programLangs.put("JavaScript", "Not Java");
		System.out.println("JavaScript is " + programLangs.get("JavaScript"));

		//Another thing to note is that the Map interface does not implement Iterable
		//just some ways you can iterate over a map: 
		
		//if I want all the keys: 
		for (String key : programLangs.keySet()) {
			System.out.println("The key is: " + key);
		}
		
		//If I want to iterate over both the keys and the values within the map: 
		for(Map.Entry<String, String> entry : programLangs.entrySet()) {
			System.out.println(entry);
		}
		
		
	}


}

//outside curly braces would be just a 2nd class

class TestClass<T> {
	T randomObject;
	
	TestClass(T object) {
		this.randomObject = object;
	}
	
	public T getObject() {
		return this.randomObject;
	}
	
}
