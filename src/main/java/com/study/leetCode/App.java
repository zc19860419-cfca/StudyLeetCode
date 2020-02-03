package com.study.leetCode;

import com.study.leetCode.linkedList.hascycle.HasCycleSolution;
import com.study.leetCode.twoSums.TwoSumsSolution;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        twoSums();
        hasCycle();

    }

    private static void hasCycle() {
        final HasCycleSolution solution = new HasCycleSolution();

        HasCycleSolution.ListNode head = new HasCycleSolution.ListNode(3);
        solution.hasCycle(head);
    }

    private static void twoSums() {
        final TwoSumsSolution twoSumsSolution = new TwoSumsSolution();

        int[] nums = new int[]{3,2,4};
        int target = 6;
        final int[] results = twoSumsSolution.twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }
}
