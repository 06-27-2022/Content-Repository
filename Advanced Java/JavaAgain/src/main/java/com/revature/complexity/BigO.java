package com.revature.complexity;

/**
 * When you write methods, you should ideally be thinking about how "efficient" your
 * implementations are. For instance, maybe you're concerned about how much memory
 * your implementation requires. You might also be worried about how fast an algorithm
 * runs.
 * 
 * When we concern ourselves with how fast an algorithm runs, we are thinking about the
 * time complexity of the algorithm. To represent an algorithm's time complexity, we use
 * "Big O Notation". For instance, you might see:
 * 
 * O(n^2)
 * O(n)
 * O(log(n))
 * 
 * The idea behind time complexity is that even though an algorithm might not take a "long"
 * time to run when the data set is small, it could scale very poorly and take much longer
 * to run as the data set increases.
 * 
 * @author 17084
 *
 */
public class BigO {

	public static void main(String[] args) {
		
		int[] theNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
		
		System.out.println(searchLinearly(18, theNums));
		System.out.println(searchBinarily(18, theNums));
		
	}
	
	/**
	 * This method will use a binary search to get to our largest number. The idea
	 * behind a binary search is that we will not be checking every single number.
	 * This allows to cut down on the number of iterations we make.
	 * 
	 * In this method, we will add an additional parameter for looking for a specific
	 * number.
	 * 
	 * @param numbers
	 * @return
	 */
	public static int searchBinarily(int numToFind, int[] numbers) {
		
		/*
		 * When you're binary searching, the idea is to keep cutting the data set in
		 * half until you find the number you're looking for. That said, I am going
		 * to start around the halfway point of the array.
		 */
		
		int numOfIterations = 0;
		boolean isNum = false;
		int lowerBound = 0;
		int upperBound = numbers.length - 1;
		
		while(!isNum) {
			numOfIterations++;
			
			//Take the average of my lower bound any my upper bound.
			int indexToInspect = (lowerBound + upperBound) / 2;
			
			if(numbers[indexToInspect] == numToFind) isNum = true;
			
			else if(numbers[indexToInspect] > numToFind) {
				upperBound = indexToInspect - 1;
			}
			
			else if(numbers[indexToInspect] < numToFind) {
				lowerBound = indexToInspect + 1;
			}
		}
		
		return numOfIterations;
	}
	
	/**
	 * This method will search for the largest number in the array that we pass in
	 * 
	 * @param numbers the array of numbers
	 * @return
	 */
	public static int searchLinearly(int numToFind, int[] numbers) {
		
		int numOfIterations = 0;
		boolean isNum = false;
		
		/*
		 * When you have a single for loop like this (that iterates over every element
		 * in a linear search), we consider the time complexity O(n). Also understand
		 * that every time you nest a loop inside of another loop, you increase the time
		 * complexity (e.g. a loop inside of a loop yields a time complexity of O(n^2)).
		 */
		for(int i = 0; i < numbers.length; i++) {
			numOfIterations++;
			if(numbers[i] == numToFind) {
				isNum = true;
			}
			if(isNum == true) break;
		}
		
		return numOfIterations;
	}
}
