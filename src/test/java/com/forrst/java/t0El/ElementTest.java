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
package com.forrst.java.t0El;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.t0El.*;
import com.forrst.java.t0Qu.Dates;
import com.forrst.java.t0Qu.Elements;
import com.forrst.java.t0Qu.Type;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Dec 8, 2010
 *
 */
public class ElementTest
{
    private static final Date DATE_VALUE = Dates.of(22, 1, 2010);
    
    @Test
    public void formatId() throws Exception
    {
        Assert.assertEquals("\"id\":\"1\"", Elements.ID.format(1));
    }
    
    @Test
    public void formatName() throws Exception
    {
    	Assert.assertEquals("\"name\":\"Kyle\"", Elements.NAME.format("Kyle"));
    }
    
    @Test
    public void formatType() throws Exception
    {
    	Assert.assertEquals("\"type\":\"developer\"", Elements.TYPE.format(Type.DEVELOPER));
    }
    
    @Test
    public void formatDate() throws Exception
    {
        Assert.assertEquals("\"date\":\"Jan 22, '10\"", Elements.DATE.format(DATE_VALUE));
    }
}
