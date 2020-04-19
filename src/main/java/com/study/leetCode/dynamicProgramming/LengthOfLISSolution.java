package com.study.leetCode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: zhangchong
 * @Description: 300. 最长上升子序列
 * Given an unsorted array of integers, find the length of longest increasing sub
 * sequence.
 * <p>
 * Example:
 * <p>
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
 * length is 4.
 * <p>
 * Note:
 * <p>
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to r
 * eturn the length.
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 * Related Topics 二分查找 动态规划
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class LengthOfLISSolution {
    public int lengthOfLIS(int[] nums) {
        return BinarySearchHelper.lengthOfLIS(nums);
    }

    static class SimpleDPHelper {
        static int lengthOfLIS(int[] nums) {
            int result;
            if (nums == null || nums.length == 0) {
                result = 0;
            } else {
                result = 1;
                int[] dp = new int[nums.length + 1];
                for (int i = 0; i < nums.length; i++) {
                    dp[i] = 1;
                }

                for (int i = 0; i < nums.length; i++) {
                    for (int j = 0; j < i; j++) {
                        if (nums[j] < nums[i]) {
                            dp[i] = Math.max(dp[i], dp[j] + 1);
                        }
                    }
                    result = Math.max(result, dp[i]);
                }
            }
            return result;
        }
    }

    static class BinarySearchHelper {
        static int lengthOfLIS(int[] nums) {
            int result;
            if (nums == null || nums.length == 0) {
                result = 0;
            } else {
                final ArrayList<Integer> lis = new ArrayList<>();
                int index;
                int low;
                for (int i = 0; i < nums.length; i++) {
                    index = Collections.binarySearch(lis, nums[i]);
                    if (index == -(lis.size() + 1)) {
                        lis.add(nums[i]);
                    } else if (index < 0) {
                        low = ((-index) - 1);
//                        System.out.println("low=" + low);
                        lis.set(low, nums[i]);
                    }
//                    System.out.println("lis=" + lis);
                }
                result = lis.size();

            }
            return result;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
