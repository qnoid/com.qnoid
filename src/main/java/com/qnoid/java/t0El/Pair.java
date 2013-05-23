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
package com.qnoid.java.t0El;

import com.qnoid.java.t0Qu.Element;
import com.qnoid.java.t0Qu.Elements;
import com.google.common.base.Preconditions;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * A JSON pair that is associated with an element and has a value
 * 
 * @param <T> the type of the pair which derives from the Element is associated with
 * @see Element
 */
public final class Pair<T>
{
	/**
	 * Create a new JSON pair
	 * 
	 * @param <T> the type of the JSON pair 
	 * @param element the element of the pair
	 * @param value its value
	 * @return a new Pair
	 * @see Elements
	 */
    public static final <T> Pair<T> newPair(Element<T> element, T value)
    {
        Preconditions.checkNotNull(element);
        Preconditions.checkNotNull(value);
    return new Pair<T>(element, value);
    }
    
    private final Element<T> element;
    private final T value;
    
    /**
     * @param element
     * @param value
     */
    private Pair(Element<T> element, T value)
    {
        this.element = element;
        this.value = value;
    }
    
    public Element<T> element() {
    return this.element;
    }

    public T value() {
    return value;
    }

	@Override
    public String toString() {
    return this.element.format(this.value);
    }

	/**
	 * Effective Java 2nd Edition, Joshua Bloch, Item 8
	 */
	@Override
    public int hashCode() 
	{
	    int result = 17;
	    result = 37 * result + this.element.hashCode();
	    result = 37 * result + this.value.hashCode();
    return result;
    }

	@Override
    public boolean equals(Object that) 
	{
		if(this == that){
			return true;
		}
		
		if(!(that instanceof Pair)){
			return false;
		}
		
		Pair<?> pair = (Pair<?>)that;
		
    return this.element.equals(pair.element) && this.value.equals(pair.value);
    }
}
