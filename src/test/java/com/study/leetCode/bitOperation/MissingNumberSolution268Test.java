package com.study.leetCode.bitOperation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MissingNumberSolution268Test {

    private MissingNumberSolution268 solution268;

    @Before
    public void setUp() throws Exception {
        solution268 = new MissingNumberSolution268();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void missingNumber() {
        int[] nums = new int[]{0, 1, 3};
        solution268.missingNumber(nums);
    }

    @Test
    public void test() {
        int missing = 7;
        System.out.println(Integer.toBinaryString(missing));

        int i = 1;
        int j = 3;
        missing ^= i ^ j;
        System.out.println(Integer.toBinaryString(missing));

        missing = 7;
        missing ^= (i ^ j);
        System.out.println(Integer.toBinaryString(missing));
    }
}