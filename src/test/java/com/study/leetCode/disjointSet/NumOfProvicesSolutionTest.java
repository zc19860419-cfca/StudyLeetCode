package com.study.leetCode.disjointSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class NumOfProvicesSolutionTest {

    NumOfProvicesSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new NumOfProvicesSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findCircleNum() {
        int[][] grid = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        Assert.assertEquals(2, solution.findCircleNum(grid));
    }
}