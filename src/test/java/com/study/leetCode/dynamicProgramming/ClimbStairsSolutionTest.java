package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ClimbStairsSolutionTest {

    private ClimbStairsSolution climbStairsSolution;

    @Before
    public void setUp() throws Exception {
        climbStairsSolution = new ClimbStairsSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void climbStairs() {
        Assert.assertEquals(2, climbStairsSolution.climbStairs(2));
        Assert.assertEquals(3, climbStairsSolution.climbStairs(3));
    }
}