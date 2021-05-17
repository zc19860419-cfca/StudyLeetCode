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
public class DecodeWaysSolution91Test {

    private DecodeWaysSolution91 solution91;

    @Before
    public void setUp() throws Exception {
        solution91 = new DecodeWaysSolution91();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void numDecodings1() {
        Assert.assertEquals(2, solution91.numDecodings("11106"));
    }

    @Test
    public void numDecodings2() {
        Assert.assertEquals(2, solution91.numDecodings("12"));
    }

    @Test
    public void numDecodings3() {
        Assert.assertEquals(3, solution91.numDecodings("226"));
    }


    @Test
    public void numDecodings4() {
        Assert.assertEquals(0, solution91.numDecodings("0"));
    }


    @Test
    public void numDecodings5() {
        Assert.assertEquals(0, solution91.numDecodings("06"));
    }
}