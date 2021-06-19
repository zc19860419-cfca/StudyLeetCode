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
public class SearchInRotatedArraySolution81Test {

    private SearchInRotatedArraySolution81 solution81;

    @Before
    public void setUp() throws Exception {
        solution81 = new SearchInRotatedArraySolution81();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search() {
        int[] nums1 = {2, 5, 6, 0, 0, 1, 2};
        Assert.assertTrue(solution81.search(nums1, 0));

        int[] nums2 = {2, 5, 6, 0, 0, 1, 2};
        Assert.assertFalse(solution81.search(nums2, 3));
    }


    @Test
    public void search1() {
        int[] nums1 = {1, 0, 1, 1, 1};
        Assert.assertTrue(solution81.search(nums1, 0));

    }
}