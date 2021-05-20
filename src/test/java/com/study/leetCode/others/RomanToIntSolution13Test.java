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
public class RomanToIntSolution13Test {

    private RomanToIntSolution13 solution13;

    @Before
    public void setUp() throws Exception {
        solution13 = new RomanToIntSolution13();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void romanToInt() {
        Assert.assertEquals(3, solution13.romanToInt("III"));
    }
}