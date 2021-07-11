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
public class IntegerReplacementSolution397Test {

    private IntegerReplacementSolution397 solution397;

    @Before
    public void setUp() throws Exception {
        solution397 = new IntegerReplacementSolution397();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void integerReplacement() {
        Assert.assertEquals(3, solution397.integerReplacement(8));
        Assert.assertEquals(4, solution397.integerReplacement(7));
        Assert.assertEquals(2, solution397.integerReplacement(4));
    }

    @Test
    public void integerReplacement1() {
        Assert.assertEquals(32, solution397.integerReplacement(2147483647));
    }
}