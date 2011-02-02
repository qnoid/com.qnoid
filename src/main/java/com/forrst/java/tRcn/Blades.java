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
package com.forrst.java.tRcn;


/**
 * Lists all available blades
 * 
 * @see Grinder#grind(Blade)
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 1, 2011
 */
public class Blades
{
    /**
     * Effective Java 2nd Edition, Joshua Bloch, Item 27, page 131
     */
    private static final Blade<Iterable<Object>, Object> DEFAULT = new Blade<Iterable<Object>, Object>() {
        @Override
        public Iterable<Object> cut(Iterable<Object> input) {
        return input;
        }
    };
    
    /*
     * type inference 
     */
    public static final Blade<Box, Fruit> BOX = newBlade();    
    public static final Blade<Fruit, Seed> FRUIT = newBlade();
    
    /**
     * lack of generic typing in static fields
     * 
     * @param <I>
     * @param <O>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <I extends Iterable<O>, O> Blade<I, O> newBlade(){
    return (Blade<I, O>) DEFAULT;
    }
}
