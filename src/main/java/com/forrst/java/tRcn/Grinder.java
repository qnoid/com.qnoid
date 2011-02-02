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

import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Use it to apply grinding
 * 
 * @param <T>
 * 
 * @see Grinders
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 1, 2011
 */
public final class Grinder<T>
{
    private final Iterable<T> items;

    /**
     * @param items the items to grind
     */
    public Grinder(Iterable<T> items)
    {
        this.items = items;
    }

    /**
     * Grinds the items specified in {@link #Grinder(Iterable)} and returns a
     * new Grinder holding the <O> for further grinding.
     * 
     * @param <O> what the grinding produces with the specified blade
     * @param blade the blade to use for the grinding
     * @return a new Grinder instance to chain the 
     * @see #items to get the result of the grinding 
     */
    public <O> Grinder<O> grind(Blade<T, O> blade) 
    {
        List<O> output = Lists.newArrayList();
        
        for (T value : this.items)
        {
            Iterable<O> cut = blade.cut(value);
            Iterables.addAll(output, cut);
        }
        
        
    return new Grinder<O>(output);
    }

    /**
     * @return the items currently in the grinder
     */
    public Iterable<T> items() {
    return this.items;
    }    
}
