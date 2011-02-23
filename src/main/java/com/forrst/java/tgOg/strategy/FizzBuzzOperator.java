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
package com.forrst.java.tgOg.strategy;

import com.forrst.java.tgOg.FizzBuzzOperation;

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
     * @return a new {@link FizzBuzzOperator} using {@link FizzBuzzStrategies#DEFAULT} 
     */
	public static FizzBuzzOperator newFizzBuzz() {
	return newFizzBuzz( FizzBuzzStrategies.DEFAULT );
	}
	
	public static FizzBuzzOperator newFizzBuzz(FizzBuzzStrategy fizzbuzzStrategy) {
	return new FizzBuzzOperator( fizzbuzzStrategy );
	}	

	private final FizzBuzzStrategy fizzbuzzStrategy;
	
	/**
	 * @param fizzbuzzStrategy the strategy to use to find the 
	 * {@link FizzBuzzOperation}
	 */
	private FizzBuzzOperator(FizzBuzzStrategy fizzbuzzStrategy) {
		this.fizzbuzzStrategy = fizzbuzzStrategy;
	}

	/**
	 * Returns the fizz/buzz representation of the given number
	 * 
	 * @param number the number to use
	 */
    public String op(int number){
    return this.fizzbuzzStrategy.fizzBuzzOf(number).toString();
    }
}
