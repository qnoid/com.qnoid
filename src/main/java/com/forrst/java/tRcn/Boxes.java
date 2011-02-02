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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


/**
 * Use to create {@link Box}es
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 1, 2011
 */
public final class Boxes
{
    /**
     * Use to create a list of boxes
     */
    public static final class BoxBuilder
    {
        private final List<Fruit> fruits;

        /**
         * @param fruits the fruits to include in every box 
         */
        private BoxBuilder(List<Fruit> fruits)
        {
            this.fruits = fruits;
        }
        
        /**
         * @param howMany boxes
         * @return a new list containing that many boxes
         */
        public List<Box> times(int howMany)
        {
            Box box = new Box() {        
                @Override
                public Iterator<Fruit> iterator() {
                return fruits.iterator();
                }
            };
            
        return Collections.nCopies(howMany, box);
        }                
    }
    
    /**
     * @param fruits the fruits to include in the boxes
     * @return a {@link BoxBuilder}
     * @see BoxBuilder#times(int) to create the boxes
     */
    public static BoxBuilder of(List<Fruit> fruits){
    return new BoxBuilder(fruits);
    }
    
    /*
     * No need to instantiate 
     */
    private Boxes() {}    
}
