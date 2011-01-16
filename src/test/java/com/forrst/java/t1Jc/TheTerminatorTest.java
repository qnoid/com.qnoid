/*
 *	This file is under the licence Attribution-ShareAlike 3.0 Unported 
 *	(CC BY-SA 3.0) http://creativecommons.org/licenses/by-sa/3.0/
 *
 *	You are free:
 *		to Share Ñ to copy, distribute and transmit the work
 *		to Remix Ñ to adapt the work
 *
 *	Under the following conditions:
 *
 *	Attribution Ñ You must attribute the work in the manner specified by the 
 *	author or licensor (but not in any way that suggests that they endorse you 
 *	or your use of the work).
 *	
 *	Share Alike Ñ If you alter, transform, or build upon this work, you may 
 *	distribute the resulting work only under the same or similar license to 
 *	this one.
 *
 *	With the understanding that:
 *
 *	Waiver Ñ Any of the above conditions can be waived if you get permission 
 *	from the copyright holder.
 *
 *	Public Domain Ñ Where the work or any of its elements is in the public 
 *	domain under applicable law, that status is in no way affected by the 
 *	license.
 *
 *	Other Rights Ñ In no way are any of the following rights affected by the 
 *	license:
 *	Your fair dealing or fair use rights, or other applicable copyright 
 *	exceptions and limitations;
 *
 *	The author's moral rights;
 *	Rights other persons may have either in the work itself or in how the work 
 *	is used, such as publicity or privacy rights.
 *
 */
package com.forrst.java.t1Jc;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.t1Jc.Punches;
import com.forrst.java.t1Jc.Skynet;
import com.forrst.java.t1Jc.TheTerminator;


/**
 * @author Markos Charatzas [http://forrst.com/people/Cue]
 * @date Jan 14, 2011
 *
 */
public class TheTerminatorTest
{
    private static final Skynet SKYNET = Skynet.instance();

    @Test
    public void fight() throws Exception
    {
        TheTerminator t800 = SKYNET.newT800(Punches.WEAK);        
        TheTerminator t1000 = SKYNET.newT1000(Punches.STRONG);
        TheTerminator hkScout = SKYNET.newHKScount();
        
        Assert.assertFalse( 
                String.format("Terminator '%s' is destroyed by '%s'", t1000, t800), 
                t800.destroy(t1000)
                );
        
        Assert.assertTrue( 
                String.format("Terminator '%s' not destroyed by %s", t800, t1000), 
                t1000.destroy(t800)
                );
        
        Assert.assertFalse( 
        		String.format("Terminator '%s' not destroyed by %s", t800, hkScout), 
        		hkScout.destroy(t800)
        );
        
        Assert.assertFalse( 
        		"Terminator shouldn't be destroyed", 
        		hkScout.destroy(t800)
        );
    }
}
