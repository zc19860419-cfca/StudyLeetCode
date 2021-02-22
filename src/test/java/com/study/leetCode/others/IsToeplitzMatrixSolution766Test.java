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
public class IsToeplitzMatrixSolution766Test {

    private IsToeplitzMatrixSolution766 solution;

    @Before
    public void setUp() throws Exception {
        solution = new IsToeplitzMatrixSolution766();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isToeplitzMatrix() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        Assert.assertTrue(solution.isToeplitzMatrix(matrix));
    }
}