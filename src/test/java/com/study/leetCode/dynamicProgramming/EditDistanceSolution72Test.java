package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class EditDistanceSolution72Test {

    private EditDistanceSolution72 solution;

    @Before
    public void setUp() throws Exception {
        solution = new EditDistanceSolution72();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minDistance() {
        Assert.assertEquals(3, solution.minDistance("horse", "ros"));
    }
}