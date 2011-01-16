/*
 *	This file is under the licence Attribution-ShareAlike 3.0 Unported 
 *	(CC BY-SA 3.0) http://creativecommons.org/licenses/by-sa/3.0/
 *
 *	You are free:
 *		to Share Ñ to copy, distribute and transmit the work
 *		to Remix Ñ to adapt the work
 *
 *	Under the following conditions:
 *
 *	Attribution Ñ You must attribute the work in the manner specified by the 
 *	author or licensor (but not in any way that suggests that they endorse you 
 *	or your use of the work).
 *	
 *	Share Alike Ñ If you alter, transform, or build upon this work, you may 
 *	distribute the resulting work only under the same or similar license to 
 *	this one.
 *
 *	With the understanding that:
 *
 *	Waiver Ñ Any of the above conditions can be waived if you get permission 
 *	from the copyright holder.
 *
 *	Public Domain Ñ Where the work or any of its elements is in the public 
 *	domain under applicable law, that status is in no way affected by the 
 *	license.
 *
 *	Other Rights Ñ In no way are any of the following rights affected by the 
 *	license:
 *	Your fair dealing or fair use rights, or other applicable copyright 
 *	exceptions and limitations;
 *
 *	The author's moral rights;
 *	Rights other persons may have either in the work itself or in how the work 
 *	is used, such as publicity or privacy rights.
 *
 */
package com.forrst.java.t1Jc;


/**
 * @author Markos Charatzas [http://forrst.com/people/Cue]
 * @date Jan 14, 2011
 */
public class Skynet
{
    private static final Skynet INSTANCE = 
    	new Skynet( new TerminatorFactory() );

	/**
     * @return the one and only Skynet
     */
    public static Skynet instance() {
    return INSTANCE;
    }

	private TerminatorFactory terminatorFactory;
		
    /**
	 * @param terminatorFactory
	 */
	private Skynet(TerminatorFactory terminatorFactory) 
	{
		this.terminatorFactory = terminatorFactory;
	}

    /**
     * @param punch the punch
     * @return a new T800 terminator dealing punch damage with 100 health
     * @see Punch#newPunch(int)
     */
    public TheTerminator newT800(Punch punch) 
    {
        DestructionMode punching = DestructionModes.punch( punch );
        
    return this.terminatorFactory.newT800(punching);
    }
    
    /**
     * @param shotgun 
     * @return a new T800 terminator dealing shotgun damage with 100 health
     * @see Shotgun#newShotgun(Bullet...)
     */
    public TheTerminator newT800WithShotgun(Shotgun shotgun) 
    {
        DestructionMode shooting = DestructionModes.shotgun( shotgun );
        
    return this.terminatorFactory.newT800(shooting);
    }

    /**
     * @param punch
     * @return a new T1000 terminator doing 100 damage per fight with 1000 health
     */
    public TheTerminator newT1000(Punch punch) 
    {
        DestructionMode punching = DestructionModes.punch( punch );

    return this.terminatorFactory.newT1000(punching);
    }

	/**
	 * @return a new HK-Scout terminator with 500 health dealing no damage but 
	 * reporting any Terminator appearances 
	 */
	public TheTerminator newHKScount() {
	return this.terminatorFactory.newHKScount();
	}
}
