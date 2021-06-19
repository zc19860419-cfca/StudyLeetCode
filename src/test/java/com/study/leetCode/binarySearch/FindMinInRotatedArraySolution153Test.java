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
public class FindMinInRotatedArraySolution153Test {

    private FindMinInRotatedArraySolution153 solution153;

    @Before
    public void setUp() throws Exception {
        solution153 = new FindMinInRotatedArraySolution153();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMin() {
        int[] nums1 = new int[]{3, 4, 5, 1, 2};
        Assert.assertEquals(1, solution153.findMin(nums1));

        int[] nums2 = new int[]{4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(0, solution153.findMin(nums2));

        int[] nums3 = new int[]{11, 13, 15, 17};
        Assert.assertEquals(11, solution153.findMin(nums3));
    }

}