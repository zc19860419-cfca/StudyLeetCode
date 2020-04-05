package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MaxProfitTwiceSolutionTest {

    private MaxProfitTwiceSolution maxProfitTwiceSolution;

    @Before
    public void setUp() throws Exception {
        maxProfitTwiceSolution = new MaxProfitTwiceSolution();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxProfit1() {
        Assert.assertEquals(6, maxProfitTwiceSolution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    @Test
    public void maxProfit2() {
        Assert.assertEquals(4, maxProfitTwiceSolution.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}