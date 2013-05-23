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
package com.qnoid.java.ty2J.dont;

import junit.framework.Assert;

import org.junit.Test;

import com.qnoid.java.ty2J.dont.IndecisiveDragon;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date 30 Aug 2010
 * 
 * 
 */
public class IndecisiveDragonTest
{
    private static final int FIRE_DAMAGE = 30;
    private static final int POISON_DAMAGE = 50;

    @Test
    public void breath() throws Exception
    {
        IndecisiveDragon harmlessDragon = new IndecisiveDragon();
        IndecisiveDragon fireDragon = new IndecisiveDragon(IndecisiveDragon.FIRE_BREATH, FIRE_DAMAGE);
        IndecisiveDragon poisonDragon = new IndecisiveDragon(IndecisiveDragon.POISON_BREATH, POISON_DAMAGE);
        
        Assert.assertEquals(0, harmlessDragon.breathe());
        Assert.assertEquals(FIRE_DAMAGE, fireDragon.breathe());
        Assert.assertEquals(POISON_DAMAGE, poisonDragon.breathe());
    }
}
