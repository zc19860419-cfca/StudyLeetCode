package com.study.leetCode.dynamicProgramming;

/**
 * @Author: zhangchong
 * @Description: 122. 买卖股票的最佳时机
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell be
 * fore buying again.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * Related Topics 贪心算法 数组
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class MaxProfitAnySolution {
    /**
     * 峰谷法
     * <pre>
     *             i
     * TotalProfit=∑(height(peaki)−height(valleyi))
     * </pre>
     * 关键是需要考虑到紧跟 valley 的每一个 peak 值以最大化利润。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        if (null == prices || 0 >= prices.length) {
            maxprofit = 0;
        } else {
            int i = 0;
            int valley = prices[0];
            int peak = prices[0];

            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                    i++;
                }
                //Ascending-run
                valley = prices[i];
                while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                    i++;
                }
                //Descending-run
                peak = prices[i];
                maxprofit += (peak - valley);
            }
        }
        return maxprofit;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


