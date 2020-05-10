package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class CoinChangeSolutionTest {

    private CoinChangeSolution coinChangeSolution;

    @Before
    public void setUp() throws Exception {
        coinChangeSolution = new CoinChangeSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void coinChange() {
        Assert.assertEquals(3, coinChangeSolution.coinChange(new int[]{1, 2, 5}, 11));
    }
}