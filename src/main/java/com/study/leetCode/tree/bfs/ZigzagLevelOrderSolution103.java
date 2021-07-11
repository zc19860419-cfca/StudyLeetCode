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
public class ZigzagLevelOrderSolution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result;

        if (null == root) {
            result = new ArrayList<>(0);
        } else {
            result = new ArrayList<>();
            Queue<TreeNode> bfs = new LinkedList<>();
            bfs.offer(root);

            int levelSize;
            List<TreeNode> level;
            List<Integer> traverse;
            boolean left2right = true;
            TreeNode node;
            while (!bfs.isEmpty()) {
                level = new ArrayList<>();
                traverse = new ArrayList<>();
                levelSize = bfs.size();

                for (int i = 0; i < levelSize; i++) {
                    node = bfs.poll();
                    if (node != null) {
                        level.add(node);
                        if (node.left != null) {
                            bfs.offer(node.left);
                        }

                        if (node.right != null) {
                            bfs.offer(node.right);
                        }
                    }
                }

                if (left2right) {
                    for (int i = 0; i < levelSize; i++) {
                        traverse.add(level.get(i).val);
                    }
                } else {
                    for (int i = levelSize - 1; i >= 0; i--) {
                        traverse.add(level.get(i).val);
                    }
                }

                left2right = !left2right;
                result.add(traverse);
            }
        }

        return result;
    }
}
