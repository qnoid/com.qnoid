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
package com.forrst.java.tgyO;

import java.util.List;

/**
 * A filter provides a way to find elements by applying {@link Conditions} 
 * 
 * @see FilterOnIterables
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 20, 2011
 */
public interface Filter<T> 
{
	/**
	 * Find the first type in the filter that satisfies the condition
	 * 
	 * @param condition the condition to apply to the types
	 * @return the first type where the condition applies
	 * @throws ConditionNotSatisfiedException if the condition doesn't apply to 
	 * any of the elements in the filter
	 */
	public T find(Condition<T> condition);

	/**
	 * Find all the types in the filter that satisfy the condition 
	 * @param condition
	 * @return a list of types satisfying that condition or empty if none
	 */
	public List<T> list(Condition<T> condition);
}