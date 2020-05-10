package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
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
            mem[0] = 1; //从顶层 n 下 1 层只有一种解法
            mem[1] = 2;//从顶层 n 下 2 层有2种解法 ：1 阶 + 1 阶 或者 2阶
            for (int i = 2; i < n; i++) {
                //从顶层 n 下 i+1 层总的走法个数=从顶层 n 下 i 层总的走法个数+从顶层 n 下 i-1 层总的走法个数
                //      __  i-1
                //   __|    i
                //__|       i+1：能从i层下来 也能从 i-1层下来
                mem[i] = mem[i - 1] + mem[i - 2];
            }
            ans = mem[n - 1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
