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
public class MyatoiSolution8Test {

    private MyatoiSolution8 solution;

    @Before
    public void setUp() throws Exception {
        solution = new MyatoiSolution8();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void myAtoi() {
        Assert.assertEquals(42, solution.myAtoi("42"));
    }
}