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
package com.qnoid.java.t11z;

import java.util.EnumMap;

/**
 * @author Markos Charatzas [http://forrst.me/Cue]
 * Smooth sailing
 */
public class CruiseLiner
{
    /**
     * 
     */
    private static final String UNKNOWN_DESTINATION = 
        "There is no destination in the direction '%s'. " +
        "Did you specify it as such in CruiseLiner#newCruiseLiner " +
        "when constructing the cruise liner?";

    /**
     * Create a new {@link CruiseLiner} which is able to sail to the specified
     * destinations
     *  
     * @param destinations the destinations to set sail
     * @return a new {@link CruiseLiner}
     * @see Destinations
     */
    public static CruiseLiner newCruiseLiner(Destination... destinations)
    {
        EnumMap<Direction, Destination> map = 
            new EnumMap<Direction, Destination>(Direction.class);
        
        for (Destination destination : destinations){
            map.put(destination.direction(), destination);
        }
        
    return new CruiseLiner(map);
    }
    
    /*
     * A map by direction for each destination 
     */
    private final EnumMap<Direction, Destination> map;
    
    /**
     * @param map
     */
    private CruiseLiner(EnumMap<Direction, Destination> map)
    {
        this.map = map;
    }

    public void sail(Direction direction)
    {
        Destination destination = this.map.get(direction);
        
        if(destination == null){
            throw new UnknownDestination(
                    String.format(UNKNOWN_DESTINATION, direction));
        }
        
        destination.sail(this);
    }
}
