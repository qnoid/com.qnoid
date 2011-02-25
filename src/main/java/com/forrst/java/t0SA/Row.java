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
package com.forrst.java.t0SA;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 15, 2011
 *
 * This class emulates a database row holding the columns' values
 */
public class Row
{
    /*
     * A column can be of arbitrary type therefore we use 
     * a heterogeneous map
     * to hold the different types of values 
     */
    private final Map<Column<?>, Object> columns;

    /*
     * elevated to public access due to different packages (posts on forrst)
     */
    public Row()
    {
        this.columns = new HashMap<Column<?>, Object>();
    }

    /**
     * Returns the value for the specified column 
     * 
     * @param column the column to get the value for
     * @return the value of the column
     */
    public <T> T get(Column<T> column) {
    return column.type().cast( this.columns.get(column) );
    }

    /**
     * Adds a new column value
     *
     * @param column the column related to the value
     * @param value the value under that column
     * @throws InvalidColumnType if the column type specified for 
     * the value is wrong
     */
    public <T> void put(Column<T> column, Object value)
    {
        Class<T> type = column.type();
        /*
         * early cast just in case the column type is wrongly specified
         * as opposed to the actual
         */
        try{
            T typed = type.cast(value);
            this.columns.put(column, typed);
        }
        catch(ClassCastException e){
            throw new InvalidColumnType(
                    String.format(
                            "Actual type for column '%s' is %s", 
                            column.name(), 
                            value.getClass().getSimpleName()
                            ));
        }            
    }
}
