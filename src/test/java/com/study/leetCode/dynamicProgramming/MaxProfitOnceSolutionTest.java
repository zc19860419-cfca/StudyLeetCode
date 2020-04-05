package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MaxProfitOnceSolutionTest {

    private MaxProfitOnceSolution maxProfitOnceSolution;

    @Before
    public void setUp() throws Exception {
        maxProfitOnceSolution = new MaxProfitOnceSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxProfit() {
        Assert.assertEquals(5, maxProfitOnceSolution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}