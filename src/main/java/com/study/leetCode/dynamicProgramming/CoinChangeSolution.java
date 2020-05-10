package com.study.leetCode.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author: zhangchong
 * @Description: 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *  
 * <p>
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * Related Topics 动态规划
 */

//leetcode submit region begin(Prohibit modification and deletion)
public class CoinChangeSolution {

    public int coinChange(int[] coins, int amount) {
        //DP状态定义：  dp[i]为达到面值 i 的最少钱币数
        //DP方程：     dp[i]=min{dp[i-coins[j]]}+1, j属于钱币数组中的任一元素[0,n-1]
        //时间复杂度为：O(x*n) x代表面值
        //时间复杂度为：O(x)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public int coinChange1(int[] coins, int amount) {
        //DP状态定义：  dp[i]为达到面值 i 的最少钱币数
        //DP方程：     dp[i]=min{dp[i-coins[j]]}+1, j属于钱币数组中的任一元素[0,n-1]
        //时间复杂度为：O(x*n) x代表面值
        //时间复杂度为：O(x)
        int maxResult;
        if (amount < 1) {
            maxResult = 0;
        } else {
            maxResult = coinChange(coins, amount, new int[amount]);
        }
        return maxResult;
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        int maxResult;
        if (rem < 0) {
            maxResult = -1;
        } else if (rem == 0) {
            maxResult = 0;
        } else {
            if (count[rem - 1] != 0) {
                maxResult = count[rem - 1];
            } else {
                int min = Integer.MAX_VALUE;
                for (int coin : coins) {
                    int res = coinChange(coins, rem - coin, count);
                    if (res >= 0 && res < min)
                        min = 1 + res;
                }
                count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
                maxResult = count[rem - 1];
            }

        }
        return maxResult;
    }
}
//leetcode submit region end(Prohibit modification and deletion)