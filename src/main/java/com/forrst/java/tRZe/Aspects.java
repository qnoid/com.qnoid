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
package com.forrst.java.tRZe;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 3, 2011
 */
public class Aspects
{
    /**
     * @param <E> the type of the objects
     * @return a new Aspect on unique objects
     */
    public static <E> Aspect<E> uniqueAspect()
    {
    return new Aspect<E>()
        {
            /*
             * Holding all unique elements
             */
            private final Set<E> uniques = new HashSet<E>();
            
            /**
             * @return true if element is unique
             */
            @Override
            public boolean apply(E e) {
            return this.uniques.add(e);
            }
        };
    }
}
