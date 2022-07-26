package com.revature.comparing;

import java.util.Comparator;

import com.revature.model.Student;

/*
 * This class needs to implement the Comparator interface.
 */
public class StudentFirstNameComparator implements Comparator<Student>{

	/*
	 * This is where we determine an alternative method of sorting Students. Note that
	 * you can make Comparator classes.
	 */
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getFirstName().compareTo(o2.getFirstName());
	}

}
