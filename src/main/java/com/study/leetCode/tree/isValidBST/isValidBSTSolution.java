package com.study.leetCode.tree.isValidBST;

/**
 * @Author: zhangchong
 * @Description: Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's
 * key.
 * The right subtree of a node contains only nodes with keys greater than the no
 * de's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * Input: [2,1,3]
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * <p>
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * <p>
 * Related Topics 树 深度优先搜索
 */

//leetcode submit region begin(Prohibit modification and deletion)

import com.study.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

class isValidBSTSolution {

    private List<TreeNode> visitInOrder(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (null != root) {
            if (null != root.left) {
                nodeList.addAll(visitInOrder(root.left));
            }
            nodeList.add(root);
            if (null != root.right) {
                nodeList.addAll(visitInOrder(root.right));
            }
        }
        return nodeList;
    }

    private boolean visitInOrder(TreeNode root, TreeNode min, TreeNode max) {
        boolean result;
        if (root == null) {
            result = true;
        } else if (min != null && root.val <= min.val) {
            result = false;
        } else if (max != null && root.val >= max.val) {
            result = false;
        } else {
            result = visitInOrder(root.left, min, root) && visitInOrder(root.right, root, max);
        }
        return result;
    }

    public boolean isValidBST(TreeNode root) {
        return visitInOrder(root, null, null);
    }


    public boolean isValidBSTSlow(TreeNode root) {
        boolean isValidBST = true;
        if (null == root) {
            isValidBST = true;
        } else {
            final List<TreeNode> treeNodes = visitInOrder(root);
            if (1 == treeNodes.size()) {
                isValidBST = true;
            } else {
                TreeNode preNode;
                TreeNode nextNode;
                for (int i = 0; i < treeNodes.size() - 1; i++) {
                    preNode = treeNodes.get(i);
                    nextNode = treeNodes.get(i + 1);
                    if (preNode.val >= nextNode.val) {
                        isValidBST = false;
                        break;
                    }
                }
            }
        }

        return isValidBST;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

