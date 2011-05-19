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
package com.forrst.java.tDJb;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.tDJb.Wording;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date May 18, 2011
 */
public class WordingTest 
{
	private void assertOf(String name, int number) 
	{
		Wording wording = Wording.newWording();
		
		Assert.assertEquals(name, wording.of(number));
	}

	@Test
	public void stringOfConstants() throws Exception 
	{
		assertOf("zero", 0);
		assertOf("ten", 10);		
		assertOf("eleven", 11);
		assertOf("twelve", 12);
		assertOf("thirteen", 13);
		assertOf("forteen", 14);
		assertOf("fifteen", 15);
		assertOf("sixteen", 16);
		assertOf("seventeen", 17);
		assertOf("eighteen", 18);
		assertOf("nineteen", 19);
		assertOf("twenty", 20);
	}
	
	@Test
	public void stringOfUnits() throws Exception 
	{
		assertOf("one", 1);
		assertOf("two", 2);
		assertOf("three", 3);
		assertOf("four", 4);
		assertOf("five", 5);
		assertOf("six", 6);
		assertOf("seven", 7);
		assertOf("eight", 8);
		assertOf("nine", 9);
	}
	
	@Test
	public void stringOfTens() throws Exception 
	{
		assertOf("twentyone", 21);
		assertOf("twentynine", 29);
		assertOf("thirtyone", 31);
		assertOf("thirtynine", 39);
		assertOf("fortyone", 41);
		assertOf("fortynine", 49);
		assertOf("fiftyone", 51);
		assertOf("fiftynine", 59);
		assertOf("sixtyone", 61);
		assertOf("sixtynine", 69);
		assertOf("seventyone", 71);
		assertOf("seventynine", 79);
		assertOf("eightyone", 81);
		assertOf("eightynine", 89);
		assertOf("ninetyone", 91);
		assertOf("ninetynine", 99);
	}
	
	@Test
	public void stringOfOneHundred() throws Exception 
	{
		assertOf("onehundred", 100);
	}

	@Test
	public void stringOfOneHundredTwenty() throws Exception 
	{
		assertOf("onehundredtwenty", 120);
	}
	
	@Test
	public void stringOfOneHundredSeven() throws Exception 
	{
		assertOf("onehundredseven", 107);
	}
	
	@Test
	public void stringOfOneHundredTwentySeven() throws Exception 
	{
		assertOf("onehundredtwentyseven", 127);
	}
	
	@Test
	public void stringOfOneThousandSeven() throws Exception 
	{
		assertOf("onethousandseven", 1007);
	}
	
	@Test
	public void stringOfOneThousandOneHundredTwentySeven() throws Exception 
	{
		assertOf("onethousandonehundredtwentyseven", 1127);
	}
}
