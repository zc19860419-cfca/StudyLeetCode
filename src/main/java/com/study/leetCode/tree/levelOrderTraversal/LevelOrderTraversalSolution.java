package com.study.leetCode.tree.levelOrderTraversal;

/**
 * @author zhangchong
 * @CodeReviewer zhangqingan
 * @Description Given a binary tree, return the level order traversal of its nodes' values. (i
 * e, from left to right, level by level).
 * <p>
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * <p>
 * return its level order traversal as:
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * Related Topics 树 广度优先搜索
 */
//leetcode submit region begin(Prohibit modification and deletion)

import com.study.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class LevelOrderTraversalSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            result = new ArrayList<>(0);
        } else {
            final LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);

            //visited = set(root) 图的遍历是需要的，tree不需要

            int levelSize;
            List<Integer> currentLevel;
            TreeNode node;
            while (!queue.isEmpty()) {
                levelSize = queue.size();
                currentLevel = new ArrayList<>();

                //遍历处理队列中的节点,依次出队
                for (int i = 0; i < levelSize; i++) {
                    node = queue.pollFirst();
                    if (null != node) {
                        currentLevel.add(node.val);
                        if (null != node.left) {
                            queue.addLast(node.left);
                        }
                        if (null != node.right) {
                            queue.addLast(node.right);
                        }
                    }
                }
                result.add(currentLevel);
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

