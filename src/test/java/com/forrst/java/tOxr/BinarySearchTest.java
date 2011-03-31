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
package com.forrst.java.tOxr;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.tOxr.BinarySearch;


/**
 * Let's assert that it works
 * 
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 31, 2011
 */
public class BinarySearchTest 
{
	public void assertIndexOf(int[] numbers, int what, int index) 
	{
		BinarySearch search = new BinarySearch();
		
		int indexOf = search.indexOf(numbers, what);
		
		Assert.assertEquals(index, indexOf);
	}
	/**
	 * Makes the following asserts
	 * <ul>
	 * 	<li> returns -1 on an empty array</li>
	 * 	<li> returns the index on an odd elements array</li>
	 * 	<li> returns the index on an even elements array</li>
	 * 	<li> returns the index on an odd elements array with a direct hit</li>
	 * 	<li> returns the index on an odd elements array after 1 division</li>
	 * 	<li> returns the index on an even elements array after 1 division</li>
	 * 	<li> returns the index on an even elements array after 2 divisions</li>
	 * 	<li> returns -1 on a non empty array without the element</li>
	 * </ul>
	 */
	@Test
	public void indexOf()
	{	
		assertIndexOf(new int[]{}, 0, -1);
		
		assertIndexOf(new int[]{0}, 0, 0);
		
		assertIndexOf(new int[]{0, 1}, 0, 0);
		assertIndexOf(new int[]{0, 1}, 1, 1);		
		
		assertIndexOf(new int[]{0, 1, 2}, 0, 0);
		assertIndexOf(new int[]{0, 1, 2}, 1, 1);
		assertIndexOf(new int[]{0, 1, 2}, 2, 2);
		
		assertIndexOf(new int[]{0, 1, 2, 3}, 0, 0);
		assertIndexOf(new int[]{0, 1, 2, 3}, 1, 1);
		assertIndexOf(new int[]{0, 1, 2, 3}, 2, 2);
		assertIndexOf(new int[]{0, 1, 2, 3}, 3, 3);
		
		assertIndexOf(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, 10, -1);		
	}	
}
