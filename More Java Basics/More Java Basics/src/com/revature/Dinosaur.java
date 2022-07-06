package com.revature;

/*
 * Please note the different scopes present in this class. When I say "scope", I'm
 * referring to where we can access certain variables. And by "where", I mean "inside
 * of which blocks".
 * 
 * Java uses curly braces to denote a variable's scope. A variable is in scope for
 * the entirety of the "block" inside of which it is directly declared.
 */
public class Dinosaur {

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
	
	Dinosaur(){
		
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
	Dinosaur(String name, String habitat, int height){
		this.name = name;
		this.habitat = habitat;
		this.height = height;
	}
	
	void roar() {
		System.out.println("Rawr very ferociously");
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
		
//		System.out.println(dino);
	}
	
}
