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
public class isPalindromeSolution125Test {

    private isPalindromeSolution125 solution;

    @Before
    public void setUp() throws Exception {
        solution = new isPalindromeSolution125();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_isPalindrome_True() {
        Assert.assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}