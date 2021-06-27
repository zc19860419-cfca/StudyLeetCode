package com.study.leetCode.binarySearch;

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
public class SingleNumberSolution260Test {

    private SingleNumberSolution260 solution260;

    @Before
    public void setUp() throws Exception {
        solution260 = new SingleNumberSolution260();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void singleNumber1() {
        int[] nums = new int[]{1, 2, 1, 3, 2, 5};
        int[] singleNumbers = solution260.singleNumber(nums);
        System.out.println(Arrays.toString(singleNumbers));
        int[] expected = new int[]{5, 3};
        Assert.assertTrue(Arrays.equals(expected, singleNumbers));
    }

    @Test
    public void singleNumber2() {
        int[] nums = new int[]{-1, 0};
        int[] singleNumbers = solution260.singleNumber(nums);
        System.out.println(Arrays.toString(singleNumbers));
        int[] expected = new int[]{0, -1};
        Assert.assertTrue(Arrays.equals(expected, singleNumbers));
    }

    @Test
    public void singleNumber3() {
        int[] nums = new int[]{0, 1};
        int[] singleNumbers = solution260.singleNumber(nums);
        int[] expected = new int[]{0, 1};
        Assert.assertTrue(Arrays.equals(expected, singleNumbers));
    }
}