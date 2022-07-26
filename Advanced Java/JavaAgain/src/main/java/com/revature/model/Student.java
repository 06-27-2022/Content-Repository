package com.revature.model;

/*
 * If you wish to be able to compare instances (e.g. determine whether one instance is
 * "greater than" or "less than" another), you can implement the "Comparable" interface.
 */
public class Student implements Comparable<Student>{

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	private char grade;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String firstName, String lastName, int age, char grade) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + grade;
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (grade != other.grade)
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", grade="
				+ grade + "]";
	}

	/**
	 * The compareTo method is used to compare instances of a class. Notice that the method
	 * returns an int and it takes an instance of Student as a parameter.
	 * 
	 * If this method returns 0, both Students are "equal". If this method returns a
	 * number that is less than 0, then the instance on which you've called the method
	 * is "less than" the instance you passed in (the parameter). If this method returns
	 * a number that is greater than 0, then the instance on which you've called the
	 * method is "greater than" the instance you passed in (the parameter).
	 * 
	 * You have to provide your own implementation that specifies when the method returns
	 * 0 or a number that is less than/greater than 0. This means that you get to specify
	 * the criteria for comparing instances.
	 */
	@Override
	public int compareTo(Student o) {
		
		return this.age - o.age; // the short way of writing the logic below
		
//		if(this.age > o.age) return 1;
//		
//		else if(this.age < o.age) return -1;
//		
//		return 0;
	}

}
