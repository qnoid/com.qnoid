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

import java.util.HashMap;
import java.util.Map;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date May 19, 2011
 */
public final class WordingStrategies 
{
	public static final WordingStrategy CONSTANTS = new WordingStrategy() 
	{
		public final Map<Integer, String> wordings =
			new HashMap<Integer, String>()
			{
				{
					this.put(0, "zero");
					this.put(10, "ten");
					this.put(11, "eleven");
					this.put(12, "twelve");					
					this.put(13, "thirteen");
					this.put(14, "forteen");					
					this.put(15, "fifteen");
					this.put(16, "sixteen");					
					this.put(17, "seventeen");
					this.put(18, "eighteen");
					this.put(19, "nineteen");
				}
			};
	
		@Override
		public String of(int number, int mod) {
		return this.wordings.get(number);
		}
	};
	
	public static final WordingStrategy MOD = new WordingStrategy() 
	{
		public final Map<Integer, String> wordings =
			new HashMap<Integer, String>()
			{
				{
					this.put(1, "one");
					this.put(2, "two");
					this.put(3, "three");
					this.put(4, "four");
					this.put(5, "five");
					this.put(6, "six");
					this.put(7, "seven");
					this.put(8, "eight");
					this.put(9, "nine");
					
					this.put(20, "twenty");
					this.put(30, "thirty");
					this.put(40, "forty");
					this.put(50, "fifty");
					this.put(60, "sixty");
					this.put(70, "seventy");
					this.put(80, "eighty");
					this.put(90, "ninety");
					
					this.put(100, "onehundred");
					this.put(900, "ninehundred");
					
					this.put(1000, "onethousand");
					this.put(9000, "ninethousand");
				}
			};
					
			@Override
			public String of(int number, int mod) 
			{
				if(number == 0)
					return "";
				
				int value = number % mod;

				/*
				 * if there is no value for the number, skip to the next mod.
				 * e.g. in case of a missing digit
				 * 
				 * missing units
				 *  120 % 10 = 0
				 *  
				 * missing tens
				 *  100 % 100 = 0 //missing tens
				 */
				if(value == 0) {
				return this.of(number, mod * 10);
				}
				
				StringBuilder sb = new StringBuilder();

				String wording = this.wordings.get(value);
				
				sb.append( wording );
				
				int remaining = number - value;

				String stringOf = this.of(remaining, mod * 10);
			
				sb.insert(0, stringOf);
				
			return sb.toString();
			}
	}; 
}
