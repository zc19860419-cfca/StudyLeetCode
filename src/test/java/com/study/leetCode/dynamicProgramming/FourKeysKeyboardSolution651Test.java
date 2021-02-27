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
public class FourKeysKeyboardSolution651Test {

    private FourKeysKeyboardSolution651 solution;

    @Before
    public void setUp() throws Exception {
        solution = new FourKeysKeyboardSolution651();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxA1() {
        Assert.assertEquals(3, solution.maxA(3));
    }

    @Test
    public void maxA2() {
        Assert.assertEquals(9, solution.maxA(7));
    }
}