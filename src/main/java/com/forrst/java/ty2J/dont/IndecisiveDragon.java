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
package com.forrst.java.ty2J.dont;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date 30 Aug 2010
 * A lame dragon that can't make up his mind
 */
public class IndecisiveDragon
{
    public static final int FIRE_BREATH = 0;
    public static final int POISON_BREATH = 1;

    /*
     * Should be final but the default constructor forces us to forfeit
     */
    private int breath;
    private int damage;
    
    /**
     * Avoid naive constructor!
     * Forces breath and damage not to be final, and doesn't specify reasonable defaults.
     * Also, fails to show intend. What's a dragon without its breath?
     */
    public IndecisiveDragon(){}

    /**
     * @param breath which type of breath the dragon shall deal 
     * @param damage how much damage the breath should deal
     * @see #FIRE_BREATH
     * @see #POISON_BREATH
     */
    public IndecisiveDragon(int breath, int damage)
    {
        this.breath = breath;
        this.damage = damage;
    }
    
    /**
     * Rain chaos with just a breath  
     * @return the damage dealt by the dragon
     */
    public int breathe()
    {
        /*
         * Picture this as an if doing String comparisons and it only gets worse
         */
        switch (this.breath)
        {
        case FIRE_BREATH:
            System.out.println( String.format("Casting mighty fire dealing %d damage", this.damage) );
        return this.damage;            
        case POISON_BREATH:
            System.out.println( String.format("Unleasing poison dealing %d damage", this.damage) );
        return this.damage;            
        default:
            System.out.println("Pants...Dealing no damage"); 
        return 0;
        }
    }
}
