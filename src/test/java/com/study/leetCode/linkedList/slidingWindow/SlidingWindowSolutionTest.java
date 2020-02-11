package com.study.leetCode.linkedList.slidingWindow;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SlidingWindowSolutionTest {

    private SlidingWindowSolution slidingWindowSolution;

    @Before
    public void setUp() throws Exception {
        slidingWindowSolution = new SlidingWindowSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxSlidingWindow() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        final int[] results = slidingWindowSolution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(results));
        Assert.assertEquals(6, results.length);
        Assert.assertEquals(3, results[0]);
        Assert.assertEquals(3, results[1]);
        Assert.assertEquals(5, results[2]);
        Assert.assertEquals(5, results[3]);
        Assert.assertEquals(6, results[4]);
        Assert.assertEquals(7, results[5]);
    }
}