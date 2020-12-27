package com.study.leetCode.others;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MovezerosSolutionTest {

    MovezerosSolution movezerosSolution;

    @Before
    public void setUp() throws Exception {
        movezerosSolution = new MovezerosSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void moveZeroes() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] exp = new int[]{1, 3, 12, 0, 0};
        movezerosSolution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        Assert.assertArrayEquals(exp, nums);
    }
}