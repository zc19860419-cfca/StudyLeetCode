package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 152. 乘积最大子数组
 * Given an integer array nums, find the contiguous subarray within an array (con
 * taining at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * Related Topics 数组 动态规划
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class MaxProductSolution {
    public int maxProduct(int[] nums) {
        int ans = 0;
        if (null == nums || 0 == nums.length) {
            ans = 0;
        } else {
            ans = Integer.MIN_VALUE;
            int imax = 1, imin = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0) {
                    int tmp = imax;
                    imax = imin;
                    imin = tmp;
                }
                imax = Math.max(imax * nums[i], nums[i]);
                imin = Math.min(imin * nums[i], nums[i]);

                ans = Math.max(ans, imax);
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

