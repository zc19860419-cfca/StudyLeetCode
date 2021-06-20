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
public class SmallestDivisorSolution1283Test {

    private SmallestDivisorSolution1283 solution1283;

    @Before
    public void setUp() throws Exception {
        solution1283 = new SmallestDivisorSolution1283();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void smallestDivisor1() {
        int[] nums = new int[]{1, 2, 5, 9};
        int threshold = 6;
        Assert.assertEquals(5, solution1283.smallestDivisor(nums, threshold));
    }

    @Test
    public void smallestDivisor2() {
        int[] nums = new int[]{2, 3, 5, 7, 11};
        int threshold = 11;
        Assert.assertEquals(3, solution1283.smallestDivisor(nums, threshold));
    }

    @Test
    public void smallestDivisor3() {
        int[] nums = new int[]{19};
        int threshold = 5;
        Assert.assertEquals(4, solution1283.smallestDivisor(nums, threshold));
    }
}