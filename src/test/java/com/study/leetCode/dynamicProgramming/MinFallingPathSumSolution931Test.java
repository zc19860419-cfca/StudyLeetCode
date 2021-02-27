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
public class MinFallingPathSumSolution931Test {

    private MinFallingPathSumSolution931 solution;

    @Before
    public void setUp() throws Exception {
        solution = new MinFallingPathSumSolution931();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minFallingPathSum1() {
        int[][] matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        Assert.assertEquals(13, solution.minFallingPathSum(matrix));
    }

    @Test
    public void minFallingPathSum2() {
        int[][] matrix = new int[][]{{-19, 57}, {-40, -5}};
        Assert.assertEquals(-59, solution.minFallingPathSum(matrix));
    }

    @Test
    public void minFallingPathSum3() {
        int[][] matrix = new int[][]{{-48}};
        Assert.assertEquals(-48, solution.minFallingPathSum(matrix));
    }
}