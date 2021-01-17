package com.study.leetCode.disjointSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class NumOfIslandSolutionTest {

    NumOfIslandSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new NumOfIslandSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void numIslands() {
        char[][] grid = new char[][]{
                {'1' , '1' , '1' , '1' , '0'},
                {'1' , '1' , '0' , '1' , '0'},
                {'1' , '1' , '0' , '0' , '0'},
                {'0' , '0' , '0' , '0' , '0'}
        };

        Assert.assertEquals(1, solution.numIslands(grid));
    }

}