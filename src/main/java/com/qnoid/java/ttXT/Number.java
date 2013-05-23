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
 * @date Mar 1, 2011
 * 
 * Naive identification of a class
 */
public class Number
{
    private final double number;
    
    public Number(double value)
    {
        this.number = value;
    }

    public double multiplyBy1(){
    return multiplyBy(this.number, 1);
    }
    
    public double multiplyBy10(){
    return multiplyBy(this.number, 10);
    }
    
    public double multiplyBy100(){
    return multiplyBy(this.number, 100);
    }
    
    public double multiplyBy1000(){
    return multiplyBy(this.number, 1000);
    }
    
    public double multiplyBy(double number, double multiplier){
    return this.number * multiplier;
    }
    
    public double add1(){
    return add(this.number, 1);
    }
    
    public double add10(){
    return add(this.number, 10);
    }
    
    public double add100(){
    return add(this.number, 100);
    }
    
    public double add1000(){
    return add(this.number, 1000);
    }
    
    public double add(double number, double value){
    return this.number + value;
    }    
}
