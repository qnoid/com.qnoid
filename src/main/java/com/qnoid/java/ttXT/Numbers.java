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
package com.qnoid.java.ttXT;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 3, 2011
 * 
 * This isn't OO
 */
public class Numbers
{
    public static double multiplyBy1(double number){
    return multiplyBy(number, 1);
    }
    
    public static double multiplyBy10(double number){
    return multiplyBy(number, 10);
    }
    
    public static double multiplyBy100(double number){
    return multiplyBy(number, 100);
    }
    
    public static double multiplyBy1000(double number){
    return multiplyBy(number, 1000);
    }
    
    public static double multiplyBy(double number, double multiplier){
    return number * multiplier;
    }
    
    public static double add1(double number){
    return add(number, 1);
    }
    
    public static double add10(double number){
    return add(number, 10);
    }
    
    public static double add100(double number){
    return add(number, 100);
    }
    
    public static double add1000(double number){
    return add(number, 1000);
    }
    
    public static double add(double number, double value){
    return number + value;
    }    
}
