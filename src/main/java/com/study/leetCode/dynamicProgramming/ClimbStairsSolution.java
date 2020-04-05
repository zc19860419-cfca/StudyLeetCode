package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 70. 爬楼梯
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
 * u climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Related Topics 动态规划
 */


//leetcode submit region begin(Prohibit modification and deletion)
public class ClimbStairsSolution {
    public int climbStairs(int n) {
        int ans = 0;
        if (0 == n || 1 == n || 2 == n) {
            ans = n;
        } else {
            //mem[i] 表示从顶层 n 下 i+1 层总的走法个数
            int[] mem = new int[n];
            mem[0] = 1;
            mem[1] = 2;
            for (int i = 2; i < n; i++) {
                mem[i] = mem[i - 1] + mem[i - 2];
            }
            ans = mem[n - 1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
