/*
 *  This file is under the license Attribution-ShareAlike 3.0 Unported 
 *  (CC BY-SA 3.0) http://creativecommons.org/licenses/by-sa/3.0/
 *
 *  You are free:
 *      to Share - to copy, distribute and transmit the work
 *      to Remix - to adapt the work
 *
 *  Under the following conditions:
 *
 *  Attribution - You must attribute the work in the manner specified by the 
 *  author or licensor (but not in any way that suggests that they endorse you 
 *  or your use of the work).
 *  
 *  Share Alike - If you alter, transform, or build upon this work, you may 
 *  distribute the resulting work only under the same or similar license to 
 *  this one.
 *
 *  With the understanding that:
 *
 *  Waiver - Any of the above conditions can be waived if you get permission 
 *  from the copyright holder.
 *
 *  Public Domain - Where the work or any of its elements is in the public 
 *  domain under applicable law, that status is in no way affected by the 
 *  license.
 *
 *  Other Rights - In no way are any of the following rights affected by the 
 *  license:
 *  Your fair dealing or fair use rights, or other applicable copyright 
 *  exceptions and limitations;
 *
 *  The author's moral rights;
 *  Rights other persons may have either in the work itself or in how the work 
 *  is used, such as publicity or privacy rights.
 *
 */
package com.qnoid.java.tOxr;

/**
 * Divide and conquer
 * 
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 31, 2011
 */
public class BinarySearch 
{
	/*
	 * Let's start looking from the beginning of the array 
	 * 0 till the last index which is length - 1 since an array of size 10
	 * has positions from 0 to 9.
	 */
	public int indexOf(int[] numbers, int what) {
	return this.indexOf(numbers, what, 0, numbers.length - 1);
	}
	
	private int indexOf(int[] numbers, int what, int fromIndex, int toIndex) 
	{
		if(fromIndex > toIndex)
			return -1;
		
		/*
		 * Let's take the average by shifting bytes.
		 * How does that work?
		 * 
		 * For indexes of 0 to 9 we have 9 >>> 1
		 * 9 in binary is 1001, therefore
		 * 
		 * 1001 >>> 1 = 0100
		 * 
		 * which is equal to 4
		 * Notice how we are moving each bit 1 position to the right.
		 * So 
		 * 1 becomes 0
		 * 0 becomes 1
		 * 0 becomes 0
		 * 1 falls off and becomes 0
		 */
		int average = (fromIndex + toIndex) >>> 1;
		
		int guess = numbers[average];
		
		if(guess == what){
			return average;
		}
		
	return what < guess?
			indexOf(numbers, what, fromIndex, average-1):
			indexOf(numbers, what, average+1, toIndex);
	}
}
