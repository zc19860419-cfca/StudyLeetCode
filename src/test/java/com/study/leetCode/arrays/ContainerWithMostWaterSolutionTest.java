package com.study.leetCode.arrays;

import com.study.leetCode.others.ContainerWithMostWaterSolution;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: zhangchong
 * @Description:
 */
public class ContainerWithMostWaterSolutionTest {

    ContainerWithMostWaterSolution solution;

    @Before
    public void setUp() throws Exception {
        solution = new ContainerWithMostWaterSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void maxArea() {
        int[] heights1 = new int[]{4, 3, 2, 1, 4};
        Assert.assertEquals(16, solution.maxArea(heights1));

        int[] heights2 = new int[]{1, 1};
        Assert.assertEquals(1, solution.maxArea(heights2));

        int[] heights3 = new int[]{1, 2, 1};
        Assert.assertEquals(2, solution.maxArea(heights3));

        int[] heights4 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.assertEquals(49, solution.maxArea(heights4));

        int[] heights5 = new int[]{1};
        Assert.assertEquals(0, solution.maxArea(heights5));
    }
}