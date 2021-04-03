package com.study.leetCode.others;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class IntToRomanSolution12Test {

    private IntToRomanSolution12 solution;

    @Before
    public void setUp() throws Exception {
        solution = new IntToRomanSolution12();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void intToRoman1() {
        Assert.assertEquals("III", solution.intToRoman(3));
    }

    @Test
    public void intToRoman2() {
        Assert.assertEquals("IV", solution.intToRoman(4));
    }
}