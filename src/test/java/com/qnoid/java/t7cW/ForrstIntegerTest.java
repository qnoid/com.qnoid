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
package com.qnoid.java.t7cW;

import junit.framework.Assert;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import com.qnoid.java.t7cW.ForrstInteger;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * Let's prove our recursion theory
 */
@RunWith(Theories.class)
public class ForrstIntegerTest
{
    @DataPoints
    public static final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    @Theory
    public void multiplyByOne(int number)
    {
        int actual = new ForrstInteger(number).multiply(1); 
        
        Assert.assertEquals(number, actual);
    }
    
    @Theory
    public void multiplyByZero(int number)
    {
        int actual = new ForrstInteger(number).multiply(0); 
        
        Assert.assertEquals(0, actual);
    }
    
    @Theory
    public void multiplyByTimes(int number, int multiply)
    {
        System.out.print( String.format("%s * %s = ", number, multiply) );
        int actual = new ForrstInteger(number).multiply(multiply); 
        
        System.out.println(actual);
        Assert.assertEquals(number * multiply, actual);
    }
    
    @Theory
    public void powerByOne(int number)
    {
        long actual = new ForrstInteger(number).pow(1); 
        
        Assert.assertEquals(number, actual);
    }
    
    @Theory
    public void powerByZero(int number)
    {
        long actual = new ForrstInteger(number).pow(0); 
        
        Assert.assertEquals(1, actual);
    }
    
    @Theory
    public void powerByTimes(int number, int power)
    {
        System.out.print( String.format("%s ^ %s = ", number, power) );
        long actual = new ForrstInteger(number).pow(power); 
        
        System.out.println(actual);
        Assert.assertEquals( (long)Math.pow(number, power), actual);
    }
}
