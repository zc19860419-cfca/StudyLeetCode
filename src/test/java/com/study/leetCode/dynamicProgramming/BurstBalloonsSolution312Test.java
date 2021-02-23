package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class BurstBalloonsSolution312Test {

    private BurstBalloonsSolution312 solution;

    @Before
    public void setUp() throws Exception {
        solution = new BurstBalloonsSolution312();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxCoins1() {
        int[] nums = new int[]{3, 1, 5, 8};
        Assert.assertEquals(167, solution.maxCoins(nums));
    }

    @Test
    public void maxCoins2() {
        int[] nums = new int[]{1, 5};
        Assert.assertEquals(10, solution.maxCoins(nums));
    }

    @Test
    public void maxCoins3() {
        int[] nums = new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3};
        Assert.assertEquals(1654, solution.maxCoins(nums));
    }

}