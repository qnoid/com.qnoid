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
package com.forrst.java.t7cW;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * An integer with extended operations 
 */
public class ForrstInteger
{
    private final int number;
    
    /**
     * @param number
     */
    public ForrstInteger(int number)
    {
        this.number = number;
    }

    /**
     * Multiply the number that many times.
     * 
     * @param number the number to multiply
     * @param times how many times to multiply it
     * @return the total after multiplying the number or 0 if times is 0
     */
    private int multiply(int number, int times)
    {
        if(times == 0){
            return 0;
        }
        
    return number + this.multiply(number, --times);
    }
    
    /**
     * Raises the number to the specified power
     * 
     * if the power is 0 returns 1
     * if the power is 1 returns the number
     * 
     * @param number the number to raise
     * @param power the power to raise the number to
     * @return the result after raising the number to the power.
     */
    private long pow(int number, int power)
    {
        if(power == 0){
            return 1;
        }
        
    return number * this.pow(number, --power);
    }

    /**
     * Multiplies the number by times
     * 
     * @param times how many times to multiple the number
     * @return the multiple of the number
     */
    public int multiply(int times) {
    return this.multiply(this.number, times);
    }
    
    
    /**
     * Raise the number to the given power
     * 
     * @param power the power to raise the number to
     */
    public long pow(int power) {
    return this.pow(this.number, power);
    }
}
