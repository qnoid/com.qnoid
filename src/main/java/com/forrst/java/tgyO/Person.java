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


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 19, 2011
 */
public class Person 
{
	private final String name;
	private final int age;

	/**
	 * @param name
	 * @param age
	 * @param dbo
	 */
	public Person(String name, int age) 
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * @return the name
	 */
	public String name() {
	return name;
	}

	/**
	 * @return the age
	 */
	public int age() {
	return age;
	}
	
	/**
	 * Checks the name of the person ignoring cAsE
	 * @param name the name to have
	 * @return true if it has the specified name
	 */
	public boolean hasName(String name) {
	return this.name.equalsIgnoreCase(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() 
	{
		int hash = 23;
		
		hash = hash * 37 + this.age;
		hash = hash * 37 + this.name.hashCode();
		
	return hash;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object that) 
	{
		if(this == that){
			return true;
		}
		
		if(!(this instanceof Person)){
			return false;
		}
		
		Person person = (Person)that;
		
	return this.age == person.age && this.name.equals(person.name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	return this.name;
	}
}
