/*
 * Technically speaking, the first statement in a Java file should be a
 * package declaration which specifies which package the class is in.
 * 
 * Packages help us logically separate our classes. Packages also allow
 * us to avoid naming conflicts by allowing us to create our own namespaces.
 * In other words, do NOT have 2 classes with the same name in the same
 * package.
 * 
 * Note that the "default package" that you are provided in Java should not
 * be used as none of the classes used in that package can be used elsewhere
 * in the application.
 * 
 * Please also note that packages are really just folders/directories.
 */
package com.revature;

/*
 * Recall that classes are often used to model real-world ideas. In this
 * case, we want to use our class to model a RevatureEmployee.
 */
public class RevatureEmployee{

	/*
	 * We can first start by considering what "properties" a RevatureEmployee
	 * would have in real life. Perhaps an employee would have a name, an age,
	 * a department they work in, etc.
	 * 
	 * In order to represent this data, we can create "fields". Fields
	 * are simply properties; they should be variables.
	 */
	String name;
	int age;
	String department;
	float salary;
	
	/*
	 * If you wish to create an instance of a class, you use the new
	 * keyword in conjunction with the "constructor". A constructor is
	 * used to create an instance of an object and oftentimes contains
	 * logic for initializing that object's fields. A constructor:
	 * 
	 * 1) Must not have a return type
	 * 2) Must have a name that matches the class's name
	 * 
	 * Note that if you do not create your own constructor in Java, you
	 * will be provided with a default constructor. The moment you write
	 * your own constructor, you're no longer using the default constructor.
	 */
	RevatureEmployee(){
		// This type of constructor is called a "no-args" constructor.
	}
	
	/*
	 * This constructor will be a constructor that takes in values for the
	 * fields and initializes those fields. Those values are called "parameters".
	 * Parameters are variables that serve as placeholders for values that
	 * will be passed to the constructor later.
	 * 
	 * To define parameters, you should be thinking about what type of
	 * data you need to initialize in this case.
	 */
	RevatureEmployee(String name, int age, String department, float salary){
		/*In order to distinguish the local "name" from the class field
		 *called "name", we can use the "this" keyword. The "this" keyword
		 *specifies that we are referring to a field on this class - more
		 *specifically, this particular instance's (object's) copy of the
		 *name field.
		 */
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}
	
	/*
	 * Classes also allow us to add "behavior" by creating methods. Simply
	 * put, a method is a reusable block of code. A method should include:
	 * 
	 * 1) An access modifier
	 * 2) A return type
	 * 3) A name
	 * 4) (Optionally) Parameter list, but note that the "()" must be present
	 * 
	 * The idea behind a method is that it performs a very specific task.
	 * Methods should do one thing and one thing well; if a method is too
	 * long, it likely needs to broken up into several smaller methods.
	 */
	void printEmployeeDetails() {
		System.out.println("Employee Name: " + this.name + ", Employee Age: "
			+ this.age + ", Employee Dept: " + this.department +
			", Employee Salary: " + this.salary);
		//All methods return control to the caller (the method they were
		//called within) at the end, even void methods.
		return;
	}
	
	/*
	 * Let's make another method that calculates the amount of years an
	 * employee still has remaining until they can retire. Let's assume
	 * that Revature lets you retire at 55.
	 * 
	 * Note that our method will return that value to the caller.
	 */
	
	int calculateRemainingWorkYears() {
		
		int remainingYears = 55 - this.age;
		return remainingYears;
	}
	
	/*
	 * Let's write a method that gives Revature Employees raises. The
	 * amount of the raise provided will be passed in when the method
	 * is called.
	 */
	void giveRaise(float increaseInPay){
		
		
//		this.salary = this.salary + increaseInPay;
		/*
		 * This is the shortcut for the commented out line of code
		 * above.
		 */
		this.salary += increaseInPay;
	}
	
	public static void main(String[] args) {
		
		// We can make instances of our own classes of course.
		RevatureEmployee christina = new RevatureEmployee("Christina", 28, "Training", 78f);
		RevatureEmployee jackie = new RevatureEmployee("Jackie", 24, "Training", 78f);
		
		/*
		 * We are going to call giveRaise. The salary for each object
		 * that we call this method on should increase.
		 */
		christina.giveRaise(10000000f);
		jackie.giveRaise(10000000000f);
		
		christina.printEmployeeDetails();
		jackie.printEmployeeDetails();
		
		/*
		 * The calculateRemainingWorkYears method returns a value to its
		 * caller (main in this case) that main can use however it wishes.
		 */
		int christinasRemainingWorkYears = christina.calculateRemainingWorkYears();
		System.out.println("Christina can retire in " + 
				christinasRemainingWorkYears + " years.");
	}
}


