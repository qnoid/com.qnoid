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
package com.forrst.java.t0Qu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.forrst.java.t0El.ElementFormats;
import com.forrst.java.t0Qu.Element.ElementBuilder;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * Access to constant JSON elements and creation
 */
public final class Elements
{
    public static final Element<Integer> ID = newNumericType("id", 1);
    
    public static final Element<String> NAME = 
        newStringType("name", 2);
    
    public static final Element<Date> DATE = 
        newDateType("date", new SimpleDateFormat("MMM dd, ''yy"), 3);
    
    public static final Element<Type> TYPE = 
    	newEnumType(Type.class, "type", 4);

    public static final <E extends Enum<E>> Element<E> newEnumType(Class<E> type, String name, int order){
    return new ElementBuilder<E>(type, name).order(order).build();
    }
    
    public static final Element<String> newStringType(String name, int order){
    return new ElementBuilder<String>(String.class, name).order(order).build();
    }
    
    public static final Element<Date> newDateType(String name, final DateFormat dateFormat, int order){
    return new ElementBuilder<Date>(Date.class, name).order(order).format( ElementFormats.newDateFormat(dateFormat) ).build();
    }
    
    public static final Element<Integer> newNumericType(String name, int order){
    return new ElementBuilder<Integer>(Integer.class, name).order(order).build();
    }
}
