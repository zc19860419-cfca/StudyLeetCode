package com.study.leetCode.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class KokoEatingBananasSolution875Test {

    private KokoEatingBananasSolution875 solution875;

    @Before
    public void setUp() throws Exception {
        solution875 = new KokoEatingBananasSolution875();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minEatingSpeed() {
        int[] piles1 = new int[]{3, 6, 7, 11};
        Assert.assertEquals(4, solution875.minEatingSpeed(piles1, 8));

        int[] piles2 = new int[]{30, 11, 23, 4, 20};
        Assert.assertEquals(30, solution875.minEatingSpeed(piles2, 5));

        int[] piles3 = new int[]{30, 11, 23, 4, 20};
        Assert.assertEquals(23, solution875.minEatingSpeed(piles3, 6));
    }
}