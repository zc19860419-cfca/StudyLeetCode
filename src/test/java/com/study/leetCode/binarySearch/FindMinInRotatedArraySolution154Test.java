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
public class FindMinInRotatedArraySolution154Test {

    private FindMinInRotatedArraySolution154 solution154;

    @Before
    public void setUp() throws Exception {
        solution154 = new FindMinInRotatedArraySolution154();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMin() {
        int[] nums1 = new int[]{1, 3, 5};
        Assert.assertEquals(1, solution154.findMin(nums1));

        int[] nums2 = new int[]{2, 2, 2, 0, 1};
        Assert.assertEquals(0, solution154.findMin(nums2));
    }
}