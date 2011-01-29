/*
 *	This file is under the licence Attribution-ShareAlike 3.0 Unported 
 *	(CC BY-SA 3.0) http://creativecommons.org/licenses/by-sa/3.0/
 *
 *	You are free:
 *		to Share � to copy, distribute and transmit the work
 *		to Remix � to adapt the work
 *
 *	Under the following conditions:
 *
 *	Attribution � You must attribute the work in the manner specified by the 
 *	author or licensor (but not in any way that suggests that they endorse you 
 *	or your use of the work).
 *	
 *	Share Alike � If you alter, transform, or build upon this work, you may 
 *	distribute the resulting work only under the same or similar license to 
 *	this one.
 *
 *	With the understanding that:
 *
 *	Waiver � Any of the above conditions can be waived if you get permission 
 *	from the copyright holder.
 *
 *	Public Domain � Where the work or any of its elements is in the public 
 *	domain under applicable law, that status is in no way affected by the 
 *	license.
 *
 *	Other Rights � In no way are any of the following rights affected by the 
 *	license:
 *	Your fair dealing or fair use rights, or other applicable copyright 
 *	exceptions and limitations;
 *
 *	The author's moral rights;
 *	Rights other persons may have either in the work itself or in how the work 
 *	is used, such as publicity or privacy rights.
 *
 */
package com.forrst.java.t1Jc.dont;

import com.forrst.java.t1Jc.Punch;
import com.forrst.java.t1Jc.Terminator;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 14, 2011
 * 
 * Can only give punches
 */
public class StiffTerminator implements Terminator
{
    private final String model;
    
    /*
     * Is that the only thing a terminator can fight with?
     */
    private final Punch punch;
    private int health;
    
    /*
     * Forced 'protected' by the fact that we need to extend the 
     * {@link #fight(Terminator)} method
     */
    protected StiffTerminator(String model, Punch punch, int health)
    {
        this.model = model;
        this.health = health;
        this.punch = punch;
    }

    /*
     * Will need to accommodate for a change in the destruction
     */
    @Override
    public boolean destroy(Terminator terminator) {
    return this.punch.punch(terminator);
    }
    
    @Override
    public int health(){
    return this.health;
    }

    @Override
    public boolean damageBy(int damage) 
    {
        this.health -= damage;
        
    return this.isTerminated();
    }
    
    @Override
    public boolean isTerminated() {
    return this.health <= 0;
    }    

    @Override
    public String toString() {
    return this.model;
    }
}
