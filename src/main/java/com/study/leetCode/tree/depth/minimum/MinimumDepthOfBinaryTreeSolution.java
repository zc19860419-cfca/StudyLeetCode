package com.study.leetCode.tree.depth.minimum;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description 104. 二叉树的最大深度
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the roo
 * t node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * return its minimum depth = 2.
 * Related Topics 树 深度优先搜索 广度优先搜索
 */
//leetcode submit region begin(Prohibit modification and deletion)

import com.study.leetCode.tree.TreeNode;

public class MinimumDepthOfBinaryTreeSolution {

    public int minDepth(TreeNode root) {
        int minDepth;
        if (null == root) {
            minDepth = 0;
        } else {
            if (null == root.left && null == root.right) {
                minDepth = 1;
            } else {
                minDepth = Integer.MAX_VALUE;
                if (null != root.left){
                    minDepth = Math.min(minDepth, minDepth(root.left));
                }
                if (null != root.right){
                    minDepth = Math.min(minDepth, minDepth(root.right));
                }
                minDepth = 1 + minDepth;
            }
        }

        return minDepth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

