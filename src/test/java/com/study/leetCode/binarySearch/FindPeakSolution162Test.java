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
public class FindPeakSolution162Test {

    private FindPeakSolution162 solution;

    @Before
    public void setUp() throws Exception {
        solution = new FindPeakSolution162();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findPeakElement1() {
        int[] nums = new int[]{1, 2, 3, 1};
        Assert.assertEquals(2, solution.findPeakElement(nums));
    }

    @Test
    public void findPeakElement2() {
        int[] nums = new int[]{1, 2, 1, 3, 5, 6};
        Assert.assertTrue(1 == solution.findPeakElement(nums) || 5 == solution.findPeakElement(nums));
    }
}