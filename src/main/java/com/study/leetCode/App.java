package com.study.leetCode;

import com.study.leetCode.twoSums.Solution;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        final Solution solution = new Solution();

        int[] nums = new int[]{3,2,4};
        int target = 6;
        final int[] results = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(results));
    }
}
