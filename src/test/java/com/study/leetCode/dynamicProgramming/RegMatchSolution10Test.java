package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class RegMatchSolution10Test {

    private RegMatchSolution10 solution;

    @Before
    public void setUp() throws Exception {
        solution = new RegMatchSolution10();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isMatch1() {
        Assert.assertFalse(solution.isMatch("aa", "a"));
    }

    @Test
    public void isMatch2() {
        Assert.assertTrue(solution.isMatch("aa", "a*"));
    }

    @Test
    public void isMatch3() {
        Assert.assertTrue(solution.isMatch("ab", ".*"));
    }

    @Test
    public void isMatch4() {
        Assert.assertTrue(solution.isMatch("aab", "c*a*b"));
    }

    @Test
    public void isMatch5() {
        Assert.assertFalse(solution.isMatch("mississippi", "mis*is*p*."));
    }
}