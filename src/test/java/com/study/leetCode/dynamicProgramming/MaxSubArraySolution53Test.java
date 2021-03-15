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
public class MaxSubArraySolution53Test {

    private MaxSubArraySolution53 solution;

    @Before
    public void setUp() throws Exception {
        solution = new MaxSubArraySolution53();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxSubArray1() {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Assert.assertEquals(6, solution.maxSubArray(nums));
    }
}