package com.study.leetCode.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author: zhangchong
 * @Description:
 */
public class SearchRangeSolution34Test {

    private SearchRangeSolution34 solution;

    @Before
    public void setUp() throws Exception {
        solution = new SearchRangeSolution34();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void searchRange1() {
        int[] actual = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(actual));
        Assert.assertEquals(3, actual[0]);
        Assert.assertEquals(4, actual[1]);
    }

    @Test
    public void searchRange2() {
        int[] actual = solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(actual));
        Assert.assertEquals(-1, actual[0]);
        Assert.assertEquals(-1, actual[1]);
    }

    @Test
    public void searchRange3() {
        int[] actual = solution.searchRange(new int[]{}, 0);
        System.out.println(Arrays.toString(actual));
        Assert.assertEquals(-1, actual[0]);
        Assert.assertEquals(-1, actual[1]);
    }
}