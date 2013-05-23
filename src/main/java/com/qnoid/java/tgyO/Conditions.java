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
package com.qnoid.java.tgyO;



/**
 * Available conditions 
 * @see Filter
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 19, 2011
 */
public final class Conditions 
{
	/**
	 * @param name the name that person must have
	 * @return a condition on the name of the person
	 */
	public static Condition<Person> hasName(final String name) {
	return new Condition<Person>(){
			@Override
			public boolean apply(Person person) {
			return person.hasName(name);
			}
		};
	}

	/**
	 * @param condition the condition to apply to the age
	 * @return the condition
	 * @see IntegerConditionChain
	 */
	public static Condition<Person> age(final Condition<Integer> condition) {
	return new Condition<Person>() {
		
		@Override
		public boolean apply(Person person) {
		return condition.apply( person.age() );
		}
	};
	}

	/**
	 * @param condition a condition on the person
	 * @return a condition on the person
	 */
	public static Condition<Person> onPerson( final Condition<Person> condition) 
	{
	return new Condition<Person>() {
		
		@Override
		public boolean apply(Person person) {
		return condition.apply(person);
		}
	};
	}
	
	private Conditions(){};
}
