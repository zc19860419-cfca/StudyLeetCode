package com.study.leetCode.threeSums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhangchong
 * @Description: Given an array nums of n integers, are there elements a, b, c in nums such tha
 * t a + b + c = 0? Find all unique triplets in the array which gives the sum of ze
 * ro.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * Related Topics 数组 双指针
 */

//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumsSolution {

    private static final Integer[] ALL_ZERO_SOLUTION = new Integer[]{0, 0, 0};

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (null == nums || 3 > nums.length) {
            return solutions;
        }

        if (0 == nums[0] && 0 == nums[1] && 0 == nums[2]) {
            solutions.add(Arrays.asList(ALL_ZERO_SOLUTION));
            return solutions;
        }

        int a;
        int b;
        List<Integer> solution;

        Arrays.sort(nums);

        List<Integer> numsList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numsList.add(Integer.valueOf(nums[i]));
        }
        for (int i = 0; i < nums.length - 1; i++) {
            a = nums[i];
            if (a == nums[nums.length - 1]) {
                break;
            }

            for (int j = i + 1; j < nums.length; j++) {
                b = nums[j];
                numsList.remove(Integer.valueOf(a));
                numsList.remove(Integer.valueOf(b));
                if (numsList.contains(-a - b)) {
                    solution = new ArrayList<>();
                    solution.add(a);
                    solution.add(b);
                    solution.add(-a - b);
                    solutions.add(solution);
                }
                numsList.add(Integer.valueOf(a));
                numsList.add(Integer.valueOf(b));
            }
        }
        return unique(solutions);
    }

    private List<List<Integer>> unique(List<List<Integer>> solutions) {
        List<List<Integer>> uniqueSolution = new ArrayList<>();
        Set<Set<Integer>> solutionSet = new HashSet<Set<Integer>>();
        Set<Integer> uniqueNums;
        for (List<Integer> solution : solutions) {
            uniqueNums = new HashSet<>(solution);
            if (!solutionSet.contains(uniqueNums)) {
                solutionSet.add(uniqueNums);
                uniqueSolution.add(solution);
            }
        }
        return uniqueSolution;
    }

    private void debugNumSet(Set<Integer> numSet) {
        System.out.println(numSet);
    }

    private int[] convertSet(Set<Integer> numSet) {
        final Integer[] uniqued = numSet.toArray(new Integer[numSet.size()]);
        final int[] uniquedPrimitive = new int[uniqued.length];
        for (int i = 0; i < uniqued.length; i++) {
            uniquedPrimitive[i] = uniqued[i].intValue();
        }
        return uniquedPrimitive;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        if (null == nums || 3 > nums.length) {
            return solutions;
        }

        if (0 == nums[0] && 0 == nums[1] && 0 == nums[2]) {
            solutions.add(Arrays.asList(ALL_ZERO_SOLUTION));
            return solutions;
        }

        Arrays.sort(nums);
        int low;
        int high;
        int a;
        int b;
        int c;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            a = nums[i];
            low = i + 1;
            high = nums.length - 1;
            while (low < high) {
                b = nums[low];
                c = nums[high];
                if (0 == a + b + c) {
                    solutions.add(Arrays.asList(new Integer[]{a, b, c}));
                    while (low < high && nums[high - 1] == nums[high]) {
                        --high;
                    }
                    --high;
                    while (low < high && nums[low + 1] == nums[low]) {
                        ++low;
                    }
                    ++low;
                } else if (0 < a + b + c) {
                    --high;
                    while (low < high && nums[high + 1] == nums[high]) {
                        --high;
                    }
                } else {
                    ++low;
                    while (low < high && nums[low - 1] == nums[low]) {
                        ++low;
                    }
                }
            }
        }
        return solutions;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

