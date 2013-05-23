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
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 20, 2011
 */
public final class PersonConditionChain implements ConditionChain<Person> 
{
	private List<Condition<Person>> conditions = Lists.newArrayList();

	/* (non-Javadoc)
	 * @see com.qnoid.java.model.ConditionChain#addCondition(com.qnoid.java.model.Condition)
	 */
	@Override
	public ConditionChain<Person> addCondition(Condition<Person> condition) 
	{
		this.conditions.add(condition);
	return this;
	}

	/* (non-Javadoc)
	 * @see com.qnoid.java.model.Condition#apply(java.lang.Object)
	 */
	@Override
	public boolean apply(Person person) 
	{
		for (Condition<Person> condition : this.conditions) 
		{
			if(!condition.apply(person)){
				return false;
			}
		}
		
	return true;
	}

	/**
	 * @param name
	 * @return the chain
	 */
	public PersonConditionChain hasName(final String name) 
	{
		this.addCondition( new Condition<Person>() {
			
			@Override
			public boolean apply(Person person) {
			return person.hasName(name);
			}
		});
		
	return this;
	}

	/**
	 * @param conditionOnAge an age condition
	 * @return the chain 
	 */
	public PersonConditionChain age(final Condition<Integer> conditionOnAge) 
	{
		this.addCondition( new Condition<Person>() {
			
			@Override
			public boolean apply(Person person) {
			return conditionOnAge.apply( person.age() );
			}
		});
		
	return this;
	}

}
