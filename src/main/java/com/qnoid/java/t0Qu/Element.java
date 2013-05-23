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
package com.qnoid.java.t0Qu;

import com.qnoid.java.t0El.ElementFormat;
import com.qnoid.java.t0El.ElementFormats;
import com.qnoid.java.t1XE.PairSet;
import com.google.common.base.Preconditions;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * 
 * A JSON element describing its type and name.
 * 
 * @param <T> the type of the element
 * 
 * @see Elements#newStringType(String)
 * @see Elements#newNumericType(String)
 * @see Elements#newDateType(String, java.text.DateFormat)
 * @see Elements#newBooleanType(String)
 * @see Elements#newEnumType(Class, String)
 */
public final class Element<T> implements Comparable<Element<T>>
{
    /**
     * By default ordering isn't taken into account and the element's format is
     * {@link ElementFormats#defaultFormat()}
     * 
     * @see Element#format(Object)
     */
    public static class ElementBuilder<T>
    {
        private final Class<T> type;
        private final String name;
        private ElementFormat<T> format = ElementFormats.defaultFormat(); 
        private Integer order = 0;
        
        /**
         * @param type the element type
         * @param name its name
         */
        public ElementBuilder(Class<T> type, String name)
        {
            Preconditions.checkNotNull(type);
            Preconditions.checkNotNull(name);
            this.type = type;
            this.name = name;
        }

        /**
         * Use to specify a custom format
         * @param format the format of the element
         * @see ElementFormats
         */
        public ElementBuilder<T> format(ElementFormat<T> format)
        {
            Preconditions.checkNotNull(format);
            this.format = format;
            
        return this;
        }

        /**
         * Use to specify the ordering of the elements
         * @param order will be taken into account when iterating over a 
         * {@link PairSet}
         */
        public ElementBuilder<T> order(Integer order)
        {
            Preconditions.checkNotNull(order);
            this.order = order;
        return this;
        }

        /**
         * @return a new Element the specified type
         */
        public Element<T> build(){
        return new Element<T>(this.type, this.name, this.order, this.format);
        }
    }
    
    private final ElementFormat<T> format; 
	private final Class<T> type;
    private final String name;
    private final Integer order;
    
    Element(Class<T> type, String name, Integer order, ElementFormat<T> format)
    {
        this.type = type;
        this.name = name;
        this.order = order;
        this.format = format;
    }

    public Class<T> type() {
    return type;
    }

    public String name() {
    return name;
    }    
    
    @Override
    public String toString(){
    return this.name;
    }
    
    /**
     * Formats the value of this element based on the format specified. 
     * This will be used when creating its string representation  
     * 
     * @param value the value to format
     * @return a String formatted as specified by the {@link ElementFormat}
     */
    public String format(T value) {
	return this.format.format(this, value);
    }

	@Override
    public boolean equals(Object that) 
	{
		if(this == that){
			return true;
		}
		
		if(!(that instanceof Element)){
			return false;
		}
		
		Element<?> element = (Element<?>)that;
		
    return this.name.equals(element.name);
    }

	@Override
    public int hashCode() {
    return this.name.hashCode();
    }

	/* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Element<T> element) {
	return this.order.compareTo(element.order);
    }  
}
