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
package com.forrst.java.tBUU;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.tBUU.Designer;
import com.forrst.java.tBUU.Developer;
import com.forrst.java.tBUU.HeterogenousList;
import com.forrst.java.tBUU.Person;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * Let's see how it looks like
 */
public class PersonsTest 
{
	@Test
    public void homogeneous() throws Exception 
    {
		Developer developer = new Developer();
		Designer designer = new Designer();
		
		List<Person> persons = new ArrayList<Person>();		
		persons.add( developer );
		persons.add( designer );
	    
		int DEVELOPER_INDEX = 0;
		int DESIGNER_INDEX = 1;

	    Person theDeveloper = persons.get(DEVELOPER_INDEX);
	    Person theDesigner = persons.get(DESIGNER_INDEX);
	    
		Assert.assertEquals(developer, theDeveloper);
		Assert.assertEquals(designer, theDesigner);	    
    }
	
	@Test
	public void heterogeneous() throws Exception 
	{
		Developer developer = new Developer();
		Designer designer = new Designer();
		
		HeterogenousList<Person> persons = new HeterogenousList<Person>();		
		persons.add( developer );
		persons.add( designer );
		
		Class<Developer> DEVELOPER_INDEX = Developer.class;
	    Class<Designer> DESIGNER_INDEX = Designer.class;	    

		Developer theDeveloper = persons.get(DEVELOPER_INDEX);
		Designer theDesigner = persons.get(DESIGNER_INDEX);
		
		Assert.assertEquals(developer, theDeveloper);
		Assert.assertEquals(designer, theDesigner);	    
	}
	
	@Test(expected=NoSuchElementException.class)
	public void noSuchElementException() throws Exception 
	{
		HeterogenousList<Person> persons = new HeterogenousList<Person>();		
		persons.add( new Developer() );
		
		Class<Designer> DESIGNER_INDEX = Designer.class;	    
		
		persons.get(DESIGNER_INDEX);
	}
	
	public void incorrectType() throws Exception 
	{
		HeterogenousList<Person> persons = new HeterogenousList<Person>();		
		
		//persons.get(String.class);		
	}
}
