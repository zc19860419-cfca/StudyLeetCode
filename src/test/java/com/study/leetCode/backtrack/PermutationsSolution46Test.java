package com.study.leetCode.backtrack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhangchong
 * @Description:
 */
public class PermutationsSolution46Test {

    private PermutationsSolution46 solution;

    @Before
    public void setUp() throws Exception {
        solution = new PermutationsSolution46();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_permute1() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> all = solution.permute(nums);
        Assert.assertEquals("[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]", all.toString());
    }

    @Test
    public void test_permute2() {
        int[] nums = new int[]{1};
        List<List<Integer>> all = solution.permute(nums);
        Assert.assertEquals("[[1]]", all.toString());
    }

    @Test
    public void test_permute3() {
        int[] nums = new int[]{0, -1, 1};
        List<List<Integer>> all = solution.permute(nums);
//        Assert.assertEquals("[[-1, 0, 1], [-1, 1, 0], [0, -1, 1], [0, 1, -1], [1, -1, 0], [1, 0, -1]]", all.toString());
        List<List<Integer>> exp = new ArrayList<List<Integer>>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(-1);
        l1.add(0);
        l1.add(1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(-1);
        l2.add(1);
        l2.add(0);
        List<Integer> l3 = new ArrayList<>();
        l3.add(0);
        l3.add(-1);
        l3.add(1);
        List<Integer> l4 = new ArrayList<>();
        l4.add(0);
        l4.add(1);
        l4.add(-1);
        List<Integer> l5 = new ArrayList<>();
        l5.add(1);
        l5.add(-1);
        l5.add(0);
        List<Integer> l6 = new ArrayList<>();
        l6.add(1);
        l6.add(0);
        l6.add(-1);
        exp.add(l1);
        exp.add(l2);
        exp.add(l3);
        exp.add(l4);
        exp.add(l5);
        exp.add(l6);
        Assert.assertTrue(compare1(all, exp));
    }

    private boolean compare1(List<List<Integer>> l1, List<List<Integer>> l2) {
        if (l1 == null && l2 == null) {
            return true;
        } else if (l1 == null || l2 == null) {
            return false;
        } else if (l1.size() != l2.size()) {
            return false;
        } else {
            List<Integer> l1i;
            List<Integer> l2j;
            boolean match = true;
            for (int i = 0; i < l1.size(); i++) {
                l1i = l1.get(i);
                match = false;
                for (int j = 0; j < l2.size(); j++) {
                    l2j = l2.get(j);
                    if (compare(l1i, l2j)) {
                        match = true;
                        break;
                    }
                }
                if (!match) {
                    break;
                }
            }
            return match;
        }
    }

    private boolean compare(List<Integer> l1, List<Integer> l2) {
        if (l1 == null && l2 == null) {
            return true;
        } else if (l1 == null || l2 == null) {
            return false;
        } else if (l1.size() != l2.size()) {
            return false;
        } else {
            boolean match = true;
            Integer l1i;
            Integer l2i;
            for (int i = 0; i < l1.size(); i++) {
                l1i = l1.get(i);
                l2i = l2.get(i);
                if (l1i != l2i) {
                    match = false;
                    break;
                }
            }
            return match;
        }
    }

    @Test
    public void test_swap1() {
        int[] nums = new int[]{1, 2, 3, 4};
        swap1(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
        swap1(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test_swa2() {
        int[] nums = new int[]{1, 2, 3, 4};
        swap2(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
        swap2(nums, 1, 2);
        System.out.println(Arrays.toString(nums));
    }

    private void swap1(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void swap2(int[] array, int j, int l) {
        array[j] ^= array[l];
        array[l] ^= array[j];
        array[j] ^= array[l];
    }
}