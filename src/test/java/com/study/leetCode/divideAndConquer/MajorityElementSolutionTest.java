package com.study.leetCode.divideAndConquer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description
 */
public class MajorityElementSolutionTest {

    private MajorityElementSolution majorityElementSolution;

    @Before
    public void setUp() throws Exception {
        majorityElementSolution = new MajorityElementSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void majorityElement1() {
        int[] nums = new int[]{1, 3, 2, 3, 3, 4};
        final int majorityElement = majorityElementSolution.majorityElement(nums);
        System.out.println(majorityElement);
        Assert.assertEquals(3, majorityElement);
    }

    @Test
    public void majorityElement2() {
        int[] nums = new int[]{0, 1, 3, 2, 3, 4, 3, 4};
        final int majorityElement = majorityElementSolution.majorityElement(nums);
        System.out.println(majorityElement);
        Assert.assertEquals(3, majorityElement);
    }
}