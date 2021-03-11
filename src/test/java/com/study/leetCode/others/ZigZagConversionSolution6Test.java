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
public class ZigZagConversionSolution6Test {

    private ZigZagConversionSolution6 solution;

    @Before
    public void setUp() throws Exception {
        solution = new ZigZagConversionSolution6();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convert1() {
        Assert.assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void convert2() {
        Assert.assertEquals("AB", solution.convert("AB", 1));
    }
}