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
package com.forrst.java.tgyO;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.tgyO.Condition;
import com.forrst.java.tgyO.Conditions;
import com.forrst.java.tgyO.Filters;
import com.forrst.java.tgyO.IntegerConditionChain;
import com.forrst.java.tgyO.Person;
import com.forrst.java.tgyO.PersonConditionChain;
import com.google.common.collect.Lists;



/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 19, 2011
 * IASD (It's about software design)
 */
public class FilterTest 
{
	@Test
	public void findByName() throws Exception 
	{
		Person john = new Person("John", 20);
		Person markos = new Person("Markos", 30);

		Condition<Person> isNamedJohn = Conditions.hasName("John");
		
		Person actual = Filters.of(john, markos).find( isNamedJohn );
		
		Assert.assertEquals(john, actual);		
	}
	
	@Test
	public void findByAge() throws Exception 
	{
		Person john = new Person("John", 20);
		Person markos = new Person("Markos", 30);		
		
		Condition<Integer> between17and25 = 
			new IntegerConditionChain()
					.gt(17)
					.lt(25);
		
		Condition<Person> agedBetween17and25 = 
			Conditions.age( between17and25 );
		
		Person actual = Filters
			.of(john, markos)
			.find( agedBetween17and25 );
		
		Assert.assertEquals(john, actual);		
	}
	
	@Test
	public void findByNameAndAge() throws Exception 
	{
		Person johnAged20 = new Person("John", 20);
		Person johnAged21 = new Person("John", 21);
		Person johnAged29 = new Person("John", 29);
		Person johnAged30 = new Person("John", 30);
		Person markosAged30 = new Person("Markos", 29);
		
		Condition<Integer> between20and30 = 
			new IntegerConditionChain()
					.gt(20)
					.lt(30);

		PersonConditionChain namedJohnBetween20And30 = 
			new PersonConditionChain()
					.hasName("John")
					.age(between20and30);
		
		Condition<Person> onPerson = 
			Conditions.onPerson( namedJohnBetween20And30 );
		
		List<Person> actual = Filters
			.of(johnAged20, 
				johnAged21, 
				johnAged29, 
				johnAged30, 
				markosAged30)
			.list( onPerson );
		
		Assert.assertEquals(2, actual.size());		
		Assert.assertEquals(
				Lists.newArrayList(johnAged21, johnAged29), 
				actual);		
	}	
}
