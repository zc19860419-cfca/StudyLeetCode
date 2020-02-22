package com.study.leetCode.binarySearch.sqrt;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SqrtSolutionTest {

    private SqrtSolution sqrtSolution;

    @Before
    public void setUp() throws Exception {
        sqrtSolution = new SqrtSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        int right = 3;
        int left = 2;
        System.out.println(left + ((right - left) >> 1));
    }

    @Test
    public void mySqrt1() {
        final int sqrt = sqrtSolution.mySqrt(4);
        Assert.assertEquals(2, sqrt);
    }

    @Test
    public void mySqrt2() {
        final int sqrt = sqrtSolution.mySqrt(8);
        Assert.assertEquals(2, sqrt);
    }

    @Test
    public void mySqrt3() {
        final int sqrt = sqrtSolution.mySqrt(2147395599);
        Assert.assertEquals(46339, sqrt);
    }

    @Test
    public void mySqrt4() {
        final int sqrt = sqrtSolution.mySqrt(0);
        Assert.assertEquals(0, sqrt);
    }

    @Test
    public void mySqrt5() {
        final int sqrt = sqrtSolution.mySqrt(2147483647);
        Assert.assertEquals(46340, sqrt);
    }

    @Test
    public void mySqrt6() {
        System.out.println(sqrtSolution.mySqrt(2));
    }

}