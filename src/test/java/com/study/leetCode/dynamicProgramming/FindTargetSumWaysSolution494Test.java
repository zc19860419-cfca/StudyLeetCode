package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class FindTargetSumWaysSolution494Test {

    private FindTargetSumWaysSolution494 solution;

    @Before
    public void setUp() throws Exception {
        solution = new FindTargetSumWaysSolution494();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findTargetSumWays_backtrack() {
//        输入：nums: [1, 1, 1, 1, 1], S: 3
//        输出：5
        int[] nums = new int[]{1, 1, 1, 1, 1};
        Assert.assertEquals(5, solution.findTargetSumWays_backtrack(nums, 3));
    }
}