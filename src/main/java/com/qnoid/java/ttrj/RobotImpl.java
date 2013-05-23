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
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 14, 2011
 */
public final class RobotImpl implements Robot
{
    private final StringBuilder log = new StringBuilder();
    private int x;
    private int y;
    
    public int x() {
    return x;
    }

    public int y() {
    return y;
    }
    
    /**
     * @return the current log as written by {@link #log(String)}
     */
    public String log(){
    return this.log.toString();
    }
    
    @Override
    public void alert() {
        System.out.println("Beep! Beep!");
    }

    @Override
    public void log(String message) {
        this.log.append(message);        
    }

    @Override
    public void move(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
}
