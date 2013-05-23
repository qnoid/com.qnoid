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
package com.qnoid.java.tRZe;

import java.util.HashSet;
import java.util.Set;

import com.google.common.collect.Lists;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 3, 2011
 */
public class AspectSets
{
    /**
     * Create a new Set which is strong on duplicates 
     * 
     * @param <E> the type of the {@link Set}
     * @param elements the elements to take create the set from
     * @return a new Set which is only keen on holding added 
     * elements more than once.
     */
    public static <E> Set<E> newSetOnDuplicates(final E[] elements)
    {
        final Aspect<E> isUnique = Aspects.uniqueAspect();
        
        /*
         * Using a set to handle multiple duplicates
         * (elements that occur more than 2 times)
         */
        return new HashSet<E>( Lists.newArrayList(elements) )
        {
            private static final long serialVersionUID = 
                -8073479479226481874L;

            /**
         * Add the element only if its a duplicate
             */
            @Override
            public boolean add(E e) 
            {                
                if(isDuplicate(e))
                    return super.add(e);
                
            return false;
            }

            private boolean isDuplicate(E e) {
            return !isUnique.apply(e);
            }
        };
    }
}
