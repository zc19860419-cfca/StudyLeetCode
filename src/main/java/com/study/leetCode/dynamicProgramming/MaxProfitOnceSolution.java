package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 121. 买卖股票的最佳时机
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum profi
 * t.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 * 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying pric
 * e.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * Related Topics 数组 动态规划
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class MaxProfitOnceSolution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                profit = prices[j] - prices[i];
                if (maxprofit < profit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

