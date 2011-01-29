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
package com.forrst.java.t1Jc;

import com.forrst.java.t1Jc.TheTerminator.TheTerminatorBuilder;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 15, 2011
 * 
 * Producing {@link Terminator}s
 */
public class TerminatorFactory 
{
	/**
     * @return a new HK-Scout model with 500 health
	 */
	public TheTerminator newHKScount(){
	return new TheTerminatorBuilder( DestructionModes.NONE )
		.model("HK-Scout")
		.health(500)
		.build();
	}

    /**
     * @return a new T800 model with the specified fighting and 100 health
     * @see DestructionModes
     */
    public TheTerminator newT800(DestructionMode method){
    return new TheTerminatorBuilder( method ).build();
    }
    
    /**
     * @param method
     * @return a new T1000 model with the specified fighting and 
     * 1000 health
     * @see DestructionModes
     */
    public TheTerminator newT1000(DestructionMode method) 
    {
    return new TheTerminatorBuilder( method )
        .model("T1000")
        .health(1000)
        .build();
    }
}
