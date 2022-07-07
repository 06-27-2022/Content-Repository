package com.revature;

/*
 * Please note the different scopes present in this class. When I say "scope", I'm
 * referring to where we can access certain variables. And by "where", I mean "inside
 * of which blocks".
 * 
 * Java uses curly braces to denote a variable's scope. A variable is in scope for
 * the entirety of the "block" inside of which it is directly declared.
 * 
 * Recall that every class inherits from the Object class in Java. We now know that inheritance
 * suggests that we inherit behavior and state from the parent class. This would suggest that
 * methods from the Object class must be inherited by all classes in Java.
 */
public class Dinosaur{

	/*
	 * As a refresher, classes are often used to model or create blueprints for 
	 * real-world concepts. Classes can have state (fields) and behavior (methods).
	 * Each instance of this class will have its own copies of the non-static fields
	 * and methods.
	 */
	
	/**
	 * This type of comment is used to generate JavaDocs for our source code. This
	 * can be helpful as our applications get much larger and we more methods and 
	 * fields to keep track of.
	 * 
	 * In any case, the "name" field corresponds to the dinosaur species. Is it a T-rex
	 * or a pterodactyl?
	 * 
	 * The scope of this instance variable is the entire Dinosaur class.
	 * 
	 * This variable has no default value. It simply points to "null", meaining it doesn't
	 * point to an object.
	 */
	String name;
	
	/**
	 * This variable does not point to an object.
	 */
	String habitat;
	/**
	 * This represents the dinosaur's height in feet.
	 * 
	 * This has a default value of 0.
	 */
	int height;
	
	//Polymorphism - "many forms" 
	//Overloading - when you have the same method name with a different method signature (different parameters)
	//
	//Constructor overloading
	//no args consturctor
	Dinosaur(){
		
	}
	
	Dinosaur(String name, String habitat) {
		this.name = name;
		this.habitat = habitat;
	}
	
	/**
	 * 
	 * @param name the name that will be assigned to the dinosaur
	 * @param habitat
	 * @param height
	 * 
	 * All of the parameters here are local variables. This means that they are only
	 * in scope for this particular constructor.
	 */
	//parameterized constructor
	Dinosaur(String name, String habitat, int height){
		//constructor chaining
		this(name, habitat);
//		this.name = name;
//		this.habitat = habitat;
		this.height = height;
	}
	
	void roar() {
		System.out.println("Rawr very ferociously");
	}
	
	void roar(String name) {
		System.out.println(name + " rawrs very ferociously");
	}
	
	
	void eat() {
		System.out.print("I am inside Dinosaur's eat method: ");
		System.out.println("Ate very hungrily");
	}
	
	void eat(int timesADay) {
		//how many times a day a dinosaur eats
		System.out.println("Ate very hungrily " + timesADay + " times a day");
	}
	
	/*
	 * The toString method is inherited from the Object class. It returns a String representation
	 * of your Object.
	 * 
	 * Please note that Java knows that it should call the toString method when you attempt
	 * to print an object. As such, you rarely see developers calling the toString method
	 * themselves.
	 */
	@Override
	public String toString() {
		return "Dinosaur [name=" + name + ", habitat=" + habitat + ", height=" + height + "]";
	}
	
	/*
	 * The hashCode method is inherited from the Object class. Java uses the hashCode
	 * method to easily put objects into "buckets" so that they are easier to locate
	 * (in memory).
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((habitat == null) ? 0 : habitat.hashCode());
		result = prime * result + height;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * The equals method is inherited from the Object class. It is used to "compare"
	 * two instances of a class. Please note that it is a different type of comparison
	 * than the == operator provides.
	 * 
	 * For example:
	 * 
	 * String s1 = "a string";
	 * String s2 = "a string";
	 * 
	 * s1 == s2
	 * s1.equals(s2)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dinosaur other = (Dinosaur) obj;
		if (habitat == null) {
			if (other.habitat != null)
				return false;
		} else if (!habitat.equals(other.habitat))
			return false;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String[] args) {
		
		/*
		 * Unlike instance variables, local variables must be initialized before you
		 * use them. In other words, a variable declaration will not suffice. You must
		 * make sure that a local variable points to some value or object before using
		 * it. Yes, this is even true for primitive types.
		 */
		Dinosaur trex;
		Dinosaur triceratops = new Dinosaur("Triceratops", "Land", 40);
		Dinosaur pterodactyl = new Dinosaur("Pterodactyl", "Land, but they fly", 30);
		trex = new Dinosaur("T-rex", "Land", 100);
		Dinosaur trex2 = new Dinosaur("T-rex", "Land", 100);
				
		Dinosaur[] dinosaurs = {trex, triceratops, pterodactyl};
		
		//Let's say we want to iterate over our dinosaurs using a loop.
		for(Dinosaur dino : dinosaurs) {
			if(!dino.habitat.equals("Land"))
			{
				/*
				 * Continue skips an iteration of the loop.
				 */
				continue;
			}
			System.out.print(dino.name + " ");
			
		}
		
		
		System.out.println();
		
		trex.roar();
		trex.roar(trex.name);
		
		triceratops.eat();
		triceratops.eat(5);
		
		//Playing around with the toString method
		System.out.println(trex);
		System.out.println(triceratops);
		
		System.out.println("===============================================");
		
		//Playing around with the equals method
		
		int a = 78;
		int b = 89;
		
		/*
		 * We actually DO use the == operator to compare primitives, but this is not
		 * acceptable for object types (depending on what you're trying to do).
		 */
		if(a == b) {
			System.out.println("they're the same number");
		}
		
		/*
		 * What if we try this with Strings?
		 */
		
		String s1 = "a string";
		String s2 = "a string";
		
		/*
		 * This is only going to print "true" because of the String pool. The == operator
		 * compares memory addresses when used with Object types - NOT contents. It is
		 * only true because both Strings are actually just the exact same String object
		 * in memory.
		 */
		System.out.println(s1 == s2);
		
		String s3 = "a string";
		String s4 = new String("a string");
		
		System.out.println(s3 == s4);
		
		/*
		 * It is very likely that your intention here is to actually compare the contents
		 *  of the strings. In that case, you need to use the "equals" method.
		 */
		System.out.println(s3.equals(s4));
		
		//What if we want to compare Dinosaurs to each other?
		
		System.out.println(trex.equals(pterodactyl));
		System.out.println(trex.equals(trex2));
	}
	
}