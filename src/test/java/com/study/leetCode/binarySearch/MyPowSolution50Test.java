package com.study.leetCode.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MyPowSolution50Test {

    private MyPowSolution50 solution;

    @Before
    public void setUp() throws Exception {
        solution = new MyPowSolution50();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void myPow1() {
        Assert.assertEquals(1024.00000, solution.myPow(2.00000, 10), 0.0);
    }

    @Test
    public void myPow2() {
        Assert.assertEquals(9.26100, solution.myPow(2.10000, 3), 0.0001);
    }

    @Test
    public void myPow3() {
        Assert.assertEquals(0.25000, solution.myPow(2.00000, -2), 0.0001);
    }
}