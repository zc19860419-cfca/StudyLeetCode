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
public class ShipWithinDaysSolution1011Test {

    private ShipWithinDaysSolution1011 solution1011;

    @Before
    public void setUp() throws Exception {
        solution1011 = new ShipWithinDaysSolution1011();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shipWithinDays1() {
        int[] weights = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertEquals(15, solution1011.shipWithinDays(weights, 5));
    }

    @Test
    public void shipWithinDays2() {
        int[] weights = new int[]{3, 2, 2, 4, 1, 4};
        Assert.assertEquals(6, solution1011.shipWithinDays(weights, 3));
    }

    @Test
    public void shipWithinDays3() {
        int[] weights = new int[]{1, 2, 3, 1, 1};
        Assert.assertEquals(3, solution1011.shipWithinDays(weights, 4));
    }

    @Test
    public void shipWithinDays4() {
        int[] weights = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        Assert.assertEquals(10, solution1011.shipWithinDays(weights, 8));
    }

}