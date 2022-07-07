package com.revature;

import java.time.LocalDate;

public class Movie extends Media{

	String director;
	
	public Movie() {
		
	}
	
	public static void main(String[] args) {
		
		Media myMedia = new Media();
		myMedia.title = "Life Is Beautiful";
		myMedia.dateReleased = LocalDate.of(2022, 7, 7);
		
		Book myBook = new Book();
		myBook.setNumberOfPages(100);
		System.out.println(myBook.getNumberOfPages());
		myBook.setPublishingCompany("Random Publishing Company");
		System.out.println(myBook.getPublishingCompany());
		
	}
}
