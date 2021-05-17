package com.study.leetCode.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class MinSubArrayLenSolution209Test {

    private MinSubArrayLenSolution209 solution;

    @Before
    public void setUp() throws Exception {
        solution = new MinSubArrayLenSolution209();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minSubArrayLen1() {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        Assert.assertEquals(2, solution.minSubArrayLen(target, nums));
    }
}