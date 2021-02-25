package com.study.leetCode.others;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ReverseIntegerSolution7Test {

    private ReverseIntegerSolution7 solution;

    @Before
    public void setUp() throws Exception {
        solution = new ReverseIntegerSolution7();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void reverse() {
        Assert.assertEquals(2, solution.reverse(20));
    }
}