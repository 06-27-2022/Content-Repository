package com.revature;

public class Book extends Media{

	private int numberOfPages;
	private String publishingCompany;
	
	public Book() {
		
	}
	
	/*
	 * I can't directly access the numberOfPages outside of this class. Even so, I
	 * want a way to be able to change the number of pages. In this case, I can make
	 * a method that allows me to indirectly access the number of pages.
	 * 
	 * Methods have logic that can prevent a variable assignment if needed.
	 * 
	 * This method is a conventional method called a "setter". It is a also called a
	 * "mutator".
	 */
	public void setNumberOfPages(int numberOfPages) {
		if(numberOfPages < 1) {
			System.out.println("Invalid number of pages!");
		}
		else this.numberOfPages = numberOfPages;
	}
	
	/*
	 * We can also make a method that allows for us to indirectly read from the variable.
	 * 
	 * This is a conventional method called by a "getter". It is also called an "accessor".
	 */
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	
	//Writing a getter and setter for the publishingCompany field:
	
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	
	public String getPublishingCompany() {
		return this.publishingCompany;
	}
}
