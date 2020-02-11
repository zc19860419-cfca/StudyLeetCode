package com.study.leetCode.tree.dfs;

/**
 * @Author: zhangchong
 * @Description:
 */
public class StockBruteForceSolution {

    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        int max = 0;
        if (s >= prices.length) {
            max = 0;
        } else {
            for (int start = s; start < prices.length; start++) {
                int maxprofit = 0;
                for (int i = start + 1; i < prices.length; i++) {
                    System.out.println("(" + start + "," + i + ")");
                    if (prices[start] < prices[i]) {
                        int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                        if (profit > maxprofit) {
                            maxprofit = profit;
                        }
                    }
                }
                if (maxprofit > max) {
                    max = maxprofit;
                }
            }
        }

        return max;
    }
}
