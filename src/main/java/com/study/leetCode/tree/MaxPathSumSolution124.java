package com.study.leetCode.tree;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 * <pre>
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * </pre>
 * <p>
 * }
 */
public class MaxPathSumSolution124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGainPostOrder(root);
        return maxSum;
    }

    /**
     * 后序遍历 获取节点最大贡献值
     * @param node
     * @return
     */
    private int maxGainPostOrder(TreeNode node) {
        int gain = 0;
        if (node != null) {
            int leftGain = Math.max(maxGainPostOrder(node.left), 0);
            int rightGain = Math.max(maxGainPostOrder(node.right), 0);
            int priceNewpath = node.val + leftGain + rightGain;
            maxSum = Math.max(maxSum, priceNewpath);
            //返回节点的最大贡献值
            gain = node.val + Math.max(leftGain, rightGain);
        }
        return gain;
    }
}
