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
public class RangeBitwiseAndSolution201Test {

    private RangeBitwiseAndSolution201 solution201;

    @Before
    public void setUp() throws Exception {
        solution201 = new RangeBitwiseAndSolution201();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void rangeBitwiseAnd() {
        int m = 9, n = 12;
        Assert.assertEquals(8, solution201.rangeBitwiseAnd(m, n));
    }
}