package com.study.leetCode.tree.lowestCommonAncestor;

import com.study.leetCode.tree.TreeNode;

/**
 * @Author: zhangchong
 * @Description: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
 * given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p and
 * q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree: root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant o
 * f itself according to the LCA definition.
 * <p>
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 * <p>
 * Related Topics 树
 * 暴力解法
 */

//leetcode submit region begin(Prohibit modification and deletion)
class BSTLCABruteForceSolution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = null;
        if (null != root) {
            if (p.val > root.val && q.val > root.val) {
                ancestor = lowestCommonAncestor(root.right, p, q);
            } else if (p.val < root.val && q.val < root.val) {
                ancestor = lowestCommonAncestor(root.left, p, q);
            } else {
                ancestor = root;
            }
        }
        return ancestor;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

