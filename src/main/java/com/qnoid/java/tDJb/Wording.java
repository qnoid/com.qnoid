/*
 *  This file is under the license Attribution-ShareAlike 3.0 Unported 
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
package com.qnoid.java.tDJb;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date May 18, 2011
 */
public final class Wording 
{
	private static final String NO_WORDING_FOUND = 
		"No wording found for number: %d";
	
	public static final Wording newWording(){
	return new Wording(
			Lists.newArrayList(
					WordingStrategies.CONSTANTS, 
					WordingStrategies.MOD));	
	}
	
	private final List<WordingStrategy> strategies;

	private Wording(List<WordingStrategy> strategies) 
	{
		this.strategies = strategies;
	}
	
	public String of(int number) 
	{
		for (WordingStrategy strategy : this.strategies) 
		{
			String wording = strategy.of(number, 10);
			
			if(wording != null)
				return wording;
		}
		
	throw new WordingException(String.format(NO_WORDING_FOUND, number))
				.number(number);
	}	
}
