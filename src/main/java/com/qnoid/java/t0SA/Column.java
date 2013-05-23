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
package com.qnoid.java.t0SA;

import java.util.Date;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 15, 2011
 * Defines a column in a table of a specified type under a given name.
 */
public final class Column<T>
{
    public static final Column<Integer> newIntegerType(String name){
    return new Column<Integer>(Integer.class, name);
    }
    
    public static final Column<Long> newLongType(String name){
    return new Column<Long>(Long.class, name);
    }
    
    public static final Column<Date> newDateType(String name){
    return new Column<Date>(Date.class, name);
    }
    
    public static final Column<String> newStringType(String name){
    return new Column<String>(String.class, name);
    }
    
    public static final <E> Column<E> newColumn(Class<E> clazz, String name){
    return new Column<E>(clazz, name);
    }
    
    private Class<T> clazz;
    private String name;
    
    public Column(Class<T> clazz, String name)
    {
        this.clazz = clazz;
        this.name = name;
    }

    public Class<T> type() {
    return clazz;
    }

    public String name() {
    return name;
    }
}
