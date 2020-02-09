package com.study.leetCode.tree.dfs;

import java.util.Objects;
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

    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;

        public TreeNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            boolean result;
            if (this == o) {
                result = true;
            } else if (o == null || getClass() != o.getClass()) {
                result = false;
            } else {
                TreeNode treeNode = (TreeNode) o;
                result = (val == treeNode.val &&
                        Objects.equals(left, treeNode.left) &&
                        Objects.equals(right, treeNode.right));
            }
            return result;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("TreeNode{");
            sb.append("val=").append(val);
            sb.append(", left=").append(null == left ? "null" : left.val);
            sb.append(", right=").append(null == right ? "null" : right.val);
            sb.append('}');
            return sb.toString();
        }
    }
}
