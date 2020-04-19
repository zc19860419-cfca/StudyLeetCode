package com.study.leetCode.dynamicProgramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhangchong
 * @Description:
 */
public class LengthOfLISSolutionTest {

    private LengthOfLISSolution lengthOfLISSolution;

    @Before
    public void setUp() throws Exception {
        lengthOfLISSolution = new LengthOfLISSolution();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lengthOfLIS1() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        Assert.assertEquals(4, lengthOfLISSolution.lengthOfLIS(nums));
    }

    @Test
    public void binarySearch1() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        final int index = Collections.binarySearch(list1, 102);
        System.out.println("index=" + index);
        System.out.println("low=" + ((-index) - 1));
    }

    @Test
    public void binarySearch2() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        final int index = Collections.binarySearch(list1, 1);
        System.out.println("index=" + index);
        System.out.println("low=" + ((-index) - 1));
    }

    @Test
    public void binarySearch3() {
        int[] nums = new int[]{4, 107, 118};
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        final int index = Collections.binarySearch(list1, 5);//-(low + 1)
        System.out.println("index=" + index);
        System.out.println("low=" + ((-index) - 1));
    }

    @Test
    public void binarySearch4() {
        int[] nums = new int[]{4, 10};
        List<Integer> list1 = Arrays.stream(nums).boxed().collect(Collectors.toList());
        final int index = Collections.binarySearch(list1, 4);//-(low + 1)
        System.out.println("index=" + index);
        System.out.println("low=" + ((-index) - 1));
    }

    @Test
    public void lengthOfLIS2() {
        int[] nums = new int[]{4, 10, 4, 3, 8, 9};
        Assert.assertEquals(3, lengthOfLISSolution.lengthOfLIS(nums));
    }
}