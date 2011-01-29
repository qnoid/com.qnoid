/*
 *  This file is under the licence Attribution-ShareAlike 3.0 Unported 
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
package com.forrst.java.tRm1.dont;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import com.forrst.java.tRm1.dont.Person;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 22, 2011
 * 
 * It's a pain to test!
 */
public class PersonTest 
{
	@Test
	public void newPersonOfArray() throws Exception 
	{
		String name = "Markos";
		int age = 30;
		
		String[] args = {name, String.valueOf(age)};		
		Person person = new Person(args);
		
		Assert.assertEquals(age, person.howOldAreYou());
		Assert.assertEquals(name, person.whatsYourName());
	}
	
	@Test
	public void newPersonOfByteArrayAndCalendar() throws Exception 
	{
		byte[] name = new byte[]{'I', 'n', 'f', 'a', 'n', 't'};		
		Calendar dob = Calendar.getInstance();
		
		Person person = new Person(name, dob);
		
		Assert.assertEquals(0, person.howOldAreYou());
		Assert.assertEquals("Infant", person.whatsYourName());				
	}
}
