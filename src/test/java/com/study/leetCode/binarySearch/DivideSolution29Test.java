package com.study.leetCode.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class DivideSolution29Test {

    private DivideSolution29 solution;

    @Before
    public void setUp() throws Exception {
        solution = new DivideSolution29();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void divide1() {
        Assert.assertEquals(3, solution.divide(10, 3));
    }
}