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
package com.qnoid.java.tRvO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import com.qnoid.java.tRPu.Destination;
import com.qnoid.java.tRvO.UrbanLegend;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 25, 2011
 * 
 * You have to live with it
 */
public class UrbanLegendTest
{
    private static final DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");	
	private static final Calendar now = Calendar.getInstance();	
	private static final String STRING = 
		String.format("%s%s%s", 
				Destination.EDINBURGH.code(), 
				Destination.LONDON.code(),
				dateFormat.format(now.getTime()));

    @Test
    public void tell() throws Exception
    {
        boolean status = true; //making a choice!
        String string = "business"; //making a choice!
        int type = 1; //making a choice!
        String one = "EDI";
        String another = "LON";
        Calendar date = Calendar.getInstance();

        UrbanLegend myth = new UrbanLegend(one, another, date, status);
        
        Assert.assertEquals(STRING, myth.string);
        Assert.assertEquals(500, myth.tell(type, string));
    }
}
