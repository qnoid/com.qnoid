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
package com.qnoid.java.tRPu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 26, 2011
 */
public class Flying implements TransportMethod
{
    private static final String ROUTE_MESSAGE = "Flying down to %s from %s in %s class on %s";
    
    private final FlightClass flightClass;

    /**
     * @param flightClass
     */
    Flying(FlightClass flightClass)
    {
        this.flightClass = flightClass;
    }
        
    /* (non-Javadoc)
     * @see com.qnoid.java.object.Route#foo(java.lang.Object, java.lang.Object)
     */
    @Override
    public int route(Destination from, Destination to, Calendar date)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println( 
                String.format(
                        ROUTE_MESSAGE, 
                        to, 
                        from, 
                        this.flightClass, 
                        dateFormat.format(date.getTime())) );
        
    return this.flightClass.miles();
    }   
}
