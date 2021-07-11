package com.study.leetCode.tree.bfs;

import com.study.leetCode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zhangchong
 * @Description:
 */
public class LevelOrderBottomSolution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            TreeNode node;
            TreeNode left;
            TreeNode right;
            List<Integer> level;
            int levelSize;
            while (!queue.isEmpty()) {
                levelSize = queue.size();
                level = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    node = queue.poll();
                    level.add(node.val);

                    left = node.left;
                    right = node.right;
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }

                levelOrder.add(0, level);
            }
        }
        return levelOrder;
    }
}
