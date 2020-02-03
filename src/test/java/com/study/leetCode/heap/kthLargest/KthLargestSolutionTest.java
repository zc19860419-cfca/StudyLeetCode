package com.study.leetCode.heap.kthLargest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class KthLargestSolutionTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void add() {
        int k = 3;
        int[] nums = new int[]{4, 5, 8, 2};
        final KthLargestSolution kthLargest = new KthLargestSolution(k, nums);
        Assert.assertEquals(4, kthLargest.add(3));
        Assert.assertEquals(5, kthLargest.add(5));
        Assert.assertEquals(5, kthLargest.add(10));
        Assert.assertEquals(8, kthLargest.add(9));
        Assert.assertEquals(8, kthLargest.add(4));

    }
}