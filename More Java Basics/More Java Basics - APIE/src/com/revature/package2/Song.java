package com.revature.package2;

import java.time.LocalDate;

import com.revature.Media;

public class Song extends Media{

	String artist;

	public Song() {
		this.title = "n/a";
		/*
		 * Notice that we can directly access dateReleased in the Song class because
		 * it has "protected" access in the Media class.
		 */
		this.dateReleased = LocalDate.now();
	}
	
	public Song(String title, LocalDate dateReleased, String intendedAudience, String artist) {
		super(title, dateReleased, intendedAudience);
		this.artist = artist;
	}
	
	public static void main(String[] args) {
		Media myMedia = new Media();
		/*
		 * This isn't allowed because intendedAudience is only directly accessible
		 * from within the com.revature package due to intendedAudience having default
		 * access.
		 */
//		myMedia.intendedAudience = "kids";
		
	}
}
