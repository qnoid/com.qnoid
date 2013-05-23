package com.qnoid.java.tgyO;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * A {@link IntegerConditionChain} which to use for applying conditions on
 * an integer value
 *
 * @see #gt(int)
 * @see #lt(int)  
 * @param value the value the condition is based on
 * @return the condition chain
 */
public final class IntegerConditionChain implements ConditionChain<Integer>
{
	private final List<Condition<Integer>> conditions = 
		Lists.newArrayList();
	
	/**
	 * 
	 */
	public ConditionChain<Integer> addCondition(Condition<Integer> condition) 
	{
		this.conditions.add(condition);
		
	return this;
	}
	
	/* (non-Javadoc)
	 * @see com.qnoid.java.model.ConditionChain#apply()
	 */
	@Override
	public boolean apply(Integer value) 
	{
		for (Condition<Integer> condition : this.conditions) 
		{
			if(!condition.apply(value)){
				return false;
			}
		}
		
	return true;
	}

	/**
	 * Must be greater than the specified int
	 *  
	 * @param that the int to be less than
	 * @return the chain
	 */
	public IntegerConditionChain gt(final int that) 
	{
		this.addCondition(new Condition<Integer>(){

			@Override
			public boolean apply(Integer value) {
			return value > that;
			}
		});
		
	return this;
	}

	/**
	 * Must be less than the specified int
	 *  
	 * @param that the int to be greater than
	 * @return the chain
	 */
	public IntegerConditionChain lt(final int that) 
	{
		this.addCondition(new Condition<Integer>(){

			@Override
			public boolean apply(Integer value) {
			return value < that;
			}
		});
		
	return this;
	}
}
