package com.study.leetCode.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SearchInRotatedArraySolution33Test {

    private SearchInRotatedArraySolution33 solution33;

    @Before
    public void setUp() throws Exception {
        solution33 = new SearchInRotatedArraySolution33();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void search() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(4, solution33.search(nums, 0));
    }
}