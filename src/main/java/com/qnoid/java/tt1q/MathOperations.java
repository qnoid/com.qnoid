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
package com.qnoid.java.tt1q;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 1, 2011
 * 
 * All available operators
 */
public class MathOperations
{
    /*
     * In an OO world an Object is a first class citizen.
     * To have an object you need a class
     */
    private static final class Multiplication implements MathOperation
    {     
        private final double multiplier;

        private Multiplication(double multiplier)
        {
            this.multiplier = multiplier;
        }

        public double op(double number){
        return number * this.multiplier;
        }
    }
    
    private static final class Division implements MathOperation
    {     
        private final double divisor;
        
        private Division(double divisor)
        {
            this.divisor = divisor;
        }
        
        public double op(double number){
        return number / this.divisor;
        }
    }
    
    private static final class Addition implements MathOperation
    {     
        private final double amount;
        
        private Addition(double amount)
        {
            this.amount = amount;
        }
        
        public double op(double number){
        return number + this.amount;
        }
    }
    
    private static final class Substraction implements MathOperation
    {     
        private final double amount;
        
        private Substraction(double amount)
        {
            this.amount = amount;
        }
        
        public double op(double number){
        return number - this.amount;
        }
    }
        
    /*
     * Reusable! operations  
     */
    public static final MathOperation MULTIPLY_BY_2 = 
        new Multiplication(2);
    
    public static final MathOperation MULTIPLY_BY_PI = 
        new Multiplication(Math.PI);
    
    public static Addition addition(double amount){
    return new Addition(amount);
    }
    
    public static Substraction substraction(double amount){
    return new Substraction(amount);
    }

    public static MathOperation multiplication(double multiplier) {
    return new Multiplication(multiplier);
    }

    public static MathOperation division(double divisor) {
    return new Division(divisor);
    }
}
