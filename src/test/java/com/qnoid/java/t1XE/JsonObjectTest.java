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
package com.qnoid.java.t1XE;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

import com.qnoid.java.t0El.*;
import com.qnoid.java.t0Qu.Elements;
import com.qnoid.java.t0Qu.Type;
import com.qnoid.java.t1XE.JsonObject;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 */
public class JsonObjectTest 
{
    private static final Integer ID_VALUE = 1;
    
    private static final Pair<Integer> ID_PAIR = 
        Pair.newPair(Elements.ID, ID_VALUE);
    
    private static final String NAME_VALUE = "Kyle Bragger";
    
    private static final Pair<String> NAME_PAIR = 
        Pair.newPair(Elements.NAME, NAME_VALUE);
    
    private static final Date DATE_VALUE = 
        Calendar.getInstance().getTime();
    
    private static final Pair<Date> DATE_PAIR = 
        Pair.newPair(Elements.DATE, DATE_VALUE);
    
    private static final Type TYPE_VALUE = Type.DEVELOPER;
    
    private static final Pair<Type> TYPE_PAIR = 
        Pair.newPair(Elements.TYPE, TYPE_VALUE);
    
    private static final Pair<?>[] PAIRS = 
        new Pair<?>[]{
            ID_PAIR, 
            NAME_PAIR, 
            DATE_PAIR, 
            TYPE_PAIR};
    
	private static final String toString =
		String.format("{%s,%s,%s,%s}", ID_PAIR, NAME_PAIR, DATE_PAIR, TYPE_PAIR);

	@Test
    public void string() throws Exception 
    {
		JsonObject jsonObject = JsonObject.of( PAIRS );
		
		Assert.assertEquals(toString, jsonObject.toString());
    }
	
	@Test
	public void valueOfId() throws Exception 
	{
		JsonObject jsonObject = JsonObject.of( PAIRS );
		
		Assert.assertEquals(ID_VALUE, jsonObject.valueOf(Elements.ID));
	}
	@Test
	public void valueOfName() throws Exception 
	{
		JsonObject jsonObject = JsonObject.of( PAIRS );
		
		Assert.assertEquals(NAME_VALUE, jsonObject.valueOf(Elements.NAME));
	}
	@Test
	public void valueOfType() throws Exception 
	{
		JsonObject jsonObject = JsonObject.of( PAIRS );
		
		Assert.assertEquals(TYPE_VALUE, jsonObject.valueOf(Elements.TYPE));
	}
	@Test
	public void valueOfDate() throws Exception 
	{
		JsonObject jsonObject = JsonObject.of( PAIRS );
		
		Assert.assertEquals(DATE_VALUE, jsonObject.valueOf(Elements.DATE));
	}
}
