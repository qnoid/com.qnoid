package com.forrst.java.ty2J;

import junit.framework.Assert;

import org.junit.Test;


/**
 * Here be dragons
 */
public class MightyDragonTest
{
    @Test
    public void breath() throws Exception
    {
        MightyDragon harmlessDragon = new MightyDragon(Breaths.NO_BREATH);
        MightyDragon fireDragon = new MightyDragon(Breaths.FIRE_BREATH);
        MightyDragon poisonDragon = new MightyDragon(Breaths.POISON_BREATH);
        MightyDragon heavyFireDragon = new MightyDragon(Breaths.newHeavyFireBreath());
        
        Assert.assertEquals(0, harmlessDragon.breathe());
        Assert.assertEquals(30, fireDragon.breathe());
        Assert.assertEquals(50, poisonDragon.breathe());
        Assert.assertEquals(20, heavyFireDragon.breathe());
        Assert.assertEquals(40, heavyFireDragon.breathe());
        Assert.assertEquals(60, heavyFireDragon.breathe());
        
        MightyDragon anotherHeavyFireDragon = new MightyDragon(Breaths.newHeavyFireBreath());
        Assert.assertEquals(20, anotherHeavyFireDragon.breathe()); // Fails

    }
}
