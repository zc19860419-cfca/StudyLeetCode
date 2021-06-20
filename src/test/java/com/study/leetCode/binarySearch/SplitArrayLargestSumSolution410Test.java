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
public class SplitArrayLargestSumSolution410Test {

    private SplitArrayLargestSumSolution410 solution410;

    @Before
    public void setUp() throws Exception {
        solution410 = new SplitArrayLargestSumSolution410();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void splitArray() {
        int[] nums1 = new int[]{7, 2, 5, 10, 8};
        Assert.assertEquals(18, solution410.splitArray(nums1, 2));

        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        Assert.assertEquals(9, solution410.splitArray(nums2, 2));

        int[] nums3 = new int[]{1, 4, 4};
        Assert.assertEquals(4, solution410.splitArray(nums3, 3));
    }
}