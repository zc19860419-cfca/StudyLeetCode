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
public class FindTheDifferenceSolution389Test {

    private FindTheDifferenceSolution389 solution389;

    @Before
    public void setUp() throws Exception {
        solution389 = new FindTheDifferenceSolution389();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findTheDifference() {
        String s = "abcd", t = "abcde";
        Assert.assertEquals('e', solution389.findTheDifference(s, t));
    }
}