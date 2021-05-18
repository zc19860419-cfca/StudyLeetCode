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
public class isInterleaveSolution97Test {

    private isInterleaveSolution97 solution97;

    @Before
    public void setUp() throws Exception {
        solution97 = new isInterleaveSolution97();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isInterleave1() {
        Assert.assertTrue(solution97.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    @Test
    public void isInterleave2() {
        Assert.assertFalse(solution97.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    @Test
    public void isInterleave3() {
        Assert.assertTrue(solution97.isInterleave("", "", ""));
    }

    @Test
    public void isInterleave4() {
        Assert.assertTrue(solution97.isInterleave("a", "", "a"));
    }
}