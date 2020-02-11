package com.study.leetCode.tree.dfs;

import com.study.leetCode.tree.TreeNode;

import java.util.Set;

/**
 * @Author: zhangchong
 * @Description:
 */
public class StockDFSSolution {

    public int maxProfit(int[] prices) {
//        return calculate(prices, 0);
        return 0;
    }

    public int dfs(TreeNode node, Set<TreeNode> visited, boolean isBuy) {
        int max = 0;
        if (null == node) {
            max = 0;
        } else {
            visited.add(node);
            if (!isBuy) {
                max -= node.val;
            } else if (null != node.parent) {
                max += node.parent.val;
            }

            int maxprofit = 0;
            if (null != node.left) {
                if (!visited.contains(node.left)) {
                    maxprofit = dfs(node.left, visited, true);
                }
            }
            if (null != node.right) {
                if (!visited.contains(node.right)) {
                    maxprofit = dfs(node.right, visited, false);
                }
            }
            if (maxprofit > max) {
                max = maxprofit;
            }
        }

        return max;
    }
}
