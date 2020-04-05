package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MaxProfitAnySolutionTest {

    private MaxProfitAnySolution maxProfitAnySolution;

    @Before
    public void setUp() throws Exception {
        maxProfitAnySolution = new MaxProfitAnySolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxProfit() {
        Assert.assertEquals(7, maxProfitAnySolution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}