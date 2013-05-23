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
package com.qnoid.java.ttrj;

import junit.framework.Assert;

import org.junit.Test;


/**
 * Let's track some robots
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 14, 2011
 */
public class BugTest
{
    private final RobotTracker robotTracker = 
        new RobotTracker();
    
    private final RobotFactory robotFactory = 
        new RobotFactory(this.robotTracker);
    
    @Test
    public void playbackOn() throws Exception
    {
        final String message = "Hello";
        final int x = 1;
        final int y = 1;
        
        Robot buggedRobot = this.robotFactory.newRobot();
        
        buggedRobot.alert();
        buggedRobot.log(message);
        buggedRobot.move(x, y);
                
        Bug bug = this.robotTracker.latestBug();
        
        RobotImpl mimic = new RobotImpl();        
        bug.playbackOn(mimic);
        
        Assert.assertEquals(message, mimic.log());
        Assert.assertEquals(x, mimic.x());
        Assert.assertEquals(y, mimic.y());
    }
}
