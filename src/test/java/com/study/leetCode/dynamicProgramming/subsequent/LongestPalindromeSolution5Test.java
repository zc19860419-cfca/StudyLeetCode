package com.study.leetCode.dynamicProgramming.subsequent;

import com.study.leetCode.dynamicProgramming.LongestPalindromeSolution5;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class LongestPalindromeSolution5Test {

    private LongestPalindromeSolution5 solution;

    @Before
    public void setUp() throws Exception {
        solution = new LongestPalindromeSolution5();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestPalindrome1() {
        Assert.assertEquals("bab", solution.longestPalindrome("babad"));
    }

    @Test
    public void longestPalindrome2() {
        Assert.assertEquals("bb", solution.longestPalindrome("cbbd"));
    }

    @Test
    public void longestPalindrome3() {
        Assert.assertEquals("a", solution.longestPalindrome("a"));
    }

    @Test
    public void longestPalindrome4() {
        Assert.assertEquals("a", solution.longestPalindrome("ac"));
    }
}