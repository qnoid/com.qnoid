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
package com.forrst.java.t11z;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * Constant destinations with each specifying its required dependencies
 */
public class Destinations
{
    public static final Destination NORTH_AMERICA = new Destination() 
    {
        private final WallStreet wallstreet = new WallStreet();

        @Override
        public void sail(CruiseLiner cruiseLiner)
        {
            wallstreet.moneyNeverSleeps();
        }

        @Override
        public Direction direction() {
        return Direction.NORTH;
        }
    };
    
    public static final Destination SOUTH_AFRICA = new Destination() {
        
        private final Pharaoh pharaoh = new Pharaoh();

        @Override
        public void sail(CruiseLiner cruiseLiner)
        {
            pharaoh.curse();
        }

        @Override
        public Direction direction() {
        return Direction.SOUTH;
        }
    };
    
    public static final Destination MIDDLE_EAST = new Destination() {
        
        private final Oilwell oilwell = new Oilwell();

        @Override
        public void sail(CruiseLiner cruiseLiner)
        {
            oilwell.drill();
        }

        @Override
        public Direction direction() {
        return Direction.EAST;
        }
    };
    
    public static final Destination GREAT_WEST = new Destination() {
        
        private final Cowboy[] cowboys = new Cowboy[]{new Cowboy()};

        @Override
        public void sail(CruiseLiner cruiseLiner)
        {
            for (Cowboy cowboy : this.cowboys) {
                cowboy.shoot();
            }
        }

        @Override
        public Direction direction() {
        return Direction.WEST;
        }
    };
}
