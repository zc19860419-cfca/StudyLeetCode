package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhangchong
 * @Description:
 */
public class MinimumTotalSolutionTest {

    private MinimumTotalSolution minimumTotalSolution;

    @Before
    public void setUp() throws Exception {
        minimumTotalSolution = new MinimumTotalSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void minimumTotal() {
        final int[] r1Array = {2};
        final int[] r2Array = {3, 4};
        final int[] r3Array = {6, 5, 7};
        final int[] r4Array = {4, 1, 8, 3};
        List<Integer> r1 = Arrays.stream(r1Array).boxed().collect(Collectors.toList());
        List<Integer> r2 = Arrays.stream(r2Array).boxed().collect(Collectors.toList());
        List<Integer> r3 = Arrays.stream(r3Array).boxed().collect(Collectors.toList());
        List<Integer> r4 = Arrays.stream(r4Array).boxed().collect(Collectors.toList());
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(r1);
        triangle.add(r2);
        triangle.add(r3);
        triangle.add(r4);
        Assert.assertEquals(11, minimumTotalSolution.minimumTotal(triangle));
    }
}