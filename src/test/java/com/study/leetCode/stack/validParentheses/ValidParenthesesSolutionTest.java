package com.study.leetCode.stack.validParentheses;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ValidParenthesesSolutionTest {

    private ValidParenthesesSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new ValidParenthesesSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isValid1() {
        Assert.assertTrue(solution.isValid("()"));
    }

    @Test
    public void isValid2() {
        Assert.assertTrue(solution.isValid("()[]{}"));
    }

    @Test
    public void isValid3() {
        Assert.assertFalse(solution.isValid("(]"));
    }

    @Test
    public void isValid4() {
        Assert.assertFalse(solution.isValid("([)]"));
    }

    @Test
    public void isValid5() {
        Assert.assertTrue(solution.isValid("{[]}"));
    }


}