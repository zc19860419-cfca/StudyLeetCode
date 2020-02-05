package com.study.leetCode.threeSums;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ThreeSumsSolutionTest {

    private ThreeSumsSolution threeSumsSolution;

    @Before
    public void setUp() throws Exception {
        threeSumsSolution = new ThreeSumsSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void threeSum1() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        final List<List<Integer>> results = threeSumsSolution.threeSum(nums);
        System.out.println(results);
        Assert.assertEquals(2, results.size());
        final Integer[] int1 = {-1, -1, 2};
        final List<Integer> integers1 = Arrays.asList(int1);
        Assert.assertEquals(true, results.contains(integers1));

        final Integer[] int2 = {-1, 0, 1};
        final List<Integer> integers2 = Arrays.asList(int2);
        Assert.assertEquals(true, results.contains(integers2));
    }

    @Test
    public void threeSum2() {
        int[] nums = new int[]{0, 0, 0};
        final List<List<Integer>> results = threeSumsSolution.threeSum(nums);
        System.out.println(results);
        Assert.assertEquals(1, results.size());
        final Integer[] int1 = {0, 0, 0};
        final List<Integer> integers1 = Arrays.asList(int1);
        Assert.assertEquals(true, results.contains(integers1));
    }

    @Test
    public void threeSum3() {
        int[] nums = new int[]{1, 1, -2};
        final List<List<Integer>> results = threeSumsSolution.threeSum(nums);
        System.out.println(results);
        Assert.assertEquals(1, results.size());
        final Integer[] int1 = {-2, 1, 1};
        final List<Integer> integers1 = Arrays.asList(int1);
        Assert.assertEquals(true, results.contains(integers1));
    }

    @Test(timeout = 10)
    public void threeSum4Timeout() {
        int[] nums = new int[]{2, -8, 8, 6, -14, -12, 11, -10, 13, 14, 7, 3, 10, -13, 3, -15, 7, 3, -11, -8, 4, 5, 9, 11, 7, 1, 3, 13, 14, -13, 3, -6, -6, -12, -15, -12, -9, 3, -15, -11, -6, -1, 0, 11, 2, -12, 3, -6, 6, 0, -6, -12, -10, -12, 6, 5, -4, -5, -5, -4, -11, 13, 5, -2, -13, -3, -7, -15, 8, -15, 12, -13, 0, -3, 6, 9, -8, -6, 10, 5, 9, -11, 0, 7, -15, -8, -3, -4, -6, 7, 7, -2, -2, -11, 3, 0, -6, 12, 0, -13, 4, -3, 11, -11, 1, 2, 13, 8, 4, 9, -1, -2, 5, 14, 12, 5, 13, -6, -13, -8, 9, 1, 5, -8, -2, -6, -1};
        final List<List<Integer>> results = threeSumsSolution.threeSum(nums);
        System.out.println(results.size() + "=" + results);
        Assert.assertEquals(119, results.size());
    }

}