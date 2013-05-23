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

import java.text.DateFormat;
import java.util.Date;

import com.qnoid.java.t0Qu.Element;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * A resource for various element formats
 */
public final class ElementFormats
{
    /**
     * A default JSON format as
     * <code>
     *  "name":"value"
     * </code>
     */
    public static final <T> ElementFormat<T> defaultFormat()
    {
    return new ElementFormat<T>() {
            @Override
            public String format(Element<T> element, T value){
            return String.format("\"%s\":\"%s\"", element.name(), value);
            }
        };
    }

    /**
     * Creates a new format for Date {@link Element}s. 
     * The specified date format will be used to format the date of the element. 
     * 
     * @see DateFormat#format(Date)
     */
    public static final ElementFormat<Date> newDateFormat(final DateFormat dateFormat)
    {
    return new ElementFormat<Date>() {        
            @Override
            public String format(Element<Date> element, Date value) {
            return String.format("\"%s\":\"%s\"", element.name(), dateFormat.format(value));
            }
        };    
    }    
}
