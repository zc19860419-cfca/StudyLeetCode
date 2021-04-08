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
public class LongestCommonPrefixSolution14Test {

    LongestCommonPrefixSolution14 solution;

    @Before
    public void setUp() throws Exception {
        solution = new LongestCommonPrefixSolution14();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void longestCommonPrefix() {
        String[] strs = new String[]{"flower", "flow", "flight"};
        Assert.assertEquals("fl", solution.longestCommonPrefix(strs));
    }

    @Test
    public void longestCommonPrefix1() {
        String[] strs = new String[]{"dog", "racecar", "car"};
        Assert.assertEquals("", solution.longestCommonPrefix(strs));
    }

    @Test
    public void longestCommonPrefix2() {
        String[] strs = new String[]{};
        Assert.assertEquals("", solution.longestCommonPrefix(strs));
    }

    @Test
    public void longestCommonPrefix3() {
        String[] strs = new String[]{"a"};
        Assert.assertEquals("a", solution.longestCommonPrefix(strs));
    }

}