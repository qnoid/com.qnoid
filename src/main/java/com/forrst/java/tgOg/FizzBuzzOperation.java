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
package com.forrst.java.tgOg;

/**
 * Implementations of this class should provide different operations 
 * for fizz/buzz
 * 
 * @see ModFizzBuzz
 * @see FizzBuzzOperator#newFizzBuzz(FizzBuzzOperation...)
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 23, 2011
 */
public interface FizzBuzzOperation
{
    /**
     * Applies the fizz/buzz operation to the given number
     * @return true if the fizz/buzz operation applies to this number
     */    
    public boolean applies(int number);
    
    /**
     * @return the name of the fizz/buzz operation
     */
    public String toString();
}