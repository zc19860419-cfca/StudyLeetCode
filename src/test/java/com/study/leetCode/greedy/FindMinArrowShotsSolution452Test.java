package com.study.leetCode.greedy;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class FindMinArrowShotsSolution452Test {

    private FindMinArrowShotsSolution452 solution452;

    @Before
    public void setUp() throws Exception {
        solution452 = new FindMinArrowShotsSolution452();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMinArrowShots1() {
        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Assert.assertEquals(2, solution452.findMinArrowShots(points));
    }

    @Test
    public void findMinArrowShots2() {
        int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        Assert.assertEquals(4, solution452.findMinArrowShots(points));
    }

    @Test
    public void findMinArrowShots3() {
        int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        Assert.assertEquals(2, solution452.findMinArrowShots(points));
    }

    @Test
    public void findMinArrowShots4() {
        int[][] points = new int[][]{{1, 2}};
        Assert.assertEquals(1, solution452.findMinArrowShots(points));
    }

    @Test
    public void findMinArrowShots5() {
        int[][] points = new int[][]{{2, 3}, {2, 3}};
        Assert.assertEquals(1, solution452.findMinArrowShots(points));
    }

    @Test
    public void findMinArrowShots6() {
        int[][] points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        Assert.assertEquals(2, solution452.findMinArrowShots(points));
    }

}