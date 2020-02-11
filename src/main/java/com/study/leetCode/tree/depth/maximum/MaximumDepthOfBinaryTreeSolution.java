package com.study.leetCode.tree.depth.maximum;

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

public class MaximumDepthOfBinaryTreeSolution {

    public int maxDepth(TreeNode root) {
        return null == root ? 0 :
                1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

