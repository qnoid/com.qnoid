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
package com.forrst.java.t0mR;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

import com.forrst.java.t0SA.Column;
import com.forrst.java.t0SA.Row;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 15, 2011

 * This class provides a way to retrieve all the values in a result set based
 * on the columns specified and create a new object of type {@code T} based on 
 * that values
 *
 * Classes extending this class should provide an implementation for the 
 * template method {@link #newType(Row)} which must return the object based on 
 * the row's columns
 * @see ResultSetHandler
 */
public abstract class TemplateResultSetHandler<T> implements ResultSetHandler<T>
{
    private final List<Column<?>> columns;

    /**
     * @param columns all columns available in the ResultSet
     */
    public TemplateResultSetHandler(List<Column<?>> columns)
    {
        this.columns = columns;        
    }

    /**
     * This method will iterate through all the columns 
     * (as specified in the constructor) in the result set and provide a single 
     * callback to the {@link #newType(Row)} with a Row object holding all the 
     * column values.
     * 
     * @param rs a ResultSet pointing to the row holding the next instance of {@code T}
     * @return an object of type T as returned by the {@link #newType(Row)}
     * @see ResultSet#next()
     */
    @Override
    public final T handle(ResultSet rs) throws SQLException
    {        
        Row row = new Row();
        
        for (Column<?> column : this.columns) {
            row.put(column, rs.getObject(column.name()) );
        }
        
    return this.newType( row );
    }
    
    /**
     * Template method to be overridden and provide the type of object related
     * to the given row.
     * 
     * @param row the row 
     * @return a new object based on the column 
     * @see Row#get(Column)
     */
    protected abstract T newType(Row row);    
}

