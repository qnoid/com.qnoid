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
package com.qnoid.java.t1Jc;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Jan 14, 2011
 * 
 * The menacing terminator
 *
 */
public class TheTerminator implements Terminator
{
    /**
     * model = T800
     * health = 100
     */
    public static class TheTerminatorBuilder
    {
        private String model = "T800";
        private int health = 100;
        private DestructionMode destructionMode;
        
        public TheTerminatorBuilder(DestructionMode destructionMode)
        {
            this.destructionMode = destructionMode;
        }

        public TheTerminatorBuilder model(String model)
        {
            this.model = model;
        return this; 
        }

        public TheTerminatorBuilder health(int health)
        {
            this.health = health;
        return this; 
        }

        public TheTerminator build(){
        return new TheTerminator(this.model, this.destructionMode, this.health);
        }        
    }
    
    private final String model;
    private final DestructionMode destructionMode;
    private int health;
    
    private TheTerminator(String model, DestructionMode destructionMode, int health)
    {
        this.model = model;
        this.health = health;
        this.destructionMode = destructionMode;
    }

    @Override
    public boolean destroy(Terminator terminator) {
    return this.destructionMode.destroy(terminator);
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
