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
public class PeakIndexInMountainArraySolution852Test {

    private PeakIndexInMountainArraySolution852 solution852;

    @Before
    public void setUp() throws Exception {
        solution852 = new PeakIndexInMountainArraySolution852();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void peakIndexInMountainArray() {
        int[] arr1 = new int[]{0, 1, 0};
        Assert.assertEquals(1, solution852.peakIndexInMountainArray(arr1));

        int[] arr2 = new int[]{0, 2, 1, 0};
        Assert.assertEquals(1, solution852.peakIndexInMountainArray(arr2));

        int[] arr3 = new int[]{0, 10, 5, 2};
        Assert.assertEquals(1, solution852.peakIndexInMountainArray(arr3));

        int[] arr4 = new int[]{3, 4, 5, 1};
        Assert.assertEquals(2, solution852.peakIndexInMountainArray(arr4));

        int[] arr5 = new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        Assert.assertEquals(2, solution852.peakIndexInMountainArray(arr5));
    }
}