package com.study.leetCode.bitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangchong
 * @Description: 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 * <p>
 * Related Topics 位运算 数组 回溯
 */
public class SubsetSolution78 {

    List<List<Integer>> ans;
    List<Integer> combine;

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temporary = new ArrayList<Integer>();

        int n = nums.length;
        if (n == 0) {
            ans.add(temporary);
        } else if (n == 1) {
            ans.add(new ArrayList<Integer>());
            temporary.add(nums[0]);
            ans.add(temporary);
        } else {
            int test;
            //[0000...000, 1111...111]
            int capacity = 1 << n;
            System.out.println("capacity=" + capacity);
            for (int mask = 0; mask < capacity; mask++) {
                System.out.println("mask=" + Integer.toBinaryString(mask));
                temporary.clear();
                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) != 0) {
                        temporary.add(nums[i]);
                    }
                }
                ans.add(new ArrayList<Integer>(temporary));
            }
        }

        return ans;
    }

    //---------------------最快解法如下：--------------------------
    public List<List<Integer>> subsets1(int[] nums) {
        ans = new ArrayList<>();
        combine = new ArrayList<>();
        backTrack(nums, 0, nums.length);
        return ans;
    }

    private void backTrack(int[] nums, int start, int len) {
        if (start == len) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        backTrack(nums, start + 1, len);
        combine.add(nums[start]);
        backTrack(nums, start + 1, len);
        combine.remove(combine.size() - 1);
    }
}
