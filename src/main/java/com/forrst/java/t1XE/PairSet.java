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
package com.forrst.java.t1XE;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.forrst.java.t0El.Pair;
import com.forrst.java.t0Qu.Element;
import com.forrst.java.t0Qu.Element.ElementBuilder;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * An collection of pairs ordered based on the order of their {@link Element}s
 * 
 * @see ElementBuilder
 */
public final class PairSet implements Iterable<Pair<?>>
{
	/**
     * Create a new JSON object with the specified pairs
     * 
     * @param pairs the pairs to the JSON object
     * @return a JsonObject with the specified pairs
     */
    public static final PairSet of(Pair<?>... pairs)
    {
        PairSet pairSet = new PairSet();
        
        for (Pair<?> attribute : pairs) {
            pairSet.add(attribute);
        }
        
    return pairSet;
    }    

    /*
     * Using TreeMap implementation for sorting
     */
    private final Map<Element<?>, Pair<?>> pairs = 
        new TreeMap<Element<?>, Pair<?>>();
    
    /**
     * Adds a new pair value
     * @param <T> the pair type
     * @param pair the pair to add
     */
    public <T> PairSet add(Pair<T> pair)
    {
        this.pairs.put(pair.element(), pair);
    return this;
    }
    
    @Override
    public Iterator<Pair<?>> iterator(){
    return this.pairs.values().iterator();
    }
        
    /**
     * 
     * @param <T>
     * @param element the type of the pair
     * @return the pair instance
     * @see Element#type()
     */
    public <T> T get(Element<T> element) {
    return element.type().cast( this.pairs.get(element).value() );
    }

    public int size(){
    return this.pairs.size();
    }
}
