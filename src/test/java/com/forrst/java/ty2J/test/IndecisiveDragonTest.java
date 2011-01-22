package com.forrst.java.ty2J.test;

import junit.framework.Assert;

import org.junit.Test;

import com.forrst.java.ty2J.dont.IndecisiveDragon;


/**
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
