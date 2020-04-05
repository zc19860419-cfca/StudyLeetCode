package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MaxProductSolutionTest {

    private MaxProductSolution maxProductSolution;

    @Before
    public void setUp() throws Exception {
        maxProductSolution = new MaxProductSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxProduct() {
        Assert.assertEquals(6, maxProductSolution.maxProduct(new int[]{2, 3, -2, 4}));
    }
}