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
 * @date Mar 7, 2011
 * 
 * This is the result of failing to identify a class in {@link Numbers} 
 * that models a math operation thus having to handle different types of
 * formulas.
 */
public class AbusingTheIfFormula
{
    public static final int AREA_OF_CIRCLE = 1;
    public static final int AREA_OF_TRIANGLE = 2;
    public static final int N = 3;
    
    private final double base;

    /**
     * On which type does it make sense?
     */
    public AbusingTheIfFormula()
    {
        this.base = 0.0;
    }
    
    /**
     * @param base only related to a specific type
     */
    public AbusingTheIfFormula(double base)
    {
        this.base = base;
    }

    /**
     * You are forced to abuse the if now
     */
    public double op(double number, int type)
    {
        if(AREA_OF_CIRCLE == type){
            
            number = Numbers.multiplyBy(number, Math.PI);
            number = Numbers.multiplyBy(number, 2);
            
        return number;
        }
        else if(AREA_OF_TRIANGLE == type)
        {
            if(this.base != 0.0)
            {
                number = Numbers.multiplyBy(base, number);
                
            return number / 2;
            }
        }
        else if(N == type)
        {
            double original = number;
            number = Numbers.add(number, 1);
            number = Numbers.multiplyBy(original, number);
            
        return number / 2;
        }
        
    throw new UnsupportedOperationException("Uknown type: " + type);
    }
}
