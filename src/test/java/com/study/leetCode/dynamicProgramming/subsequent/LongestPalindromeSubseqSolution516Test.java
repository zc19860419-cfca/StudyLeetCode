package com.study.leetCode.dynamicProgramming.subsequent;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class LongestPalindromeSubseqSolution516Test {

    private LongestPalindromeSubseqSolution516 solution;

    @Before
    public void setUp() throws Exception {
        solution = new LongestPalindromeSubseqSolution516();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestPalindromeSubseq1() {
        Assert.assertEquals(4, solution.longestPalindromeSubseq("bbbab"));
    }

    @Test
    public void longestPalindromeSubseq2() {
        Assert.assertEquals(2, solution.longestPalindromeSubseq("cbbd"));
    }

    @Test
    public void longestPalindromeSubseq3() {
        Assert.assertEquals(3, solution.longestPalindromeSubseq("aaa"));
    }
}