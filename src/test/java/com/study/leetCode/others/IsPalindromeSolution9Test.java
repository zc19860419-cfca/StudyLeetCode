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
public class IsPalindromeSolution9Test {

    private IsPalindromeSolution9 solution;

    @Before
    public void setUp() throws Exception {
        solution = new IsPalindromeSolution9();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isPalindrome1() {
        Assert.assertTrue(solution.isPalindrome(121));
    }

    @Test
    public void isPalindrome2() {
        Assert.assertFalse(solution.isPalindrome(-121));
    }

    @Test
    public void isPalindrome3() {
        Assert.assertFalse(solution.isPalindrome(10));
    }
}