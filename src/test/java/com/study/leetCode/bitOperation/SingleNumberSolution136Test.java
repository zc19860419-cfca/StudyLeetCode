package com.study.leetCode.bitOperation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SingleNumberSolution136Test {

    private SingleNumberSolution136 solution136;

    @Before
    public void setUp() throws Exception {
        solution136 = new SingleNumberSolution136();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void singleNumber1() {
        int[] nums = new int[]{2, 2, 1};
        Assert.assertEquals(1, solution136.singleNumber(nums));
    }

    @Test
    public void singleNumber2() {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        Assert.assertEquals(4, solution136.singleNumber(nums));
    }
}