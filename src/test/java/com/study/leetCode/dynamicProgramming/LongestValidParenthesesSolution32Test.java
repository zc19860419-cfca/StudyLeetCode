package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class LongestValidParenthesesSolution32Test {

    private LongestValidParenthesesSolution32 solution;

    @Before
    public void setUp() throws Exception {
        solution = new LongestValidParenthesesSolution32();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestValidParentheses1() {
        Assert.assertEquals(4, solution.longestValidParentheses(")()())"));
    }

    @Test
    public void longestValidParentheses2() {
        Assert.assertEquals(2, solution.longestValidParentheses("(()"));
    }

    @Test
    public void longestValidParentheses3() {
        Assert.assertEquals(0, solution.longestValidParentheses(""));
    }

    @Test
    public void longestValidParentheses4() {
        Assert.assertEquals(4, solution.longestValidParentheses("()(()()"));
    }

    @Test
    public void longestValidParentheses5() {
        Assert.assertEquals(8, solution.longestValidParentheses("()(()())"));
    }
}