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
package com.forrst.java.t1XE;

import com.forrst.java.t0El.Pair;
import com.forrst.java.t0Qu.Element;
import com.forrst.java.t0Qu.Elements;
import com.forrst.java.t0Qu.Type;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * A non-complex JSON object
 */
public final class JsonObject 
{
    public static JsonObject of(Pair<?>... pairs) {
    return new JsonObject( PairSet.of(pairs) );
    }

	private static final Element<Type> LAST_ELEMENT = Elements.TYPE;
	
	private static final String LEFT_BRACE = "{";
	private static final String RIGHT_BRACE = "}";
	private static final String COMMA = ",";
	
	private final PairSet pairs;

	JsonObject(PairSet pairs) 
	{
	    this.pairs = pairs;
    }
	
	private boolean isLast(Pair<?> pair){
	return LAST_ELEMENT.equals(pair.element());
	}
	
    private void appendEveryPairOf(StringBuilder builder, PairSet pairs)
    {
        for (Pair<?> pair : pairs) 
        {
            builder.append( pair );            
            appendCommaIfNotLast(builder, pair);
        }
    }

    private void appendCommaIfNotLast(StringBuilder builder, Pair<?> pair)
    {
        boolean isLast = isLast(pair);
        
        if(!isLast){
            builder.append( COMMA );
        }
    }

	/**
	 * 
	 * @param <T>
	 * @param element the element which is present in the JSON object
	 * @return its value
	 */
	public <T> T valueOf(Element<T> element){
	return this.pairs.get(element);		
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append(LEFT_BRACE);
		
		appendEveryPairOf(builder, this.pairs);
		
		builder.append(RIGHT_BRACE);
		
	return builder.toString();
	}
}
