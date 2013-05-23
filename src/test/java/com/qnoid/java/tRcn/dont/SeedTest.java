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
package com.qnoid.java.tRcn.dont;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.qnoid.java.tRcn.*;
import com.qnoid.java.tRcn.dont.Seeds;


/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Feb 1, 2011
 */
public class SeedTest
{
    private static final Seed MELON = Seed.MELON;
    private static final int SEEDS_PER_MELON = MELON.noOfSeeds();

    @Test
    public void seedsIn() throws Exception
    {
        int noOfMelons = 5;
        int noOfBoxes = 2;
        
        List<Fruit> melons = Fruits.nFruits( noOfMelons, Fruits.newFruit(MELON) );        
        List<Box> boxes = Boxes.of( melons ).times(noOfBoxes);        
        
        List<Seed> seeds = Seeds.in(boxes);
        
        Assert.assertEquals(noOfBoxes, boxes.size());
        Assert.assertEquals(noOfBoxes * noOfMelons * SEEDS_PER_MELON, seeds.size());
    }
}
