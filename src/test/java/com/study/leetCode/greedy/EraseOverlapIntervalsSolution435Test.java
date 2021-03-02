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
public class EraseOverlapIntervalsSolution435Test {

    private EraseOverlapIntervalsSolution435 solution;

    @Before
    public void setUp() throws Exception {
        solution = new EraseOverlapIntervalsSolution435();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void eraseOverlapIntervals1() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        Assert.assertEquals(1, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    public void eraseOverlapIntervals2() {
        int[][] intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        Assert.assertEquals(2, solution.eraseOverlapIntervals(intervals));
    }

    @Test
    public void eraseOverlapIntervals3() {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}};
        Assert.assertEquals(0, solution.eraseOverlapIntervals(intervals));
    }
}