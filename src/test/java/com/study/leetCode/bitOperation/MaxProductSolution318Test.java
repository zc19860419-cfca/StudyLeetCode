package com.study.leetCode.bitOperation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MaxProductSolution318Test {

    private MaxProductSolution318 solution318;

    @Before
    public void setUp() throws Exception {
        solution318 = new MaxProductSolution318();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxProduct1() {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        Assert.assertEquals(16, solution318.maxProduct(words));
    }

    @Test
    public void maxProduct2() {
        String[] words = new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        Assert.assertEquals(4, solution318.maxProduct(words));
    }
}