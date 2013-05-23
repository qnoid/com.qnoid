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


/**
 * Keeps track of the every {@link Robot} created using 
 * {@link RobotFactory#newRobot()} 
 * 
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 14, 2011
 */
final class RobotTracker
{
    private Bug bug;

    /**
     * Called when a new robot is created.
     * 
     * Holds only the bug to the last created robot
     * 
     * @param robot the robot that was created by {@link RobotFactory#newRobot()}
     * @return a bug tracking all methods executed on the specified robot
     */
    public Bug wasCreated(Robot robot) {
        
        this.bug = new Bug(robot);
        
    return bug;
    }

    /**
     * @return the bug for the last robot created 
     */
    public Bug latestBug(){
    return this.bug;
    }
}
