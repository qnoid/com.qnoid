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
 * Is it really about different formula implementations? Unfortunately since 
 * there isn't an <b>operation class</b> to have a relationship with a 
 * formula one the only way is to implement different classes for different 
 * formulas. Naively "reusing" {@link Numbers#multiplyBy(double, double)} 
 * affecting any class related to it while still losing on actual reusability of
 * operations. 
 */
public class Formulas
{
    public static class AreaOfCircleFormula implements Formula
    {
        public double op(double radius)
        {
            double value = Numbers.multiplyBy(radius, 2);
            
        return Numbers.multiplyBy(value, Math.PI);
        }
    }
    
    public static class AreaOfTriangleFormula implements Formula
    {
        private final double height;

        public AreaOfTriangleFormula(double height)
        {
            this.height = height;
        }

        public double op(double base)
        {
            double value = Numbers.multiplyBy(base, this.height);
            
        return value / 2;
        }
    }
    
    public static class NFormula implements Formula
    {
        public double op(double n)
        {
            double value = Numbers.add(n, 1);
            value = Numbers.multiplyBy(value, n);
            
        return value / 2;
        }
    }
}
