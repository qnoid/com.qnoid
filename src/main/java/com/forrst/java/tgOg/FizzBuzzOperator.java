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
package com.forrst.java.tgOg;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Use to convert numbers to fizz/buzz representations
 * 
 * @see #op(int)
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 23, 2011
 */
public final class FizzBuzzOperator
{
    /**
     * @return a new {@link FizzBuzzOperator} with
     * 
     * <ul>
     * <li>{@link ModFizzBuzz#FizzBuzz}</li>
     * <li>{@link ModFizzBuzz#Buzz}</li>
     * <li>{@link ModFizzBuzz#Fizz}</li>
     * </ul>
     * 
     * operations
     */
	public static FizzBuzzOperator newFizzBuzz() {
	return newFizzBuzz( ModFizzBuzz.FizzBuzz, ModFizzBuzz.Buzz, ModFizzBuzz.Fizz );
	}
	
	public static FizzBuzzOperator newFizzBuzz(FizzBuzzOperation... fizzbuzzes) {
	return new FizzBuzzOperator( Lists.newArrayList(fizzbuzzes) );
	}	

	private final List<FizzBuzzOperation> fizzbuzzes;
	
	/**
	 * @param fizzbuzzes the list of {@link FizzBuzzOperation}s related to the 
	 * operator
	 */
	private FizzBuzzOperator(List<FizzBuzzOperation> fizzbuzzes) {
		this.fizzbuzzes = fizzbuzzes;
	}

	/**
	 * Strategy to get the corresponding FizzBuzz given a number
	 * 
	 * @param number
	 * @return the {@link FizzBuzzOperation} that corresponds to the number
	 */
	private FizzBuzzOperation fizzBuzzOf(final int number)
	{
		for (FizzBuzzOperation fizzbuzz : this.fizzbuzzes) {
			if(fizzbuzz.applies(number))
				return fizzbuzz;
		}
		
		/*
		 * Default FizzBuzzOperation - if none applies - 
		 * returns the number as a String
		 */
	return new FizzBuzzOperation() 
	{		
		@Override
		public boolean applies(int number){
		return true;
		}

		@Override
		public String toString() {
		return String.valueOf(number);
		}
	};	
	}

	/**
	 * Returns the fizz/buzz representation of the given number
	 * 
	 * @param number the number to use
	 * @return "fizz" for mod 3, "buzz" for mod 5, "fizzbuzz" for mod 15 or the 
	 * number itself
	 */
    public String op(int number){
    return this.fizzBuzzOf(number).toString();
    }
}
