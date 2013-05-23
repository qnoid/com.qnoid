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
package com.qnoid.java.tgOg.strategy;

import static com.qnoid.java.tgOg.ModFizzBuzz.Buzz;
import static com.qnoid.java.tgOg.ModFizzBuzz.Fizz;
import static com.qnoid.java.tgOg.ModFizzBuzz.FizzBuzz;
import junit.framework.Assert;

import org.junit.Test;

import com.qnoid.java.tgOg.Closure;
import com.qnoid.java.tgOg.Each;
import com.qnoid.java.tgOg.Range;
import com.qnoid.java.tgOg.strategy.FizzBuzzOperator;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 23, 2011
 */
public class FizzBuzzOperatorTest 
{
	private static String op(int number)
	{
	return FizzBuzz.applies(number)?FizzBuzz.toString()
			:Fizz.applies(number)?Fizz.toString()
			:Buzz.applies(number)?Buzz.toString()
			:String.valueOf(number);
	}

	@Test
	public void fizzBuzz() throws Exception 
	{
		final FizzBuzzOperator fizzBuzzOperator = 
			FizzBuzzOperator.newFizzBuzz();

		Each<Integer> between1and100 = Range.of(1, 100);

		between1and100.each(
		            new Closure<Integer>(){
		                public void apply(Integer number) 
		                {
		                    Assert.assertEquals(
		                            op(number), 
		                            fizzBuzzOperator.op(number) );
		                }
		            }
		        );		
	}
}
