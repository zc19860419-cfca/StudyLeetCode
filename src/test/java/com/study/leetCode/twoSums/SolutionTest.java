package com.study.leetCode.twoSums;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void twoSum1() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        final int[] results = solution.twoSum(nums, target);
        Assert.assertEquals(1, results[0]);
        Assert.assertEquals(2, results[1]);
    }

    @Test
    public void twoSum1_1() {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        final int[] results = solution.twoSum1(nums, target);
        Assert.assertEquals(1, results[0]);
        Assert.assertEquals(2, results[1]);
    }

    @Test
    public void twoSum2() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        final int[] results = solution.twoSum(nums, target);
        Assert.assertEquals(0, results[0]);
        Assert.assertEquals(1, results[1]);
    }
}