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
 * All available {@link RobotMethod}s
 * 
 * @author Markos Charatzas [http://forrst.me/Cue]
 * @date Mar 14, 2011
 */
public class RobotMethods
{
    /**
     * Encapsulates the {@link Robot#log(String)}
     */
    private static final class MessageMethod implements RobotMethod
    {
        private final String message;

        /**
         * @param message
         */
        private MessageMethod(String message)
        {
            this.message = message;
        }

        @Override
        public void execute(Robot robot) {
            robot.log(this.message);
        }
    }

    /**
     * Encapsulates the {@link Robot#alert()} method
     */
    private static final class AlertMethod implements RobotMethod
    {
        @Override
        public void execute(Robot robot) {
            robot.alert();
        }
    }

    /**
     * Encapsulates the {@link Robot#move(int, int)} method
     */
    private static final class MoveMethod implements RobotMethod
    {
        private final int y;
        private final int x;

        /**
         * @param y
         * @param x
         */
        private MoveMethod(int y, int x)
        {
            this.y = y;
            this.x = x;
        }

        @Override
        public void execute(Robot robot) {
            robot.move(this.x, this.y);
        }
    }

    /**
     * @param x
     * @param y
     * @return a {@link RobotMethod} that makes a robot move to the specified coordinates
     * @see Robot#move(int, int)
     */
    public static RobotMethod newMove(int x, int y) {
    return new MoveMethod(y, x);
    }

    /**
     * @return a {@link RobotMethod} that makes a robot alert
     * @see Robot#alert()
     */
    public static RobotMethod newAlert() {
    return new AlertMethod();
    }

    /**
     * @param message the message to display
     * @return a {@link RobotMethod} that makes a robot display the specified message
     * @see Robot#log(String)
     */
    public static RobotMethod newMessage(String message) {
    return new MessageMethod(message);
    }
}
