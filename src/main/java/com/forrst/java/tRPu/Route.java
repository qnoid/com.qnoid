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
package com.forrst.java.tRPu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 26, 2011
 * 
 * It's a revelation
 */
public final class Route
{
    public static final class RouteBuilder
    {
        private final Destination from;
        private final Destination to;
        private Calendar date = Calendar.getInstance();
        
        public RouteBuilder(Destination from, Destination to)
        {
            this.from = from;
            this.to = to;
        }
        
        public RouteBuilder onDate(Calendar date)
        {
            this.date = date;
            
        return this;
        }

        public Route build() {
        return new Route(this.from, this.to, this.date);
        }
    }

    private final DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
    
    private final Destination from;
    private final Destination to;
    private final Calendar date;

    private Route(Destination from, Destination to, Calendar date)
    {
        
        this.from = from;
        this.to = to;
        this.date = date;
    }

    private void appendDate(StringBuilder builder, Date date, DateFormat dateFormat) {
        builder.append( dateFormat.format(date) );
    }

    private void appendCode(StringBuilder builder, String code) {
        builder.append(code);
    }

    public int via(TransportMethod method) {
    return method.route(this.from, this.to, this.date);
    }
    
    public String bookingCode()
    {
        StringBuilder builder = new StringBuilder();
        
        this.appendCode(builder, this.from.code());    
        this.appendCode(builder, this.to.code());    
        this.appendDate(builder, this.date.getTime(), this.dateFormat);
        
    return builder.toString();
    }
}
