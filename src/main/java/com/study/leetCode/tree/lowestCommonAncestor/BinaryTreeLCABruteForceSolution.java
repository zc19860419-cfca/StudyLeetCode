package com.study.leetCode.tree.lowestCommonAncestor;

import com.study.leetCode.tree.TreeNode;

/**
 * @Author: zhangchong
 * @Description: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p and
 * q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree: root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
 * f itself according to the LCA definition.
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * <p>
 * Related Topics 树
 * 暴力解法
 */
//leetcode submit region begin(Prohibit modification and deletion)
class BinaryTreeLCABruteForceSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor;
        if (null == root) {
            ancestor = null;
        } else if (root.equals(p) || root.equals(q)) {
            ancestor = root;
        } else {
            final TreeNode left = lowestCommonAncestor(root.left, p, q);
            final TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (null != left && null != right) {
                ancestor = root;
            } else if (null != left) {
                ancestor = left;
            } else if (null != right) {
                ancestor = right;
            } else {
                ancestor = null;
            }
        }

        return ancestor;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

