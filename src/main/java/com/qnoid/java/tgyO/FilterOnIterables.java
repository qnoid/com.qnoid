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
package com.qnoid.java.tgyO;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Use to filter an {@link Iterable}
 *  
 * @see #find(Condition)
 * @see #list(Condition)
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 19, 2011
 */
public final class FilterOnIterables<T> implements Filter<T> 
{
	private final Iterable<T> iterable;
	
	/**
	 * @param types the types of the filter
	 */
	public FilterOnIterables(Iterable<T> iterable) 
	{
		this.iterable = iterable;
	}

	/* (non-Javadoc)
	 * @see com.qnoid.java.model.Filter#find(com.qnoid.java.model.Condition)
	 */
	@Override
	public T find(Condition<T> condition)
	{
		for (T type : this.iterable) 
		{
			if( condition.apply(type) ){
				return type;
			}
		}
		
	throw new ConditionNotSatisfiedException(condition);
	}

	/* (non-Javadoc)
	 * @see com.qnoid.java.model.Filter#list(com.qnoid.java.model.Condition)
	 */
	@Override
	public List<T> list(Condition<T> condition) 
	{
		List<T> types = Lists.newArrayList();
		
		for (T type : this.iterable) 
		{
			if( condition.apply(type) ){
				types.add(type);
			}
		}
		
	return types;
	}
}
